package com.mindtree.DoctorApplication.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.DoctorApplication.Entity.Doctor;
import com.mindtree.DoctorApplication.Exception.DoctorAbsentException;
import com.mindtree.DoctorApplication.Service.DoctorService;


@RestController
@Validated
@RequestMapping("/doctor")
public class DoctorController {

	@Autowired
	private DoctorService service;
	
//	@PostMapping("/addDoctor")
//	public void addDoctor(@RequestBody Doctor doctor)
//	{
//		boolean isAdded = service.addDoctor(doctor);
//		if(isAdded)
//			System.out.println("doctor is successfully added to the database");
//	}
	@PostMapping("/addDoctor")
	public ResponseEntity<?> addDoctor(@RequestBody @Valid Doctor doctor)
	{
		boolean isAdded = service.addDoctor(doctor);
		if(isAdded)
			System.out.println("doctor is successfully added to the database");
		return new ResponseEntity<>("successful",HttpStatus.ACCEPTED);
	}
	
	@RequestMapping("/getAllDoctors")
	public List<Doctor> getAllDoctors()
	{
		List<Doctor> doctors = service.getAllDoctors();
		return doctors;
	}
	
	@RequestMapping("/getSpecialist/{specialist}")
	public Doctor getSpecialist(@PathVariable @NotBlank(message="please mention the specialist") String specialist)
	{
		Doctor doctor = new Doctor();
		try {
		doctor = service.getSpecialistDoctor(specialist);
		}
		catch(DoctorAbsentException ex)
		{
			System.out.println(ex.getMessage());
		}
		return doctor;
	}
	
	@PutMapping("/updateDoctor")
	public ResponseEntity<?> updateDoctor( @RequestBody Doctor doctor)
	{
		doctor = service.updateDoctor(doctor);
		return new ResponseEntity<>(doctor, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/deleteDoctor/{id}")
	public String deleteDoctor(@PathVariable int id)
	{
		return service.deleteDoctorById(id);
	}
}
