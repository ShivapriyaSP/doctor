package com.mindtree.DoctorApplication.Service;

import java.util.List;

import com.mindtree.DoctorApplication.Entity.Doctor;
import com.mindtree.DoctorApplication.Exception.DoctorAbsentException;

public interface DoctorService {

	boolean addDoctor(Doctor doctor);

	List<Doctor> getAllDoctors();

	Doctor getSpecialistDoctor(String specialist) throws DoctorAbsentException;

	Doctor updateDoctor(Doctor doctor);

	String deleteDoctorById(int id);

	

	

}
