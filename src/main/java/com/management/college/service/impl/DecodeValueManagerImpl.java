package com.management.college.service.impl;

import com.management.college.dao.DecodeValueDao;
import com.management.college.model.DecodeValue;
import com.management.college.service.DecodeValueManager;
import com.management.college.service.impl.GenericManagerImpl;

import java.util.List;
import javax.jws.WebService;

@WebService(serviceName = "DecodeValueService", endpointInterface = "com.management.college.service.DecodeValueManager")
public class DecodeValueManagerImpl extends GenericManagerImpl<DecodeValue, Long> implements DecodeValueManager {
    DecodeValueDao decodeValueDao;

    public DecodeValueManagerImpl(DecodeValueDao decodeValueDao) {
        super(decodeValueDao);
        this.decodeValueDao = decodeValueDao;
    }
}