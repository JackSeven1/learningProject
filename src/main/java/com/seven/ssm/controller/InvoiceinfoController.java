package com.seven.ssm.controller;

import com.alibaba.fastjson.JSONObject;
import com.seven.ssm.common.model.ExecuteResult;
import com.seven.ssm.entity.Invoiceinfo;
import com.seven.ssm.service.InvoiceinfoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by douqi on 2017/4/27.
 * 上传发票数据
 */
@Controller
@RequestMapping("/invoiceinfo")
public class InvoiceinfoController {

    private Logger logger = Logger.getLogger(InvoiceinfoController.class);

    @Autowired
    InvoiceinfoService invoiceinfoService;

    @RequestMapping("/updataInfo")
    public ExecuteResult updataInvoiceinfo(HttpServletRequest request) throws Exception{
        ExecuteResult executeResult = new ExecuteResult();
        Invoiceinfo data = JSONObject.parseObject(request.getParameter("data"), Invoiceinfo.class);
//        invoiceinfoService.insertinfo(data);
        invoiceinfoService.save(data);
        return executeResult;
    }
}
