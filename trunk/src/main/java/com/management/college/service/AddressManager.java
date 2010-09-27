package com.management.college.service;

import com.management.college.service.GenericManager;
import com.management.college.model.Address;

import java.util.List;
import javax.jws.WebService;

@WebService
public interface AddressManager extends GenericManager<Address, Long> {
    
}