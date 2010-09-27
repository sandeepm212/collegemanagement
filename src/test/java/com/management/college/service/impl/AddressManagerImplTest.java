package com.management.college.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.management.college.dao.AddressDao;
import com.management.college.model.Address;
import com.management.college.service.impl.BaseManagerMockTestCase;

import org.jmock.Expectations;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class AddressManagerImplTest extends BaseManagerMockTestCase {
    private AddressManagerImpl manager = null;
    private AddressDao dao = null;

    @Before
    public void setUp() {
        dao = context.mock(AddressDao.class);
        manager = new AddressManagerImpl(dao);
    }

    @After
    public void tearDown() {
        manager = null;
    }

    @Test
    public void testGetAddress() {
        log.debug("testing get...");

        final Long id = 7L;
        final Address address = new Address();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).get(with(equal(id)));
            will(returnValue(address));
        }});

        Address result = manager.get(id);
        assertSame(address, result);
    }

    @Test
    public void testGetAddresses() {
        log.debug("testing getAll...");

        final List addresses = new ArrayList();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).getAll();
            will(returnValue(addresses));
        }});

        List result = manager.getAll();
        assertSame(addresses, result);
    }

    @Test
    public void testSaveAddress() {
        log.debug("testing save...");

        final Address address = new Address();
        // enter all required fields
        address.setCreatedOn(new java.util.Date());
        address.setUpdatedOn(new java.util.Date());
        address.setAddressType(8L);
        address.setDisplayOrder(928619637);
        address.setEnabled(Boolean.FALSE);
        address.setOwnerEntityId(1L);
        address.setOwnerEntityTypeId(175543064);
        address.setPrimaryAddress(Boolean.FALSE);
        address.setUniqueCode("IS");
        
        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).save(with(same(address)));
        }});

        manager.save(address);
    }

    @Test
    public void testRemoveAddress() {
        log.debug("testing remove...");

        final Long id = -11L;

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).remove(with(equal(id)));
        }});

        manager.remove(id);
    }
}