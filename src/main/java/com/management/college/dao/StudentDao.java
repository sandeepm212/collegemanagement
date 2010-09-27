package com.management.college.dao;

import java.util.Map;

import com.management.college.model.Student;
import com.management.college.model.util.FilterInfo;
import com.management.college.model.util.ListWrapper;
import com.management.college.model.view.StudentView;

/**
 * An interface that provides a data management interface to the Student table.
 */
public interface StudentDao extends GenericDao<Student, Long> {
	public ListWrapper<StudentView> getStudents (Map filters, FilterInfo filterInfo);
}