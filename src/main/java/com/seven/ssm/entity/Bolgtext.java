package com.seven.ssm.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by douqi on 2017/5/18.
 */
@Entity
public class Bolgtext {
    private int id;
    private String content;
    private Integer userId;
    private String publishTime;
    private String title;
    private String labelId;
    private Integer accessNumber;

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
    @Column(name = "userId", nullable = true)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "publishTime", nullable = true, length = 45)
    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    @Basic
    @Column(name = "title", nullable = true, length = 45)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "labelId", nullable = true, length = 45)
    public String getLabelId() {
        return labelId;
    }

    public void setLabelId(String labelId) {
        this.labelId = labelId;
    }

    @Basic
    @Column(name = "accessNumber", nullable = true)
    public Integer getAccessNumber() {
        return accessNumber;
    }

    public void setAccessNumber(Integer accessNumber) {
        this.accessNumber = accessNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bolgtext bolgtext = (Bolgtext) o;

        if (id != bolgtext.id) return false;
        if (content != null ? !content.equals(bolgtext.content) : bolgtext.content != null) return false;
        if (userId != null ? !userId.equals(bolgtext.userId) : bolgtext.userId != null) return false;
        if (publishTime != null ? !publishTime.equals(bolgtext.publishTime) : bolgtext.publishTime != null)
            return false;
        if (title != null ? !title.equals(bolgtext.title) : bolgtext.title != null) return false;
        if (labelId != null ? !labelId.equals(bolgtext.labelId) : bolgtext.labelId != null) return false;
        if (accessNumber != null ? !accessNumber.equals(bolgtext.accessNumber) : bolgtext.accessNumber != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (publishTime != null ? publishTime.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (labelId != null ? labelId.hashCode() : 0);
        result = 31 * result + (accessNumber != null ? accessNumber.hashCode() : 0);
        return result;
    }
}
