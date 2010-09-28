package com.management.college.service;

import java.util.List;

import javax.jws.WebService;

import com.management.college.model.DecodeGroup;
import com.management.college.model.DecodeValue;
import com.management.college.model.util.FilterInfo;
import com.management.college.model.util.ListWrapper;
import com.management.college.model.util.PagingInfo;

@WebService
public interface DecodeGroupManager extends GenericManager<DecodeGroup, Long> {

	ListWrapper<DecodeGroup> getDecodeGroups(DecodeGroup decodeGroup,
			FilterInfo filterInfo);

	DecodeGroup getDecodeGroup(Long id);

	DecodeGroup saveDecodeGroup(DecodeGroup decodeGroup);

	void removeDecodeGroup(Long id);

	DecodeValue saveDecodeValue(Long decodeGroupId, DecodeValue decodeValue);

	void removeDecodeValue(Long decodeGroupId, Long id);

	DecodeValue getDecodeValue(Long id);

	ListWrapper<DecodeValue> getDecodeValues(Long decodeGroupId,
			boolean isActiveOnly);

	/**
	 * Retrieves all of the decodeValues
	 * 
	 * @param decodeGroupCode
	 * @return the list of decode values
	 */
	List<DecodeValue> getDecodeValuesByGroup(String decodeGroupCode);

}