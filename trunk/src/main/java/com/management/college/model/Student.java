package com.management.college.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;

import com.management.college.AppConstants;

@Entity(name = "mgmt_student")
public class Student extends BaseObject {

	int currentYear;

	Date joiningDate;
	
	Date dateOfBirth;

	String studentId;

	String registrationNumber;

	String admissionNumber;

	Course course;

	String gender;

	Long nationality;

	Long religion;

	Long bloodGroup;

	String identificationMarks;

	@TableGenerator(name = "address_id_gen", table = "mgmt_id_table", pkColumnName = "table_name", valueColumnName = "next_id", initialValue = 1, allocationSize = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "address_id_gen")
	public Long getId() {
		return id;
	}

	@Column(name = "current_year")
	public int getCurrentYear() {
		return this.currentYear;
	}

	@Column(name = "joining_date", nullable = false)
	public Date getJoiningDate() {
		return this.joiningDate;
	}

	@Column(name = "student_id", nullable = false)
	public String getStudentId() {
		return this.studentId;
	}

	@Column(name = "registration_number")
	public String getRegistrationNumber() {
		return this.registrationNumber;
	}

	@Column(name = "admission_number")
	public String getAdmissionNumber() {
		return this.admissionNumber;
	}

	@ManyToOne
	@JoinColumn(name = "course_id")
	public Course getCourse() {
		return this.course;
	}

	@Column(name = "gender", nullable = false)
	public String getGender() {
		return this.gender;
	}

	@Column(name = "nationality", nullable = false)
	public Long getNationality() {
		return this.nationality;
	}

	@Column(name = "religion")
	public Long getReligion() {
		return this.religion;
	}

	@Column(name = "blood_group")
	public Long getBloodGroup() {
		return this.bloodGroup;
	}

	@Column(name = "identification_marks")
	public String getIdentificationMarks() {
		return this.identificationMarks;
	}
	
	@Column(name = "date_of_birth")
	public Date getDateOfBirth() {
		return dateOfBirth;
	}


	@Transient
	public int getEntityType() {
		return AppConstants.ENTITY_TYPE_CORE_STUDENT;
	}

	// ---- Setters

	public void setCurrentYear(int inputCurrentYear) {
		this.currentYear = inputCurrentYear;
	}

	public void setJoiningDate(Date inputJoiningDate) {
		this.joiningDate = inputJoiningDate;
	}

	public void setStudentId(String inputStudentId) {
		this.studentId = inputStudentId;
	}

	public void setRegistrationNumber(String inputRegistrationNumber) {
		this.registrationNumber = inputRegistrationNumber;
	}

	public void setAdmissionNumber(String inputAdmissionNumber) {
		this.admissionNumber = inputAdmissionNumber;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public void setGender(String inputGender) {
		this.gender = inputGender;
	}

	public void setNationality(Long inputNationality) {
		this.nationality = inputNationality;
	}

	public void setReligion(Long inputReligion) {
		this.religion = inputReligion;
	}

	public void setBloodGroup(Long inputBloodGroup) {
		this.bloodGroup = inputBloodGroup;
	}

	public void setIdentificationMarks(String inputIdentificationMarks) {
		this.identificationMarks = inputIdentificationMarks;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return null;
	}

	@Override
	public boolean equals(Object inputO) {
		return false;
	}

	@Override
	public int hashCode() {
		return 0;
	}



}
