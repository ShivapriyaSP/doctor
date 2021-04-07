package com.mindtree.DoctorApplication.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.mindtree.DoctorApplication.Entity.Doctor;
import com.mindtree.DoctorApplication.Exception.DoctorAbsentException;
import com.mindtree.DoctorApplication.Repository.DoctorRepository;

@Service
public class DoctorServiceImpl implements DoctorService{

	@Autowired
	private DoctorRepository doctorrepository;

	@Override
	public boolean addDoctor(Doctor doctor) {
		doctorrepository.save(doctor);
		return true;
	}


	//@Cacheable(value="cache")
	@Override
	@Cacheable (value = "doctors")
	public List<Doctor> getAllDoctors() {
		// TODO Auto-generated method stub
		List<Doctor> doctors = new ArrayList<Doctor>();
		try
		{
			Thread.sleep(2000);
		}
		catch(InterruptedException ex)
		{
			ex.printStackTrace();
		}
		doctors = doctorrepository.findAll();
		Collections.sort(doctors, new SortByName());
		return doctors;
	}

	@Override
	@CachePut(value="doctors")
	public Doctor updateDoctor(Doctor doctor) {
		Doctor d = doctorrepository.findById(doctor.getId()).orElse(null);
		d.setName(doctor.getName());
		d.setNoOfPatients(doctor.getNoOfPatients());
		d.setSalary(doctor.getSalary());
		d.setSpecialist(doctor.getSpecialist());
		return doctorrepository.save(d);
	}

	@Override
	@CacheEvict(value = "doctors")
	public String deleteDoctorById(int id) {
		Doctor d = doctorrepository.findById(id).get();
		doctorrepository.delete(d);
		return "doctor has been deleted successfully";
	}

	@Override
	public Doctor getSpecialistDoctor(String specialist)  throws DoctorAbsentException {
		
		Doctor doctor = doctorrepository.findBySpecialist(specialist);
		if(doctor==null)
			throw new DoctorAbsentException("no such doctor are there");
		return doctor;
	}

	
}
