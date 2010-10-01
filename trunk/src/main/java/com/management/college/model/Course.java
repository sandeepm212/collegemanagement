package com.management.college.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;

@Entity
@Table(name = "mgmt_course")
public class Course extends BaseObject {

	/*
	 * Ex: UG & PG / Polytechnic
	 */
	private DecodeValue group;

	/**
	 * ECE
	 */
	private String name;

	private String code;

	/*
	 * No of Students for each year
	 */
	private int intake;

	/*
	 * Total Cource duration.
	 */
	private int duration;

	private String description;

	@TableGenerator(name = "course_id_gen", table = "mgmt_id_table", pkColumnName = "table_name", valueColumnName = "next_id", initialValue = 1, allocationSize = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "course_id_gen")
	public Long getId() {
		return id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "group_id", nullable = false)
	public DecodeValue getGroup() {
		return group;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}

	@Column(name = "code", nullable = false)
	public String getCode() {
		return code;
	}

	@Column(name = "intake")
	public int getIntake() {
		return intake;
	}

	@Column(name = "duration", nullable = false)
	public int getDuration() {
		return duration;
	}

	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	@Override
	@Transient
	public int getEntityType() {
		return 0;
	}

	// ----- Setters

	public void setGroup(DecodeValue group) {
		this.group = group;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setIntake(int intake) {
		this.intake = intake;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return null;
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		int result;
		result = ((name == null) ? 0 : name.hashCode());
		result = 29 * result + ((code == null) ? 0 : code.hashCode());
		result = 29 * result + ((group == null) ? 0 : group.hashCode());
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

}
