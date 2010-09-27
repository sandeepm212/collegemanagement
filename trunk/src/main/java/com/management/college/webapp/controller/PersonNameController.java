package com.management.college.webapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.management.college.service.PersonNameManager;
import com.management.college.model.PersonName;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class PersonNameController implements Controller {
    private PersonNameManager personNameManager;

    public void setPersonNameManager(PersonNameManager personNameManager) {
        this.personNameManager = personNameManager;
    }

    public ModelAndView handleRequest(HttpServletRequest request,
                                      HttpServletResponse response)
    throws Exception {
        return new ModelAndView().addObject(personNameManager.getAll());
    }
}
