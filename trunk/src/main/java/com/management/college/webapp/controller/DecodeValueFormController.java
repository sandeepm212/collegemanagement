package com.management.college.webapp.controller;

import org.apache.commons.lang.StringUtils;
import com.management.college.service.DecodeValueManager;
import com.management.college.model.DecodeValue;
import com.management.college.webapp.controller.BaseFormController;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class DecodeValueFormController extends BaseFormController {
    private DecodeValueManager decodeValueManager = null;

    public void setDecodeValueManager(DecodeValueManager decodeValueManager) {
        this.decodeValueManager = decodeValueManager;
    }

    public DecodeValueFormController() {
        setCommandClass(DecodeValue.class);
        setCommandName("decodeValue");
    }

    protected Object formBackingObject(HttpServletRequest request)
    throws Exception {
        String id = request.getParameter("id");

        if (!StringUtils.isBlank(id)) {
            return decodeValueManager.get(new Long(id));
        }

        return new DecodeValue();
    }

    public ModelAndView onSubmit(HttpServletRequest request,
                                 HttpServletResponse response, Object command,
                                 BindException errors)
    throws Exception {
        log.debug("entering 'onSubmit' method...");

        DecodeValue decodeValue = (DecodeValue) command;
        boolean isNew = (decodeValue.getId() == null);
        String success = getSuccessView();
        Locale locale = request.getLocale();

        if (request.getParameter("delete") != null) {
            decodeValueManager.remove(decodeValue.getId());
            saveMessage(request, getText("decodeValue.deleted", locale));
        } else {
            decodeValueManager.save(decodeValue);
            String key = (isNew) ? "decodeValue.added" : "decodeValue.updated";
            saveMessage(request, getText(key, locale));

            if (!isNew) {
                success = "redirect:decodeValueform.html?id=" + decodeValue.getId();
            }
        }

        return new ModelAndView(success);
    }
}
