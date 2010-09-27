package com.management.college.webapp.controller;

import com.management.college.webapp.controller.BaseControllerTestCase;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public class PhoneControllerTest extends BaseControllerTestCase {
    private PhoneController controller;

    public void setPhoneController(PhoneController controller) {
        this.controller = controller;
    }

    public void testHandleRequest() throws Exception {
        ModelAndView mav = controller.handleRequest(null, null);
        ModelMap m = mav.getModelMap();
        assertNotNull(m.get("phoneList"));
        assertTrue(((List) m.get("phoneList")).size() > 0);
    }
}