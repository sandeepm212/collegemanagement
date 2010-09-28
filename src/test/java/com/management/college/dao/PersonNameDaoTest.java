package com.management.college.dao;

import com.management.college.AppConstants;
import com.management.college.dao.BaseDaoTestCase;
import com.management.college.model.PersonName;
import org.springframework.dao.DataAccessException;

import java.util.List;

public class PersonNameDaoTest extends BaseDaoTestCase {
    private PersonNameDao personNameDao;

    public void setPersonNameDao(PersonNameDao personNameDao) {
        this.personNameDao = personNameDao;
    }

    public void testAddAndRemovePersonName() throws Exception {
        PersonName personName = new PersonName();

        // enter all required fields
        personName.setCreatedOn(new java.util.Date());
        personName.setUpdatedOn(new java.util.Date());
        personName.setFirstName("Student3");
        personName.setLastName("LN");
        personName.setOwnerEntityId(6L);
        personName.setOwnerEntityType(868576317);
        personName.setPersonType(770975680);

        log.debug("adding personName...");
        personName = personNameDao.save(personName);

        personName = personNameDao.get(personName.getId());

        assertNotNull(personName.getId());

        log.debug("removing personName...");

        personNameDao.remove(personName.getId());

        try {
            personNameDao.get(personName.getId());
            fail("PersonName found in database");
        } catch (DataAccessException e) {
            log.debug("Expected exception: " + e.getMessage());
            assertNotNull(e);
        }
    }
    
    public void testGetPersonsByOwner () throws Exception {
    	List<PersonName> personNames = personNameDao.getPersonNamesByOwner (AppConstants.ENTITY_TYPE_CORE_STUDENT, 1L);
    	System.out.println("\n\n==================\n\n");
    	System.out.println(personNames);
    }
}