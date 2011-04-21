package com.management.college.webapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.mvc.Controller;

import com.management.college.service.AddressManager;

public class AddressController implements Controller {
    private AddressManager addressManager;

    public void setAddressManager(AddressManager addressManager) {
        this.addressManager = addressManager;
    }

    public ModelAndView handleRequest(HttpServletRequest request,
                                      HttpServletResponse response)
    throws Exception {
    	SimpleUrlHandlerMapping l;
    	DispatcherServlet k;
    	SimpleUrlHandlerMapping suhm;
    	CommonsMultipartResolver mp;
        return new ModelAndView().addObject(addressManager.getAll());
    }
}
