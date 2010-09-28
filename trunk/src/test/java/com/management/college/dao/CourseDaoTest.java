package com.management.college.dao;

import com.management.college.dao.BaseDaoTestCase;
import com.management.college.model.Course;
import org.springframework.dao.DataAccessException;

import java.util.List;

public class CourseDaoTest extends BaseDaoTestCase {
    private CourseDao courseDao;

    public void setCourseDao(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    public void testAddAndRemoveCourse() throws Exception {
        Course course = new Course();

        // enter all required fields
        course.setCreatedOn(new java.util.Date());
        course.setUpdatedOn(new java.util.Date());
        course.setName("HxCvBkTpSjHyBfJbEcNbReUpIkFnNeMmBxKcIyHzBaGgMjOqJuRjAiIuDbGpEpJzJkKwOyZrLmLgIsVtKtFrSmRgTqTkYfFfQkJkRoViLwKvUuVyNbKvTrIuRyWwGjAfZlDpJvLuYqXfYtPxMcJxSxShFzFfAxSsJxYcFjCqKwWpPxDcMjIrUgCeNkMeHiRfXlZaGkHjWiKeYmKrBoXiAlTuBnEqHzWkStWnBrTmOgKeWjDgNdDiOsLiDqUgQuU");
        course.setCode("SrPuGmBbYmYgHgQnJmThTrQvBtDxOyXhKrZcHgAiAtZpDsTnAmCePjPrMrNcElBxSbQlZiRkDfKpLiJuLfDpOwFvAzCjHeQhAfVoOyVzGqInVxHvAuKfWvCpXkFlLaJwWnHxKmKgCvTdMjRgUeSiQgYnDjUbNoEwQoNcCyCnCbPyQgMmSfUlDgQfCaUjCkGmRoDyJkHlHzYcLuEkUhQkQjZmUqKyTpKlXwUkNzDdOjTzExTrTcVkHzKvZeXuYoM");
        course.setDuration(1186272483);

        log.debug("adding course...");
        course = courseDao.save(course);

        course = courseDao.get(course.getId());

        assertNotNull(course.getId());

        log.debug("removing course...");

        courseDao.remove(course.getId());

        try {
            courseDao.get(course.getId());
            fail("Course found in database");
        } catch (DataAccessException e) {
            log.debug("Expected exception: " + e.getMessage());
            assertNotNull(e);
        }
    }
}