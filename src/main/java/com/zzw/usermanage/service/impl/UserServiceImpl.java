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
 * @description: user
 * @version: 1.0
 * @author: zhaowei.zhang@hand-china.com
 * @date: 2019/3/1
 */

@Service
public class UserServiceImpl implements UserServicel {

    private static final String TYPE_USERNAME="userName";
    //登录名确认存在

    private static final String TYPE_ID="id";
    //id确认存在

    private static final User user;
    //默认用户

    static {
        user=new User(-1L,-1L,"游客","0","游客",0);
    }

    @Autowired
    private UserRepository userRepository;


    /**
     * 验证用户账号密码是否正确
     * @param user
     * @return
     * @throws Exception
     */
    @Override
    public User verifUser(User user) throws Exception{
        User v=userRepository.getUserByUserName(user.getUsername());
        if(v==null){
            throw new XmException(XmError.USERNAME_ERROR);
        }
        if(!v.getPassword().equals(password2Md5(user.getPassword()))){
            throw new XmException(XmError.PASSWORD_ERROR);
        }
        return v;
    }


    /**
     * MD5加密
     * @param password
     * @return
     */
    private String password2Md5(String password){
        String passwordkey;
        passwordkey=DigestUtils.md5DigestAsHex(password.getBytes());
        passwordkey=passwordkey+Key.MAP.get("md5key");
        passwordkey=DigestUtils.md5DigestAsHex(passwordkey.getBytes());
        return passwordkey;
    }


    /**
     * 增加新用户
     * @param user
     * @return
     */
    @Override
    public User addUser(User user) {

        if(!userIsNull(TYPE_USERNAME,user.getUsername())){
            return user;
        }


        Long id=userRepository.getIdMax()+1;
        user.setId(id);
        System.out.println("id:"+id);
        user.setPassword(this.password2Md5(user.getPassword()));
        user=userRepository.save(user);
        System.out.println("user:"+user);
        return user;
    }



    private boolean userIsNull(String type,String...arg){
        if(TYPE_USERNAME.equals(type)){return userRepository.queryCountByUserName(arg[0])<=0;}
        return false;
    }


}
