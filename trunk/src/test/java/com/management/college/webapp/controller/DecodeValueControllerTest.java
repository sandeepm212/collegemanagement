package com.management.college.webapp.controller;

import com.management.college.webapp.controller.BaseControllerTestCase;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public class DecodeValueControllerTest extends BaseControllerTestCase {
    private DecodeValueController controller;

    public void setDecodeValueController(DecodeValueController controller) {
        this.controller = controller;
    }

    public void testHandleRequest() throws Exception {
        ModelAndView mav = controller.handleRequest(null, null);
        ModelMap m = mav.getModelMap();
        assertNotNull(m.get("decodeValueList"));
        assertTrue(((List) m.get("decodeValueList")).size() > 0);
    }
}