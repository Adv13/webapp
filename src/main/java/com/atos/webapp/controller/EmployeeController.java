package com.atos.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.atos.webapp.model.Employee;
import com.atos.webapp.service.EmployeeService;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonView;



@Data
//@RestController
@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@GetMapping("/")
	@JsonView(EmployeeViews.AllEmployees.class)
	public String home(Model model) {
		final Iterable<Employee> listEmployee = service.getEmployees();
		model.addAttribute("employees", listEmployee);
		return "home";
	}
	
	
	@GetMapping("/createEmployee")
	@JsonView(EmployeeViews.OneEmployee.class)
	public String createEmployee(Model model) {
		final Employee e = new Employee();
		model.addAttribute("employee", e);
		return "formNewEmployee";
	}
	
	
	@GetMapping("/updateEmployee/{id}")
	@JsonView(EmployeeViews.OneEmployee.class)
	public String updateEmployee(@PathVariable("id") final int id, Model model) {
		final Employee e = service.getEmployee(id);		
		model.addAttribute("employee", e);	
		return "formUpdateEmployee";		
	}
	
	@GetMapping("/deleteEmployee/{id}")
	@JsonView(EmployeeViews.OneEmployee.class)
	public ModelAndView deleteEmployee(@PathVariable("id") final int id) {
		service.deleteEmployee(id);
		return new ModelAndView("redirect:/");		
	}
	
	@PostMapping("/saveEmployee")
	@JsonView(EmployeeViews.OneEmployee.class)
	public ModelAndView saveEmployee(@ModelAttribute Employee employee) {
		if(employee.getId() != null) {
			// Employee from update form has the password field not filled,
			// so we fill it with the current password.
			final Employee current = service.getEmployee(employee.getId());
			employee.setPassword(current.getPassword());
		}
		service.saveEmployee(employee);
		return new ModelAndView("redirect:/");	
	}
}
