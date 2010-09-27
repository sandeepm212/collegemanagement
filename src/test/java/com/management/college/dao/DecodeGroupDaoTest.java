package com.management.college.dao;

import com.management.college.DecodeConstants;
import com.management.college.dao.BaseDaoTestCase;
import com.management.college.model.DecodeGroup;
import com.management.college.model.DecodeValue;
import com.management.college.model.util.FilterInfo;
import com.management.college.model.util.ListWrapper;

import org.springframework.dao.DataAccessException;

import java.util.List;

public class DecodeGroupDaoTest extends BaseDaoTestCase {
    private DecodeGroupDao decodeGroupDao;

    public void setDecodeGroupDao(DecodeGroupDao decodeGroupDao) {
        this.decodeGroupDao = decodeGroupDao;
    }

    public void testAddAndRemoveDecodeGroup() throws Exception {
        DecodeGroup decodeGroup = new DecodeGroup();

        // enter all required fields
        decodeGroup.setCreatedOn(new java.util.Date());
        decodeGroup.setUpdatedOn(new java.util.Date());
        decodeGroup.setCode("CODE");
        decodeGroup.setEnabled(Boolean.FALSE);
        decodeGroup.setLocked(Boolean.FALSE);
        decodeGroup.setName("NAME");

        log.debug("adding decodeGroup...");
        decodeGroup = decodeGroupDao.save(decodeGroup);

        decodeGroup = decodeGroupDao.get(decodeGroup.getId());

        assertNotNull(decodeGroup.getId());

        log.debug("removing decodeGroup...");

        decodeGroupDao.remove(decodeGroup.getId());

        try {
            decodeGroupDao.get(decodeGroup.getId());
            fail("DecodeGroup found in database");
        } catch (DataAccessException e) {
            log.debug("Expected exception: " + e.getMessage());
            assertNotNull(e);
        }
    }
    
    public void testGetDecodeValues() throws Exception {
    	ListWrapper<DecodeValue> dvlist = decodeGroupDao.getDecodevalues(4L, true);
    	System.out.println("------------");
    	//System.out.println(dvlist.getList());
    	System.out.println("------------");
    	List<DecodeValue> dvlistDg = decodeGroupDao.getDecodeValuesByGroup(DecodeConstants.DG_CODE_COURSE_GROUP);
    }
    
    public void testGetallDecodeValues() throws Exception {
    	FilterInfo filterInfo = new FilterInfo();
    	filterInfo.setStartIndex(0);
    	filterInfo.setNumResults(15);
    	
    	ListWrapper<DecodeGroup> dglist = decodeGroupDao.getFilteredList(null, filterInfo);
    	System.out.println("------------" + dglist);
    }
}