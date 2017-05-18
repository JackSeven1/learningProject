package com.seven.ssm.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by douqi on 2017/5/18.
 */
@Entity
public class Commenttable {
    private int id;
    private String content;
    private Integer userId;
    private Integer userCid;
    private String replyTime;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "content", nullable = true, length = -1)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "user_id", nullable = true)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "user_cid", nullable = true)
    public Integer getUserCid() {
        return userCid;
    }

    public void setUserCid(Integer userCid) {
        this.userCid = userCid;
    }

    @Basic
    @Column(name = "replyTime", nullable = true, length = 45)
    public String getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(String replyTime) {
        this.replyTime = replyTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Commenttable that = (Commenttable) o;

        if (id != that.id) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (userCid != null ? !userCid.equals(that.userCid) : that.userCid != null) return false;
        if (replyTime != null ? !replyTime.equals(that.replyTime) : that.replyTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (userCid != null ? userCid.hashCode() : 0);
        result = 31 * result + (replyTime != null ? replyTime.hashCode() : 0);
        return result;
    }
}
