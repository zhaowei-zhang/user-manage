package com.zzw.usermanage.service.impl;

import com.zzw.usermanage.dao.UserRepository;
import com.zzw.usermanage.domain.User;
import com.zzw.usermanage.service.UserServicel;
import com.zzw.usermanage.yc.Key;
import com.zzw.usermanage.yc.XmError;
import com.zzw.usermanage.yc.XmException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import java.util.List;

/**
 * @description:
 * @version: 1.0
 * @author: x.x@hand-china.com
 * @date: 2019/3/1
 */

@Service
public class UserServiceImpl implements UserServicel {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User verifYh(User user) throws Exception{
        User v=userRepository.getUserByUserName(user.getUsername());
        if(v==null){
            throw new XmException(XmError.USERNAME_ERROR);
        }
        if(!v.getPassword().equals(user.getPassword())){
            throw new XmException(XmError.PASSWORD_ERROR);
        }
        return v;
    }

    public String password2Md5(String password){
        return DigestUtils.md5DigestAsHex((password+Key.MAP.get("md5key")).getBytes());
    }

    @Override
    public User addUser(User user) {
        Long id=userRepository.getIdMax();
        user.setId(id);
        user.setPassword(this.password2Md5(user.getPassword()));
        user=userRepository.save(user);
        System.out.println("user:"+user);
        return user;
    }
}
