package com.zzw.usermanage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @description:
 * @version: 1.0
 * @author: x.x@hand-china.com
 * @date: 2019/3/1
 */
@Controller
public class LogInController {


    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index(){
        return "index.html";
    }


    @PostMapping("/test")
    public String test2(){
        return "aaaaaa";
    }
}
