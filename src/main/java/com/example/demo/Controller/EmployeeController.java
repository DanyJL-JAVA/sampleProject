package com.example.demo.Controller;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
//@RequiredArgsConstructor
public class EmployeeController {

	private final EmployeeService service;

	public EmployeeController(EmployeeService service) {
		this.service = service;
	}

	@PostMapping
	public Employee createEmployee(@RequestBody Employee employee) {

		return service.addEmployee(employee);
	}

	@GetMapping
	public List<Employee> getAllEmployees() {
		return service.getAllEmployees();
	}

	@GetMapping("/{id}")
	public Employee getEmployee(@PathVariable Long id) {

		return service.getEmployee(id);
	}

	@PutMapping("/{id}")
	public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {

		return service.updateEmployee(id, employee);
	}

	@DeleteMapping("/{id}")
	public String deleteEmployee(@PathVariable Long id) {

		service.deleteEmployee(id);

		return "Employee Deleted Successfully";

	}

}
