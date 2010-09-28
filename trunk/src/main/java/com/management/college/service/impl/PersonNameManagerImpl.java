package com.management.college.service.impl;

import com.management.college.dao.PersonNameDao;
import com.management.college.model.PersonName;
import com.management.college.service.PersonNameManager;
import com.management.college.service.impl.GenericManagerImpl;

import java.util.List;
import javax.jws.WebService;

@WebService(serviceName = "PersonNameService", endpointInterface = "com.management.college.service.PersonNameManager")
public class PersonNameManagerImpl extends GenericManagerImpl<PersonName, Long> implements PersonNameManager {
    PersonNameDao personNameDao;

    public PersonNameManagerImpl(PersonNameDao personNameDao) {
        super(personNameDao);
        this.personNameDao = personNameDao;
    }

	public List<PersonName> getPersonNamesByOwner(int ownerEntityType,
			Long ownerEntityId) {
		return personNameDao.getPersonNamesByOwner(ownerEntityType, ownerEntityId);
	}
}