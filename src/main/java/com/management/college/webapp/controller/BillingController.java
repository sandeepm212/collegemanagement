package com.management.college.webapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.management.college.service.BillingManager;
import com.management.college.model.Billing;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class BillingController implements Controller {
    private BillingManager billingManager;

    public void setBillingManager(BillingManager billingManager) {
        this.billingManager = billingManager;
    }

    public ModelAndView handleRequest(HttpServletRequest request,
                                      HttpServletResponse response)
    throws Exception {
        return new ModelAndView().addObject(billingManager.getAll());
    }
}
