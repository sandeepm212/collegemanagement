package com.management.college.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import javax.persistence.Version;

/**
 * Base class for Model objects. Child objects should implement toString(),
 * equals() and hashCode().
 * 
 * @author <a href="mailto:sandeep.mandrumaka@gmail.com">Sandeep Mandrumaka</a>
 */

@MappedSuperclass
public abstract class BaseObject implements Serializable {

	protected Long id;

	protected Integer version;

	/*
	 * The date on which the object created.
	 */
	protected java.util.Date createdOn;

	/*
	 * The date on which the object updated.
	 */
	protected java.util.Date updatedOn;

	/**
	 * Returns the id of this object.
	 * 
	 * @return the id
	 */
	@Transient
	public abstract Long getId();

	/**
	 * Returns the Hibernate version.
	 * 
	 * @return the hibernate version
	 */
	@Version
	public Integer getVersion() {
		return this.version;
	}

	/**
	 * Returns the date on which this object is created.
	 * 
	 * @return the date on which this object is created.
	 */
	@Column(name = "created_on", nullable = false, updatable = false)
	public java.util.Date getCreatedOn() {
		return this.createdOn;
	}

	/**
	 * Returns the date on which this object is updated.
	 * 
	 * @return the date on which this object is updated.
	 */
	@Column(name = "updated_on", nullable = false)
	public java.util.Date getUpdatedOn() {
		return updatedOn;
	}

	/**
	 * @return entityType
	 */
	@Transient
	public abstract int getEntityType();

	// ----- Setters

	/**
	 * Sets the id of this object.
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Sets the Hibernate version.
	 * 
	 * @param version
	 *            the version to set
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

	/**
	 * Sets the date on which this object is created.
	 * 
	 * @param createdDate
	 *            - date on which this object is created.
	 */
	public void setCreatedOn(java.util.Date createdOn) {
		this.createdOn = createdOn;
	}

	/**
	 * Sets the date on which this object is updated.
	 * 
	 * @param updatedDate
	 *            - date on which this object is updated.
	 */
	public void setUpdatedOn(java.util.Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	/**
	 * Returns a multi-line String with key=value pairs.
	 * 
	 * @return a String representation of this class.
	 */
	public abstract String toString();

	/**
	 * Compares object equality. When using Hibernate, the primary key should
	 * not be a part of this comparison.
	 * 
	 * @param o
	 *            object to compare to
	 * @return true/false based on equality tests
	 */
	public abstract boolean equals(Object o);

	/**
	 * When you override equals, you should override hashCode. See "Why are
	 * equals() and hashCode() importation" for more information:
	 * http://www.hibernate.org/109.html
	 * 
	 * @return hashCode
	 */
	public abstract int hashCode();
}
