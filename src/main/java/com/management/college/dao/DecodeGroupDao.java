package com.management.college.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.management.college.dao.GenericDao;

import com.management.college.model.DecodeGroup;
import com.management.college.model.DecodeValue;
import com.management.college.model.util.FilterInfo;
import com.management.college.model.util.ListWrapper;

/**
 * An interface that provides a data management interface to the DecodeGroup
 * table.
 */
public interface DecodeGroupDao extends GenericDao<DecodeGroup, Long> {

	public ListWrapper<DecodeValue> getDecodevalues(Long decodeGroupId, boolean isActiveOnly);

	public DecodeValue getDecodeValue(Long id);
	

    /**
     * Returns the list of decode values that belong to the specified group
     * @param decodeGroupCode the code for the group
     * @return the list of decode values
     */
    public List<DecodeValue> getDecodeValuesByGroup(String decodeGroupCode);
}