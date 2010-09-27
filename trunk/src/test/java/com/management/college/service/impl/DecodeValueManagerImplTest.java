package com.management.college.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.management.college.dao.DecodeValueDao;
import com.management.college.model.DecodeValue;
import com.management.college.service.impl.BaseManagerMockTestCase;

import org.jmock.Expectations;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class DecodeValueManagerImplTest extends BaseManagerMockTestCase {
    private DecodeValueManagerImpl manager = null;
    private DecodeValueDao dao = null;

    @Before
    public void setUp() {
        dao = context.mock(DecodeValueDao.class);
        manager = new DecodeValueManagerImpl(dao);
    }

    @After
    public void tearDown() {
        manager = null;
    }

    @Test
    public void testGetDecodeValue() {
        log.debug("testing get...");

        final Long id = 7L;
        final DecodeValue decodeValue = new DecodeValue();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).get(with(equal(id)));
            will(returnValue(decodeValue));
        }});

        DecodeValue result = manager.get(id);
        assertSame(decodeValue, result);
    }

    @Test
    public void testGetDecodeValues() {
        log.debug("testing getAll...");

        final List decodeValues = new ArrayList();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).getAll();
            will(returnValue(decodeValues));
        }});

        List result = manager.getAll();
        assertSame(decodeValues, result);
    }

    @Test
    public void testSaveDecodeValue() {
        log.debug("testing save...");

        final DecodeValue decodeValue = new DecodeValue();
        // enter all required fields
        decodeValue.setCreatedOn(new java.util.Date());
        decodeValue.setUpdatedOn(new java.util.Date());
        decodeValue.setDisplayOrder(new Short("11648"));
        decodeValue.setEnabled(Boolean.FALSE);
        decodeValue.setShortCode("JgCjEmOvKoGsCqAxFqZzCqDjKcOfKmWdCpGlDdObEmBmDyTwZzHtStSuSkCoRsJiJrVyCaVdTwXcWhQkAmGzOqDuFqFbMuAtXzLfXwQfPiMjSxSuMdRgNgUnFgRbYiCoBeFuLzBbZwVmMmLpTdYeJrTtPxUwXlWiLqSgTzIzImAhTgJvFbLcJoGaKiUmJnMdZkItGqIiThYiZoLkLmSaFgJcMgGlUkLgHiUdNzNyWpLxJlHqRlIrGeYqPwXjYoZ");
        decodeValue.setValue("UcIzEtXaZzKsIlXxClBsAxHwAlImYxXuPfDyEhQtZlZuOpRnVjZkXjWkThRdCfOgTfGeQkUhEcZoCbGvRnQiUmQbRqStQnXkUcWiKjMoZhOvYtBfWpKpDcYkUdNvQhBsPpKsVwSwWvUpAcXpYvElPiIjBwWiVrHqKaDrIjAhLmLuVeWcVrAhTgKoTwEbHzCwWhZqEcNgSkWzCbClFaIfDyTdStNyMzDkWgTuNbXiOdCrZmCbFtYtDsJrFqXdLuP");
        
        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).save(with(same(decodeValue)));
        }});

        manager.save(decodeValue);
    }

    @Test
    public void testRemoveDecodeValue() {
        log.debug("testing remove...");

        final Long id = -11L;

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).remove(with(equal(id)));
        }});

        manager.remove(id);
    }
}