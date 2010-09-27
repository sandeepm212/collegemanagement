package com.management.college.webapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.management.college.service.StudentManager;
import com.management.college.model.Student;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

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
