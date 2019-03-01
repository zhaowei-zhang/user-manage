package com.zzw.usermanage.domain;


import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @description:
 * @version: 1.0
 * @author: x.x@hand-china.com
 * @date: 2019/2/21
 */
@Entity
@Table(name = "user_basic_data")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userid;

    @Column
    private Long usernumber;

    @Column
    private String username;

    @Column
    private String userpass;

    @Column
    private String name;

    @Column
    private Integer age;


    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getUsernumber() {
        return usernumber;
    }

    public void setUsernumber(Long usernumber) {
        this.usernumber = usernumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpass() {
        return userpass;
    }

    public void setUserpass(String userpass) {
        this.userpass = userpass;
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
}
