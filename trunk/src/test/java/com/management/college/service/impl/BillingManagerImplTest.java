package com.management.college.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.management.college.dao.BillingDao;
import com.management.college.model.Billing;
import com.management.college.service.impl.BaseManagerMockTestCase;

import org.jmock.Expectations;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class BillingManagerImplTest extends BaseManagerMockTestCase {
    private BillingManagerImpl manager = null;
    private BillingDao dao = null;

    @Before
    public void setUp() {
        dao = context.mock(BillingDao.class);
        manager = new BillingManagerImpl(dao);
    }

    @After
    public void tearDown() {
        manager = null;
    }

    @Test
    public void testGetBilling() {
        log.debug("testing get...");

        final Long id = 7L;
        final Billing billing = new Billing();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).get(with(equal(id)));
            will(returnValue(billing));
        }});

        Billing result = manager.get(id);
        assertSame(billing, result);
    }

    @Test
    public void testGetBillings() {
        log.debug("testing getAll...");

        final List billings = new ArrayList();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).getAll();
            will(returnValue(billings));
        }});

        List result = manager.getAll();
        assertSame(billings, result);
    }

    @Test
    public void testSaveBilling() {
        log.debug("testing save...");

        final Billing billing = new Billing();
        // enter all required fields
        billing.setCreatedOn(new java.util.Date());
        billing.setUpdatedOn(new java.util.Date());
        billing.setAccountNumber("");
        billing.setAdmissionNumber("");
        billing.setBankId(1L);
        billing.setDdDate("");
        
        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).save(with(same(billing)));
        }});

        manager.save(billing);
    }

    @Test
    public void testRemoveBilling() {
        log.debug("testing remove...");

        final Long id = -11L;

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).remove(with(equal(id)));
        }});

        manager.remove(id);
    }
}