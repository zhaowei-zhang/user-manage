package com.zzw.usermanage.dao;

import com.zzw.usermanage.domain.TokenPack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @description:
 * @version: 1.0
 * @author: zhaowei.zhang01@hand-china.com
 * @date: 2019/3/6
 */
@Repository
public interface TokenRepository extends JpaRepository<TokenPack,Long> {

    @Query(nativeQuery = true,
            value = "update token_table a set a.user_id = ?1 where a.id=?2")
    @Modifying
    int tokenBind(Long userId,Long id);


    @Query(nativeQuery = true,
            value = "select a.* from token_table a where a.user_id = -1")
    TokenPack[] getFreeTokenList();

    @Query(nativeQuery = true,
    value = "update token_table a set a.user_id = 0")
    @Modifying
    void freeAllToken();


    @Query(nativeQuery = true,
    value = "select a.user_id from token_table a where a.token = ?1")
    Long getUserIdByToken(String token);

    @Query(nativeQuery = true,
    value = "select * from token_table a  where a.token = ?1 and a.token_state = 1")
    TokenPack queryToken(String token);
}
