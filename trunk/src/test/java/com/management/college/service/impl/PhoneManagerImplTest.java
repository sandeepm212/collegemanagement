package com.management.college.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.management.college.dao.PhoneDao;
import com.management.college.model.Phone;
import com.management.college.service.impl.BaseManagerMockTestCase;

import org.jmock.Expectations;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class PhoneManagerImplTest extends BaseManagerMockTestCase {
    private PhoneManagerImpl manager = null;
    private PhoneDao dao = null;

    @Before
    public void setUp() {
        dao = context.mock(PhoneDao.class);
        manager = new PhoneManagerImpl(dao);
    }

    @After
    public void tearDown() {
        manager = null;
    }

    @Test
    public void testGetPhone() {
        log.debug("testing get...");

        final Long id = 7L;
        final Phone phone = new Phone();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).get(with(equal(id)));
            will(returnValue(phone));
        }});

        Phone result = manager.get(id);
        assertSame(phone, result);
    }

    @Test
    public void testGetPhones() {
        log.debug("testing getAll...");

        final List phones = new ArrayList();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).getAll();
            will(returnValue(phones));
        }});

        List result = manager.getAll();
        assertSame(phones, result);
    }

    @Test
    public void testSavePhone() {
        log.debug("testing save...");

        final Phone phone = new Phone();
        // enter all required fields
        phone.setCreatedOn(new java.util.Date());
        phone.setUpdatedOn(new java.util.Date());
        phone.setDataType(1L);
        phone.setDataValue("ZT");
        phone.setDisplayOrder(1396167361);
        phone.setEnabled(Boolean.FALSE);
        phone.setEntitySubType(390545977);
        phone.setOwnerEntityId(2L);
        phone.setOwnerEntityTypeId(1612810914);
        
        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).save(with(same(phone)));
        }});

        manager.save(phone);
    }

    @Test
    public void testRemovePhone() {
        log.debug("testing remove...");

        final Long id = -11L;

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).remove(with(equal(id)));
        }});

        manager.remove(id);
    }
}