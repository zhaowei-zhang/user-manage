package com.zzw.usermanage.dao;

import com.zzw.usermanage.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @description:
 * @version: 1.0
 * @author: x.x@hand-china.com
 * @date: 2019/2/21
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long>,UserDao {
}
