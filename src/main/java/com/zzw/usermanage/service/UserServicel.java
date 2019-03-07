package com.zzw.usermanage.service;

import com.zzw.usermanage.domain.User;
import com.zzw.usermanage.xmutil.returnpag.Return;

/**
 * @description:
 * @version: 1.0
 * @author: x.x@hand-china.com
 * @date: 2019/3/4
 */
public interface UserServicel {
    public Return verifUser(User user) throws Exception;

    public Return addUser(User user);
}
