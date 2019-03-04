package com.zzw.usermanage.service;

import com.zzw.usermanage.domain.User;

/**
 * @description:
 * @version: 1.0
 * @author: x.x@hand-china.com
 * @date: 2019/3/4
 */
public interface UserServicel {
    public User verifYh(User user) throws Exception;

    public User addUser(User user);
}
