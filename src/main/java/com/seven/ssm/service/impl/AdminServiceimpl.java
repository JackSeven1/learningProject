package com.seven.ssm.service.impl;

import com.seven.ssm.common.model.ExecuteResult;
import com.seven.ssm.common.service.impl.BaseService;
import com.seven.ssm.dao.adminDao;
import com.seven.ssm.entity.User;
import com.seven.ssm.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.log4j.Logger;


/**
 * Created by douqi on 2017/4/20.
 */
@Service
public class AdminServiceimpl extends BaseService<User> implements AdminService {
    @Autowired
    private adminDao adminDao;
    private static Logger logger = Logger.getLogger(AdminServiceimpl.class);
    public ExecuteResult checkLogin(User user) {
        ExecuteResult executeResult = new ExecuteResult();
        try {
           int i =  adminDao.findUserNameByCount(user);
           if (i!=0){
               User user1 = adminDao.checkLogin(user);
               if (user1!=null){
                   executeResult.setIsSuccee(true);
                   executeResult.setDes("成功");
               }else {
                   executeResult.setIsSuccee(false);
                   executeResult.setDes("密码错误！");
               }
           }else {
               executeResult.setIsSuccee(false);
               executeResult.setDes("用户不存在！");
           }

        }catch (Exception e){
            logger.error(e.getMessage());
            executeResult.setIsSuccee(false);
            executeResult.setDes(e.getMessage());
        }
        finally {
            return executeResult;
        }
    }
}
