package com.management.college.dao;

import com.management.college.dao.BaseDaoTestCase;
import com.management.college.model.DecodeValue;
import org.springframework.dao.DataAccessException;

import java.util.List;

public class DecodeValueDaoTest extends BaseDaoTestCase {
    private DecodeValueDao decodeValueDao;

    public void setDecodeValueDao(DecodeValueDao decodeValueDao) {
        this.decodeValueDao = decodeValueDao;
    }

    public void testAddAndRemoveDecodeValue() throws Exception {
        DecodeValue decodeValue = new DecodeValue();

        // enter all required fields
        decodeValue.setCreatedOn(new java.util.Date());
        decodeValue.setUpdatedOn(new java.util.Date());
        decodeValue.setDisplayOrder(new Short("9061"));
        decodeValue.setEnabled(Boolean.FALSE);
        decodeValue.setShortCode("ZbLxXgAqGoZkLhOuPoMyCzXpJzPoCtZpAzJiQlPlMoAdOnVvOlQnIiXjXjFpGwXtNvTsQqOhAhRcDyWjLuRsRiPcKhSyFsHgInNmRzAeCoGuOdPqUtCwIgFiYeQkMlPsDuNvJjWmFpWeDtKnMmAeVsUtOeBkJxSpLaEjZiVdTzBvXkHmJgYiSgEsDsLlWsGcApBxJaMgYjQhOsDqKvRmPaNuRpKoSkApMpBkAuHaDoQtTuJfVdHiLoAyHgDaTaV");
        decodeValue.setValue("BhJsMoIxRgWxVkUwDpGtTeHvSzEqLoXjYrSnWiApAkWlWrZaDhNmGkTbNlOsWgQpEiDzDlNkYuCkCsPdQcBdCmKnObPpKpIbIqLiAwOrDbFcKaNaIyHzLuNdRiHmZkFuKaMcKuAzKrJjEwTxUdZcRhKaQhJuFeHgIpGjEjIzWoWdLbHnLbJdGiZpPnPyVtKnEbCvWoYyQdXgEwKlPfPePoGaVbEgZpPvKuInTlFeOkUsAhZtYnKxElLyOvQhGfK");

        log.debug("adding decodeValue...");
        decodeValue = decodeValueDao.save(decodeValue);

        decodeValue = decodeValueDao.get(decodeValue.getId());

        assertNotNull(decodeValue.getId());

        log.debug("removing decodeValue...");

        decodeValueDao.remove(decodeValue.getId());

        try {
            decodeValueDao.get(decodeValue.getId());
            fail("DecodeValue found in database");
        } catch (DataAccessException e) {
            log.debug("Expected exception: " + e.getMessage());
            assertNotNull(e);
        }
    }
}