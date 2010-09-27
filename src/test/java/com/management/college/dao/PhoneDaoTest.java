package com.management.college.dao;

import com.management.college.dao.BaseDaoTestCase;
import com.management.college.model.Phone;
import org.springframework.dao.DataAccessException;

import java.util.List;

public class PhoneDaoTest extends BaseDaoTestCase {
    private PhoneDao phoneDao;

    public void setPhoneDao(PhoneDao phoneDao) {
        this.phoneDao = phoneDao;
    }

    public void testAddAndRemovePhone() throws Exception {
        Phone phone = new Phone();

        // enter all required fields
        phone.setCreatedOn(new java.util.Date());
        phone.setUpdatedOn(new java.util.Date());
        phone.setDataType(2L);
        phone.setDataValue("HZ");
        phone.setDisplayOrder(2055624643);
        phone.setEnabled(Boolean.FALSE);
        phone.setEntitySubType(2044231604);
        phone.setOwnerEntityId(1L);
        phone.setOwnerEntityTypeId(980352860);

        log.debug("adding phone...");
        phone = phoneDao.save(phone);

        phone = phoneDao.get(phone.getId());

        assertNotNull(phone.getId());

        log.debug("removing phone...");

        phoneDao.remove(phone.getId());

        try {
            phoneDao.get(phone.getId());
            fail("Phone found in database");
        } catch (DataAccessException e) {
            log.debug("Expected exception: " + e.getMessage());
            assertNotNull(e);
        }
    }
}