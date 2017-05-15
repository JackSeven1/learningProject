package com.seven.ssm.dao;

import com.seven.ssm.common.dao.IBaseDao;
import com.seven.ssm.entity.Invoiceinfo;

/**
 * Created by douqi on 2017/4/27.
 */
public interface InvoiceinfoDao extends IBaseDao<Invoiceinfo>  {
    public void insertinfo(Invoiceinfo data);
}
