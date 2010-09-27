package com.management.college.webapp.controller;

import com.management.college.webapp.controller.BaseControllerTestCase;
import com.management.college.model.Address;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

public class AddressFormControllerTest extends BaseControllerTestCase {
    private AddressFormController form;

    public void setAddressFormController(AddressFormController form) {
        this.form = form;
    }

    public void testEdit() throws Exception {
        log.debug("testing edit...");
        MockHttpServletRequest request = newGet("/addressform.html");
        request.addParameter("id", "-1");

        ModelAndView mv = form.handleRequest(request, new MockHttpServletResponse());

        Address address = (Address) mv.getModel().get(form.getCommandName());
        assertNotNull(address);
    }

    public void testSave() throws Exception {
        MockHttpServletRequest request = newGet("/addressform.html");
        request.addParameter("id", "-1");

        ModelAndView mv = form.handleRequest(request, new MockHttpServletResponse());

        Address address = (Address) mv.getModel().get(form.getCommandName());
        assertNotNull(address);

        request = newPost("/addressform.html");

        // update required fields
        address.setCreatedOn(new java.util.Date());
        address.setUpdatedOn(new java.util.Date());
        address.setAddressType(9L);
        address.setDisplayOrder(235996399);
        address.setEnabled(Boolean.FALSE);
        address.setOwnerEntityId(1L);
        address.setOwnerEntityTypeId(520606232);
        address.setPrimaryAddress(Boolean.FALSE);
        address.setUniqueCode("EE");

        super.objectToRequestParameters(address, request);

        mv = form.handleRequest(request, new MockHttpServletResponse());

        Errors errors = (Errors) mv.getModel().get(BindException.MODEL_KEY_PREFIX + "address");
        assertNull(errors);
        assertNotNull(request.getSession().getAttribute("successMessages"));
    }

    public void testRemove() throws Exception {
        MockHttpServletRequest request = newPost("/addressform.html");
        request.addParameter("delete", "");
        request.addParameter("id", "-2");

        form.handleRequest(request, new MockHttpServletResponse());

        assertNotNull(request.getSession().getAttribute("successMessages"));
    }
}