package com.management.college.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.management.college.dao.DecodeGroupDao;
import com.management.college.model.DecodeGroup;
import com.management.college.service.impl.BaseManagerMockTestCase;

import org.jmock.Expectations;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class DecodeGroupManagerImplTest extends BaseManagerMockTestCase {
    private DecodeGroupManagerImpl manager = null;
    private DecodeGroupDao dao = null;

    @Before
    public void setUp() {
        dao = context.mock(DecodeGroupDao.class);
        manager = new DecodeGroupManagerImpl(dao);
    }

    @After
    public void tearDown() {
        manager = null;
    }

    @Test
    public void testGetDecodeGroup() {
        log.debug("testing get...");

        final Long id = 7L;
        final DecodeGroup decodeGroup = new DecodeGroup();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).get(with(equal(id)));
            will(returnValue(decodeGroup));
        }});

        DecodeGroup result = manager.get(id);
        assertSame(decodeGroup, result);
    }

    @Test
    public void testGetDecodeGroups() {
        log.debug("testing getAll...");

        final List decodeGroups = new ArrayList();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).getAll();
            will(returnValue(decodeGroups));
        }});

        List result = manager.getAll();
        assertSame(decodeGroups, result);
    }

    @Test
    public void testSaveDecodeGroup() {
        log.debug("testing save...");

        final DecodeGroup decodeGroup = new DecodeGroup();
        // enter all required fields
        decodeGroup.setCreatedOn(new java.util.Date());
        decodeGroup.setUpdatedOn(new java.util.Date());
        decodeGroup.setCode("CuVxAiAbGbPjHmNoFlVeBwZcIqTeOnKvLzIaKgWhVcVwYuHfCpVsIwVeCuMbFzXuBqSeCwDbSiJvAaUxShCzYfZeJaBvFjQoJyWxPjUnKgHuIaDoMxNeOuHeMtNzIwXpKbCvLmYoWaIgEaBzRhWaVuEsSiQaGzVrJeFhXrZwJwHuIjQpPuGwWgJfOtVpWbLjYyQbJlBfCaMyAzQmLfAgHhByBmHtZhXpGjZmQaQqLmPvAmUqZdAlXeZaVsMhApF");
        decodeGroup.setEnabled(Boolean.FALSE);
        decodeGroup.setLocked(Boolean.FALSE);
        decodeGroup.setName("QpQsVsEkKbSsLiFtOzPrLmZbWpRrRkBwBfJhPoKkWxSqXuYrYkAvDtGbPwLaWsLbLfDcQrIlSpGhBdByRbCmSwAtAxRoQkZaQxDhZwEsIxMtOhFyGsGyKuCzOaXuCqNmBkGfGtYtQqPdQrUlCyHdHgNjVxVhKlVoLiEnByFjZxBwUfZzOvEjQrJzZlDnRbCxPsWlBuThHdTiDeZqRkDwDpSgQsHeIoTxToLfUjBrRzLpMkHtRrCfTfXlZaRmNtP");
        
        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).save(with(same(decodeGroup)));
        }});

        manager.save(decodeGroup);
    }

    @Test
    public void testRemoveDecodeGroup() {
        log.debug("testing remove...");

        final Long id = -11L;

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(dao).remove(with(equal(id)));
        }});

        manager.remove(id);
    }
}