package com.management.college.webapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.management.college.service.CourseManager;
import com.management.college.model.Course;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class CourseController implements Controller {
    private CourseManager courseManager;
    
    private String             successView;

    public void setSuccessView(String successView) {
        this.successView = successView;
    }


    public void setCourseManager(CourseManager courseManager) {
        this.courseManager = courseManager;
    }

    public ModelAndView handleRequest(HttpServletRequest request,
                                      HttpServletResponse response)
    throws Exception {
        return new ModelAndView(successView).addObject(courseManager.getAll());
    }
}
