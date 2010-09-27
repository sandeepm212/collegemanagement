package com.management.college.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;

/**
 * In this module all the fee details(Installment, Monthly, Amount Paid, Balance
 * details etc) will be maintained
 * 
 * @author <a href="mailto:smandrumaka@fuelquest.com">Sandeep Mandrumaka</a>
 * 
 */
@Entity
@Table(name = "mgmt_billing")
public class Billing extends BaseObject {

	String admissionNumber;

	long bankId;

	String accountNumber;

	String ddChallanNumber;

	String ddDate;



	@TableGenerator(name = "billing_id_gen", table = "mgmt_id_table", pkColumnName = "table_name", valueColumnName = "next_id", initialValue = 1, allocationSize = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "billing_id_gen")
	public Long getId() {
		return id;
	}

	@Column(name = "admission_number", nullable = false)
	public String getAdmissionNumber() {
		return admissionNumber;
	}

	@Column(name = "bank_id", nullable = false)
	public long getBankId() {
		return bankId;
	}

	@Column(name = "account_number", nullable = false)
	public String getAccountNumber() {
		return accountNumber;
	}

	@Column(name = "dd_challan_number")
	public String getDdChallanNumber() {
		return ddChallanNumber;
	}

	@Column(name = "dd_date", nullable = false)
	public String getDdDate() {
		return ddDate;
	}
	
	@Transient
	public int getEntityType() {
		return 0;
	}
	
	// -----------

	public void setAdmissionNumber(String admissionNumber) {
		this.admissionNumber = admissionNumber;
	}

	public void setBankId(long bankId) {
		this.bankId = bankId;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setDdChallanNumber(String ddChallanNumber) {
		this.ddChallanNumber = ddChallanNumber;
	}

	public void setDdDate(String ddDate) {
		this.ddDate = ddDate;
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
