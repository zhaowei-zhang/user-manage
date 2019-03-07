package com.zzw.usermanage.controller;

import com.zzw.usermanage.domain.TokenPack;
import com.zzw.usermanage.domain.User;
import com.zzw.usermanage.xmutil.returnpag.MapReturn;
import com.zzw.usermanage.xmutil.returnpag.Return;
import com.zzw.usermanage.service.UserServicel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;


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

    /**
     * @api {Post} /api/user/getUserData 登陆 api
     * @apiName getUserData
     * @apiGroup UserController
     *
     * @apiParam {String}   token 登录人token
     *
     * @apiParamExample {json} 请求参数:
     * {
     *        "token":"xxxxxxxxxxxxxxxxxxx"
     * }
     *
     *
     * @apiSuccess {int} 0 变更行数
     *
     *
     * @apiSuccessExample {json} 成功返回值:
     * {
     *     "success": true,
     *     "exception": null,
     *     "userNumber": 865533614,
     *     "username": "admin",
     *     "password": "1eb1f481ceaf83536f48b38d1d330e91",
     *     "name": "张照威",
     *     "age": 24,
     *     "token": "xxxxxxxxxxxxxxxxxxxx"
     * }
     */
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
    public Return addUser(@RequestBody User user){
        return userService.addUser(user);
    }


    @PutMapping("/updateUser")
    public Return updateUser(@RequestBody User user, HttpServletRequest request){
        String token=request.getHeader("token");
        System.out.println(token);
        TokenPack tokenPack=new TokenPack();
        tokenPack.setToken(token);
        return userService.updateUser(user,tokenPack);
    }


    @PostMapping("/test")
    public Return test(){
        MapReturn mapReturn=new MapReturn();
        mapReturn.add("name","张照威");
        mapReturn.add("user",new User(1L,1L,"a","a","a",1));
        MapReturn mapReturn2=new MapReturn();
        mapReturn2.add("m2",mapReturn);
        return mapReturn2;
    }

}
