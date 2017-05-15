package com.seven.ssm.common.service.impl;
import com.seven.ssm.common.dao.IBaseDao;
import com.seven.ssm.common.service.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;


/**
 * Created by douqi on 2017/4/25.
 */

public class BaseService<T> implements IBaseService<T> {
    private Class<T> clazz;
    /**
     * 通过构造方法获取泛型类，即实现此类的具体实体 0.0
     */
    public BaseService() {
        Type type = this.getClass().getGenericSuperclass();//获取泛型
        if (!type.toString().contains("java.lang.Object")) {
            ParameterizedType parameterizedType = (ParameterizedType) type; //转为参数化类型
            clazz = (Class<T>) parameterizedType.getActualTypeArguments()[0];
        }
    }
    @Autowired
    private IBaseDao<T> dao;

    @Override
    public Serializable save(T entity) {
        return dao.save(entity);
    }

    @Override
    public void update(T entity) {
        dao.update(entity);
    }

    @Override
    public void delete(T entity) {
        dao.delete(entity);
    }

    @Override
    public T getById(Serializable id) {
        return dao.findById(clazz,id);
    }

    @Override
    public void deleteAll() {
        dao.deleteAll(clazz);
    }

    @Override
    public List<T> getAll() {
        return dao.getAll(clazz);
    }

}