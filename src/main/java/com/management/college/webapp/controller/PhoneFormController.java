package com.management.college.webapp.controller;

import org.apache.commons.lang.StringUtils;
import com.management.college.service.PhoneManager;
import com.management.college.model.Phone;
import com.management.college.webapp.controller.BaseFormController;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class PhoneFormController extends BaseFormController {
    private PhoneManager phoneManager = null;

    public void setPhoneManager(PhoneManager phoneManager) {
        this.phoneManager = phoneManager;
    }

    public PhoneFormController() {
        setCommandClass(Phone.class);
        setCommandName("phone");
    }

    protected Object formBackingObject(HttpServletRequest request)
    throws Exception {
        String id = request.getParameter("id");

        if (!StringUtils.isBlank(id)) {
            return phoneManager.get(new Long(id));
        }

        return new Phone();
    }

    public ModelAndView onSubmit(HttpServletRequest request,
                                 HttpServletResponse response, Object command,
                                 BindException errors)
    throws Exception {
        log.debug("entering 'onSubmit' method...");

        Phone phone = (Phone) command;
        boolean isNew = (phone.getId() == null);
        String success = getSuccessView();
        Locale locale = request.getLocale();

        if (request.getParameter("delete") != null) {
            phoneManager.remove(phone.getId());
            saveMessage(request, getText("phone.deleted", locale));
        } else {
            phoneManager.save(phone);
            String key = (isNew) ? "phone.added" : "phone.updated";
            saveMessage(request, getText(key, locale));

            if (!isNew) {
                success = "redirect:phoneform.html?id=" + phone.getId();
            }
        }

        return new ModelAndView(success);
    }
}
