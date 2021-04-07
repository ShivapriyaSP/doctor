package com.mindtree.DoctorApplication.Service;

import java.util.Comparator;

import com.mindtree.DoctorApplication.Entity.Doctor;

public class SortByName implements Comparator<Doctor>{

	@Override
	public int compare(Doctor o1, Doctor o2) {
		
		return (o1.getName().compareTo(o2.getName()))*-1;
	}

}
