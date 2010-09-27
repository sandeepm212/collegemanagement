package com.management.college.service.impl;

import com.management.college.dao.PhoneDao;
import com.management.college.model.Phone;
import com.management.college.service.PhoneManager;
import com.management.college.service.impl.GenericManagerImpl;

import java.util.List;
import javax.jws.WebService;

@WebService(serviceName = "PhoneService", endpointInterface = "com.management.college.service.PhoneManager")
public class PhoneManagerImpl extends GenericManagerImpl<Phone, Long> implements PhoneManager {
    PhoneDao phoneDao;

    public PhoneManagerImpl(PhoneDao phoneDao) {
        super(phoneDao);
        this.phoneDao = phoneDao;
    }
}