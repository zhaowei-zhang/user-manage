package com.zzw.usermanage.service;

import com.zzw.usermanage.domain.TokenPack;
import com.zzw.usermanage.domain.User;
import com.zzw.usermanage.xmutil.returnpag.Return;

/**
 * @description:
 * @version: 1.0
 * @author: x.x@hand-china.com
 * @date: 2019/3/4
 */
public interface UserServicel {
    Return verifUser(User user);

    Return addUser(User user);

    Return getUserDataByToken(TokenPack token);
}
