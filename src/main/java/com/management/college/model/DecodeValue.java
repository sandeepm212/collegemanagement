package com.management.college.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.management.college.AppConstants;

/**
 * <p>
 * A object that holds the data in the decode values database table.
 * </p>
 * 
 * @author <a href="mailto:sandeep@endofthenight.com">sandeep@endofthenight.com</a>.
 * 
 */
@Entity
@Table(name = "mgmt_decode_value")
public class DecodeValue extends BaseObject implements Serializable {
    private static final long serialVersionUID = 6258484315662145785L;

    /*
     * A unique identified for the DecodeValue.
     */
    private String            shortCode;

    /*
     * The value of the decode value.
     */
    private String            value;

    /*
     * The description of the decode value.
     */
    private String            description;

    /*
     * This is true if the DecodeValue is enabled.
     */
    private boolean           enabled;

    /*
     * The DecodeGroup to which this DecodeValue belongs.
     */
    private DecodeGroup       decodeGroup;

    /*
     * The position at which this object will be displayed in a list of siblings.
     */
    private short             displayOrder;

    @TableGenerator(name = "decode_value_id_gen", table = "mgmt_id_table", pkColumnName = "table_name", valueColumnName = "next_id", initialValue = 1, allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "decode_value_id_gen")
    public Long getId() {
        return id;
    }

    @Column(name = "short_code", length = 255, nullable = false)
    public String getShortCode() {
        return shortCode;
    }

    @Column(name = "value", length = 255, nullable = false)
    public String getValue() {
        return value;
    }

    @Column(name = "description", length = 512)
    public String getDescription() {
        return description;
    }

    @Column(name = "enabled", nullable = false)
    public boolean isEnabled() {
        return enabled;
    }

    @ManyToOne
    @JoinColumn(name = "decode_group_id", nullable = false)
    public DecodeGroup getDecodeGroup() {
        return decodeGroup;
    }

    @Column(name = "display_order", nullable = false)
    public short getDisplayOrder() {
        return displayOrder;
    }

    @Transient
    public int getEntityType() {
        return AppConstants.ENTITY_TYPE_UTIL_DECODE_VALUE;
    }

    // -- setters

    /**
     * @param decodeGroup
     *            the decodeGroup to set
     */
    public void setDecodeGroup(DecodeGroup decodeGroup) {
        this.decodeGroup = decodeGroup;
    }

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @param shortCode
     *            the shortCode to set
     */
    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    /**
     * @param value
     *            the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * @param enabled
     *            the enabled to set
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * Sets the displayOrder.
     * 
     * @param displayOrder
     *            The displayOrder to set
     */
    public void setDisplayOrder(short displayOrder) {
        this.displayOrder = displayOrder;
    }

    /**
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        int result;
        result = ((decodeGroup == null) ? 0 : decodeGroup.hashCode());
        result = 29 * result + ((description == null) ? 0 : description.hashCode());
        result = 29 * result + ((shortCode == null) ? 0 : shortCode.hashCode());
        result = 29 * result + ((value == null) ? 0 : value.hashCode());
        return result;
    }

    /**
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }

        if (!(object instanceof DecodeValue)) {
            return false;
        }

        final DecodeValue decodeValue = (DecodeValue) object;
        if (this.getId() != null ? (!this.getId().equals(decodeValue.getId()))
            : (decodeValue.getId() != null)) {
            return false;
        }
        return true;
    }

    /**
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("shortCode", this.shortCode)
                .append("description", this.description).append("id", this.id).append("value", this.value)
                .append("enabled", this.enabled).append("objectType", this.getEntityType()).toString();
    }
}
