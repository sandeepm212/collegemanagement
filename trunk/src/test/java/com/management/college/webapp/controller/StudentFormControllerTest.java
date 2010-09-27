package com.management.college.webapp.controller;

import com.management.college.webapp.controller.BaseControllerTestCase;
import com.management.college.model.Student;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

public class StudentFormControllerTest extends BaseControllerTestCase {
    private StudentFormController form;

    public void setStudentFormController(StudentFormController form) {
        this.form = form;
    }

    public void testEdit() throws Exception {
        log.debug("testing edit...");
        MockHttpServletRequest request = newGet("/studentform.html");
        request.addParameter("id", "-1");

        ModelAndView mv = form.handleRequest(request, new MockHttpServletResponse());

        Student student = (Student) mv.getModel().get(form.getCommandName());
        assertNotNull(student);
    }

    public void testSave() throws Exception {
        MockHttpServletRequest request = newGet("/studentform.html");
        request.addParameter("id", "-1");

        ModelAndView mv = form.handleRequest(request, new MockHttpServletResponse());

        Student student = (Student) mv.getModel().get(form.getCommandName());
        assertNotNull(student);

        request = newPost("/studentform.html");

        // update required fields
        student.setCreatedOn(new java.util.Date());
        student.setUpdatedOn(new java.util.Date());
        student.setGender("Male");
        student.setJoiningDate(new java.util.Date());
        student.setNationality(1L);
        student.setStudentId("1234");

        super.objectToRequestParameters(student, request);

        mv = form.handleRequest(request, new MockHttpServletResponse());

        Errors errors = (Errors) mv.getModel().get(BindException.MODEL_KEY_PREFIX + "student");
        assertNull(errors);
        assertNotNull(request.getSession().getAttribute("successMessages"));
    }

    public void testRemove() throws Exception {
        MockHttpServletRequest request = newPost("/studentform.html");
        request.addParameter("delete", "");
        request.addParameter("id", "-2");

        form.handleRequest(request, new MockHttpServletResponse());

        assertNotNull(request.getSession().getAttribute("successMessages"));
    }
}