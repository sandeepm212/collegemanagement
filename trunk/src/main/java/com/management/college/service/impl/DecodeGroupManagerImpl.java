package com.management.college.service.impl;

import java.util.Date;
import java.util.List;

import javax.jws.WebService;

import com.management.college.dao.DecodeGroupDao;
import com.management.college.model.DecodeGroup;
import com.management.college.model.DecodeValue;
import com.management.college.model.util.FilterInfo;
import com.management.college.model.util.ListWrapper;
import com.management.college.service.DecodeGroupManager;

@WebService(serviceName = "DecodeGroupService", endpointInterface = "com.management.college.service.DecodeGroupManager")
public class DecodeGroupManagerImpl
		extends
			GenericManagerImpl<DecodeGroup, Long> implements DecodeGroupManager {
	DecodeGroupDao decodeGroupDao;

	public DecodeGroupManagerImpl(DecodeGroupDao decodeGroupDao) {
		super(decodeGroupDao);
		this.decodeGroupDao = decodeGroupDao;
	}

	public ListWrapper<DecodeGroup> getDecodeGroups(DecodeGroup decodeGroup, FilterInfo filterInfo) {
		return getFilteredList(decodeGroup, filterInfo);
	}
	
	public DecodeGroup getDecodeGroup(Long id) {
		return get(id);
	}
	
	public DecodeGroup saveDecodeGroup(DecodeGroup decodeGroup) {
		Long id = decodeGroup.getId();
		DecodeGroup dg = null;
		Date currDate = new Date();
		if (id != null) {
			dg = get(id);
		} else {
			dg = new DecodeGroup();
			dg.setCreatedOn(currDate);
		}
		dg.setName(decodeGroup.getName());
		dg.setCode(decodeGroup.getCode());
		dg.setDescription(decodeGroup.getDescription());
		dg.setEnabled(decodeGroup.isEnabled());
		dg.setUpdatedOn(currDate);
		
		dg = save(dg);
		
		return dg;
	}
	
	public void removeDecodeGroup (Long id) {
		if (id != null) {
			remove(id);
		}
	}

	public DecodeValue saveDecodeValue(Long decodeGroupId, DecodeValue decodeValue) {
		DecodeGroup dg = decodeGroupDao.get(decodeGroupId);
		Long id = decodeValue.getId();
		DecodeValue dv = null;
		Date currDate = new Date();
		if (id != null) {
			dv = getDecodeValueFromList(dg, id);
		} else {
			dv = new DecodeValue();
			dv.setCreatedOn(currDate);
			dg.addDecodeValue(dv);
		}
		dv.setValue(decodeValue.getValue());
		dv.setShortCode(decodeValue.getShortCode());
		dv.setDescription(decodeValue.getDescription());
		dv.setEnabled(decodeValue.isEnabled());
		dv.setUpdatedOn(currDate);
		
		decodeGroupDao.save(dg);
		
		return dv;		
	}
	
	private DecodeValue getDecodeValueFromList(DecodeGroup dg, Long decodeValueId) {
		List<DecodeValue> decodeValues =  dg.getDecodeValues();
		if (decodeValues != null && !decodeValues.isEmpty()) {
			for (DecodeValue dv : decodeValues) {
				if (dv.getId().equals(decodeValueId)) {
					return dv;
				}
			}
		}
		return null;
	}

	public void removeDecodeValue(Long decodeGroupId, Long decodeValueId) {
		DecodeGroup dg = decodeGroupDao.get(decodeGroupId);
		DecodeValue dv = getDecodeValueFromList(dg, decodeValueId);
		dg.removeDecodeValue(dv);		
		decodeGroupDao.save(dg);
	}

	public ListWrapper<DecodeValue> getDecodeValues(Long decodeGroupId, final boolean isActiveOnly) {
		return decodeGroupDao.getDecodevalues(decodeGroupId, isActiveOnly);
	}

	public DecodeValue getDecodeValue(Long id) {
		return decodeGroupDao.getDecodeValue(id);
	}

	public List<DecodeValue> getDecodeValuesByGroup(String decodeGroupCode) {
		return decodeGroupDao.getDecodeValuesByGroup(decodeGroupCode);
	}
}