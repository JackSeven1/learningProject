package com.seven.ssm.service.impl;

import com.seven.ssm.common.model.ExecuteResult;
import com.seven.ssm.common.service.impl.BaseService;
import com.seven.ssm.dao.adminDao;
import com.seven.ssm.entity.User;
import com.seven.ssm.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by douqi on 2017/4/20.
 */
@Service
public class AdminServiceimpl extends BaseService<User> implements AdminService {
    @Autowired
    private adminDao adminDao;

    public ExecuteResult getlogin() {
        adminDao.getlogin();
        return null;
    }
}
