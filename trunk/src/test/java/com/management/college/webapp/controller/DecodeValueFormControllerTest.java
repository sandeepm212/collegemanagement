package com.management.college.webapp.controller;

import com.management.college.webapp.controller.BaseControllerTestCase;
import com.management.college.model.DecodeValue;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

public class DecodeValueFormControllerTest extends BaseControllerTestCase {
    private DecodeValueFormController form;

    public void setDecodeValueFormController(DecodeValueFormController form) {
        this.form = form;
    }

    public void testEdit() throws Exception {
        log.debug("testing edit...");
        MockHttpServletRequest request = newGet("/decodeValueform.html");
        request.addParameter("id", "-1");

        ModelAndView mv = form.handleRequest(request, new MockHttpServletResponse());

        DecodeValue decodeValue = (DecodeValue) mv.getModel().get(form.getCommandName());
        assertNotNull(decodeValue);
    }

    public void testSave() throws Exception {
        MockHttpServletRequest request = newGet("/decodeValueform.html");
        request.addParameter("id", "-1");

        ModelAndView mv = form.handleRequest(request, new MockHttpServletResponse());

        DecodeValue decodeValue = (DecodeValue) mv.getModel().get(form.getCommandName());
        assertNotNull(decodeValue);

        request = newPost("/decodeValueform.html");

        // update required fields
        decodeValue.setCreatedOn(new java.util.Date());
        decodeValue.setUpdatedOn(new java.util.Date());
        decodeValue.setDisplayOrder(new Short("4409"));
        decodeValue.setEnabled(Boolean.FALSE);
        decodeValue.setShortCode("YbMwRjBkTnPmMqFyCeSnOjAkQmYkEuYqMgCbQtLwTfOyWlInPcFsFyFoXpQcKxOcVlDpUjHiGhFcPsZrDxYiYuEgWeKyReBtYvEzCyPiOwUyKaKgOyHzNqChTjJkGiLfYrYzCbQmMmBmQkBpVhGoHyQmLpCaWaViHaCqVqNvJfZoVoKpKpEuTwWyJuFiJuHgVwCnDwFkLkSnNeXrGdPiHxGyDkSqNxYpNgHjDeRyHlTpKpDgXkUoPfTxBbZmMuG");
        decodeValue.setValue("YaYiTePfDtWkYpTkKxRxOxDsIfCqYaHsUqFtGlKeXwVnLhCiRfXeErSiQmUfLkTrJtTaQwQzXhLhPlGyHkWlPmSwMdCfSfOiYeBjMzPcMvXrNdJxOlSwTcWyBlWoEqXiNvZoBiUoOdHrJpEvMjJcQdDyAnSaBaWdHaJeEuRrGxGaWcBgOpRdAjRzEsTdQkLzXiHtPpKuCdHhImJkDeKnHxLvXvEeTnIzSjDrQgYqFrTxPmGoPkUgWeSdMwIqIeM");

        super.objectToRequestParameters(decodeValue, request);

        mv = form.handleRequest(request, new MockHttpServletResponse());

        Errors errors = (Errors) mv.getModel().get(BindException.MODEL_KEY_PREFIX + "decodeValue");
        assertNull(errors);
        assertNotNull(request.getSession().getAttribute("successMessages"));
    }

    public void testRemove() throws Exception {
        MockHttpServletRequest request = newPost("/decodeValueform.html");
        request.addParameter("delete", "");
        request.addParameter("id", "-2");

        form.handleRequest(request, new MockHttpServletResponse());

        assertNotNull(request.getSession().getAttribute("successMessages"));
    }
}