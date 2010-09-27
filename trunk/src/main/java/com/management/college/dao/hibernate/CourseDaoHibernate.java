package com.management.college.dao.hibernate;

import com.management.college.model.Course;
import com.management.college.dao.CourseDao;
import com.management.college.dao.hibernate.GenericDaoHibernate;

public class CourseDaoHibernate extends GenericDaoHibernate<Course, Long> implements CourseDao {

    public CourseDaoHibernate() {
        super(Course.class);
    }
}
