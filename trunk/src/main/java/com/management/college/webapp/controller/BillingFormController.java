package com.management.college.webapp.controller;

import org.apache.commons.lang.StringUtils;
import com.management.college.service.BillingManager;
import com.management.college.model.Billing;
import com.management.college.webapp.controller.BaseFormController;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class BillingFormController extends BaseFormController {
    private BillingManager billingManager = null;

    public void setBillingManager(BillingManager billingManager) {
        this.billingManager = billingManager;
    }

    public BillingFormController() {
        setCommandClass(Billing.class);
        setCommandName("billing");
    }

    protected Object formBackingObject(HttpServletRequest request)
    throws Exception {
        String id = request.getParameter("id");

        if (!StringUtils.isBlank(id)) {
            return billingManager.get(new Long(id));
        }

        return new Billing();
    }

    public ModelAndView onSubmit(HttpServletRequest request,
                                 HttpServletResponse response, Object command,
                                 BindException errors)
    throws Exception {
        log.debug("entering 'onSubmit' method...");

        Billing billing = (Billing) command;
        boolean isNew = (billing.getId() == null);
        String success = getSuccessView();
        Locale locale = request.getLocale();

        if (request.getParameter("delete") != null) {
            billingManager.remove(billing.getId());
            saveMessage(request, getText("billing.deleted", locale));
        } else {
            billingManager.save(billing);
            String key = (isNew) ? "billing.added" : "billing.updated";
            saveMessage(request, getText(key, locale));

            if (!isNew) {
                success = "redirect:billingform.html?id=" + billing.getId();
            }
        }

        return new ModelAndView(success);
    }
}
