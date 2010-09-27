package com.management.college.service.impl;

import com.management.college.dao.BillingDao;
import com.management.college.model.Billing;
import com.management.college.service.BillingManager;
import com.management.college.service.impl.GenericManagerImpl;

import java.util.List;
import javax.jws.WebService;

@WebService(serviceName = "BillingService", endpointInterface = "com.management.college.service.BillingManager")
public class BillingManagerImpl extends GenericManagerImpl<Billing, Long> implements BillingManager {
    BillingDao billingDao;

    public BillingManagerImpl(BillingDao billingDao) {
        super(billingDao);
        this.billingDao = billingDao;
    }
}