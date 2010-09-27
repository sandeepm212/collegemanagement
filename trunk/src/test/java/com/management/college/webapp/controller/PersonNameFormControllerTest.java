package com.management.college.webapp.controller;

import com.management.college.webapp.controller.BaseControllerTestCase;
import com.management.college.model.PersonName;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

public class PersonNameFormControllerTest extends BaseControllerTestCase {
    private PersonNameFormController form;

    public void setPersonNameFormController(PersonNameFormController form) {
        this.form = form;
    }

    public void testEdit() throws Exception {
        log.debug("testing edit...");
        MockHttpServletRequest request = newGet("/personNameform.html");
        request.addParameter("id", "-1");

        ModelAndView mv = form.handleRequest(request, new MockHttpServletResponse());

        PersonName personName = (PersonName) mv.getModel().get(form.getCommandName());
        assertNotNull(personName);
    }

    public void testSave() throws Exception {
        MockHttpServletRequest request = newGet("/personNameform.html");
        request.addParameter("id", "-1");

        ModelAndView mv = form.handleRequest(request, new MockHttpServletResponse());

        PersonName personName = (PersonName) mv.getModel().get(form.getCommandName());
        assertNotNull(personName);

        request = newPost("/personNameform.html");

        // update required fields
        personName.setCreatedOn(new java.util.Date());
        personName.setUpdatedOn(new java.util.Date());
        personName.setFirstName("Student4");
        personName.setLastName("LN");
        personName.setOwnerEntityId(3L);
        personName.setOwnerEntityType(52876379);
        personName.setPersonType(278901872);

        super.objectToRequestParameters(personName, request);

        mv = form.handleRequest(request, new MockHttpServletResponse());

        Errors errors = (Errors) mv.getModel().get(BindException.MODEL_KEY_PREFIX + "personName");
        assertNull(errors);
        assertNotNull(request.getSession().getAttribute("successMessages"));
    }

    public void testRemove() throws Exception {
        MockHttpServletRequest request = newPost("/personNameform.html");
        request.addParameter("delete", "");
        request.addParameter("id", "-2");

        form.handleRequest(request, new MockHttpServletResponse());

        assertNotNull(request.getSession().getAttribute("successMessages"));
    }
}