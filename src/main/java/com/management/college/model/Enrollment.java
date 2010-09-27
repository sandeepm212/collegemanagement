package com.management.college.model;

import javax.persistence.Transient;

/**
 * In this module we can manage all the student details like name, address,
 * phone number, contact details, communication details, previous academic
 * history etc.
 * 
 * Reports like Student wise, Course Wise, and Semester Wise will be provided.
 * Note: please provide sample course wise registration numbers to generate
 * automatically.
 * 
 * @author <a href="mailto:smandrumaka@fuelquest.com">Sandeep Mandrumaka</a>
 * 
 */
public class Enrollment extends BaseObject {

	@Override
	public Long getId() {
		return null;
	}

	@Override
	@Transient
	public int getEntityType() {
		return 0;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean equals(Object inputO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 0;
	}

}
