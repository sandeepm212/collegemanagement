package com.management.college.service.impl;

import com.management.college.dao.StudentDao;
import com.management.college.model.DecodeGroup;
import com.management.college.model.Student;
import com.management.college.model.util.FilterInfo;
import com.management.college.model.util.ListWrapper;
import com.management.college.model.view.StudentView;
import com.management.college.service.StudentManager;
import com.management.college.service.impl.GenericManagerImpl;

import java.util.List;
import java.util.Map;

import javax.jws.WebService;

@WebService(serviceName = "StudentService", endpointInterface = "com.management.college.service.StudentManager")
public class StudentManagerImpl extends GenericManagerImpl<Student, Long> implements StudentManager {
    StudentDao studentDao;

    public StudentManagerImpl(StudentDao studentDao) {
        super(studentDao);
        this.studentDao = studentDao;
    }

	
    
	public ListWrapper<StudentView> getStudents(Map filters,
			FilterInfo filterInfo) {
		return studentDao.getStudents(filters, filterInfo);
	}
    
}