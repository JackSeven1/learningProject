package com.seven.ssm.dao;


import com.seven.ssm.common.dao.IBaseDao;
import com.seven.ssm.entity.User;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * Created by douqi on 2017/4/20.
 */
public interface adminDao extends IBaseDao<User> {
    public  User checkLogin(User user) throws Exception;

    public void findUserById(int id) throws  Exception;

    public int findUserNameByCount(User user) throws  Exception;
}
