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
public class IndexController {
    @RequestMapping(value = "index")
    public String index(){
        return "index";
    }
}
