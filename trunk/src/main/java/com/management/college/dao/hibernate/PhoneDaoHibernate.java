package com.management.college.dao.hibernate;

import com.management.college.model.Phone;
import com.management.college.dao.PhoneDao;
import com.management.college.dao.hibernate.GenericDaoHibernate;

public class PhoneDaoHibernate extends GenericDaoHibernate<Phone, Long> implements PhoneDao {

    public PhoneDaoHibernate() {
        super(Phone.class);
    }
}
