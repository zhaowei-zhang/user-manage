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
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/Login")
    public @ResponseBody User Login(@RequestBody User user) throws Exception{
        System.out.println(user);
        return userService.VerifY(user);
    }
}
