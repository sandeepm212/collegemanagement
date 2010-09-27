package com.management.college.webapp.controller;

import com.management.college.webapp.controller.BaseControllerTestCase;
import com.management.college.model.Phone;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

public class PhoneFormControllerTest extends BaseControllerTestCase {
    private PhoneFormController form;

    public void setPhoneFormController(PhoneFormController form) {
        this.form = form;
    }

    public void testEdit() throws Exception {
        log.debug("testing edit...");
        MockHttpServletRequest request = newGet("/phoneform.html");
        request.addParameter("id", "-1");

        ModelAndView mv = form.handleRequest(request, new MockHttpServletResponse());

        Phone phone = (Phone) mv.getModel().get(form.getCommandName());
        assertNotNull(phone);
    }

    public void testSave() throws Exception {
        MockHttpServletRequest request = newGet("/phoneform.html");
        request.addParameter("id", "-1");

        ModelAndView mv = form.handleRequest(request, new MockHttpServletResponse());

        Phone phone = (Phone) mv.getModel().get(form.getCommandName());
        assertNotNull(phone);

        request = newPost("/phoneform.html");

        // update required fields
        phone.setCreatedOn(new java.util.Date());
        phone.setUpdatedOn(new java.util.Date());
        phone.setDataType(1L);
        phone.setDataValue("UA");
        phone.setDisplayOrder(100974031);
        phone.setEnabled(Boolean.FALSE);
        phone.setEntitySubType(77220431);
        phone.setOwnerEntityId(8L);
        phone.setOwnerEntityTypeId(276326730);

        super.objectToRequestParameters(phone, request);

        mv = form.handleRequest(request, new MockHttpServletResponse());

        Errors errors = (Errors) mv.getModel().get(BindException.MODEL_KEY_PREFIX + "phone");
        assertNull(errors);
        assertNotNull(request.getSession().getAttribute("successMessages"));
    }

    public void testRemove() throws Exception {
        MockHttpServletRequest request = newPost("/phoneform.html");
        request.addParameter("delete", "");
        request.addParameter("id", "-2");

        form.handleRequest(request, new MockHttpServletResponse());

        assertNotNull(request.getSession().getAttribute("successMessages"));
    }
}