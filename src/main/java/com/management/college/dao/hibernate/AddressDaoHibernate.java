package com.management.college.dao.hibernate;

import com.management.college.model.Address;
import com.management.college.dao.AddressDao;
import com.management.college.dao.hibernate.GenericDaoHibernate;

public class AddressDaoHibernate extends GenericDaoHibernate<Address, Long> implements AddressDao {

    public AddressDaoHibernate() {
        super(Address.class);
    }
}
