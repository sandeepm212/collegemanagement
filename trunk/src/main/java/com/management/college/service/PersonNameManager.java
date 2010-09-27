package com.management.college.service;

import com.management.college.service.GenericManager;
import com.management.college.model.PersonName;

import java.util.List;
import javax.jws.WebService;

@WebService
public interface PersonNameManager extends GenericManager<PersonName, Long> {
    
}