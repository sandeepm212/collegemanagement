package com.management.college.webapp.controller;

import com.management.college.webapp.controller.BaseControllerTestCase;
import com.management.college.model.Course;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

public class CourseFormControllerTest extends BaseControllerTestCase {
    private CourseFormController form;

    public void setCourseFormController(CourseFormController form) {
        this.form = form;
    }

    public void testEdit() throws Exception {
        log.debug("testing edit...");
        MockHttpServletRequest request = newGet("/courseform.html");
        request.addParameter("id", "-1");

        ModelAndView mv = form.handleRequest(request, new MockHttpServletResponse());

        Course course = (Course) mv.getModel().get(form.getCommandName());
        assertNotNull(course);
    }

    public void testSave() throws Exception {
        MockHttpServletRequest request = newGet("/courseform.html");
        request.addParameter("id", "-1");

        ModelAndView mv = form.handleRequest(request, new MockHttpServletResponse());

        Course course = (Course) mv.getModel().get(form.getCommandName());
        assertNotNull(course);

        request = newPost("/courseform.html");

        // update required fields
        course.setCreatedOn(new java.util.Date());
        course.setUpdatedOn(new java.util.Date());
        course.setBranch("WkNpMzInCxHaOlZwGxBjHhUcGzIbLjZwPnEwQbQgAaYsQaHgMfMcKdGuImFvOwHwXeEcDwVwDaEtCcMoKtHePuOrRiDxFbImOyShIiMfLiWkUwElYuAiFuMvBoRcUiFnHeXpCcJsHpOyReLvKxHkIaXyEpLyBoBzWeEoLtMaPlWtSyImZrKaXiRlMkKjUhIcFyPwNmTzOnFuDhUqRiNqKaWbGaFqLjFqUbMsNtAsIrTxUmVcHzYaMyErDrSnJpQ");
        course.setCode("PpWlBgPwCxKvXuHwGuRqYzRsGvOxSbTzYuTmVrPaFsNdIoVkPyCyTdTuDsNaNqWoReElHsXzNxJtYyGxOeGvWeThNjHxUtSbHmZpXoOwUeTwGtWyHoPzUaVaJrQmCsQgFhHrGvZkNvOgFeQoZfHkYeFkHrIwDnKbUsDzIhAgTbNmLcWwHyPhNfLpTiLeLuOwDwVvXvRqSlByKyTcBaZzKzFjXuDeGhZyTfIdMiSeFtRpYiWoGgUhWpFxAtHqUbM");
        course.setDuration(509725335);

        super.objectToRequestParameters(course, request);

        mv = form.handleRequest(request, new MockHttpServletResponse());

        Errors errors = (Errors) mv.getModel().get(BindException.MODEL_KEY_PREFIX + "course");
        assertNull(errors);
        assertNotNull(request.getSession().getAttribute("successMessages"));
    }

    public void testRemove() throws Exception {
        MockHttpServletRequest request = newPost("/courseform.html");
        request.addParameter("delete", "");
        request.addParameter("id", "-2");

        form.handleRequest(request, new MockHttpServletResponse());

        assertNotNull(request.getSession().getAttribute("successMessages"));
    }
}