package com.example.domain;

import java.math.BigInteger;
import java.util.Date;

/**
 * @author Created by yangwj5 on 2017/3/21 at 23:47.
 */
public class BatchJobExecution {
    private BigInteger id;
    private BigInteger version;
    private BigInteger jobInstanceId;
    private Date  createTime;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getVersion() {
        return version;
    }

    public void setVersion(BigInteger version) {
        this.version = version;
    }

    public BigInteger getJobInstanceId() {
        return jobInstanceId;
    }

    public void setJobInstanceId(BigInteger jobInstanceId) {
        this.jobInstanceId = jobInstanceId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return com.google.common.base.MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("version", version)
                .add("jobInstanceId", jobInstanceId)
                .add("createTime", createTime)
                .toString();
    }
}
