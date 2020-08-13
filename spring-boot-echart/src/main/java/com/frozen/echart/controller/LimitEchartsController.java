package com.frozen.echart.controller;

import com.frozen.echart.bean.XAxisNum;
import com.frozen.echart.bean.echart.LineChartData;
import com.frozen.echart.bean.echart.XAxis;
import com.frozen.echart.bean.echart.YAxis;
import com.frozen.echart.service.LimitService;
import com.frozen.echart.utils.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 冯默风
 * @Date: 2019/1/19 18:41
 * @Description:
 */
@RestController
public class LimitEchartsController {

	@Autowired
	private LimitService limitService;

    @RequestMapping(value = "/getLimitChartData")
    public LineChartData getLineChartData(){
        LineChartData.Title title=new LineChartData.Title();
        title.setText("故障请求重启限流");
        LineChartData.Toolbox toolbox=new LineChartData.Toolbox();
        LineChartData.Legend legend = new LineChartData.Legend();
        List<String> legendData=  new ArrayList<>();
        legendData.add("当前限流");
        legend.setData(legendData);
        YAxis yAxis = new YAxis();
        LineChartData.Serie serie = new LineChartData.Serie();
        serie.setName("当前限流");
        serie.setType("line");
	    List<LineChartData.Serie> series = new ArrayList<>();
	    series.add(serie);
	    List<XAxisNum> xAxisNum= limitService.getXAxisNum();
        List<Integer> seriesData= limitService.getSeriesData(xAxisNum);
        serie.setData(seriesData);
	    XAxis xAxis = limitService.getXAxis(xAxisNum);
        LineChartData lineChartData = LineChartData.builder().
		        toolbox(toolbox).
		        legend(legend).
		        series(series).
		        title(title).
		        xAxis(xAxis).
		        yAxis(yAxis).
		        build();
        return lineChartData;
    }

	@RequestMapping(value = "/setNum")
	public BaseResponse lineChartStart(@RequestParam Integer num){
		limitService.setNum(num);
		return BaseResponse.createSuccess();
	}


}
