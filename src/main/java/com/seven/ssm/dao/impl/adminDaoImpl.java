package com.seven.ssm.dao.impl;

import com.seven.ssm.common.dao.impl.BaseDao;
import com.seven.ssm.common.model.ParameterKeyValue;
import com.seven.ssm.dao.adminDao;
import com.seven.ssm.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by douqi on 2017/4/20.
 */

@Repository
public class adminDaoImpl extends BaseDao<User> implements adminDao {
    /**
     * 检查登录状态并返回用户信息
     * @param user
     * @return
     * @throws Exception
     */

    @Override
    public User checkLogin(User user) throws Exception {
        String sql ="select id ,name from user where username=:username and password =:password";
        List<ParameterKeyValue> params=new ArrayList<ParameterKeyValue>();
        params.add(new ParameterKeyValue("username",user.getUsername()));
        params.add(new ParameterKeyValue("password",user.getPassword()));
        return this.getBySQL(User.class,sql,params);
    }

    /**
     * 根据用户id 查找用户信息
     * @param id
     * @throws Exception
     */
    @Override
    public void findUserById(int id) throws Exception {

    }
    /**
     *  根据账号查询用户是否存在
     * @param user
     * @throws Exception
     */
    @Override
    public int findUserNameByCount(User user) throws Exception {
        String hql ="select * from user where username=:username";
        List<ParameterKeyValue> params=new ArrayList<ParameterKeyValue>();
        params.add(new ParameterKeyValue("username",user.getUsername()));
        return this.execSQL(User.class,hql,params).size();
    }
}
