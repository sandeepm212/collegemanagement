package com.management.college.dao.hibernate;

import java.util.List;

import com.management.college.dao.LookupDao;
import com.management.college.model.Role;

/**
 * Hibernate implementation of LookupDao.
 *
 * @author <a href="mailto:sandeep.mandrumaka@gmail.com">Sandeep Mandrumaka</a>
 */
public class LookupDaoHibernate extends UniversalDaoHibernate implements LookupDao {

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public List<Role> getRoles() {
        log.debug("Retrieving all role names...");

        return getHibernateTemplate().find("from Role order by name");
    }
}
