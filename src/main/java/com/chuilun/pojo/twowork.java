package com.chuilun.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

@Component
public class twowork implements Serializable {

    private Integer twoId;

    private String twoworkName;

    private Integer state;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Timestamp createAt;

    private String createBy;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Timestamp updateAt;

    private String updateBy;

    private Integer oneId;

    private String oneWorkName;


    public Integer getTwoId() {
        return twoId;
    }

    public void setTwoId(Integer twoId) {
        this.twoId = twoId;
    }

    public String getTwoworkName() {
        return twoworkName;
    }

    public void setTwoworkName(String twoworkName) {
        this.twoworkName = twoworkName;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Timestamp getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Timestamp updateAt) {
        this.updateAt = updateAt;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Integer getOneId() {
        return oneId;
    }

    public void setOneId(Integer oneId) {
        this.oneId = oneId;
    }

    public String getOneWorkName() {
        return oneWorkName;
    }

    public void setOneWorkName(String oneWorkName) {
        this.oneWorkName = oneWorkName;
    }

    @Override
    public String toString() {
        return "twowork{" +
                "twoId=" + twoId +
                ", twoworkName='" + twoworkName + '\'' +
                ", state=" + state +
                ", createAt=" + createAt +
                ", createBy='" + createBy + '\'' +
                ", updateAt=" + updateAt +
                ", updateBy='" + updateBy + '\'' +
                ", oneWorkName='" + oneWorkName + '\'' +
                '}';
    }
}


