package com.management.college.webapp.controller;

import com.management.college.webapp.controller.BaseControllerTestCase;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public class StudentControllerTest extends BaseControllerTestCase {
    private StudentController controller;

    public void setStudentController(StudentController controller) {
        this.controller = controller;
    }

    public void testHandleRequest() throws Exception {
        ModelAndView mav = controller.handleRequest(null, null);
        ModelMap m = mav.getModelMap();
        assertNotNull(m.get("studentList"));
        assertTrue(((List) m.get("studentList")).size() > 0);
    }
}