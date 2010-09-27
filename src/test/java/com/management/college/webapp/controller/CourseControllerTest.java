package com.management.college.webapp.controller;

import com.management.college.webapp.controller.BaseControllerTestCase;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public class CourseControllerTest extends BaseControllerTestCase {
    private CourseController controller;

    public void setCourseController(CourseController controller) {
        this.controller = controller;
    }

    public void testHandleRequest() throws Exception {
        ModelAndView mav = controller.handleRequest(null, null);
        ModelMap m = mav.getModelMap();
        assertNotNull(m.get("courseList"));
        assertTrue(((List) m.get("courseList")).size() > 0);
    }
}