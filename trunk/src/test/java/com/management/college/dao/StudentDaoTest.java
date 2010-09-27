package com.management.college.dao;

import com.management.college.dao.BaseDaoTestCase;
import com.management.college.model.Student;
import com.management.college.model.util.FilterInfo;
import com.management.college.model.util.ListWrapper;
import com.management.college.model.view.StudentView;

import org.springframework.dao.DataAccessException;

import java.util.List;
import java.util.Map;

public class StudentDaoTest extends BaseDaoTestCase {
	private StudentDao studentDao;

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public void testAddAndRemoveStudent() throws Exception {
		Student student = new Student();

		// enter all required fields
		student.setCreatedOn(new java.util.Date());
		student.setUpdatedOn(new java.util.Date());
		student.setGender("Male");
		student.setJoiningDate(new java.util.Date());
		student.setNationality(8L);
		student.setStudentId("1234");

		log.debug("adding student...");
		student = studentDao.save(student);

		student = studentDao.get(student.getId());

		assertNotNull(student.getId());

		log.debug("removing student...");

		studentDao.remove(student.getId());

		try {
			studentDao.get(student.getId());
			fail("Student found in database");
		} catch (DataAccessException e) {
			log.debug("Expected exception: " + e.getMessage());
			assertNotNull(e);
		}
	}

	public void testGetStudents () throws Exception {
		FilterInfo filterInfo = new FilterInfo();
		filterInfo.setStartIndex(0);
    	filterInfo.setNumResults(2);
    	
    	ListWrapper<StudentView> studentViewList = studentDao.getStudents(null, filterInfo);
    	System.out.println(studentViewList);
    	
    }
}