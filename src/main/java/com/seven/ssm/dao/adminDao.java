package com.seven.ssm.dao;


import com.seven.ssm.common.dao.IBaseDao;
import com.seven.ssm.entity.User;

/**
 * Created by douqi on 2017/4/20.
 */
public interface adminDao extends IBaseDao<User> {

    public int getlogin();
}
