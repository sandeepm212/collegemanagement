package com.management.college.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author <a href="mailto:ravi@endofthenight.com">ravi@endofthenight.com</a>
 *         A generic object to allow other objects to have an extensible set of
 *         properties. Various data types are stored in the same column and are cast based
 *         on the type of the property.
 */
@Entity(name = "mgmt_property")
public class Property extends BaseObject {

    /*
     * The serial version UID.
     */
    private static final long                  serialVersionUID = -6752775407793578111L;

    /**
     * The value stored in this Property is a String.
     */
    public static final char                   TYPE_STRING      = 's';

    /**
     * The value stored in this Property is a boolean.
     */
    public static final char                   TYPE_BOOLEAN     = 'b';

    /**
     * The value stored in this Property is an integer.
     */
    public static final char                   TYPE_INTEGER     = 'i';

    /**
     * The value stored in this Property is a decimal.
     */
    public static final char                   TYPE_DECIMAL     = 'f';

    /**
     * The value stored in this Property is a date.
     */
    public static final char                   TYPE_DATE        = 'd';

    /**
     * Descriptive labels for the various property types.
     */
    public static final Map<Character, String> TYPE_LABELS;
    static {
        TYPE_LABELS = new HashMap<Character, String>(5);
        TYPE_LABELS.put(TYPE_STRING, "String");
        TYPE_LABELS.put(TYPE_BOOLEAN, "True/False");
        TYPE_LABELS.put(TYPE_INTEGER, "Integer");
        TYPE_LABELS.put(TYPE_DECIMAL, "Decimal");
        TYPE_LABELS.put(TYPE_DATE, "Date");
    }

    /*
     * The name of the property.
     */
    private String                             name;

    /*
     * The type of the data stored in this property.
     */
    private char                               type;

    /*
     * The value of the property.
     */
    private String                             value;

    /*
     * The id of the object to which this Property belongs.
     */
    private long                               ownerEntityId;

    /*
     * The objectType of the object to which this Property belongs. This contains one of
     * the defined ENTITY_TYPE constants and is used in combination with the ownerId to
     * retrieve this property from persistence.
     */
    private int                                ownerEntityTypeId;

    /*
     * The position of this object in a list of its siblings.
     */
    private int                                displayOrder;

    /*
     * This is true if the Property is currently enabled and available for use.
     */
    private boolean                            enabled;

    /*
     * The description of the property.
     */
    private String                             description;

    /*
     * If true, the property cannot be modified.
     */
    private boolean                            locked;

    /*
     * The id of the user that locked this property. Only this User can unlock it.
     */
    private long                               lockedBy;

    /**
     * Returns the id of this object.
     * 
     * @return the id
     */
    @TableGenerator(name = "property_id_gen", table = "mgmt_id_table", pkColumnName = "table_name", valueColumnName = "next_id", initialValue = 1, allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "property_id_gen")
	public Long getId() {
        return id;
    }

    /**
     * Returns the name of the property.
     * 
     * @return the name
     */
    @Column(name = "name", length = 100, nullable = false)
	public String getName() {
        return name;
    }

    /**
     * Returns the type of the property.
     * 
     * @return the type
     */
    @Column(name = "prop_type", nullable = false, length = 1)
	public char getType() {
        return type;
    }

    /**
     * Returns the display label for the property type.
     * 
     * @return the label for the type
     */
    @Transient
	public String getTypeLabel() {
        return TYPE_LABELS.get(this.type);
    }

    /**
     * Returns the value of this property.
     * 
     * @return the value
     */
    @Column(name = "value", length = 255)
	public String getValue() {
        return value;
    }

