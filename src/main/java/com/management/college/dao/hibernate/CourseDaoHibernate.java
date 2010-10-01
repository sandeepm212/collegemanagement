package com.management.college.dao.hibernate;

import java.util.List;

import com.management.college.model.Course;
import com.management.college.model.DecodeValue;
import com.management.college.dao.CourseDao;
import com.management.college.dao.hibernate.GenericDaoHibernate;

public class CourseDaoHibernate extends GenericDaoHibernate<Course, Long>
		implements CourseDao {

	public CourseDaoHibernate() {
		super(Course.class);
	}

	public List<Course> getCoursesByGroup(Long courseGroupId) {
		return getHibernateTemplate().find(
				"from Course c left join fetch c.group where c.group.id = ?",
				courseGroupId);
	}
}
