package com.zzw.usermanage.xmutil.returnpag;

/**
 * @description:
 * @version: 1.0
 * @author: zhaowei.zhang01@hand-china.com
 * @date: 2019/3/6
 */
public class UserReturn extends SuccessReturn {


    protected Long userNumber;
    protected String name;
    protected String token;

    public UserReturn() {
        super();
    }

    public UserReturn(Long userNumber, String name, String token) {
        this.userNumber = userNumber;
        this.name = name;
        this.token = token;
    }



    public Long getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(Long userNumber) {
        this.userNumber = userNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
