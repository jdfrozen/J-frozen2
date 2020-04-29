package com.frozen.rpcclient.controller;

import com.frozen.rpcclient.service.ClientApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Frozen
 * @create: 2019-08-23 13:59
 * @description:
 **/
@RestController
@Slf4j
public class IndexController {

    @RequestMapping(value = "index")
    public String index(){
        return "/index";
    }

}
