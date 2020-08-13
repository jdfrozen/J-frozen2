package com.frozen.helloboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: Frozen
 * @create: 2019-08-23 13:59
 * @description:
 **/
@Controller
@RequestMapping("/")
public class LimitEchartsViewController {
    @RequestMapping(value = "limitLine")
    public String index(){
        return "/echarts/limitLine";
    }
}
