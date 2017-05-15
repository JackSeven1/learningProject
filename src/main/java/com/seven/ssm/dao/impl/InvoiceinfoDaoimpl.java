package com.seven.ssm.dao.impl;

import com.seven.ssm.common.dao.impl.BaseDao;
import com.seven.ssm.common.model.ExecuteResult;
import com.seven.ssm.dao.InvoiceinfoDao;
import com.seven.ssm.entity.Invoiceinfo;
import org.springframework.stereotype.Repository;

/**
 * Created by douqi on 2017/4/27.
 */
@Repository
public class InvoiceinfoDaoimpl extends BaseDao<Invoiceinfo> implements InvoiceinfoDao {
    @Override
    public void insertinfo(Invoiceinfo data) {

         this.saveOrUpdate(data);
    }
}
