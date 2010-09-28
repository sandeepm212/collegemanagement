/**
 * 
 */
package com.management.college.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.management.college.AppConstants;

/**
 * Represents a name of a person
 * 
 * @author <a
 *         href="mailto:malathi@endofthenight.com">malathi@endofthenight.com</a>
 */
@Entity
@Table(name = "mgmt_person_name")
public class PersonName extends BaseObject implements Serializable {

	public static final int PN_TYPE_DEFAULT = 0;

	public static final int PN_TYPE_FATHER = 1;

	public static final int PN_TYPE_MOTHER = 2;

	/**
     * 
     */
	private static final long serialVersionUID = 5350443289034885018L;

	/*
	 * A person's title: Mr., Mrs., Ms., etc.
	 */
	private Long title;

	/*
	 * The first name of the person
	 */
	private String firstName;

	/*
	 * The middle name of the person
	 */
	private String middleName;

	/*
	 * The last name of the person
	 */
	private String lastName;

	/*
	 * An optional suffix
	 */
	private String suffix;

	/*
	 * A formatted version of the name
	 */
	private String displayName;

	/*
	 * The objectType of the object to which this contact belongs. This contains
	 * one of the defined ENTITY_TYPE constants and is used in combination with
	 * the entityId to retrieve this contact from persistence.
	 */
	private int ownerEntityType;

	/*
	 * The id of the object to which this Contact belongs.
	 */
	private long ownerEntityId;

	/*
	 * Father / Mother .....
	 */
	private int personType;

	public PersonName() {
	}
	
	public PersonName(int personType) {
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.endofthenight.apps.etrack.model.BaseObject#getId()
	 */
	@TableGenerator(name = "person_id_gen", table = "mgmt_id_table", pkColumnName = "table_name", valueColumnName = "next_id")
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "person_id_gen")
	public Long getId() {
		return id;
	}

	/**
	 * @return the title
	 */
	@Column(name = "title", nullable = true)
	public Long getTitle() {
		return title;
	}

	/**
	 * @return the firstName
	 */
	@Column(name = "first_name", nullable = false, length = 50)
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the middleName
	 */
	@Column(name = "middle_name", nullable = true, length = 50)
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * @return the lastName
	 */
	@Column(name = "last_name", nullable = false, length = 100)
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return the suffix
	 */
	@Column(name = "suffix", nullable = true, length = 10)
	public String getSuffix() {
		return suffix;
	}

	/**
	 * Returns the full name.
	 * 
	 * @return firstName + ' ' + lastName
	 */
	@Transient
	public final String getFullName() {
		StringBuffer sb = new StringBuffer();

		if (title != null) {
			// sb.append(title);
		}

		if (firstName != null) {
			if (sb.length() > 0) {
				sb.append(' ');
			}
			sb.append(firstName.trim());
		}

		if (middleName != null) {
			if (sb.length() > 0) {
				sb.append(' ');
			}
			sb.append(middleName.trim());
		} else {
			sb.append(' ');
		}

		if (lastName != null) {
			if (sb.length() > 0) {
				sb.append(' ');
			}
			sb.append(lastName.trim());
		}

		if (suffix != null) {
			if (sb.length() > 0) {
				sb.append(' ');
			}
			sb.append(suffix.trim());
		}

		return sb.toString();
	}

	/**
	 * @return the displayName
	 */
	@Column(name = "display_name", nullable = true, length = 255)
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * Returns the application level constant integer of the model to which this
	 * contact belongs. Eg. AppConstants.ENTITY_TYPE_CORE_USER
	 * 
	 * @return the ownerEntityType
	 */
	@Column(name = "owner_entity_type", nullable = false)
	public int getOwnerEntityType() {
		return ownerEntityType;
	}
	
	@Column(name = "person_type", nullable = false)
	public int getPersonType() {
		return personType;
	}

	/**
	 * Returns the id of the owner entity (like User) whose address book has
	 * this contact entity.
	 * 
	 * @return the ownerEntityId
	 */
	@Column(name = "owner_entity_id", nullable = false)
	public long getOwnerEntityId() {
		return ownerEntityId;
	}

	@Override
	@Transient
	public final int getEntityType() {
		return AppConstants.ENTITY_TYPE_CONTACT_PERSON_NAME;
	}

	// ---------- Setters
	/**
	 * @param id
	 *            the id to set
	 */

	public void setId(final Long id) {
		this.id = id;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(final Long title) {
		this.title = title;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @param middleName
	 *            the middleName to set
	 */
	public void setMiddleName(final String middleName) {
		this.middleName = middleName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @param suffix
	 *            the suffix to set
	 */
	public void setSuffix(final String suffix) {
		this.suffix = suffix;
	}

	/**
	 * @param displayName
	 *            the displayName to set
	 */
	public void setDisplayName(final String displayName) {
		this.displayName = displayName;
	}

	/**
	 * Sets the ownerEntityType.
	 * 
	 * @param ownerEntityType
	 *            The ownerEntityType to set
	 */
	public void setOwnerEntityType(final int ownerEntityType) {
		this.ownerEntityType = ownerEntityType;
	}

	/**
	 * Sets the ownerEntityId.
	 * 
	 * @param ownerEntityId
	 *            The ownerEntityId to set
	 */
	public void setOwnerEntityId(final long ownerEntityId) {
		this.ownerEntityId = ownerEntityId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public final boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof PersonName)) {
			return false;
		}
		final PersonName personName = (PersonName) o;
		if (this.id != null ? !(this.id == personName.id)
				: personName.id != null) {
			return false;
		}

		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public final int hashCode() {
		int result;

		result = ((id == null) ? 0 : id.hashCode());
		result = 29 * (firstName != null ? firstName.hashCode() : 0);
		result = 29 * result + (lastName == null ? 0 : lastName.hashCode());

		return result;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public final String toString() {
		return new ToStringBuilder(this).append("updatedOn", this.updatedOn)
				.append("id", this.id).append("displayName", this.displayName)
				.append("suffix", this.suffix)
				.append("firstName", this.firstName)
				.append("entityType", this.getEntityType())
				.append("middleName", this.middleName)
				.append("lastName", this.lastName)
				.append("version", this.version).append("title", this.title)
				.toString();
	}

	public void setPersonType(int personType) {
		this.personType = personType;
	}
}
