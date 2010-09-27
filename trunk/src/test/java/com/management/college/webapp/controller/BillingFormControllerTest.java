package com.management.college.webapp.controller;

import com.management.college.webapp.controller.BaseControllerTestCase;
import com.management.college.model.Billing;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

public class BillingFormControllerTest extends BaseControllerTestCase {
    private BillingFormController form;

    public void setBillingFormController(BillingFormController form) {
        this.form = form;
    }

    public void testEdit() throws Exception {
        log.debug("testing edit...");
        MockHttpServletRequest request = newGet("/billingform.html");
        request.addParameter("id", "-1");

        ModelAndView mv = form.handleRequest(request, new MockHttpServletResponse());

        Billing billing = (Billing) mv.getModel().get(form.getCommandName());
        assertNotNull(billing);
    }

    public void testSave() throws Exception {
        MockHttpServletRequest request = newGet("/billingform.html");
        request.addParameter("id", "-1");

        ModelAndView mv = form.handleRequest(request, new MockHttpServletResponse());

        Billing billing = (Billing) mv.getModel().get(form.getCommandName());
        assertNotNull(billing);

        request = newPost("/billingform.html");

        // update required fields
        billing.setCreatedOn(new java.util.Date());
        billing.setUpdatedOn(new java.util.Date());
        billing.setAccountNumber("sada");
        billing.setAdmissionNumber("");
        billing.setBankId(4L);
        billing.setDdDate("");

        super.objectToRequestParameters(billing, request);

        mv = form.handleRequest(request, new MockHttpServletResponse());

        Errors errors = (Errors) mv.getModel().get(BindException.MODEL_KEY_PREFIX + "billing");
        assertNull(errors);
        assertNotNull(request.getSession().getAttribute("successMessages"));
    }

    public void testRemove() throws Exception {
        MockHttpServletRequest request = newPost("/billingform.html");
        request.addParameter("delete", "");
        request.addParameter("id", "-2");

        form.handleRequest(request, new MockHttpServletResponse());

        assertNotNull(request.getSession().getAttribute("successMessages"));
    }
}