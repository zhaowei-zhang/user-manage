package com.zzw.usermanage.controller;

import com.zzw.usermanage.domain.TokenPack;
import com.zzw.usermanage.domain.User;
import com.zzw.usermanage.xmutil.returnpag.Return;
import com.zzw.usermanage.service.UserServicel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


 /**
 * @apiDefine UserController 用户控制器
 */
/**
 * @description:
 * @version: 1.0
 * @author: x.x@hand-china.com
 * @date: 2019/2/21
 */
@RestController
@RequestMapping("/api/user")
public class UserController {



    @Autowired
    private UserServicel userService;

    
    @PostMapping("/getUserData")
    public Return getUserData(@RequestBody TokenPack tokenPack){
        return userService.getUserDataByToken(tokenPack);
    }



    /**
     * @api {Post} /api/user/login 登陆 api
     * @apiName login
     * @apiGroup UserController
     *
     * @apiParam {String}   username 登录名
     * @apiParam {String}   password 登陆密码
     *
     * @apiParamExample {json} 请求参数:
     * {
     *        "username":"admin",
     *        "password":"000000"
     * }
     *
     *
     * @apiSuccess {int} 1 变更行数
     *
     *
     * @apiSuccessExample {json} 成功返回值:
     * {
     *     "userNumber": XXXXXX,
     *     "name": "张照威",
     *     "token": "XXXXXXXXXXXXXXXX",
     *     "exception": null
     * }
     */
    @PostMapping("/login")
    public Return login(@RequestBody User user) {
        System.out.println(user);
        return userService.verifUser(user);
    }



    /**
     * @api {Post} /api/user/addUser 注册用户 api
     * @apiName addUser
     * @apiGroup UserController
     *
     * @apiParam {String}   username 登录名
     * @apiParam {String}   password 登陆密码
     * @apiParam {String}   userNumber 用户编码
     * @apiParam {String}   age 年龄
     * @apiParam {String}   name 姓名
     *
     * @apiParamExample {json} 请求参数:
     * {
     *     "userNumber" : "865533614",
     *     "age" : "24",
     *     "name": "张照威",
     *     "username":"admin",
     *     "password":"000000"
     * }
     *
     *
     * @apiSuccess {int} 1 变更行数
     *
     *
     * @apiSuccessExample {json} 成功返回值:
     * {
     *     "id": null,
     *     "datalag": 0,
     *     "versionNumber": 0,
     *     "createdDate": null,
     *     "createdBy": 0,
     *     "lastUpdatedDate": null,
     *     "lastUpdatedBy": 0,
     *     "userNumber": 865533614,
     *     "username": "admin",
     *     "password": "000000",
     *     "name": "张照威",
     *     "age": 24
     * }
     */
    @PostMapping("/addUser")
    public Return addUser(@RequestBody User user) throws Exception{
        return userService.addUser(user);
    }





}
