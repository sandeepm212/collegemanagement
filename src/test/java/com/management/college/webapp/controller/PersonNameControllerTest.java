package com.management.college.webapp.controller;

import com.management.college.webapp.controller.BaseControllerTestCase;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public class PersonNameControllerTest extends BaseControllerTestCase {
    private PersonNameController controller;

    public void setPersonNameController(PersonNameController controller) {
        this.controller = controller;
    }

    public void testHandleRequest() throws Exception {
        ModelAndView mav = controller.handleRequest(null, null);
        ModelMap m = mav.getModelMap();
        assertNotNull(m.get("personNameList"));
        assertTrue(((List) m.get("personNameList")).size() > 0);
    }
}