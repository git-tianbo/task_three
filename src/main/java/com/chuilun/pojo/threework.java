package com.chuilun.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.sql.Timestamp;

@Component
public class threework implements Serializable {


    private Integer threeId;

    private String threeworkName;

    private String briefIntro;

    private String thumbnailPicture;

    private String video;

    private String picture;

    private String intro;

    private Integer state;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Timestamp createAt;

    private String createBy;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Timestamp updateAt;

    private String updateBy;


//    1级表 2级表的id和name
    private Integer oneId;
    private Integer twoId;
    private String oneworkName;
    private String twoworkName;





    public Integer getThreeId() {
        return threeId;
    }

    public void setThreeId(Integer threeId) {
        this.threeId = threeId;
    }

    public String getThreeworkName() {
        return threeworkName;
    }

    public void setThreeworkName(String threeworkName) {
        this.threeworkName = threeworkName;
    }

    public String getBriefIntro() {
        return briefIntro;
    }

    public void setBriefIntro(String briefIntro) {
        this.briefIntro = briefIntro;
    }

    public String getThumbnailPicture() {
        return thumbnailPicture;
    }

    public void setThumbnailPicture(String thumbnailPicture) {
        this.thumbnailPicture = thumbnailPicture;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
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




    //    1级表 2级表的id和name   get/set方法
    public Integer getOneId() {
        return oneId;
    }

    public void setOneId(Integer oneId) {
        this.oneId = oneId;
    }

    public Integer getTwoId() {
        return twoId;
    }

    public void setTwoId(Integer twoId) {
        this.twoId = twoId;
    }

    public String getOneworkName() {
        return oneworkName;
    }

    public void setOneworkName(String oneworkName) {
        this.oneworkName = oneworkName;
    }

    public String getTwoworkName() {
        return twoworkName;
    }

    public void setTwoworkName(String twoworkName) {
        this.twoworkName = twoworkName;
    }





    @Override
    public String toString() {
        return "threework{" +
                "threeId=" + threeId +
                ", oneworkName='" + oneworkName + '\'' +
                ", twoworkName='" + twoworkName + '\'' +
                ", threeworkName='" + threeworkName + '\'' +
                ", briefIntro='" + briefIntro + '\'' +
                ", thumbnailPicture='" + thumbnailPicture + '\'' +
                ", video='" + video + '\'' +
                ", picture='" + picture + '\'' +
                ", intro='" + intro + '\'' +
                ", state=" + state +
                ", createAt=" + createAt +
                ", createBy='" + createBy + '\'' +
                ", updateAt=" + updateAt +
                ", updateBy='" + updateBy + '\'' +
                '}';
    }
}
