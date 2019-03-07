package com.zzw.usermanage.service;

import com.zzw.usermanage.domain.TokenPack;
import com.zzw.usermanage.domain.User;
import com.zzw.usermanage.xmutil.returnpag.Return;

import java.util.Map;

/**
 * @description:
 * @version: 1.0
 * @author: x.x@hand-china.com
 * @date: 2019/3/4
 */
public interface UserServicel {

    /**
     * 用户登陆验证
     * @param user
     * @return
     */
    Return verifUser(User user);

    /**
     * 增加用户
     * @param user
     * @return
     */
    Return addUser(User user);

    /**
     * 获取用户信息 by token
     * @param token
     * @return
     */
    Return getUserDataByToken(TokenPack token);

    Return deleteUser(TokenPack token);

    Return updateUser(User new_user, TokenPack token);


}
