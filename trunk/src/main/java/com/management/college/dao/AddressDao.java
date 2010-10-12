package com.management.college.dao;

import java.util.List;

import com.management.college.dao.GenericDao;

import com.management.college.model.Address;

/**
 * An interface that provides a data management interface to the Address table.
 */
public interface AddressDao extends GenericDao<Address, Long> {
	List<Address> getAddressByOwner (final Long ownerId, final int ownerType);
}