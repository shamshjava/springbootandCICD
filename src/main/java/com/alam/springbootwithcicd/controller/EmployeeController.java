package com.alam.springbootwithcicd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alam.springbootwithcicd.dao.EmployeeRepo;
import com.alam.springbootwithcicd.exception.ResourceNotFoundException;
import com.alam.springbootwithcicd.model.Employee;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeRepo empRepo;
	
	@GetMapping("/")
	public String sayHello() {
		return "Hello World";
	}

	// Get All Employees
	@GetMapping("/employee")
	public List<Employee> getAllNotes() {
	    return empRepo.findAll();
	}
	
	// Get a Single Employee
	@GetMapping("/employee/{empId}")
	public Employee getEmployeeById(@PathVariable(value = "empId") Integer empId) {
	    return empRepo.findById(empId)
	            .orElseThrow(() -> new ResourceNotFoundException("Employee", "empId", empId));
	}
	
	// Create a new Employee
	@PostMapping("/employee")
	public Employee createEmployee(@Validated @RequestBody Employee employee) {
		System.out.println("Create Employee");
	    return empRepo.save(employee);
	}
	
	// Update a Employee
	@PutMapping("/employee/{empId}")
	public Employee updateEmployee(@PathVariable(value = "empId") Integer empId,
	                                        @Validated @RequestBody Employee empDetails) {

		Employee emp = empRepo.findById(empId)
	            .orElseThrow(() -> new ResourceNotFoundException("Employee", "empId", empId));

		emp.setEmpName(empDetails.getEmpName());
		emp.setEmpAddress(empDetails.getEmpAddress());
		emp.setEmpSalary(empDetails.getEmpSalary());

	    Employee updatedEmp = empRepo.save(emp);
	    return updatedEmp;
	}
	
	// Delete a Employee
	@DeleteMapping("/employee/{empId}")
	public ResponseEntity<?> deleteNote(@PathVariable(value = "empId") Integer empId) {
		Employee emp = empRepo.findById(empId)
	            .orElseThrow(() -> new ResourceNotFoundException("Employee", "empId", empId));

		empRepo.delete(emp);

	    return ResponseEntity.ok().build();
	}
}
