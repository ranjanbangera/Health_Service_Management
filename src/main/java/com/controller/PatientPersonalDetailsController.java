package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.model.HealthInsurancePolicy;
import com.model.PatientPersonalDetails;
import com.service.PatientPersonalDetailsService;

@RestController
public class PatientPersonalDetailsController {
	@Autowired
	PatientPersonalDetailsService patientService;
	
	//add patient
	@PostMapping("/PatientPersonalDetails/add")
	ResponseEntity<PatientPersonalDetails> addPatientPersonalDetails(@RequestBody PatientPersonalDetails patient) {
		PatientPersonalDetails patient2=patientService.addPatientPersonalDetails(patient);
		return new ResponseEntity<>(patient2, HttpStatus.CREATED);//201 created
	}
	    // get patient by id
		@GetMapping("/PatientPersonalDetails/{pId}")
		ResponseEntity<PatientPersonalDetails> getPatientPersonalDetailsById(@PathVariable("pId") int pId) {
			PatientPersonalDetails  patient3 = patientService.getPatientPersonalDetailsById(pId);
			return new ResponseEntity<>(patient3, HttpStatus.OK); // 200 ok
			
			
		}
		
		
		
		@PutMapping(path="/updatePatientPersonalDetails")
		 ResponseEntity<PatientPersonalDetails> updatePatientPersonalDetails(@RequestBody PatientPersonalDetails e) throws Throwable
		{
			PatientPersonalDetails e1=patientService.updatePatientPersonalDetails(e);
			
			ResponseEntity re=new ResponseEntity<PatientPersonalDetails>(e1,HttpStatus.OK);
			return re;
		}
		//get all patients
		@GetMapping("/PatientPersonalDetails")
		ResponseEntity<List<PatientPersonalDetails>> getAllPatientPersonalDetails() {
			List<PatientPersonalDetails>  patient3 = patientService.getAllPatientPersonalDetails();
			return new ResponseEntity<>(patient3, HttpStatus.OK); // 200 ok
			
			
		}
		//delete patient by id
		@DeleteMapping("/PatientPersonalDetails/{pId}")
		ResponseEntity<PatientPersonalDetails> deleteEmployeeById(@PathVariable("pId")int pId){
			PatientPersonalDetails patient= patientService.deletePatientPersonalDetailsById(pId);
			return new ResponseEntity<>(patient,HttpStatus.OK);
			
		}
	}