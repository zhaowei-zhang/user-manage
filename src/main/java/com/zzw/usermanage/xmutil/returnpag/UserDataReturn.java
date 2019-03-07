package com.zzw.usermanage.xmutil.returnpag;

import com.zzw.usermanage.domain.User;

/**
 * @description:
 * @version: 1.0
 * @author: zhaowei.zhang01@hand-china.com
 * @date: 2019/3/7
 */
public class UserDataReturn extends SuccessReturn {

    protected Long userNumber;
    protected String username;
    protected String password;
    protected String name;
    protected Integer age;
    protected String token;
    public UserDataReturn(){
        super();
    }
    public UserDataReturn(User user,String token) {
        this.userNumber=user.getUserNumber();
        this.username=user.getUsername();
        this.password=user.getPassword();
        this.name=user.getName();
        this.age=user.getAge();
        this.token=token;
    }

    public UserDataReturn(boolean success) {
        super(success);
    }

    public UserDataReturn(boolean success, String exception) {
        super(success, exception);
    }

    public Long getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(Long userNumber) {
        this.userNumber = userNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
