package com.management.college.webapp.controller;

import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

import com.management.college.AppConstants;
import com.management.college.model.Course;
import com.management.college.model.PersonName;
import com.management.college.model.Student;
import com.management.college.model.view.StudentView;
import com.management.college.service.CourseManager;
import com.management.college.service.PersonNameManager;
import com.management.college.service.StudentManager;

public class StudentFormController extends BaseFormController {
    private StudentManager studentManager = null;
    
    private CourseManager courseManager = null;
    
    private PersonNameManager personNameManager = null;

    public void setStudentManager(StudentManager studentManager) {
        this.studentManager = studentManager;
    }
    
    public void setPersonNameManager(PersonNameManager personNameManager) {
        this.personNameManager = personNameManager;
    }
    
    public void setCourseManager(CourseManager courseManager) {
        this.courseManager = courseManager;
    }

    public StudentFormController() {        
    }

    protected Object formBackingObject(HttpServletRequest request)
    throws Exception {
        String id = request.getParameter("id");

        if (!StringUtils.isBlank(id)) {
        	StudentView studentView = studentManager.getStudent(new Long(id));
        	List<PersonName> personNames = personNameManager.getPersonNamesByOwner(AppConstants.ENTITY_TYPE_CORE_STUDENT, studentView.getId());
        	if (personNames != null) {
        		for (PersonName pn : personNames) {
            		switch (pn.getPersonType()) {
						case PersonName.PN_TYPE_FATHER :
							studentView.setFatherName(pn);
							break;
						case PersonName.PN_TYPE_MOTHER :
							studentView.setMotherName(pn);
							break;
					}
            	}
        	}        	
        	
            return studentView;
        }
        return new StudentView();
    }
    
    public ModelAndView onSubmit(HttpServletRequest request,
                                 HttpServletResponse response, Object command,
                                 BindException errors)
    throws Exception {
        log.debug("entering 'onSubmit' method...");

        StudentView studentView = (StudentView) command;
        boolean isNew = (studentView.getId() == null);
        
        Student student;
        Date currentDate = new Date();
        if (isNew) {
        	student = new Student();
        	student.setCreatedOn(currentDate);
        } else {
        	student = studentManager.get(studentView.getId());
        }
        student.setUpdatedOn(currentDate);
        
        setStudentFromView(studentView, student);
        
        String success = getSuccessView();
        Locale locale = request.getLocale();

        if (request.getParameter("delete") != null) {
            studentManager.remove(student.getId());
            saveMessage(request, getText("student.deleted", locale));
        } else {
            studentManager.save(student);
            
            //Save Associated Entities
            Long id  = student.getId();
            PersonName studentName = null;
            if (studentView.getStudentName().getId() != null) {
            	studentName = personNameManager.get(studentView.getStudentName().getId());
            	studentName.setTitle(studentView.getStudentName().getTitle());
            	studentName.setFirstName(studentView.getStudentName().getFirstName());
            	studentName.setMiddleName(studentView.getStudentName().getMiddleName());
            	studentName.setLastName(studentView.getStudentName().getLastName());
            } else {
            	studentName = studentView.getStudentName();
            	studentName.setOwnerEntityId(id);
                studentName.setOwnerEntityType(student.getEntityType());
                studentName.setCreatedOn(currentDate);
            }
            studentName.setUpdatedOn(currentDate);
            personNameManager.save(studentName);
            
            String key = (isNew) ? "student.added" : "student.updated";
            saveMessage(request, getText(key, locale));

            if (!isNew) {
                success = "redirect:studentform.html?id=" + student.getId();
            }
        }

        return new ModelAndView(success);
    }
    
    private void setStudentFromView (StudentView studentView, Student student) {
    	if (studentView != null && student != null) {
    		Course course = courseManager.get(studentView.getCourseId());
    		student.setCourse(course);
    		
    		student.setDateOfBirth(studentView.getDateOfBirth());
    		student.setCurrentYear(studentView.getCurrentYear());
    		student.setAdmissionNumber(studentView.getAdmissionNumber());
    		student.setBloodGroup(studentView.getBloodGroup());
    		student.setGender(studentView.getGender());
    		student.setIdentificationMarks(studentView.getIdentificationMarks());
    		student.setJoiningDate(studentView.getJoiningDate());
    		student.setNationality(studentView.getNationality());
    		student.setRegistrationNumber(studentView.getRegistrationNumber());
    		student.setStudentId(studentView.getStudentId());
    	}
    }
}