    /**
     * Returns the value of this property in boolean format.
     * 
     * @return the value as a boolean
     */
    @Transient
	public Boolean getBooleanValue() {
        if (this.value != null) {
            if ("true".equals(this.value)) {
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        }
        return null;
    }

    /**
     * Returns the value of this property in integer format.
     * 
     * @return the property value as an Integer
     */
    @Transient
	public Integer getIntegerValue() {
        if (this.value != null) {
            return Integer.valueOf(this.value);
        }
        return null;
    }

    /**
     * Returns the value of this property in double format.
     * 
     * @return the property value as a Double
     */
    @Transient
	public Double getDoubleValue() {
        if (this.value != null) {
            return Double.valueOf(this.value);
        }
        return null;
    }

    /**
     * Returns the value of this property as a date.
     * 
     * @return the property value as a Date
     */
    @Transient
	public java.util.Date getDateValue() {
        if (this.value != null) {
            try {
                return DATE_FORMAT.parse(this.value);
            } catch (ParseException ignored) {
                // do nothing
            }
        }
        return null;
    }

    /**
     * Returns the id of the object to which this property belongs.
     * 
     * @return the ownerId
     */
    @Column(name = "owner_entity_id", nullable = false)
	public long getOwnerEntityId() {
        return ownerEntityId;
    }

    /**
     * Returns the type of the object to which this property belongs.
     * 
     * @return the entityTypeId
     */
    @Column(name = "owner_entity_type_id", nullable = false)
	public int getOwnerEntityTypeId() {
        return ownerEntityTypeId;
    }

    /**
     * Returns the position of this property in a list of its siblings.
     * 
     * @return the displayOrder
     */
    @Column(name = "display_order", nullable = false)
	public int getDisplayOrder() {
        return displayOrder;
    }

    /**
     * Returns the type of this object.
     * 
     * @return the entity type
     */
    @Transient
	public int getEntityType() {
        return 0;//AppConstants.ENTITY_TYPE_MISC_PROPERTY;
    }

    /**
     * Returns true if this instance is currently active.
     * 
     * @return the enabled value
     */
    @Column(name = "prop_enabled")
	public boolean isEnabled() {
        return enabled;
    }

    /**
     * Returns the description of this property.
     * 
     * @return the description
     */
    @Column(name = "description")
	public String getDescription() {
        return description;
    }

    /**
     * Returns true if the property is locked.
     * 
     * @return the locked value
     */
    @Column(name = "locked")
	public boolean isLocked() {
        return this.locked;
    }

    /**
     * Returns the id of the user that locked this property.
     * 
     * @return the user id
     */
    @Column(name = "locked_by")
	public long getLockedBy() {
        return this.lockedBy;
    }

    // --------- setters

    /**
     * Sets the name.
     * 
     * @param inputName
     *            The name to set
     */
	public void setName(final String inputName) {
        this.name = inputName;
    }

    /**
     * Sets the property type.
     * 
     * @param inputType
     *            The type to set
     */
	public void setType(final char inputType) {
        this.type = inputType;
    }

    /**
     * Sets the value.
     * 
     * @param inputValue
     *            The value to set
     */
	public void setValue(final String inputValue) {
        this.value = inputValue;
    }

    /**
     * Sets an integer value.
     * 
     * @param intValue
     *            the input as an Integer
     */
	public void setIntegerValue(final Integer intValue) {
        if (intValue != null) {
            this.value = intValue.toString();
        }
    }

    /**
     * Sets a double value.
     * 
     * @param doubleValue
     *            the input as a Double
     */
	public void setDecimalValue(final Double doubleValue) {
        if (doubleValue != null) {
            this.value = doubleValue.toString();
        }
    }

    /**
     * Sets a boolean value.
     * 
     * @param bValue
     *            the input as a boolean
     */
	public void setBooleanValue(final boolean bValue) {
        if (bValue) {
            this.value = "true";
        } else {
            this.value = "false";
        }
    }

    /*
     * A default date format for a property that contains a date value.
     */
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MM/dd/yyyy");

    /**
     * Sets a date value.
     * 
     * @param dateValue
     *            the input as a date
     */
	public void setDateValue(final java.util.Date dateValue) {
        if (dateValue != null) {
            this.value = DATE_FORMAT.format(dateValue);
        }
    }

    /**
     * Sets the id of the object to which this property belongs.
     * 
     * @param inputOwnerEntityId
     *            The ownerEntityId to set
     */
	public void setOwnerEntityId(final long inputOwnerEntityId) {
        this.ownerEntityId = inputOwnerEntityId;
    }

    /**
     * Sets the type of the object to which this property belongs.
     * 
     * @param inputOwnerEntityTypeId
     *            the ownerEntityTypeId to set
     */
	public void setOwnerEntityTypeId(final int inputOwnerEntityTypeId) {
        this.ownerEntityTypeId = inputOwnerEntityTypeId;
    }

    /**
     * Sets the position of this property in a list of its siblings.
     * 
     * @param inputDisplayOrder
     *            The displayOrder to set
     */
	public void setDisplayOrder(final int inputDisplayOrder) {
        this.displayOrder = inputDisplayOrder;
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
     * Sets the description.
     * 
     * @param inputDescription
     *            the description to set
     */
	public void setDescription(final String inputDescription) {
        this.description = inputDescription;
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
     * Sets the lockedBy.
     * 
     * @param inputLockedBy
     *            The lockedBy to set
     */
	public void setLockedBy(final long inputLockedBy) {
        this.lockedBy = inputLockedBy;
    }

    @Override
    public final boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Property)) {
            return false;
        }
        final Property property = (Property) o;
        if (this.id != null ? !(this.id == property.id) : property.id != null) {
            return false;
        }

        return true;
    }

    @Override
    public final int hashCode() {
		int result = ((id == null) ? 0 : id.hashCode());
        result = 29 * result + ((name == null) ? 0 : name.hashCode());
        result = 29 * result + ((value == null) ? 0 : value.hashCode());
        return result;
    }

    @Override
    public final String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("id", this.id).append("version",
            this.version).append("name", this.name).append("type", this.type).append("value", this.value).append(
            "ownerEntityId", this.ownerEntityId).append("ownerEntityTypeId", this.ownerEntityTypeId).append(
            "displayOrder", this.displayOrder).append("enabled", this.enabled).append("description", this.description)
                .toString();
    }

    /**
     * Contains the Properties data types.
     */
    private static final List<LabelValue> PROPERTY_TYPES;
    static {
        PROPERTY_TYPES = loadPropertyTypesList();
    }

    /**
     * Loads the property types data into a List.
     * 
     * @return the Property types data list
     */
    private static List<LabelValue> loadPropertyTypesList() {

		final List<LabelValue> userFilterList = new ArrayList<LabelValue>(5);
        userFilterList.add(new LabelValue("Boolean", String.valueOf(TYPE_BOOLEAN)));
        userFilterList.add(new LabelValue("Date", String.valueOf(TYPE_DATE)));
        userFilterList.add(new LabelValue("Decimal", String.valueOf(TYPE_DECIMAL)));
        userFilterList.add(new LabelValue("Integer", String.valueOf(TYPE_INTEGER)));
        userFilterList.add(new LabelValue("String", String.valueOf(TYPE_STRING)));

        return userFilterList;
    }

    /**
     * Returns the list of display labels of the various types of properties.
     * 
     * @return the list of type labels
     */
    @Transient
    public final List<LabelValue> getPropertyTypes() {
        return PROPERTY_TYPES;
    }


}
