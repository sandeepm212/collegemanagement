package com.management.college.webapp.controller;

import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

import com.management.college.model.Student;
import com.management.college.service.StudentManager;

public class StudentFormController extends BaseFormController {
    private StudentManager studentManager = null;

    public void setStudentManager(StudentManager studentManager) {
        this.studentManager = studentManager;
    }

    public StudentFormController() {
        setCommandClass(Student.class);
        setCommandName("student");
    }

    protected Object formBackingObject(HttpServletRequest request)
    throws Exception {
        String id = request.getParameter("id");

        if (!StringUtils.isBlank(id)) {
            return studentManager.get(new Long(id));
        }

        return new Student();
    }

    public ModelAndView onSubmit(HttpServletRequest request,
                                 HttpServletResponse response, Object command,
                                 BindException errors)
    throws Exception {
        log.debug("entering 'onSubmit' method...");

        Student student = (Student) command;
        boolean isNew = (student.getId() == null);
        
        Date currentDate = new Date();
        if (isNew) {
        	student.setCreatedOn(currentDate);
        }
        student.setUpdatedOn(currentDate);
        
        String success = getSuccessView();
        Locale locale = request.getLocale();

        if (request.getParameter("delete") != null) {
            studentManager.remove(student.getId());
            saveMessage(request, getText("student.deleted", locale));
        } else {
            studentManager.save(student);
            String key = (isNew) ? "student.added" : "student.updated";
            saveMessage(request, getText(key, locale));

            if (!isNew) {
                success = "redirect:studentform.html?id=" + student.getId();
            }
        }

        return new ModelAndView(success);
    }
}
