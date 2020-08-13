package com.frozen.echart.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: 冯默风
 * @Date: 2019/1/19 18:41
 * @Description:
 */
@RestController
public class HelloBoot {
    @RequestMapping(value = "/user")
    public String helloBoot(){
        return "hello boot";
    }
}
