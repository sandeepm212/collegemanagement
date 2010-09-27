package com.management.college.webapp.controller;

import org.apache.commons.lang.StringUtils;
import com.management.college.service.AddressManager;
import com.management.college.model.Address;
import com.management.college.webapp.controller.BaseFormController;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class AddressFormController extends BaseFormController {
    private AddressManager addressManager = null;

    public void setAddressManager(AddressManager addressManager) {
        this.addressManager = addressManager;
    }

    public AddressFormController() {
        setCommandClass(Address.class);
        setCommandName("address");
    }

    protected Object formBackingObject(HttpServletRequest request)
    throws Exception {
        String id = request.getParameter("id");

        if (!StringUtils.isBlank(id)) {
            return addressManager.get(new Long(id));
        }

        return new Address();
    }

    public ModelAndView onSubmit(HttpServletRequest request,
                                 HttpServletResponse response, Object command,
                                 BindException errors)
    throws Exception {
        log.debug("entering 'onSubmit' method...");

        Address address = (Address) command;
        boolean isNew = (address.getId() == null);
        String success = getSuccessView();
        Locale locale = request.getLocale();

        if (request.getParameter("delete") != null) {
            addressManager.remove(address.getId());
            saveMessage(request, getText("address.deleted", locale));
        } else {
            addressManager.save(address);
            String key = (isNew) ? "address.added" : "address.updated";
            saveMessage(request, getText(key, locale));

            if (!isNew) {
                success = "redirect:addressform.html?id=" + address.getId();
            }
        }

        return new ModelAndView(success);
    }
}
