package com.management.college.webapp.controller;

import com.management.college.webapp.controller.BaseControllerTestCase;
import com.management.college.model.DecodeGroup;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

public class DecodeGroupFormControllerTest extends BaseControllerTestCase {
    private DecodeGroupFormController form;

    public void setDecodeGroupFormController(DecodeGroupFormController form) {
        this.form = form;
    }

    public void testEdit() throws Exception {
        log.debug("testing edit...");
        MockHttpServletRequest request = newGet("/decodeGroupform.html");
        request.addParameter("id", "-1");

        ModelAndView mv = form.handleRequest(request, new MockHttpServletResponse());

        DecodeGroup decodeGroup = (DecodeGroup) mv.getModel().get(form.getCommandName());
        assertNotNull(decodeGroup);
    }

    public void testSave() throws Exception {
        MockHttpServletRequest request = newGet("/decodeGroupform.html");
        request.addParameter("id", "-1");

        ModelAndView mv = form.handleRequest(request, new MockHttpServletResponse());

        DecodeGroup decodeGroup = (DecodeGroup) mv.getModel().get(form.getCommandName());
        assertNotNull(decodeGroup);

        request = newPost("/decodeGroupform.html");

        // update required fields
        decodeGroup.setCreatedOn(new java.util.Date());
        decodeGroup.setUpdatedOn(new java.util.Date());
        decodeGroup.setCode("IsEyUbQfYyXuMiXoKjQbOoBbCaPeYxGeCtZsXmVbBuMfWfOnTzWgFyGxPjDoEqXeLgNtDhFpUuPfEkBcQbBaNyRpNtWrDoKhEcUoPkZnKaBxFtGvSyYeYdQdPkSlNtClGvVaNrKhPpOxGtQsLcJrOiOvJfThKfExRpIqJlJaMuOeGxXaVyYnKxBzBiAwHxAzKqTbWkXyEfUmKkGoUyJrPdLbGdJxCaXtYwPtSrHfIfUvZzLzJuPpHyAsNcSjRgR");
        decodeGroup.setEnabled(Boolean.FALSE);
        decodeGroup.setLocked(Boolean.FALSE);
        decodeGroup.setName("GpYbAcYeNxNuGkYhQtYvSbTzNtHoZmWbQoCmDwFxKoJrZkPmNvLzHmTqOvYpSnMzWxVtXqKjNxSmNrYnGxVlPdHkMyFvTjGcOwKjJiQvJcKyJqIbUoPsFmLqWmGpVtQuVkWaVxHdDsGfRnUgZxNuPjCkMwPfIfUiWeYiWgVfTcUdJoFqKbNnArDiIbWqFxVyLjSzDoGrJnMmJrEaWsReNzQfJuHiUwWxNgBwTtNtZvFnDcOwLhMlLwUhBrCqYkR");

        super.objectToRequestParameters(decodeGroup, request);

        mv = form.handleRequest(request, new MockHttpServletResponse());

        Errors errors = (Errors) mv.getModel().get(BindException.MODEL_KEY_PREFIX + "decodeGroup");
        assertNull(errors);
        assertNotNull(request.getSession().getAttribute("successMessages"));
    }

    public void testRemove() throws Exception {
        MockHttpServletRequest request = newPost("/decodeGroupform.html");
        request.addParameter("delete", "");
        request.addParameter("id", "-2");

        form.handleRequest(request, new MockHttpServletResponse());

        assertNotNull(request.getSession().getAttribute("successMessages"));
    }
}