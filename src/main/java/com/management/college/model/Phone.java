package com.management.college.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.management.college.AppConstants;

/**
 * <p>
 * This class is used to represent a phone number in the application.
 * </p>
 * 
 * <p>
 * An instance of this class can belong to different objects in the application.
 * This relationship is defined using the <code>entityId</code> - which is the
 * id of the owning object, and <code>entityType</code> - a constant that
 * identifies the type of the owning object.
 * </p>
 * 
 */
@Entity(name = "mgmt_phone")
public class Phone extends BaseObject implements Serializable {

	private static final long serialVersionUID = -8767715717154510432L;

	/*
	 * The Phone number.
	 */
	private String dataValue;

	/*
	 * Type of Phone. Example:Home, Email, InstantMessenger, TypeUrl. This is
	 * identified by a DecodeValue which can be edited through the application.
	 */
	private long dataType;

	/*
	 * Type of Phone. Example:Phone, Email, IM, TypeUrl. This is identified by a
	 * DecodeValue which can be edited through the application.
	 */
	private int entitySubType;

	/*
	 * Priority of Phone. Example:Primary, Secondary, Alternative. This is
	 * identified by a DecodeValue which can be edited through the application.
	 */
	private long primary;

	/*
	 * The position at which this object will be displayed in a list of
	 * siblings.
	 */
	private int displayOrder;

	/*
	 * This is true if the Phone is currently enabled and available for use.
	 */
	private boolean enabled;

	/*
	 * The id of the object to which this Phone belongs.
	 */
	private long ownerEntityId;

	/*
	 * The objectType of the object to which this phone belongs. This contains
	 * one of the defined ENEITY_TYPE constants and is used in combination with
	 * the entityId to retrieve this phone from persistence.
	 */
	private int ownerEntityType;

	public static final int PHONE_ENTITY_SUB_TYPE_PHONE = 1;

	public static final int PHONE_ENTITY_SUB_TYPE_IM = 2;

	public static final int PHONE_ENTITY_SUB_TYPE_EMAIL = 3;

	public static final int PHONE_ENTITY_SUB_TYPE_URL = 4;

	/**
	 * Default Constructor for Phone.
	 */
	public Phone() {
	}

	/**
	 * @return id
	 */
	@TableGenerator(name = "phone_id_gen", table = "mgmt_id_table", pkColumnName = "table_name", valueColumnName = "next_id", allocationSize = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "phone_id_gen")
	public Long getId() {
		return id;
	}

	/**
	 * @return the dataValue
	 */
	@Column(name = "data_value", nullable = false)
	public String getDataValue() {
		return dataValue;
	}

	/**
	 * @return the dataType
	 */
	@Column(name = "data_type", nullable = false)
	public long getDataType() {
		return dataType;
	}

	/**
	 * @return the entitySubType
	 */
	@Column(name = "entity_sub_type", nullable = false)
	public int getEntitySubType() {
		return entitySubType;
	}

	/**
	 * @return the primary
	 */
	@Column(name = "primary_phone")
	public long getPrimary() {
		return primary;
	}

	/**
	 * @return enabled
	 */
	@Column(name = "enabled", nullable = false)
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * @return displayOrder
	 */
	@Column(name = "display_order", nullable = false)
	public int getDisplayOrder() {
		return displayOrder;
	}

	/**
	 * @return the OwnerEntityId
	 */
	@Column(name = "owner_entity_id", nullable = false, updatable = false)
	public long getOwnerEntityId() {
		return ownerEntityId;
	}

	/**
	 * @return the ownerEntityType
	 */
	@Column(name = "owner_entity_type", nullable = false, updatable = false)
	public int getOwnerEntityType() {
		return ownerEntityType;
	}

	/**
	 * @return the type of the object.
	 */
	@Transient
	public int getEntityType() {
		return AppConstants.ENTITY_TYPE_CONTACT_PHONE;
	}

	// -- setters

	/**
	 * 
	 * @param id
	 *            The id to set
	 */
	public void setId(final Long id) {
		this.id = id;
	}

	/**
	 * @param dataValue
	 *            the dataValue to set
	 */
	public void setDataValue(final String dataValue) {
		this.dataValue = dataValue;
	}

	/**
	 * @param dataType
	 *            the dataType to set
	 */
	public void setDataType(final long dataType) {
		this.dataType = dataType;
	}

	/**
	 * @param entitySubType
	 *            the entitySubType to set
	 */
	public void setEntitySubType(final int entitySubType) {
		this.entitySubType = entitySubType;
	}

	/**
	 * @param primary
	 *            the primary to set
	 */
	public void setPrimary(final long primary) {
		this.primary = primary;
	}

	/**
	 * @param displayOrder
	 */
	public void setDisplayOrder(final int displayOrder) {
		this.displayOrder = displayOrder;
	}

	/**
	 * @param enabled
	 */
	public void setEnabled(final boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * @param phoneEntityId
	 *            the OwnerEntityId to set
	 */
	public void setOwnerEntityId(final long phoneEntityId) {
		this.ownerEntityId = phoneEntityId;
	}

	/**
	 * @param phoneEntityType
	 *            the ownerEntityType is to set
	 */
	public void setOwnerEntityType(final int phoneEntityType) {
		this.ownerEntityType = phoneEntityType;
	}

	/**
	 * @see java.lang.Object#hashCode()
	 * @return A hash value that uniquely identifies an Object.
	 */
	public int hashCode() {
		int result;
		result = ((id == null) ? 0 : id.hashCode());
		result = 29 * result + ((dataValue == null) ? 0 : dataValue.hashCode());

		return result;
	}

	/**
	 * Method used to compare the objects.
	 * 
	 * @param o
	 *            to set the boolean value
	 * @return true if the specified Object is equal to the current Object;
	 *         otherwise, false.
	 */
	public boolean equals(final Object o) {

		if (this == o) {
			return true;
		}
		if (!(o instanceof Phone)) {
			return false;
		}

		final Phone phone1 = (Phone) o;

		if (this.id != null ? !(this.id == phone1.id) : phone1.id != null) {
			return false;
		}

		return true;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		ToStringBuilder toStringBuilder = new ToStringBuilder(this,
				ToStringStyle.MULTI_LINE_STYLE)
				.append("dataValue", this.dataValue).append("id", this.id)
				.append("primary", this.primary)
				.append("enabled", this.enabled)
				.append("displayOrder", this.displayOrder)
				.append("entityType", this.getEntityType())
				.append("entitySubType", this.entitySubType)
				.append("ownerEntityType", this.ownerEntityType)
				.append("ownerEntityId", this.ownerEntityId)
				.append("dataType", this.dataType);

		return toStringBuilder.toString();
	}

}
