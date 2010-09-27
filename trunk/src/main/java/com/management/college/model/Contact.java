package com.management.college.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.management.college.AppConstants;

/**
 * The Contacts will be used to keep track of contact information.
 * 
 * @author <a
 *         href="mailto:sandeep@endofthenight.com">sandeep@endofthenight.com</a>
 */
@Entity
@Table(name = "mgmt_contact")
public class Contact extends BaseObject {

    public static final int MAX_PRIORITY = 9999;

    /*
     * The nickname the user gives for the contact
     */
    private String          nickName;

    /*
     * The id of the category that this entity come under.
     */
    private long            categoryId;

    /*
     * The collection of phones that this entity has.
     */
    private Set<Phone>      phones;

    /*
     * The collection of address that this entity has.
     */
    private Set<Address>    addresses;

    /*
     * The additional notes or comments
     */
    private String          notes;

    /*
     * The date of birth of this contact person
     */
    private java.util.Date  birthday;

    /*
     * The objectType of the object to which this contact belongs. This contains
     * one of the defined ENTITY_TYPE constants and is used in combination with
     * the entityId to retrieve this contact from persistence.
     */
    private int             ownerEntityType;

    /*
     * The id of the object to which this Contact belongs.
     */
    private long            ownerEntityId;

    /**
     * Default Constructor.
     */
    public Contact() {
    }

    @TableGenerator(name = "contact_id_gen", table = "mgmt_id_table", pkColumnName = "table_name", valueColumnName = "next_id", initialValue = 1, allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "contact_id_gen")
    public Long getId() {
        return id;
    }

    /**
     * Returns the nickname given for the current entity.
     * 
     * @return the nickname
     */
    @Column(name = "nickname", length = 128)
    public String getNickName() {
        return nickName;
    }

    /**
     * Returns the id of the category this contact belongs to.
     * 
     * @return categoryId
     */
    @Column(name = "category_id")
    public long getCategoryId() {
        return categoryId;
    }

    /**
     * Returns the additional notes given for the current entity
     * 
     * @return the notes
     */
    @Column(name = "notes")
    public String getNotes() {
        return notes;
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

    /**
     * Returns the date of birth of the contact person.
     * 
     * @return the birthday
     */
    @Column(name = "birth_day")
    public java.util.Date getBirthday() {
        return this.birthday;
    }

    /**
     * Returns the set of phones that the contact person is having.
     * 
     * @return the phones
     */
    @OneToMany(mappedBy = "contact", fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
    public Set<Phone> getPhones() {
        return phones;
    }

    /**
     * Returns the set of addresses that the contact person is having.
     * 
     * @return the addresses
     */
    @OneToMany(mappedBy = "contact", fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
    public Set<Address> getAddresses() {
        return addresses;
    }

    /**
     * Returns the application level constant for the contact model
     */
    @Transient
    public int getEntityType() {
        return AppConstants.ENTITY_TYPE_CONTACT;
    }

    /**
     * @param nickname
     *            The nickname to set
     */
    public void setNickName(final String nickname) {
        this.nickName = nickname;
    }

    /**
     * @param categoryId
     */
    public void setCategoryId(final long categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * @param notes
     *            The notes to set
     */
    public void setNotes(final String notes) {
        this.notes = notes;
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

    /**
     * Sets the birthday.
     * 
     * @param birthday
     *            The birthday to set
     */
    public void setBirthday(final java.util.Date birthday) {
        this.birthday = birthday;
    }

    /**
     * Sets the phones.
     * 
     * @param phones
     *            The phones to set
     */
    public void setPhones(final Set<Phone> phones) {
        this.phones = phones;
    }

    /**
     * @param phone
     */
    public void addPhone(final Phone phone) {
        if (phones == null) {
            phones = new HashSet<Phone>(5);
        }
        if (!this.phones.contains(phone)) {
            this.phones.add(phone);
        }
    }

    /**
     * Sets the addresses.
     * 
     * @param addresses
     *            The addresses to set
     */
    public void setAddresses(final Set<Address> addresses) {
        this.addresses = addresses;
    }

    /**
     * @param address
     */
    public void addAddress(final Address address) {
        if (addresses == null) {
            addresses = new HashSet<Address>(5);
        }
        if (!this.addresses.contains(address)) {
            this.addresses.add(address);
        }
    }

    @Override
    public int hashCode() {
        return ((id == null) ? 0 : id.hashCode());
    }

    /**
     * @see java.lang.Object#equals(Object)
     */
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Contact)) {
            return false;
        }

        final Contact contact = (Contact) o;
        if (this.id != null ? !(this.id == contact.getId()) : contact.getId() != null) {
            return false;
        }

        return true;
    }

    /**
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("nickName", this.nickName)
                .append("notes", this.notes).append("updatedOn", this.updatedOn).append("categoryId", this.categoryId)
                .append("createdOn", this.createdOn).append("id", this.id).append("version", this.version)
                .append("ownerEntityId", this.ownerEntityId).append("ownerEntityType", this.ownerEntityType)
                .append("birthday", this.birthday).toString();
    }

}
