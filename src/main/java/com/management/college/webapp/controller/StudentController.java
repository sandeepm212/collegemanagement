package com.management.college.webapp.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.management.college.model.view.StudentView;
import com.management.college.service.StudentManager;

public class StudentController implements Controller {
    private StudentManager studentManager;

    private String successView;
    
    public void setSuccessView(String successView) {
        this.successView = successView;
    }
    
    public void setStudentManager(StudentManager studentManager) {
        this.studentManager = studentManager;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request,
                                      HttpServletResponse response)
    throws Exception {
    	
        return new ModelAndView(successView).addObject(studentManager.getAll());
    }
}
