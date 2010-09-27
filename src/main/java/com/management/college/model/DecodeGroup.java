package com.management.college.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.management.college.AppConstants;

/**
 * <p>
 * A object that holds the data in the decode groups database table.
 *</p>
 * 
 * @author <a href="mailto:sandeep@endofthenight.com">sandeep@endofthenight.com</a>.
 */
@Entity
@Table(name = "mgmt_decode_group")
public class DecodeGroup extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1699573878270427781L;

    /*
     * An unique code for this DecodeGroup. Used to locate and load this DecodeGroup.
     * Example: phone_types
     */
    private String            code;

    /*
     * The name of the group.
     */
    private String            name;

    /*
     * The description of the group.
     */
    private String            description;

    /*
     * This is true if the DecodeGroup is currently enabled and available for use.
     */
    private boolean           enabled;

    /*
     * If true, this DecodeGroup's data cannot be changed or deleted.
     */
    private boolean           locked;

    /*
     * List of the decode values for the decode group.
     */
    private List<DecodeValue> decodeValues;

    @TableGenerator(name = "decode_group_id_gen", table = "mgmt_id_table", pkColumnName = "table_name", valueColumnName = "next_id", initialValue = 5, allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "decode_group_id_gen")
    public Long getId() {
        return id;
    }

	/**
	 * Returns the code of decode group.
	 * 
	 * @return the code
	 */
    @Column(name = "code", length = 255, nullable = false, unique = true)
    public String getCode() {
        return code;
    }

	/**
	 * Returns the name of decode group.
	 * 
	 * @return the name
	 */
    @Column(name = "name", length = 255, nullable = false)
    public String getName() {
        return name;
    }

	/**
	 * Returns the description about the decode group.
	 * 
	 * @return the description
	 */
    @Column(name = "description", length = 512)
    public String getDescription() {
        return description;
    }

	/**
	 * Returns true if this instance is currently active.
	 * 
	 * @return the enabled value
	 */
    @Column(name = "enabled", nullable = false)
    public boolean isEnabled() {
        return enabled;
    }

	/**
	 * Returns true if the decode group is locked.
	 * 
	 * @return the locked value
	 */
    @Column(name = "locked", nullable = false)
    public boolean isLocked() {
        return locked;
    }

	/**
	 * Returns the list of decode values mapped to this decode group.
	 * 
	 * @return list
	 */
    @OneToMany(mappedBy = "decodeGroup", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
    public List<DecodeValue> getDecodeValues() {
        return decodeValues;
    }

	/** {@inheritDoc} */
    @Transient
    public int getEntityType() {
        return AppConstants.ENTITY_TYPE_UTIL_DECODE_GROUP;
    }

    // -- setters

	/** {@inheritDoc} */
	public void setId(final Long id) {
        this.id = id;
    }

	/**
	 * Sets the code of the decode group.
	 * 
	 * @param inputCode
	 *            the code to set
	 */
	public void setCode(final String inputCode) {
		this.code = inputCode;
    }

	/**
	 * Sets the name of the decode group.
	 * 
	 * @param decodeGroup
	 *            the name to set
	 */
	public void setName(final String decodeGroup) {
        this.name = decodeGroup;
    }

	/**
	 * Sets the description of decode group.
	 * 
	 * @param inputDescription
	 *            the description to set
	 */
	public void setDescription(final String inputDescription) {
		this.description = inputDescription;
    }

	/**
	 * Sets the enabled value.
	 * 
	 * @param inputEnabled
	 *            the enabled to set
	 */
	public void setEnabled(final boolean inputEnabled) {
		this.enabled = inputEnabled;
    }

	/**
	 * Sets the locked.
	 * 
	 * @param inputLocked
	 *            The locked to set
	 */
	public void setLocked(final boolean inputLocked) {
		this.locked = inputLocked;
    }

	/**
	 * Sets the list of decode values mapped to this decode group.
	 * 
	 * @param inputDecodeValues
	 *            the decodeValues to set
	 */
	public void setDecodeValues(final List<DecodeValue> inputDecodeValues) {
		this.decodeValues = inputDecodeValues;
    }
		
	public void addDecodeValue(DecodeValue dv) {
        if (!this.decodeValues.contains(dv)) {
        	this.decodeValues.add(dv);
            dv.setDecodeGroup(this);
        }
    }
	
	public void removeDecodeValue(DecodeValue dv) {
		if (this.decodeValues.contains(dv)) {
            this.decodeValues.remove(dv);
        }
    }

	/** {@inheritDoc} */
    public int hashCode() {
		int result = ((name == null) ? 0 : name.hashCode());
        result = 29 * result + ((description == null) ? 0 : description.hashCode());
        return result;
    }

	/** {@inheritDoc} */
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
        final DecodeGroup other = (DecodeGroup) obj;

		if (this.id != null ? !(this.id == other.id) : other.id != null) {
			return false;
		}

        return true;
    }

	/** {@inheritDoc} */
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("name", this.name).append(
            "description", this.description).append("id", this.id).append("version", this.version).append(
            "enabled", this.enabled).append("code", this.code).append("locked", this.locked).append(
            "objectType", this.getEntityType()).toString();
    }
}
