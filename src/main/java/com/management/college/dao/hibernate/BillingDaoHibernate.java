package com.management.college.dao.hibernate;

import com.management.college.model.Billing;
import com.management.college.dao.BillingDao;
import com.management.college.dao.hibernate.GenericDaoHibernate;

public class BillingDaoHibernate extends GenericDaoHibernate<Billing, Long> implements BillingDao {

    public BillingDaoHibernate() {
        super(Billing.class);
    }
}
