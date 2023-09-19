package com.atos.webapp.model;

import lombok.Data;

import com.atos.webapp.controller.EmployeeViews;
import com.fasterxml.jackson.annotation.JsonView;


@Data
public class Employee {

	@JsonView(EmployeeViews.AllEmployees.class)
	private Integer id;
	@JsonView(EmployeeViews.AllEmployees.class)
	private String firstName;
	@JsonView(EmployeeViews.AllEmployees.class)
	private String lastName;
	@JsonView(EmployeeViews.AllEmployees.class)
	private String mail;
	@JsonView(EmployeeViews.AllEmployees.class)
	private String password;
	
	public Employee() {
		super();
	}
	
	public Employee(Integer id, String firstName, String lastName, String mail, String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mail = mail;
		this.password = password;
		
		
	}

	/*
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}*/
		
}
