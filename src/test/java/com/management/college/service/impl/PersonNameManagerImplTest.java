package com.management.college.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.management.college.dao.PersonNameDao;
import com.management.college.model.PersonName;
import com.management.college.service.impl.BaseManagerMockTestCase;

import org.jmock.Expectations;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class PersonNameManagerImplTest extends BaseManagerMockTestCase {
    private PersonNameManagerImpl manager = null;
    private PersonNameDao dao = null;

    @Before
    public void setUp() {
        dao = context.mock(PersonNameDao.class);
        manager = new PersonNameManagerImpl(dao);
    }

    @After
    public void tearDown() {
        manager = null;
    }

    @Test
    public void testGetPersonName() {
        log.debug("testing get...");

        final Long id = 7L;
        final PersonName personName = new PersonName();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).get(with(equal(id)));
            will(returnValue(personName));
        }});

        PersonName result = manager.get(id);
        assertSame(personName, result);
    }

    @Test
    public void testGetPersonNames() {
        log.debug("testing getAll...");

        final List personNames = new ArrayList();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).getAll();
            will(returnValue(personNames));
        }});

        List result = manager.getAll();
        assertSame(personNames, result);
    }

    @Test
    public void testSavePersonName() {
        log.debug("testing save...");

        final PersonName personName = new PersonName();
        // enter all required fields
        personName.setCreatedOn(new java.util.Date());
        personName.setUpdatedOn(new java.util.Date());
        personName.setFirstName("Student4");
        personName.setLastName("LN");
        personName.setOwnerEntityId(1L);
        personName.setOwnerEntityType(795479438);
        personName.setPersonType(1282620654);
        
        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).save(with(same(personName)));
        }});

        manager.save(personName);
    }

    @Test
    public void testRemovePersonName() {
        log.debug("testing remove...");

        final Long id = -11L;

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).remove(with(equal(id)));
        }});

        manager.remove(id);
    }
}