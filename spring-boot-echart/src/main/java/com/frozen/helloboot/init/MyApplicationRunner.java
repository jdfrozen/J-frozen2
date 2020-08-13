package com.frozen.helloboot.init;

import com.frozen.helloboot.service.LimitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

/**
 * 实现ApplicationRunner接口,执行顺序按照value值决定,值小先执行
 *
 * @author single-聪
 * @date 2019年10月31日
 * @version 0.0.1
 */
@Slf4j
@Component
@Order(value = 1)
public class MyApplicationRunner implements ApplicationRunner {
	@Autowired
	private LimitService limitService;
	@Override
	public void run(ApplicationArguments args) {
		log.info("测试服务MyApplicationRunner");
		// 以下方法并非一定执行,根据版本升级情况决定是否执行,某些数据未产生变动不需执行,此处执行方法目的是为了解决缓存数据一致性问题
		// 同步缓存中的通知消息数目
		limitService.limitStart();
	}
}
