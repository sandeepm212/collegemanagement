package com.management.college.webapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.management.college.service.DecodeGroupManager;
import com.management.college.model.DecodeGroup;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class DecodeGroupController implements Controller {
    private DecodeGroupManager decodeGroupManager;

    private String             successView;

    public void setSuccessView(String successView) {
        this.successView = successView;
    }

    public void setDecodeGroupManager(DecodeGroupManager decodeGroupManager) {
        this.decodeGroupManager = decodeGroupManager;
    }

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return new ModelAndView(successView).addObject(decodeGroupManager.getAll());
    }
}
