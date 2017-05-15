package com.seven.ssm.common.service;
import java.io.Serializable;
import java.util.List;
/**
 * Created by douqi on 2017/4/25.
 */

public interface IBaseService<T>{
    public Serializable save(T entity);
    public void update(T entity);
    public void delete(T entity);
    public T getById(Serializable id);
    public void deleteAll();
    public List<T> getAll();
}