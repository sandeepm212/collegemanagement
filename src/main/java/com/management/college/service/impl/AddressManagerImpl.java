package com.management.college.service.impl;

import com.management.college.dao.AddressDao;
import com.management.college.model.Address;
import com.management.college.service.AddressManager;
import com.management.college.service.impl.GenericManagerImpl;

import java.util.List;
import javax.jws.WebService;

@WebService(serviceName = "AddressService", endpointInterface = "com.management.college.service.AddressManager")
public class AddressManagerImpl extends GenericManagerImpl<Address, Long> implements AddressManager {
    AddressDao addressDao;

    public AddressManagerImpl(AddressDao addressDao) {
        super(addressDao);
        this.addressDao = addressDao;
    }
}