package com.seven.ssm.service;


import com.seven.ssm.common.model.ExecuteResult;
import com.seven.ssm.common.service.IBaseService;
import com.seven.ssm.entity.User;

/**
 * Created by douqi on 2017/4/20.
 */

public interface AdminService extends IBaseService<User> {


    public ExecuteResult getlogin();
}
