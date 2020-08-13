package com.frozen.helloboot.dao;

import com.frozen.helloboot.bean.LimitList;
import com.frozen.helloboot.bean.LimitNode;
import com.frozen.helloboot.bean.XAxisNum;
import com.frozen.helloboot.current.WfsErrorRateLimiterThreadPool;
import com.frozen.helloboot.utils.SleepHelper;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Frozen
 * @create: 2020-08-13 13:20
 * @description:
 **/
@Component
@Slf4j
public class LimitDao {
	//限流器锁
	private static final Object lock = new Object();
	private static final int max=10000;
	//令牌
	private int token = 50;
	@Getter
	private int tokenLimit=50;
	private LimitList limitList = new LimitList();
	//每10秒请求数量
	@Getter
	private int num=100;
	@Getter
	private List<XAxisNum> xAxisNums=new ArrayList<>();

	public void setNum(int num){
		this.num=num;
	}

	public void limitStart(){
		supplement();
		updateTokenLimit();
		for(;;) {
			int time=max/num;
			SleepHelper.sleep(time);
			request();
		}
	}

	private synchronized void request(){
		synchronized (lock) {
			if (token >0) {
				System.out.println(":通过，token=" + token);
				token--;
			} else {
				System.out.println(":限流，token=" + token);
			}
		}
		long now =System.currentTimeMillis();
		limitList.add(LimitNode.builder().time(now).build());
	}

	/**
	 * 补充令牌
	 */
	private void supplement(){
		WfsErrorRateLimiterThreadPool.scheduleAtFixedRate(()->{
			Integer time=1000/tokenLimit-10;
			if(time>0){
				SleepHelper.sleep(time);
			}
			if(token>=tokenLimit){
				return;
			}
			synchronized (lock) {
				token++;
			}
		},1,10);
	}

	/**
	 * 更新最大的限流速度，每秒更新一次
	 */
	private void updateTokenLimit(){
		WfsErrorRateLimiterThreadPool.scheduleAtFixedRate(()->{
			try {
				long now =System.currentTimeMillis();
				tokenLimit = limitList.getMaxLimit(now);
				System.out.println("每秒最大限流，rateLimit=" + tokenLimit);
				XAxisNum xAxisNum=new XAxisNum();
				xAxisNum.setNum(num);
				xAxisNum.setTokenLimit(tokenLimit);
				xAxisNums.add(xAxisNum);
			}catch (Exception e){
				log.error("",e);
			}
		},1,1000);
	}
}
