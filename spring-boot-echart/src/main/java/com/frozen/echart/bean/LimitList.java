package com.frozen.echart.bean;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: Frozen
 * @create: 2020-08-13 10:57
 * @description:
 **/
public class LimitList {
	private static final int max=1000;
	private volatile List<LimitNode> list=new LinkedList<>();

	public  void add(LimitNode node){
		if(list.size()>=max){
			list.remove(0);
			list.add(node);
		}else {
			list.add(node);
		}
	}

	private int limit(long now){
		int limit=0;
		for(LimitNode node:list){
			if((now-node.getTime())<=max){
				limit++;
			}
		}
		return limit;
	}

	public int getMaxLimit(long now){
		int x=this.limit(now);
		if(x<20){
			return 20;
		}
		if(x>100){
			return 10;
		}
		return (-x/8)+22;
	}
}
