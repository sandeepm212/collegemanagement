package com.management.college.dao;

import java.util.List;

import com.management.college.dao.GenericDao;

import com.management.college.model.Course;

/**
 * An interface that provides a data management interface to the Course table.
 */
public interface CourseDao extends GenericDao<Course, Long> {
	public List<Course> getCoursesByGroup(Long courseGroupId);
}