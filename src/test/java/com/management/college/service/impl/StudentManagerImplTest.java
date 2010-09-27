package com.management.college.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.management.college.dao.StudentDao;
import com.management.college.model.Student;
import com.management.college.service.impl.BaseManagerMockTestCase;

import org.jmock.Expectations;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class StudentManagerImplTest extends BaseManagerMockTestCase {
    private StudentManagerImpl manager = null;
    private StudentDao dao = null;

    @Before
    public void setUp() {
        dao = context.mock(StudentDao.class);
        manager = new StudentManagerImpl(dao);
    }

    @After
    public void tearDown() {
        manager = null;
    }

    @Test
    public void testGetStudent() {
        log.debug("testing get...");

        final Long id = 7L;
        final Student student = new Student();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).get(with(equal(id)));
            will(returnValue(student));
        }});

        Student result = manager.get(id);
        assertSame(student, result);
    }

    @Test
    public void testGetStudents() {
        log.debug("testing getAll...");

        final List students = new ArrayList();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).getAll();
            will(returnValue(students));
        }});

        List result = manager.getAll();
        assertSame(students, result);
    }

    @Test
    public void testSaveStudent() {
        log.debug("testing save...");

        final Student student = new Student();
        // enter all required fields
        student.setCreatedOn(new java.util.Date());
        student.setUpdatedOn(new java.util.Date());
        student.setGender("Male");
        student.setJoiningDate(new java.util.Date());
        student.setNationality(9L);
        student.setStudentId("1234");
        
        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).save(with(same(student)));
        }});

        manager.save(student);
    }

    @Test
    public void testRemoveStudent() {
        log.debug("testing remove...");

        final Long id = -11L;

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).remove(with(equal(id)));
        }});

        manager.remove(id);
    }
}