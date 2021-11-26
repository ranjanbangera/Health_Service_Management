package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.IntPredicate;
import java.util.function.Supplier;

import com.advices.PatientNotFoundException;
import com.advices.ResourceNotFoundException;
import com.model.HealthInsurancePolicy;
import com.model.PatientPersonalDetails;
import com.repository.PatientPersonalDetailsRepository;

@Service
public class PatientPersonalDetailsService {

	@Autowired
	PatientPersonalDetailsRepository patientDao;

	public PatientPersonalDetails addPatientPersonalDetails(PatientPersonalDetails patient) {
		PatientPersonalDetails patient1 = patientDao.save(patient);
		return patient1;
	}

	public PatientPersonalDetails deletePatientPersonalDetailsById(int pId) {
		Optional<PatientPersonalDetails> optional = patientDao.findById(pId);
		PatientPersonalDetails patient = optional.get();
		if (optional.isPresent()) {
			patientDao.delete(patient);
		}

		return null;
	}

	public PatientPersonalDetails getPatientPersonalDetailsById(int pId) {
		PatientPersonalDetails patient = patientDao.findById(pId).get();

		return patient;
	}

	/*public PatientPersonalDetails updatePatientPersonalDetails(int pId, PatientPersonalDetails patient) {
		Optional<PatientPersonalDetails> optional = patientDao.findById(pId);
		if (optional.isPresent()) {
			PatientPersonalDetails dbPatient = optional.get();
			dbPatient.setpName(patient.getpName());
			dbPatient.setpAge(patient.getpAge());
			dbPatient.setSymptoms(patient.getSymptoms());
			patientDao.save(dbPatient);
		}
		return null;
	}*/
	
	public PatientPersonalDetails updatePatientPersonalDetails(PatientPersonalDetails c) throws Throwable {
		int id = c.getId();

		Supplier s1 = () -> new PatientNotFoundException("PatientPersonalDetails Does not exist in the database");
		PatientPersonalDetails c1 = patientDao.findById(id).orElseThrow(s1);

		c1.setId(c.getId());
		c1.setpName(c.getpName());
		c1.setpAge(c.getpAge());
		c1.setPhoneNo(c.getPhoneNo());
		c1.setGender(c.getGender());
		c1.setAddress(c.getAddress());
		c1.setSymptoms(c.getSymptoms());
		

		patientDao.save(c1);
		return c1;
	}

	public List<PatientPersonalDetails> getAllPatientPersonalDetails() {

		return patientDao.findAll();
	}

	
}
