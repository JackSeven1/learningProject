package com.seven.ssm.service.impl;

import com.seven.ssm.common.model.ExecuteResult;
import com.seven.ssm.common.service.impl.BaseService;
import com.seven.ssm.dao.adminDao;
import com.seven.ssm.entity.User;
import com.seven.ssm.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Created by douqi on 2017/4/20.
 */
@Service
public class AdminServiceimpl extends BaseService<User> implements AdminService {

    private static Logger logger = Logger.getLogger(AdminServiceimpl.class);

    private HttpServletResponse response;
    @Autowired
    private adminDao adminDao;
    public ExecuteResult checkLogin(User user,HttpSession session) {
        ExecuteResult executeResult = new ExecuteResult();
        try {
           int i =  adminDao.findUserNameByCount(user);
           if (i!=0){
               User user1 = adminDao.checkLogin(user);
               if (user1!=null){
                   //保持用户登录
                   executeResult.setIsSuccee(true);
                   session.setAttribute("userId",user1.getId());
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
