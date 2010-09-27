package com.management.college.dao.hibernate;

import com.management.college.model.DecodeValue;
import com.management.college.dao.DecodeValueDao;
import com.management.college.dao.hibernate.GenericDaoHibernate;

public class DecodeValueDaoHibernate extends GenericDaoHibernate<DecodeValue, Long> implements DecodeValueDao {

    public DecodeValueDaoHibernate() {
        super(DecodeValue.class);
    }
}
