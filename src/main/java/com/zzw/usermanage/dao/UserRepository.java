package com.zzw.usermanage.dao;

import com.zzw.usermanage.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @description:
 * @version: 1.0
 * @author: x.x@hand-china.com
 * @date: 2019/2/21
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Query(nativeQuery = true,
            value =
            "SELECT * FROM user_basic_data where username = ?1")
    User getUserByUserName(String userName);

    @Query(nativeQuery = true,
    value = "select * from user_pk")
    Long getIndex();

    @Query(nativeQuery = true,
    value = "update user_pk a set a.id=a.id+1")
    @Modifying
    void addIndex();


    @Query(nativeQuery = true,
    value = "select count(*) from user_basic_data where  username = ?1")
    int queryCountByUserName(String userName);


    @Query(nativeQuery = true,
    value = "update user_basic_data a " +
            "set a.username= ?1,a.password = ?2," +
            "a.name=?3,a.age=?4,a.last_updated_by = ?6," +
            "a.last_updated_date= SYSDATE() " +
            "where a.id=?5 ")
    @Modifying
    int updateUserData(String username,String password,String name,int age,Long id,Long lastId);

    //String getToken();
}
