package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.springframework.http.ResponseEntity;

@Entity
public class HealthInsurancePolicy {
	@Id
	@GeneratedValue
	private int pNum;
	@NotBlank(message="Policy Name is required.")
	private String pName;
	//@NotBlank(message="Policy Term is required.")
	private double pTerm;

	// getters&Setters
	public int getpNum() {
		return pNum;
	}

	public void setpNum(int pNum) {
		this.pNum = pNum;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public double getpTerm() {
		return pTerm;
	}

	public void setpTerm(double pTerm) {
		this.pTerm = pTerm;
	}

	@Override
	public String toString() {
		return "HospitalInsurancePolicy [pNum=" + pNum + ", pName=" + pName + ", pTerm=" + pTerm + "]";
	}

}
