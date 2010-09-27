package com.management.college.webapp.controller;

import org.apache.commons.lang.StringUtils;
import com.management.college.service.DecodeGroupManager;
import com.management.college.model.DecodeGroup;
import com.management.college.webapp.controller.BaseFormController;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class DecodeGroupFormController extends BaseFormController {
    private DecodeGroupManager decodeGroupManager = null;

    public void setDecodeGroupManager(DecodeGroupManager decodeGroupManager) {
        this.decodeGroupManager = decodeGroupManager;
    }

    public DecodeGroupFormController() {
        setCommandClass(DecodeGroup.class);
        setCommandName("decodeGroup");
    }

    protected Object formBackingObject(HttpServletRequest request)
    throws Exception {
        String id = request.getParameter("id");

        if (!StringUtils.isBlank(id)) {
            return decodeGroupManager.get(new Long(id));
        }

        return new DecodeGroup();
    }

    public ModelAndView onSubmit(HttpServletRequest request,
                                 HttpServletResponse response, Object command,
                                 BindException errors)
    throws Exception {
        log.debug("entering 'onSubmit' method...");

        DecodeGroup decodeGroup = (DecodeGroup) command;
        boolean isNew = (decodeGroup.getId() == null);
        String success = getSuccessView();
        Locale locale = request.getLocale();

        if (request.getParameter("delete") != null) {
            decodeGroupManager.remove(decodeGroup.getId());
            saveMessage(request, getText("decodeGroup.deleted", locale));
        } else {
            decodeGroupManager.save(decodeGroup);
            String key = (isNew) ? "decodeGroup.added" : "decodeGroup.updated";
            saveMessage(request, getText(key, locale));

            if (!isNew) {
                success = "redirect:decodeGroupform.html?id=" + decodeGroup.getId();
            }
        }

        return new ModelAndView(success);
    }
}
