package com.atos.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atos.webapp.model.Employee;
import com.atos.webapp.repository.EmployeeRepository;

import lombok.Data;


@Data
@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Employee getEmployee(final int id) {
		return employeeRepository.getEmployee(id);
	}
	
	public Iterable<Employee> getEmployees() {
		return employeeRepository.getEmployees();
	}
	
	public void deleteEmployee(final int id) {
		employeeRepository.deleteEmployee(id);
	}
	
	public Employee saveEmployee(Employee employee) {
		Employee savedEmployee;
		
		// Functional rule : Last name must be capitalized.
		employee.setLastName(employee.getLastName().toUpperCase());

		if(employee.getId() == null) {
			// If id is null, then it is a new employee.
			savedEmployee = employeeRepository.createEmployee(employee);
		} else {
			savedEmployee = employeeRepository.updateEmployee(employee);
		}
		
		return savedEmployee;
	}
	
}

