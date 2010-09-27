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

	public ListWrapper<DecodeGroup> getDecodeGroups(DecodeGroup decodeGroup,
			FilterInfo filterInfo);

	public DecodeGroup getDecodeGroup(Long id);

	public DecodeGroup saveDecodeGroup(DecodeGroup decodeGroup);

	public void removeDecodeGroup(Long id);

	public DecodeValue saveDecodeValue(Long decodeGroupId,
			DecodeValue decodeValue);

	public void removeDecodeValue(Long decodeGroupId, Long id);

	public DecodeValue getDecodeValue(Long id);

	public ListWrapper<DecodeValue> getDecodeValues(Long decodeGroupId, boolean isActiveOnly);
	
	 /**
     * Retrieves all of the decodeValues
     * @param decodeGroupCode 
     * @return the list of decode values
     */
    public List<DecodeValue> getDecodeValuesByGroup(String decodeGroupCode);

}