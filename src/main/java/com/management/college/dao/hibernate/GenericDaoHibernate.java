package com.management.college.dao.hibernate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.management.college.dao.GenericDao;
import com.management.college.model.util.FilterInfo;
import com.management.college.model.util.ListWrapper;

/**
 * This class serves as the Base class for all other DAOs - namely to hold
 * common CRUD methods that they might all use. You should only need to extend
 * this class when your require custom CRUD logic.
 * 
 * <p>
 * To register this class in your Spring context file, use the following XML.
 * 
 * <pre>
 *      &lt;bean id="fooDao" class="com.management.college.dao.hibernate.GenericDaoHibernate"&gt;
 *          &lt;constructor-arg value="com.management.college.model.Foo"/&gt;
 *          &lt;property name="sessionFactory" ref="sessionFactory"/&gt;
 *      &lt;/bean&gt;
 * </pre>
 * 
 * @author <a href="mailto:bwnoll@gmail.com">Bryan Noll</a>
 * @param <T>
 *            a type variable
 * @param <PK>
 *            the primary key for that type
 */
public class GenericDaoHibernate<T, PK extends Serializable>
		extends
			HibernateDaoSupport implements GenericDao<T, PK> {
	/**
	 * Log variable for all child classes. Uses LogFactory.getLog(getClass())
	 * from Commons Logging
	 */
	protected final Log log = LogFactory.getLog(getClass());
	private Class<T> persistentClass;

	/**
	 * Constructor that takes in a class to see which type of entity to persist
	 * 
	 * @param persistentClass
	 *            the class type you'd like to persist
	 */
	public GenericDaoHibernate(final Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		return super.getHibernateTemplate().loadAll(this.persistentClass);
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public List<T> getAllDistinct() {
		Collection result = new LinkedHashSet(getAll());
		return new ArrayList(result);
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public T get(PK id) {
		T entity = (T) super.getHibernateTemplate().get(this.persistentClass,
				id);

		if (entity == null) {
			log.warn("Uh oh, '" + this.persistentClass + "' object with id '"
					+ id + "' not found...");
			throw new ObjectRetrievalFailureException(this.persistentClass, id);
		}

		return entity;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public boolean exists(PK id) {
		T entity = (T) super.getHibernateTemplate().get(this.persistentClass,
				id);
		return entity != null;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public T save(T object) {
		return (T) super.getHibernateTemplate().merge(object);
	}

	/**
	 * {@inheritDoc}
	 */
	public void remove(PK id) {
		super.getHibernateTemplate().delete(this.get(id));
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public List<T> findByNamedQuery(String queryName,
			Map<String, Object> queryParams) {
		String[] params = new String[queryParams.size()];
		Object[] values = new Object[queryParams.size()];
		int index = 0;
		Iterator<String> i = queryParams.keySet().iterator();
		while (i.hasNext()) {
			String key = i.next();
			params[index] = key;
			values[index++] = queryParams.get(key);
		}
		return getHibernateTemplate().findByNamedQueryAndNamedParam(queryName,
				params, values);
	}

	public ListWrapper<T> getFilteredList(final T object,
			final FilterInfo filterInfo) {

		// filter on properties set in the optionList
		HibernateCallback callback = new HibernateCallback() {

			public Object doInHibernate(final Session session)
					throws HibernateException {

				Criteria criteria = session.createCriteria(persistentClass);

				setCriteriaExample(criteria);
				
				setResultsRestrictions(criteria, object);
				
				// First get the count with filtering but without paging
				ListWrapper<T> listWrapper = new ListWrapper<T>();
				List resultsCount = criteria.setProjection(
						Projections.projectionList()
								.add(Projections.rowCount())).list();
				Integer intCount = (Integer) resultsCount.get(0);
				listWrapper.setTotalResultsCount(intCount.intValue());

				// Reset the criteria to get the entities.
				criteria.setProjection(null);
				criteria.setResultTransformer(Criteria.ROOT_ENTITY);

				setResultProjections(criteria);
				
				if (filterInfo != null) {
					// Set paging and sorting.
					if (filterInfo.getStartIndex() >= 0) {
						criteria.setFirstResult(filterInfo.getStartIndex());
						listWrapper.setStartIndex(filterInfo.getStartIndex() + 1);
					}
					
					listWrapper.setPage(filterInfo.getPage());
					
					if (filterInfo.getNumResults() > 0) {
						criteria.setMaxResults(filterInfo.getNumResults());
					}

					if (filterInfo.getSortColumn() != null) {
						criteria.addOrder(filterInfo.isSortOrderAsc() ? Order
								.asc(filterInfo.getSortColumn()) : Order
								.desc(filterInfo.getSortColumn()));
					}
				}

				// Set the Order for the Results.
				setResultsOrder(criteria);

				List<T> results = criteria.list();

				listWrapper.setFilteredListCount(results.size());

				listWrapper.setList(results);
				return listWrapper;
			}
		};

		ListWrapper<T> listWrapper = (ListWrapper<T>) getHibernateTemplate()
				.execute(callback);

		return listWrapper;
	}

	public void setCriteriaExample(Criteria criteria) {

	}

	public void setResultsRestrictions(Criteria criteria, T object) {

	}

	public void setResultsOrder(Criteria criteria) {
		
	}
	
	public void setResultProjections(Criteria criteria) {
		
	}
}
