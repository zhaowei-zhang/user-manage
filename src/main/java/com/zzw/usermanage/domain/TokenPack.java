package com.zzw.usermanage.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * @description:
 * @version: 1.0
 * @author: zhaowei.zhang01@hand-china.com
 * @date: 2019/3/6
 */
@Entity
@Table(name = "token_table")
public class TokenPack extends BaseDomain{

    public TokenPack() {
        super();
    }


    @Column(name = "token")
    private String token;

    @Column(name = "token_state")
    private int tokenState;

    @Column(name = "star_date")
    private Date starTdate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "user_id")
    private Long userId;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getTokenState() {
        return tokenState;
    }

    public void setTokenState(int tokenState) {
        this.tokenState = tokenState;
    }

    public Date getStarTdate() {
        return starTdate;
    }

    public void setStarTdate(Date starTdate) {
        this.starTdate = starTdate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Token{" +
                "token='" + token + '\'' +
                ", tokenState=" + tokenState +
                ", starTdate=" + starTdate +
                ", endDate=" + endDate +
                ", userId=" + userId +
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
