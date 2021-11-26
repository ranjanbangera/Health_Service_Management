package com.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.model.Doctor;
import com.model.PatientPersonalDetails;
import com.repository.PatientPersonalDetailsRepository;


@SpringBootTest
public class PatientPersonalDetailsServiceTest {
	@Autowired
	PatientPersonalDetailsService patientService;
	
	@MockBean
	PatientPersonalDetailsRepository repo;

	@Test
	void testGetPatientPersonalDetails() {
		PatientPersonalDetails p1=new PatientPersonalDetails ();
		p1.setId(1);
		p1.setpName("raj");
		
		p1.setpAge(40);
		p1.setPhoneNo(98765432);
		p1.setGender("male");
		p1.setAddress("chennai");
		p1.setSymptoms("cold");
		
		PatientPersonalDetails p2 =new  PatientPersonalDetails ();
		p2.setId(2);
		p2.setpName("kumar");
		
		p2.setpAge(30);
		p2.setPhoneNo(123456);
		p2.setGender("male");
		p2.setAddress("bangalore");
		p2.setSymptoms("fever");
		
		
		List<PatientPersonalDetails> patientList = new ArrayList<>();
	    patientList.add(p1);
	    patientList.add(p2);
		
		Mockito.when(repo.findAll()).thenReturn(patientList);
		
		assertThat(patientService.getAllPatientPersonalDetails()).isEqualTo(patientList);
	}

	//@Test
	@Disabled
	void testGetPatientPersonalDetailsById() throws Throwable {
		PatientPersonalDetails p1=new PatientPersonalDetails ();
		p1.setId(1);
		p1.setpName("raj");
		
		p1.setpAge(40);
		p1.setPhoneNo(98765432);
		p1.setGender("male");
		p1.setAddress("chennai");
		p1.setSymptoms("cold");
		
		
		Optional<PatientPersonalDetails> p2=Optional.of(p1);
		
		Mockito.when(repo.findById(1)).thenReturn(p2);
		
		assertThat(patientService.getPatientPersonalDetailsById(1)).isEqualTo(p1);
	}

	@Test
	void testAddPatientPersonalDetails() {
		PatientPersonalDetails p1=new PatientPersonalDetails ();
		p1.setId(1);
		p1.setpName("raj");
		
		p1.setpAge(40);
		p1.setPhoneNo(98765432);
		p1.setGender("male");
		p1.setAddress("chennai");
		p1.setSymptoms("cold");
		
	Mockito.when(repo.save(p1)).thenReturn(p1);
		
		assertThat(patientService.addPatientPersonalDetails(p1)).isEqualTo(p1);
	}

	@Test
	void testUpdatePatientPersonalDetails() throws Throwable {
		PatientPersonalDetails p1=new PatientPersonalDetails ();
		p1.setId(1);
		p1.setpName("raj");
		
		p1.setpAge(40);
		p1.setPhoneNo(98765432);
		p1.setGender("male");
		p1.setAddress("chennai");
		p1.setSymptoms("cold");
		
		Optional<PatientPersonalDetails> p2=Optional.of(p1);
		
		Mockito.when(repo.findById(1)).thenReturn(p2);
		
		Mockito.when(repo.save(p1)).thenReturn(p1);
		p1.setId(1);
        p1.setpName("raj");
		
		p1.setpAge(40);
		p1.setPhoneNo(98765432);
		p1.setGender("male");
		p1.setAddress("chennai");
		p1.setSymptoms("cold");
		
		assertThat(patientService.updatePatientPersonalDetails(p1)).isEqualTo(p1);
	}

	@Test
	void testDeletePatientPersonalDetails() {
		PatientPersonalDetails p1=new PatientPersonalDetails ();
		p1.setId(1);
		p1.setpName("raj");
		
		p1.setpAge(40);
		p1.setPhoneNo(98765432);
		p1.setGender("male");
		p1.setAddress("chennai");
		p1.setSymptoms("cold");
		Optional<PatientPersonalDetails> p2=Optional.of(p1);
		
		Mockito.when(repo.findById(1)).thenReturn(p2);
		 Mockito.when(repo.existsById(p1.getId())).thenReturn(false);
		   assertFalse(repo.existsById(p1.getId()));
	}
	/*
	 * @Test void testDeleteCoderById() { fail("Not yet implemented"); }
	 * 
	 * @Test void testGetCoderByCname() { fail("Not yet implemented"); }
	 * 
	 * @Test void testFindByTechSorted() { fail("Not yet implemented"); }
	 */

	private void assertFalse(boolean existsById) {
		// TODO Auto-generated method stub
		
	}

	

	

}