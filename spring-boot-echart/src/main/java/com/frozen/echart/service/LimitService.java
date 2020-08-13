package com.frozen.echart.service;

import com.frozen.echart.bean.XAxisNum;
import com.frozen.echart.bean.echart.XAxis;
import com.frozen.echart.dao.LimitDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * @author: Frozen
 * @create: 2020-08-13 10:28
 * @description:
 **/
@Service
@Slf4j
public class LimitService {
	@Autowired
	private LimitDao limitDao;

	public void setNum(int num){
		limitDao.setNum(num);
	}
	public void limitStart(){
		limitDao.limitStart();
	}

	public List<XAxisNum> getXAxisNum(){
			return limitDao.getXAxisNums();
	}
	private int recent=20;

	public XAxis getXAxis(List<XAxisNum> xAxisNum){
		XAxis xAxis = new XAxis();
		List<String> xAxisData=  new ArrayList<>();
		int start=0;
		int leagth=xAxisNum.size();
		if(leagth>recent){
			start=leagth-recent-1;
		}
		for(int i=start;i<xAxisNum.size();i++){
			XAxisNum axisNum = xAxisNum.get(i);
			xAxisData.add(i+"s:"+axisNum.getNum()+"/s");
		}
		xAxis.setData(xAxisData);
		return xAxis;
	}
	public List<Integer> getSeriesData(List<XAxisNum> xAxisNum){
		List<Integer> seriesData=  new ArrayList<>();
		int start=0;
		int leagth=xAxisNum.size();
		if(leagth>recent){
			start=leagth-recent-1;
		}
		for(int i=start;i<xAxisNum.size();i++) {
			seriesData.add(xAxisNum.get(i).getTokenLimit());
		}
		return seriesData;
	}
}
