package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;


@Entity
public class Treatment {
	
	@Id
	@GeneratedValue
	private int tid;
	@NotBlank(message="This is a required field.")
	private String reports;
	@NotBlank(message="This is a required field.")
	private String medicines;
	@NotBlank(message="This is a required field.")
	private String description;
	
/*	@OneToOne(targetEntity = PatientHistory.class, mappedBy = "treatment")
	private PatientHistory patienthistory;
*/	
	
/*	
	@JsonManagedReference(value = "2")
	@OneToOne(targetEntity = Doctor.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "doctor_id")
	private Doctor doctor1;
*/	
	
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	
	public String getReports() {
		return reports;
	}
	public void setReports(String reports) {
		this.reports = reports;
	}
	public String getMedicines() {
		return medicines;
	}
	public void setMedicines(String medicines) {
		this.medicines = medicines;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
/*	
	public List<Doctor> getDoctors() {
		return doctors;
	}
	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}
	*/
	@Override
	public String toString() {
		return "Treatment [tid=" + tid +  ", reports=" + reports
				+ ", medicines=" + medicines + ", description=" + description + "]";
	}
	
	
	
}