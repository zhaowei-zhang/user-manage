package com.zzw.usermanage.service.impl;

import com.zzw.usermanage.dao.TokenRepository;
import com.zzw.usermanage.dao.UserRepository;
import com.zzw.usermanage.domain.TokenPack;
import com.zzw.usermanage.domain.User;
import com.zzw.usermanage.xmutil.returnpag.*;
import com.zzw.usermanage.service.UserServicel;
import com.zzw.usermanage.yc.Key;
import com.zzw.usermanage.yc.XmError;
import com.zzw.usermanage.yc.XmException;
import org.hibernate.boot.model.source.spi.SingularAttributeSourceToOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.SocketUtils;

import javax.transaction.Transactional;
import java.util.Map;
import java.util.Random;

/**
 * @description: user
 * @version: 1.0
 * @author: zhaowei.zhang@hand-china.com
 * @date: 2019/3/1
 */

@Service
@Transactional
public class UserServiceImpl implements UserServicel {

    private static final String TYPE_USERNAME="userName";
    //登录名确认存在

    private static final String TYPE_ID="id";
    //id确认存在

    private static final User muser;
    //默认用户

    static {
        muser=new User(-1L,-1L,"游客","0","游客",0);
    }

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenRepository tokenRepository;






    @Override
    public Return deleteUser(TokenPack token) {
        return null;
    }


    /**
     * 用户修改
     * @param new_user
     * @param token
     * @return
     */
    @Override
    public Return updateUser(User new_user, TokenPack token) {
        MapReturn mapReturn=new MapReturn();
        try {
            Return user=this.getUserDataByToken(token);
            new_user.setId(((User)((MapReturn)user).getMap().get(ReturnData.user)).getId());
            if(new_user.getUsername()!=null){  }
            else{new_user.setUsername((String)((MapReturn)user).getMap().get("username"));}

            if(new_user.getName()!=null){ }
            else{new_user.setName((String)((MapReturn)user).getMap().get("name"));}

            if(new_user.getAge()!=null){ }
            else{new_user.setAge(Integer.valueOf((String)((MapReturn)user).getMap().get("name")));}

            if(new_user.getPassword()!=null){ new_user.setPassword(this.password2Md5(new_user.getPassword()));}
            else{new_user.setPassword((String)((MapReturn)user).getMap().get("password"));}
            System.out.println("new_user:"+new_user);
            int count=userRepository.updateUserData(new_user.getUsername(),new_user.getPassword(),
                    new_user.getName(),new_user.getAge(),new_user.getId(),new_user.getId());
            if(count!=1){
                throw new XmException(XmError.UPDATE_ERROR);
            }
            mapReturn.add(ReturnData.success,true);
        }catch (Exception e){
            mapReturn.add(ReturnData.success,false);
            mapReturn.add(ReturnData.exception,e.getMessage());
        }
        return mapReturn;
    }

    /**
     * 检验token是否可用
     * @param token
     * @return
     */
    private boolean verifToken(String token) throws XmException{
        TokenPack tokenPack=tokenRepository.queryToken(token);

        if(tokenPack==null){
            throw new XmException(XmError.TOKEN_NO_AVAIL);
        }
        return true;
    }

    /**
     * 根据token获取用户信息
     * @param tokenPack
     * @return
     */
    @Override
    public Return getUserDataByToken(TokenPack tokenPack){
        User user=null;
        MapReturn mapReturn=new MapReturn();
        mapReturn.add(ReturnData.tokenPack,tokenPack);
        try {
            if(verifToken(tokenPack.getToken())){
                Long userId=tokenRepository.getUserIdByToken(tokenPack.getToken());
                user=userRepository.findOne(userId);
                if(user==null){
                    throw new XmException(XmError.USER_NO_AVAIL);
                }
                mapReturn.add(ReturnData.user,user);
                mapReturn.add(ReturnData.success,true);
            }
        }catch (Exception e){
            mapReturn.add(ReturnData.success,false);
            mapReturn.add(ReturnData.exception,e.getMessage());
        }
//        System.out.println(userDataReturn);
        return mapReturn;
    }


    /**
     * 用户信息修改
     * @param user2
     * @param token
     * @return
     */
    public Return updateUser(User user2,String token){
        UserReturn userReturn=new UserReturn();



        return userReturn;
    }





    /**
     * 验证用户账号密码是否正确
     * @param user
     * @return
     * @throws Exception
     */
    @Override
    public Return verifUser(User user){
        User v=userRepository.getUserByUserName(user.getUsername());
        TokenPack token=null;
        UserReturn returnData=new UserReturn(0L,"游客",null);
        try {
            if(v==null){
                throw new XmException(XmError.USERNAME_ERROR);
            }
            if(!v.getPassword().equals(password2Md5(user.getPassword()))){
                throw new XmException(XmError.PASSWORD_ERROR);
            }
            token=getFreeToken();
            int s=tokenRepository.tokenBind(v.getId(),token.getId());
            if(s>0){
                returnData=new UserReturn(v.getUserNumber(),v.getName(),token.getToken());
                returnData.setSuccess(true);
                return returnData;
            }else{
                returnData.setSuccess(false);
                return returnData;
            }
        }
        catch (Exception e){
            returnData.setSuccess(false);
            returnData.setException(e.getMessage());
            return returnData;
        }
    }

    /**
     * 获得自由Token
     * @return
     */
    private TokenPack getFreeToken() throws XmException{
        TokenPack[] tokens=tokenRepository.getFreeTokenList();
        if(tokens==null||tokens.length==0){
            throw new XmException(XmError.NO_FREE_TOKEN);
        }
        int count=tokens.length;
        Random r=new Random();
        TokenPack token=tokens[r.nextInt(count)];
        return token;
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
    public Return addUser(User user) {
        SuccessReturn successReturn=new SuccessReturn();
        try {
            if(!userIsNull(TYPE_USERNAME,user.getUsername())){
                throw new XmException(XmError.ADD_USERNAME_REPEAT);
            }

            userRepository.addIndex();
            Long id=userRepository.getIndex();
            user.setId(id);
            user.setPassword(this.password2Md5(user.getPassword()));
            user=userRepository.save(user);
            successReturn.setSuccess(true);
            return successReturn;
        }
        catch (Exception e){
            successReturn.setSuccess(false);
            successReturn.setException(e.getMessage());
            return successReturn;
        }

    }



    private boolean userIsNull(String type,String...arg){
        if(TYPE_USERNAME.equals(type)){return userRepository.queryCountByUserName(arg[0])<=0;}
        return false;
    }


}
