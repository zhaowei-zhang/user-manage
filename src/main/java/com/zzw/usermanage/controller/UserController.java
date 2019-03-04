package com.zzw.usermanage.controller;

import com.zzw.usermanage.dao.UserRepository;
import com.zzw.usermanage.domain.User;
import com.zzw.usermanage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @description:
 * @version: 1.0
 * @author: x.x@hand-china.com
 * @date: 2019/2/21
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @PostMapping("/Login")
    public User Login(@RequestBody User user) throws Exception{
        System.out.println(user);
        return userService.VerifY(user);
    }

    @PostMapping("/jpatest1")
    public User jpatest1(@RequestBody User user) throws Exception{
        System.out.println(user);
        user=userRepository.findOne(user.getId());
        System.out.println(user);
        return user;
    }

}
