package com.management.college.dao.hibernate;

import com.management.college.model.PersonName;
import com.management.college.dao.PersonNameDao;
import com.management.college.dao.hibernate.GenericDaoHibernate;

public class PersonNameDaoHibernate extends GenericDaoHibernate<PersonName, Long> implements PersonNameDao {

    public PersonNameDaoHibernate() {
        super(PersonName.class);
    }
}
