package com.zzw.usermanage.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * @description:
 * @version: 1.0
 * @author: x.x@hand-china.com
 * @date: 2019/3/4
 */
public class BaseDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    protected Long id;

    @Column(name = "data_flag")
    protected int datalag;

    @Column(name = "version_number")
    protected int versionNumber;

    @Column(name = "created_date")
    protected Date createdDate;

    @Column(name = "created_by")
    protected int createdBy;

    @Column(name = "last_updated_date")
    protected Date lastUpdatedDate;

    @Column(name = "last_updated_by")
    protected int lastUpdatedBy;

    @Override
    public String toString() {
        return "BaseDomain{" +
                "id=" + id +
                ", datalag=" + datalag +
                ", versionNumber=" + versionNumber +
                ", createdDate=" + createdDate +
                ", createdBy=" + createdBy +
                ", lastUpdatedDate=" + lastUpdatedDate +
                ", lastUpdatedBy=" + lastUpdatedBy +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDatalag() {
        return datalag;
    }

    public void setDatalag(int datalag) {
        this.datalag = datalag;
    }

    public int getVersionNumber() {
        return versionNumber;
    }

    public void setVersionNumber(int versionNumber) {
        this.versionNumber = versionNumber;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public int getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(int lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }
}
