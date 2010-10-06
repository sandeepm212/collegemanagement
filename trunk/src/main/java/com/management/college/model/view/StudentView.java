package com.management.college.model.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.FactoryUtils;
import org.apache.commons.collections.ListUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.management.college.model.Address;
import com.management.college.model.PersonName;
import com.management.college.model.Phone;

public class StudentView {

	Long id;

	String studentId;

	PersonName studentName;

	PersonName fatherName;

	PersonName motherName;

	int currentYear;

	Date dateOfBirth;

	String dateOfBirthStr;

	Date joiningDate;

	String joiningDateStr;

	String registrationNumber;

	String admissionNumber;

	Long courseId;

	String courseName;

	String courseCode;

	Long courseGroupId;

	String courseGroupName;

	String courseGroupCode;

	String gender;

	Long nationality;

	Long religion;

	Long bloodGroup;

	String identificationMarks;

	List<Address> addresses;

	List<PersonName> addressNames;

	List<Phone> phones;

	public StudentView() {
		studentName = new PersonName();
		fatherName = new PersonName(PersonName.PN_TYPE_FATHER);
		motherName = new PersonName(PersonName.PN_TYPE_MOTHER);

		addresses = ListUtils.lazyList(new ArrayList<Address>(5),
				FactoryUtils.instantiateFactory(Address.class));
		addressNames = ListUtils.lazyList(new ArrayList<PersonName>(5),
				FactoryUtils.instantiateFactory(PersonName.class));
		phones = ListUtils.lazyList(new ArrayList<Phone>(5),
				FactoryUtils.instantiateFactory(Phone.class));
	}

	public String getStudentId() {
		return studentId;
	}

	public PersonName getStudentName() {
		return studentName;
	}

	public PersonName getFatherName() {
		return fatherName;
	}

	public PersonName getMotherName() {
		return motherName;
	}

	public int getCurrentYear() {
		return currentYear;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public String getAdmissionNumber() {
		return admissionNumber;
	}

	public Long getCourseId() {
		return courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public String getGender() {
		return gender;
	}

	public Long getNationality() {
		return nationality;
	}

	public Long getReligion() {
		return religion;
	}

	public Long getBloodGroup() {
		return bloodGroup;
	}

	public String getIdentificationMarks() {
		return identificationMarks;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public String getDateOfBirthStr() {
		return dateOfBirthStr;
	}

	public List<PersonName> getAddressNames() {
		return addressNames;
	}

	public String getMotherFirstName() {
		if (motherName != null) {
			return motherName.getFirstName();
		}
		return "";
	}

	public String getMotherMiddleName() {
		if (motherName != null) {
			return motherName.getMiddleName();
		}
		return "";
	}

	public String getMotherLastName() {
		if (motherName != null) {
			return motherName.getLastName();
		}
		return "";
	}

	public String getFatherFirstName() {
		if (fatherName != null) {
			return fatherName.getFirstName();
		}
		return "";
	}

	public String getFatherMiddleName() {
		if (fatherName != null) {
			return fatherName.getMiddleName();
		}
		return "";
	}

	public String getFatherLastName() {
		if (fatherName != null) {
			return fatherName.getLastName();
		}
		return "";
	}

	// -----------

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public void setStudentName(PersonName studentName) {
		this.studentName = studentName;
	}

	public void setFatherName(PersonName fatherName) {
		this.fatherName = fatherName;
	}

	public void setMotherName(PersonName motherName) {
		this.motherName = motherName;
	}

	public void setCurrentYear(int currentYear) {
		this.currentYear = currentYear;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public void setAdmissionNumber(String admissionNumber) {
		this.admissionNumber = admissionNumber;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setNationality(Long nationality) {
		this.nationality = nationality;
	}

	public void setReligion(Long religion) {
		this.religion = religion;
	}

	public void setBloodGroup(Long bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public void setIdentificationMarks(String identificationMarks) {
		this.identificationMarks = identificationMarks;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	public String getJoiningDateStr() {
		return joiningDateStr;
	}

	public void setJoiningDateStr(String joiningDateStr) {
		this.joiningDateStr = joiningDateStr;
	}

	public String getCourseCode() {
		return this.courseCode;
	}

	public Long getCourseGroupId() {
		return this.courseGroupId;
	}

	public String getCourseGroupName() {
		return this.courseGroupName;
	}

	public String getCourseGroupCode() {
		return this.courseGroupCode;
	}

	public void setCourseCode(String inputCourseCode) {
		this.courseCode = inputCourseCode;
	}

	public void setCourseGroupId(Long inputCourseGroupId) {
		this.courseGroupId = inputCourseGroupId;
	}

	public void setCourseGroupName(String inputCourseGroupName) {
		this.courseGroupName = inputCourseGroupName;
	}

	public void setCourseGroupCode(String inputCourseGroupCode) {
		this.courseGroupCode = inputCourseGroupCode;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long inputId) {
		this.id = inputId;
	}

	public void setDateOfBirthStr(String dateOfBirthStr) {
		this.dateOfBirthStr = dateOfBirthStr;
	}

	public void setAddressNames(List<PersonName> addressNames) {
		this.addressNames = addressNames;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("addresses", this.addresses)
				.append("gender", this.gender)
				.append("studentId", this.studentId)
				.append("courseGroupName", this.courseGroupName)
				.append("courseName", this.courseName)
				.append("motherName", this.motherName)
				.append("religion", this.religion)
				.append("joiningDateStr", this.joiningDateStr)
				.append("nationality", this.nationality)
				.append("phones", this.phones)
				.append("courseGroupCode", this.courseGroupCode)
				.append("dateOfBirth", this.dateOfBirth)
				.append("courseCode", this.courseCode)
				.append("registrationNumber", this.registrationNumber)
				.append("studentName", this.studentName)
				.append("fatherName", this.fatherName)
				.append("courseId", this.courseId)
				.append("admissionNumber", this.admissionNumber)
				.append("bloodGroup", this.bloodGroup)
				.append("currentYear", this.currentYear)
				.append("joiningDate", this.joiningDate)
				.append("identificationMarks", this.identificationMarks)
				.append("courseGroupId", this.courseGroupId).toString();
	}
}
