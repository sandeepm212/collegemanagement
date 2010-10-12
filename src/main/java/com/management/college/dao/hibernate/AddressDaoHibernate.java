package com.management.college.dao.hibernate;

import java.util.Collections;
import java.util.List;

import org.hibernate.Query;

import com.management.college.dao.AddressDao;
import com.management.college.model.Address;

public class AddressDaoHibernate extends GenericDaoHibernate<Address, Long> implements AddressDao {

    public AddressDaoHibernate() {
        super(Address.class);
    }
    
    public List<Address> getAddressByOwner (final Long ownerId, final int ownerType) {
    	if (ownerId != null) {
    		Query query = getSession().createQuery("from Address a where a.ownerEntityId = :ownerEntityId and ownerEntityType = :ownerEntityType ");
    		query.setLong("ownerEntityId", ownerId);
    		query.setLong("ownerEntityType", ownerType);
    		List<Address> addresses = (List<Address>)query.list();
    		if (addresses != null) {
    			return addresses;
    		}
    	}
    	return Collections.emptyList();
    }
}
