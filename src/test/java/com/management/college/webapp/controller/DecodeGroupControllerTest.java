package com.management.college.webapp.controller;

import com.management.college.webapp.controller.BaseControllerTestCase;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public class DecodeGroupControllerTest extends BaseControllerTestCase {
    private DecodeGroupController controller;

    public void setDecodeGroupController(DecodeGroupController controller) {
        this.controller = controller;
    }

    public void testHandleRequest() throws Exception {
        ModelAndView mav = controller.handleRequest(null, null);
        ModelMap m = mav.getModelMap();
        assertNotNull(m.get("decodeGroupList"));
        assertTrue(((List) m.get("decodeGroupList")).size() > 0);
    }
}