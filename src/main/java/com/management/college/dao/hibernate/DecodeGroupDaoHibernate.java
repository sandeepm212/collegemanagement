package com.management.college.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.springframework.orm.ObjectRetrievalFailureException;

import com.management.college.dao.DecodeGroupDao;
import com.management.college.model.DecodeGroup;
import com.management.college.model.DecodeValue;
import com.management.college.model.util.ListWrapper;

public class DecodeGroupDaoHibernate extends
		GenericDaoHibernate<DecodeGroup, Long> implements DecodeGroupDao {

	public DecodeGroupDaoHibernate() {
		super(DecodeGroup.class);
	}

	public ListWrapper<DecodeValue> getDecodevalues(final Long decodeGroupId,
			final boolean isActiveOnly) {
		String dvQuery = "from DecodeValue v left join fetch v.decodeGroup where v.decodeGroup.id = :dgId";
		if (isActiveOnly) {
			dvQuery += " and v.enabled = true ";
		}

		Query query = getSession().createQuery(dvQuery);
		query.setParameter("dgId", decodeGroupId);

		List<DecodeValue> dValues = (List<DecodeValue>) query.list();

		ListWrapper<DecodeValue> listWrapper = new ListWrapper<DecodeValue>();
		listWrapper.setList(dValues);
		if (dValues != null) {
			listWrapper.setFilteredListCount(dValues.size());
			listWrapper.setTotalResultsCount(dValues.size());
		}

		return listWrapper;
	}

	public DecodeValue getDecodeValue(Long id) {
		DecodeValue entity = (DecodeValue) getHibernateTemplate().get(
				DecodeValue.class, id);

		if (entity == null) {
			log.warn("Uh oh, '" + DecodeValue.class + "' object with id '" + id
					+ "' not found...");
			throw new ObjectRetrievalFailureException(DecodeValue.class, id);
		}

		return entity;
	}

	/**
	 * Returns the list of decode values that belong to the specified group
	 * 
	 * @param decodeGroupCode
	 *            the code for the group
	 * @return the list of decode values
	 */
	public List<DecodeValue> getDecodeValuesByGroup(String decodeGroupCode) {
		return getHibernateTemplate()
				.find("from DecodeValue v left join fetch v.decodeGroup where v.enabled = true and v.decodeGroup.code = ?",
						decodeGroupCode);
	}

	@Override
	public void setResultsRestrictions(Criteria criteria, DecodeGroup object) {
		criteria.setFetchMode("decodeValues", FetchMode.SELECT);
	}
}
