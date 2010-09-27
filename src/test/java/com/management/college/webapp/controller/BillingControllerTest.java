package com.management.college.webapp.controller;

import com.management.college.webapp.controller.BaseControllerTestCase;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public class BillingControllerTest extends BaseControllerTestCase {
    private BillingController controller;

    public void setBillingController(BillingController controller) {
        this.controller = controller;
    }

    public void testHandleRequest() throws Exception {
        ModelAndView mav = controller.handleRequest(null, null);
        ModelMap m = mav.getModelMap();
        assertNotNull(m.get("billingList"));
        assertTrue(((List) m.get("billingList")).size() > 0);
    }
}