package com.management.college.service;

import com.management.college.service.GenericManager;
import com.management.college.model.Course;
import com.management.college.model.DecodeGroup;
import com.management.college.model.Student;
import com.management.college.model.util.FilterInfo;
import com.management.college.model.util.ListWrapper;

import java.util.List;
import javax.jws.WebService;

@WebService
public interface CourseManager extends GenericManager<Course, Long> {
	public ListWrapper<Course> getCourses(Course course, FilterInfo filterInfo);
	
	public Course getCourse(Long id);

	public Course saveCourse(Course course);

	public void removeCourse(Long id);
	
	public void setJSONDecodeGroups ();

}