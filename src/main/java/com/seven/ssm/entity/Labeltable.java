package com.seven.ssm.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by douqi on 2017/5/18.
 */
@Entity
public class Labeltable {
    private int id;
    private String content;
    private String newTime;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "content", nullable = true, length = 125)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "newTime", nullable = true, length = 45)
    public String getNewTime() {
        return newTime;
    }

    public void setNewTime(String newTime) {
        this.newTime = newTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Labeltable that = (Labeltable) o;

        if (id != that.id) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (newTime != null ? !newTime.equals(that.newTime) : that.newTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (newTime != null ? newTime.hashCode() : 0);
        return result;
    }
}
