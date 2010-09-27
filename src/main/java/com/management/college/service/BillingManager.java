package com.management.college.service;

import com.management.college.service.GenericManager;
import com.management.college.model.Billing;

import java.util.List;
import javax.jws.WebService;

@WebService
public interface BillingManager extends GenericManager<Billing, Long> {
    
}