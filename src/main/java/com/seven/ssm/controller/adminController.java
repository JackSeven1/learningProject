package com.seven.ssm.controller;

import com.seven.ssm.common.model.ExecuteResult;
import com.seven.ssm.entity.User;
import com.seven.ssm.service.AdminService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by douqi on 2017/4/20.
 */
@Controller
@RequestMapping("/user")
public class adminController {
    private Logger logger = Logger.getLogger(adminController.class);


    @Autowired
    private AdminService adminService;



    @RequestMapping("/index")
    public String gotoIndex(){
        return "index";
    }


    @RequestMapping("/login")
    @ResponseBody
    public ExecuteResult login(@ModelAttribute User user){
        ExecuteResult executeResult=new ExecuteResult();
        try {
            executeResult.setIsSuccee(true);
            executeResult.setDes("sss");
        }catch (Exception e){

        }finally {
            return executeResult;
        }

    }

}
