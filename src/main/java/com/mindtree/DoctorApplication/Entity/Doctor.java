package com.mindtree.DoctorApplication.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


@Entity
public class Doctor {
	@Id
	private int id;
	private String name;
	private double salary;
	@NotNull
	private String specialist;
	private int noOfPatients;
	
	public Doctor()
	{}
	
	public Doctor(int id, String name, double salary, String specialist, int noOfPatients) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.specialist = specialist;
		this.noOfPatients = noOfPatients;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public String getSpecialist() {
		return specialist;
	}

	public int getNoOfPatients() {
		return noOfPatients;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public void setSpecialist(String specialist) {
		this.specialist = specialist;
	}

	public void setNoOfPatients(int noOfPatients) {
		this.noOfPatients = noOfPatients;
	}
	
	
}
