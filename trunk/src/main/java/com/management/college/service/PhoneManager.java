package com.management.college.service;

import com.management.college.service.GenericManager;
import com.management.college.model.Phone;

import java.util.List;
import javax.jws.WebService;

@WebService
public interface PhoneManager extends GenericManager<Phone, Long> {
    
}