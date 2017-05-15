package com.seven.ssm.service.impl;

import com.seven.ssm.common.model.ExecuteResult;
import com.seven.ssm.common.service.impl.BaseService;
import com.seven.ssm.dao.InvoiceinfoDao;
import com.seven.ssm.entity.Invoiceinfo;
import com.seven.ssm.service.InvoiceinfoService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by douqi on 2017/4/27.
 */
@Service
public class InvoiceinfoServiceimpl extends BaseService<Invoiceinfo> implements InvoiceinfoService {

    @Autowired
    InvoiceinfoDao invoiceinfoDao;
    public void insertinfo(Invoiceinfo data){
        ExecuteResult executeResult = new ExecuteResult();
        invoiceinfoDao.insertinfo(data);
    }

    @Test
    public void insertinfo() throws Exception {
            System.out.print("ss");
    }
}
