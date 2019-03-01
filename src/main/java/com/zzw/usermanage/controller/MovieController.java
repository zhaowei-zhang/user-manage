package com.zzw.usermanage.controller;


import com.zzw.usermanage.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @description:
 * @version: 1.0
 * @author: x.x@hand-china.com
 * @date: 2019/2/21
 */
@Controller
public class MovieController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id){
        return this.restTemplate.getForObject("http://localhost:8666/"+id,User.class);
    }

    @PostMapping("/user2")
    public @ResponseBody  User findById2(@RequestParam Long id){
        System.out.println("user2");
        return this.restTemplate.getForObject("http://localhost:8666/"+id,User.class);
    }
}
