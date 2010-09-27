package com.management.college.webapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.management.college.service.AddressManager;
import com.management.college.model.Address;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class AddressController implements Controller {
    private AddressManager addressManager;

    public void setAddressManager(AddressManager addressManager) {
        this.addressManager = addressManager;
    }

    public ModelAndView handleRequest(HttpServletRequest request,
                                      HttpServletResponse response)
    throws Exception {
        return new ModelAndView().addObject(addressManager.getAll());
    }
}
