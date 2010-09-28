package com.management.college.dao;

import java.util.List;

import com.management.college.dao.GenericDao;

import com.management.college.model.PersonName;

/**
 * An interface that provides a data management interface to the PersonName table.
 */
public interface PersonNameDao extends GenericDao<PersonName, Long> {
	List<PersonName> getPersonNamesByOwner (int ownerEntityType, Long ownerEntityId);
}