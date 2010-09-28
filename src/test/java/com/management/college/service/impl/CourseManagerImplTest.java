package com.management.college.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.management.college.dao.CourseDao;
import com.management.college.model.Course;
import com.management.college.service.impl.BaseManagerMockTestCase;

import org.jmock.Expectations;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class CourseManagerImplTest extends BaseManagerMockTestCase {
    private CourseManagerImpl manager = null;
    private CourseDao dao = null;

    @Before
    public void setUp() {
        dao = context.mock(CourseDao.class);
        manager = new CourseManagerImpl(dao);
    }

    @After
    public void tearDown() {
        manager = null;
    }

    @Test
    public void testGetCourse() {
        log.debug("testing get...");

        final Long id = 7L;
        final Course course = new Course();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).get(with(equal(id)));
            will(returnValue(course));
        }});

        Course result = manager.get(id);
        assertSame(course, result);
    }

    @Test
    public void testGetCourses() {
        log.debug("testing getAll...");

        final List courses = new ArrayList();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).getAll();
            will(returnValue(courses));
        }});

        List result = manager.getAll();
        assertSame(courses, result);
    }

    @Test
    public void testSaveCourse() {
        log.debug("testing save...");

        final Course course = new Course();
        // enter all required fields
        course.setCreatedOn(new java.util.Date());
        course.setUpdatedOn(new java.util.Date());
        course.setName("JdCeTuZwBoLaOsUwOsZxGbWyEfLmDyNwCiTzIhAoYwCgKzBeYuUwFzGuAyLaTyMrKdEwJxFeKfUwNfGgBiEfCxXqUoQiXxVhBsGyGwKrXgZlVsThQdJsXcGoIxFoEwBiHqEyGcSwLoLuQxZhGfVtCqZyFlHiLvLdKwVxFxDtQbGqNcXuTrBwUlFnYaNeGvEpBkFwTdQaJvFbZfOpEvLyPlCmQoDmIoTxRwEbOhYzEyEvOcGxViBfPzNwWoZnGcM");
        course.setCode("DeJlKvNiJrYdZkTmOjTxBlNeGtWaUpUhEqSwYgXaThDyAuEsXmOyLvQuOgXzKbVyCvXvUaCbBhJyVyYtIrVeFeHqKyXiDzLgMfPaHaCrHxYhGiQbMgXbBrCiGpRlIeWrCaGnJrJmQvAwSvCqPrQaHgCyHoHyHvEeDvExDlBeRaZhFoCqEyKlFhUbDwInSxTiAvAvTeTkZqDfLqFdRqYrQcGmDaDsSnPqGjIqOeFcTcTxIiWyRsWkPyQyUsLePrJ");
        course.setDuration(60564224);
        
        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).save(with(same(course)));
        }});

        manager.save(course);
    }

    @Test
    public void testRemoveCourse() {
        log.debug("testing remove...");

        final Long id = -11L;

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).remove(with(equal(id)));
        }});

        manager.remove(id);
    }
}