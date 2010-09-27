package com.management.college.webapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.management.college.service.DecodeValueManager;
import com.management.college.model.DecodeValue;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class DecodeValueController implements Controller {
    private DecodeValueManager decodeValueManager;

    public void setDecodeValueManager(DecodeValueManager decodeValueManager) {
        this.decodeValueManager = decodeValueManager;
    }

    public ModelAndView handleRequest(HttpServletRequest request,
                                      HttpServletResponse response)
    throws Exception {
        return new ModelAndView().addObject(decodeValueManager.getAll());
    }
}
