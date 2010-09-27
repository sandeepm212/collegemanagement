package com.management.college.webapp.controller;

import com.management.college.webapp.controller.BaseControllerTestCase;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public class AddressControllerTest extends BaseControllerTestCase {
    private AddressController controller;

    public void setAddressController(AddressController controller) {
        this.controller = controller;
    }

    public void testHandleRequest() throws Exception {
        ModelAndView mav = controller.handleRequest(null, null);
        ModelMap m = mav.getModelMap();
        assertNotNull(m.get("addressList"));
        assertTrue(((List) m.get("addressList")).size() > 0);
    }
}