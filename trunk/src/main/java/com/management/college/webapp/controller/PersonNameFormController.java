package com.management.college.webapp.controller;

import org.apache.commons.lang.StringUtils;
import com.management.college.service.PersonNameManager;
import com.management.college.model.PersonName;
import com.management.college.webapp.controller.BaseFormController;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class PersonNameFormController extends BaseFormController {
    private PersonNameManager personNameManager = null;

    public void setPersonNameManager(PersonNameManager personNameManager) {
        this.personNameManager = personNameManager;
    }

    public PersonNameFormController() {
        setCommandClass(PersonName.class);
        setCommandName("personName");
    }

    protected Object formBackingObject(HttpServletRequest request)
    throws Exception {
        String id = request.getParameter("id");

        if (!StringUtils.isBlank(id)) {
            return personNameManager.get(new Long(id));
        }

        return new PersonName();
    }

    public ModelAndView onSubmit(HttpServletRequest request,
                                 HttpServletResponse response, Object command,
                                 BindException errors)
    throws Exception {
        log.debug("entering 'onSubmit' method...");

        PersonName personName = (PersonName) command;
        boolean isNew = (personName.getId() == null);
        String success = getSuccessView();
        Locale locale = request.getLocale();

        if (request.getParameter("delete") != null) {
            personNameManager.remove(personName.getId());
            saveMessage(request, getText("personName.deleted", locale));
        } else {
            personNameManager.save(personName);
            String key = (isNew) ? "personName.added" : "personName.updated";
            saveMessage(request, getText(key, locale));

            if (!isNew) {
                success = "redirect:personNameform.html?id=" + personName.getId();
            }
        }

        return new ModelAndView(success);
    }
}
