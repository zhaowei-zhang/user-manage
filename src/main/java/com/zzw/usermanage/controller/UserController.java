package com.zzw.usermanage.controller;

import com.zzw.usermanage.dao.UserRepository;
import com.zzw.usermanage.domain.User;
import com.zzw.usermanage.service.UserServicel;
import com.zzw.usermanage.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description:
 * @version: 1.0
 * @author: x.x@hand-china.com
 * @date: 2019/2/21
 */
@RestController
public class UserController {
    //aaaaaaaaaaaaaaaaaaaaaaa



    @Autowired
    private UserServicel userService;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/Login")
    public User Login(@RequestBody User user) throws Exception{
        System.out.println(user);
        return userService.verifYh(user);
    }

    @PostMapping("/addUser")
    public User jpatest1(@RequestBody User user) throws Exception{
        return userService.addUser(user);
    }

    @PostMapping("/verifYh")
    public User verifYh(@RequestBody User user) throws Exception{
        System.out.println(user);
        return userService.verifYh(user);
    }


}
