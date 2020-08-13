package com.frozen.helloboot.controller;

import com.frozen.helloboot.bean.echart.LineChartData;
import com.frozen.helloboot.bean.echart.XAxis;
import com.frozen.helloboot.bean.echart.YAxis;
import com.frozen.helloboot.service.LimitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 冯默风
 * @Date: 2019/1/19 18:41
 * @Description:
 */
@RestController
public class EchartsController {

	@Autowired
	private LimitService limitService;

    @RequestMapping(value = "/getLineChartData")
    public LineChartData getLineChartData(){
        LineChartData.Title title=new LineChartData.Title();
        title.setText("生鲜销量统计");
        LineChartData.Toolbox toolbox=new LineChartData.Toolbox();
        LineChartData.Legend legend = new LineChartData.Legend();
        List<String> legendData=  new ArrayList<>();
        legendData.add("销量");
        legend.setData(legendData);
        XAxis xAxis = new XAxis();
        List<String> xAxisData=  new ArrayList<>();
        xAxisData.add("苹果");
        xAxisData.add("梨子");
        xAxisData.add("橙子");
        xAxisData.add("香蕉");
        xAxisData.add("菠萝");
        xAxisData.add("榴莲");
        xAxis.setData(xAxisData);
        YAxis yAxis = new YAxis();
        LineChartData.Serie serie = new LineChartData.Serie();
        serie.setName("销量");
        serie.setType("line");
        List<Integer> seriesData=  new ArrayList<>();
        seriesData.add(40);
        seriesData.add(40);
        seriesData.add(50);
        seriesData.add(40);
        seriesData.add(70);
        seriesData.add(10);
        serie.setData(seriesData);
        List<LineChartData.Serie> series = new ArrayList<>();
        series.add(serie);
        LineChartData lineChartData = LineChartData.builder().toolbox(toolbox).legend(legend).series(series).title(title).xAxis(xAxis).yAxis(yAxis).build();
        return lineChartData;
    }

}
