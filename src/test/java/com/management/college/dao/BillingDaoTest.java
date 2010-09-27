package com.management.college.dao;

import com.management.college.dao.BaseDaoTestCase;
import com.management.college.model.Billing;
import org.springframework.dao.DataAccessException;

import java.util.List;

public class BillingDaoTest extends BaseDaoTestCase {
    private BillingDao billingDao;

    public void setBillingDao(BillingDao billingDao) {
        this.billingDao = billingDao;
    }

    public void testAddAndRemoveBilling() throws Exception {
        Billing billing = new Billing();

        // enter all required fields
        billing.setCreatedOn(new java.util.Date());
        billing.setUpdatedOn(new java.util.Date());
        billing.setAccountNumber("werwer");
        billing.setAdmissionNumber("wwer");
        billing.setBankId(1L);
        billing.setDdDate("sdsf");

        log.debug("adding billing...");
        billing = billingDao.save(billing);

        billing = billingDao.get(billing.getId());

        assertNotNull(billing.getId());

        log.debug("removing billing...");

        billingDao.remove(billing.getId());

        try {
            billingDao.get(billing.getId());
            fail("Billing found in database");
        } catch (DataAccessException e) {
            log.debug("Expected exception: " + e.getMessage());
            assertNotNull(e);
        }
    }
}