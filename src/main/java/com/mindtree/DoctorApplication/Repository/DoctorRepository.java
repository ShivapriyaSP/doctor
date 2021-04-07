package com.mindtree.DoctorApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mindtree.DoctorApplication.Entity.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Integer>{

	@Query("select d from Doctor d where d.specialist=?1")
	Doctor findBySpecialist(String specialist);
}
