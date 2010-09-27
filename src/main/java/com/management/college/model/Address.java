package com.management.college.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.management.college.AppConstants;
/**
 * This class is used to represent an address with address, city, province and
 * postal-code information. This stores the person information in the related
 * PersonName object.
 * 
 * @author <a href="mailto:sandeep.mandrumaka@gmail.com">Sandeep M</a>
 */
@Entity(name = "mgmt_address")
public class Address extends BaseObject implements Serializable {
	private static final long serialVersionUID = 3617859655330969141L;

	/*
	 * The type of the address. This is a decode value selected from an user
	 * defined list.
	 */
	private long addressType;
		
	/*
	 * If this is true, this is the primary address in the set of addresses that
	 * belong to the same owner.
	 */
	private boolean primaryAddress;

	/*
	 * The street component of the address.
	 */
	private String street;

	/*
	 * The city component of the address.
	 */
	private String city;

	/*
	 * The state or province component of the address.
	 */
	private String stateOrProvince;

	/*
	 * The zip or postal code of the address.
	 */
	private String postalCode;

	/*
	 * The country component of the address. This will be a 2-letter code.
	 */
	private String country;

	/*
	 * The position at which this object will be displayed in a list of
	 * siblings.
	 */
	private int displayOrder;

	/*
	 * This is true if the Address is currently enabled and available for use.
	 */
	private boolean enabled;

	/*
	 * The random value of the address.
	 */
	private String uniqueCode;

	/*
	 * The id of the object to which this Address belongs.
	 */
	private long ownerEntityId;

	/*
	 * The objectType of the object to which this Address belongs. This contains
	 * one of the defined ENTITY_TYPE constants and is used in combination with
	 * the entityId to retrieve this address from persistence.
	 */
	private int ownerEntityType;

	/**
	 * Default constructor - creates a new instance with no values set.
	 */
	public Address() {
	}
	
	@TableGenerator(name = "address_id_gen", table = "mgmt_id_table", pkColumnName = "table_name", valueColumnName = "next_id", initialValue = 1, allocationSize = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "address_id_gen")
	public Long getId() {
		return id;
	}

	/**
	 * @return ownerEntityId
	 */
	@Column(name = "owner_entity_id", nullable = false)
	public long getOwnerEntityId() {
		return ownerEntityId;
	}

	/**
	 * @return ownerEntityType
	 */
	@Column(name = "owner_entity_type", nullable = false)
	public int getOwnerEntityTypeId() {
		return ownerEntityType;
	}

	/**
	 * @return addressType
	 */
	@Column(name = "address_type", nullable = false)
	public long getAddressType() {
		return addressType;
	}

	/**
	 * @return primaryAddress
	 */
	@Column(name = "primary_address", nullable = false)
	public boolean isPrimaryAddress() {
		return primaryAddress;
	}

	/**
	 * @return street
	 */
	@Column(name = "street", length = 500)
	public String getStreet() {
		return street;
	}

	/**
	 * @return city
	 */
	@Column(name = "city", length = 100)
	public String getCity() {
		return city;
	}

	/**
	 * @return stateOrProvince
	 */
	@Column(name = "state_province", length = 100)
	public String getStateOrProvince() {
		return stateOrProvince;
	}

	/**
	 * @return postalCode
	 */
	@Column(name = "postal_code", length = 25)
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * @return country
	 */
	@Column(name = "country", length = 2)
	public String getCountry() {
		return country;
	}

	/**
	 * @return displayOrder
	 */
	@Column(name = "display_order", nullable = false)
	public int getDisplayOrder() {
		return displayOrder;
	}

	/**
	 * @return enabled
	 */
	@Column(name = "enabled", nullable = false)
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * Returns the uniqueCode.
	 * 
	 * @return the uniqueCode
	 */
	@Column(name = "unique_code", nullable = false)
	public String getUniqueCode() {
		return this.uniqueCode;
	}

	@Override
	@Transient
	public int getEntityType() {
		return AppConstants.ENTITY_TYPE_CONTACT_ADDRESS;
	}

	// ---------- Setters

	public void setId(final Long id) {
		this.id = id;
	}

	/**
	 * Sets the ownerEntityId.
	 * 
	 * @param ownerEntityId
	 */
	public void setOwnerEntityId(final long entityId) {
		this.ownerEntityId = entityId;
	}

	/**
	 * Sets the ownerEntityType.
	 * 
	 * @param ownerEntityType
	 */
	public void setOwnerEntityTypeId(final int ownerEntityType) {
		this.ownerEntityType = ownerEntityType;
	}

	/**
	 * Sets the addressType.
	 * 
	 * @param addressType
	 *            The addressType to set
	 */
	public void setAddressType(final long addressType) {
		this.addressType = addressType;
	}

	/**
	 * Sets the primaryAddress.
	 * 
	 * @param primaryAddress
	 *            The primaryAddress to set
	 */
	public void setPrimaryAddress(final boolean primaryAddress) {
		this.primaryAddress = primaryAddress;
	}

	/**
	 * Sets the street.
	 * 
	 * @param street
	 *            The street to set
	 */
	public void setStreet(final String street) {
		this.street = street;
	}

	/**
	 * Sets the city.
	 * 
	 * @param city
	 *            The city to set
	 */
	public void setCity(final String city) {
		this.city = city;
	}

	/**
	 * Sets the stateOrProvince.
	 * 
	 * @param stateOrProvince
	 *            The stateOrProvince to set
	 */
	public void setStateOrProvince(final String stateOrProvince) {
		this.stateOrProvince = stateOrProvince;
	}

	/**
	 * Sets the postalCode.
	 * 
	 * @param postalCode
	 *            The postalCode to set
	 */
	public void setPostalCode(final String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * Sets the country.
	 * 
	 * @param country
	 *            The country to set
	 */
	public void setCountry(final String country) {
		this.country = country;
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
	 * Sets the uniqueCode.
	 * 
	 * @param uniqueCode
	 *            The uniqueCode to set
	 */
	public void setUniqueCode(final String uniqueCode) {
		this.uniqueCode = uniqueCode;
	}

	/**
	 * Overridden equals method for object comparison. Compares based on
	 * hashCode.
	 * 
	 * @param o
	 *            Object to compare
	 * @return true/false based on hashCode
	 */
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Address)) {
			return false;
		}

		final Address address1 = (Address) o;

		return this.hashCode() == address1.hashCode();
	}

	/**
	 * Overridden hashCode method - compares on address, city, province, country
	 * and postal code.
	 * 
	 * @return hashCode
	 */
	public int hashCode() {
		int result;
		result = (city != null ? city.hashCode() : 0);
		result = 29 * result
				+ (stateOrProvince != null ? stateOrProvince.hashCode() : 0);
		result = 29 * result + (country != null ? country.hashCode() : 0);
		result = 29 * result + (postalCode != null ? postalCode.hashCode() : 0);
		return result;
	}

	/**
	 * Returns a multi-line String with key=value pairs.
	 * 
	 * @return a String representation of this class.
	 */
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("id", this.id).append("country", this.country)
				.append("stateOrProvince", this.stateOrProvince)
				.append("postalCode", this.postalCode)
				.append("city", this.city).append("enabled", this.enabled)
				.append("displayOrder", this.displayOrder)
				.append("uniqueCode", this.uniqueCode).toString();
	}
}
