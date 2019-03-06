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
public class User extends BaseDomain{

    public User(){
        super();
    }

    public User(Long id,Long userNumber, String username, String password, String name, Integer age) {
        this.id=id;
        this.userNumber = userNumber;
        this.username = username;
        this.password = password;
        this.name = name;
        this.age = age;
    }

    @Column(name = "user_number")
    private Long userNumber;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;

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

    @Override
    public String toString() {
        return "User{" +
                "userNumber=" + userNumber +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                ", datalag=" + datalag +
                ", versionNumber=" + versionNumber +
                ", createdDate=" + createdDate +
                ", createdBy=" + createdBy +
                ", lastUpdatedDate=" + lastUpdatedDate +
                ", lastUpdatedBy=" + lastUpdatedBy +
                '}';
    }
}
