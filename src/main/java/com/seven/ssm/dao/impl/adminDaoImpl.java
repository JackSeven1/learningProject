package com.seven.ssm.dao.impl;

import com.seven.ssm.common.dao.impl.BaseDao;
import com.seven.ssm.dao.adminDao;
import com.seven.ssm.entity.User;
import org.springframework.stereotype.Repository;

/**
 * Created by douqi on 2017/4/20.
 */

@Repository
public class adminDaoImpl extends BaseDao<User> implements adminDao {

    public int getlogin() {


        return 0;
    }
}
