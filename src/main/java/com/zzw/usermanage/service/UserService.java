package com.zzw.usermanage.service;

import com.zzw.usermanage.dao.UserRepository;
import com.zzw.usermanage.domain.User;
import com.zzw.usermanage.yc.XmError;
import com.zzw.usermanage.yc.XmException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @description:
 * @version: 1.0
 * @author: x.x@hand-china.com
 * @date: 2019/3/1
 */

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id){
        User findOne;
        findOne = this.userRepository.findOne(id);
        return findOne;
    }


    public User VerifY(User user) throws Exception{
        User v=userRepository.fandByUserName(user.getUserName());
        if(v==null){
            throw new XmException(XmError.USERNAME_ERROR);
        }
        if(v.getUserPass()!=user.getUserPass()){
            throw new XmException(XmError.USERPASS_ERROR);
        }
        return user;
    }
}
