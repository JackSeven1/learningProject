package com.seven.ssm.common.model;

/**
 * Created by douqi on 2017/4/25.
 */

public class ExecuteResult<T> {
    private boolean isSuccee = false;
    private String des = "";
    private T result;

    public ExecuteResult(boolean isSuccee,String des, T result) {
        this.isSuccee = isSuccee;
        this.result = result;
        this.des = des;
    }
    public ExecuteResult(boolean isSuccee,String des) {
        this.isSuccee = isSuccee;
        this.des = des;
    }
    public boolean getIsSuccee() {
        return isSuccee;
    }

    public void setIsSuccee(boolean isSuccee) {
        this.isSuccee = isSuccee;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public ExecuteResult(){}
    public ExecuteResult(boolean isSuccee) {
        this.isSuccee = isSuccee;
    }
}