package com.management.college.webapp.controller;

import org.apache.commons.lang.StringUtils;
import com.management.college.service.CourseManager;
import com.management.college.model.Course;
import com.management.college.webapp.controller.BaseFormController;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class CourseFormController extends BaseFormController {
    private CourseManager courseManager = null;

    public void setCourseManager(CourseManager courseManager) {
        this.courseManager = courseManager;
    }

    public CourseFormController() {
        setCommandClass(Course.class);
        setCommandName("course");
    }

    protected Object formBackingObject(HttpServletRequest request)
    throws Exception {
        String id = request.getParameter("id");

        if (!StringUtils.isBlank(id)) {
            return courseManager.get(new Long(id));
        }

        return new Course();
    }

    public ModelAndView onSubmit(HttpServletRequest request,
                                 HttpServletResponse response, Object command,
                                 BindException errors)
    throws Exception {
        log.debug("entering 'onSubmit' method...");

        Course course = (Course) command;
        boolean isNew = (course.getId() == null);
        String success = getSuccessView();
        Locale locale = request.getLocale();

        if (request.getParameter("delete") != null) {
            courseManager.remove(course.getId());
            saveMessage(request, getText("course.deleted", locale));
        } else {
            courseManager.save(course);
            String key = (isNew) ? "course.added" : "course.updated";
            saveMessage(request, getText(key, locale));

            if (!isNew) {
                success = "redirect:courseform.html?id=" + course.getId();
            }
        }

        return new ModelAndView(success);
    }
}
