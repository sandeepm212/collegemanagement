package com.management.college.service;

import com.management.college.service.GenericManager;
import com.management.college.model.DecodeGroup;
import com.management.college.model.Student;
import com.management.college.model.util.FilterInfo;
import com.management.college.model.util.ListWrapper;
import com.management.college.model.view.StudentView;

import java.util.List;
import java.util.Map;

import javax.jws.WebService;

@WebService
public interface StudentManager extends GenericManager<Student, Long> {
	
	public ListWrapper<StudentView> getStudents(Map filters,
			FilterInfo filterInfo);
}