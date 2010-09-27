package com.management.college.model;

import java.io.Serializable;

/**
 * Base class for Model contact objects. Child objects should implement setters
 * and getters for nickName, ownerEntityType and ownerEntityId.
 * 
 * @author <a
 *         href="mailto:malathi@endofthenight.com">malathi@endofthenight.com</a>
 */
public abstract class ContactBaseObject extends BaseObject
		implements
			Serializable {

	protected String nickName;

	/*
	 * The objectType of the object to which this contact belongs. This contains
	 * one of the defined ENTITY_TYPE constants and is used in combination with
	 * the entityId to retrieve this contact from persistence.
	 */
	protected int ownerEntityType;

	/*
	 * The id of the object to which this Contact belongs.
	 */
	protected long ownerEntityId;

	/**
	 * Returns the nickName.
	 * 
	 * @return the nickName
	 */
	public abstract String getNickName();

	/**
	 * Returns the ownerEntityType.
	 * 
	 * @return the ownerEntityType
	 */
	public abstract int getOwnerEntityType();

	/**
	 * Returns the ownerEntityId.
	 * 
	 * @return the ownerEntityId
	 */
	public abstract long getOwnerEntityId();

	/**
	 * Sets the nickName.
	 * 
	 * @param nickName
	 *            The nickName to set
	 */
	public abstract void setNickName(String nickName);

	/**
	 * Sets the ownerEntityType.
	 * 
	 * @param ownerEntityType
	 *            The ownerEntityType to set
	 */
	public abstract void setOwnerEntityType(int ownerEntityType);

	/**
	 * Sets the ownerEntityId.
	 * 
	 * @param ownerEntityId
	 *            The ownerEntityId to set
	 */
	public abstract void setOwnerEntityId(long ownerEntityId);
}