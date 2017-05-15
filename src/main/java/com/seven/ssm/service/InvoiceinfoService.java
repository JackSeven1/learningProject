package com.seven.ssm.service;

import com.seven.ssm.common.service.IBaseService;
import com.seven.ssm.entity.Invoiceinfo;

/**
 * Created by douqi on 2017/4/27.
 */
public interface InvoiceinfoService extends IBaseService<Invoiceinfo> {

    public void insertinfo(Invoiceinfo data);
}
