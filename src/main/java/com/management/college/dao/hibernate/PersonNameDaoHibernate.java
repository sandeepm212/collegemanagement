package com.management.college.dao.hibernate;

import java.util.Collections;
import java.util.List;

import org.hibernate.Query;

import com.management.college.dao.PersonNameDao;
import com.management.college.model.PersonName;

public class PersonNameDaoHibernate extends GenericDaoHibernate<PersonName, Long> implements PersonNameDao {

    public PersonNameDaoHibernate() {
        super(PersonName.class);
    }
    
    public List<PersonName> getPersonNamesByOwner (int ownerEntityType, Long ownerEntityId) {
    	if (ownerEntityId != null) {
    		Query query = getSession().createQuery("from PersonName where ownerEntityType = :ownerEntityType and ownerEntityId = :ownerEntityId ");
    		query.setInteger("ownerEntityType", ownerEntityType);
    		query.setLong("ownerEntityId", ownerEntityId);    		
    		List<PersonName> personNames = (List<PersonName>)query.list();
    		return personNames;
    	}
    	return Collections.emptyList();
    }
}
