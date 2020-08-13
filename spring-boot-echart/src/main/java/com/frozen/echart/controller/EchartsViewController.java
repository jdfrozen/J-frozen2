package com.frozen.echart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: Frozen
 * @create: 2019-08-23 13:59
 * @description:
 **/
@Controller
@RequestMapping("/")
public class EchartsViewController {
    @RequestMapping(value = "lineChart")
    public String index(){
        return "/echarts/lineChart";
    }
}
