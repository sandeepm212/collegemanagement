package com.management.college.dao;

import com.management.college.dao.BaseDaoTestCase;
import com.management.college.model.Address;
import org.springframework.dao.DataAccessException;

import java.util.List;

public class AddressDaoTest extends BaseDaoTestCase {
    private AddressDao addressDao;

    public void setAddressDao(AddressDao addressDao) {
        this.addressDao = addressDao;
    }

    public void testAddAndRemoveAddress() throws Exception {
        Address address = new Address();

        // enter all required fields
        address.setCreatedOn(new java.util.Date());
        address.setUpdatedOn(new java.util.Date());
        address.setAddressType(1L);
        address.setDisplayOrder(160640339);
        address.setEnabled(Boolean.FALSE);
        address.setOwnerEntityId(7L);
        address.setOwnerEntityTypeId(580980322);
        address.setPrimaryAddress(Boolean.FALSE);
        address.setUniqueCode("FF");

        log.debug("adding address...");
        address = addressDao.save(address);

        address = addressDao.get(address.getId());

        assertNotNull(address.getId());

        log.debug("removing address...");

        addressDao.remove(address.getId());

        try {
            addressDao.get(address.getId());
            fail("Address found in database");
        } catch (DataAccessException e) {
            log.debug("Expected exception: " + e.getMessage());
            assertNotNull(e);
        }
    }
}