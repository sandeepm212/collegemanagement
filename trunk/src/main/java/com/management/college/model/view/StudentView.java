package com.management.college.model.view;

import java.util.Date;
import java.util.List;

import com.management.college.model.Address;
import com.management.college.model.PersonName;
import com.management.college.model.Phone;

public class StudentView {

	Long studentId;

	PersonName studentName;

	PersonName fatherName;

	PersonName motherName;

	int currentYear;

	Date dateOfBirth;

	Date joiningDate;

	String joiningDateStr;

	String registrationNumber;

	String admissionNumber;

	Long courseId;

	String courseName;

	String gender;

	Long nationality;

	Long religion;

	Long bloodGroup;

	String identificationMarks;

	List<Address> addresses;

	List<Phone> phones;

	public Long getStudentId() {
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

	public void setStudentId(Long studentId) {
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
}
