package com.example.hiborm.model;

import javax.annotation.processing.Generated;

import jakarta.persistence.*;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String name;
	@Column(unique=true)
	private String email;
	
	//no args constructor
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//args based constructor
	public Employee(String name, String email) {
		super();
		
		this.name = name;
		this.email = email;
	}
	
	//getters&setters
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
	
	
	
	
	
	
	
	

}
