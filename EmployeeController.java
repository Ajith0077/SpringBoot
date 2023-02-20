package com.ajith;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
@Autowired
private EmployeeRepository er;
	private EmployeeService service;

	public EmployeeController(EmployeeService service) {
		super();
		this.service = service;
	}

	@PostMapping(value = "employeeDetails")
	public ResponseEntity<List<Employee>> addEmployeeDetails(@RequestBody List<Employee> emp) {
		org.springframework.http.HttpHeaders header = new org.springframework.http.HttpHeaders();
		header.add("Employee", "SalaryDetails");
		List<Employee> list = service.saveAll(emp);
		return new ResponseEntity<List<Employee>>(list, header, HttpStatus.CREATED);
	}

	@GetMapping(value = "thirdHighestSalaryList")
	public ResponseEntity<List<Employee>> thirdHighestSalary() {
		org.springframework.http.HttpHeaders header = new org.springframework.http.HttpHeaders();
		header.add("Employee", "Third Highest Salary Details");
		List<Employee> emp = service.thirdHighestSalary();
		return new ResponseEntity<List<Employee>>(emp, header, HttpStatus.FOUND);
	}

	@DeleteMapping(value = "deleteById/{id}")
	public String deleteById(@PathVariable int id) {
		return service.deleteById(id);
	}

	@PostMapping(value = "UpdateEmployeeDetails")
	public ResponseEntity<Employee> UpdateEmployeeDetails(@RequestBody Employee emp) {
		org.springframework.http.HttpHeaders header = new org.springframework.http.HttpHeaders();
		header.add("Employee", "onePersonDetails");
		Employee list = service.save(emp);
		return new ResponseEntity<Employee>(list, header, HttpStatus.CREATED);
	}
	@GetMapping(value="getAllEmployeeDetails")
	public ResponseEntity<List<Employee>>getAllEmployeeDetailsList(){
		org.springframework.http.HttpHeaders header = new org.springframework.http.HttpHeaders();
		header.add("Employee", "AllPersonsDetails");
		List<Employee>emp=service.getAllList();
        return new ResponseEntity<List<Employee>>(emp,header,HttpStatus.FOUND);
	}
	@GetMapping(value="getById/{id}")
	public Employee getById(@PathVariable int id) throws DetailsNotFound {
		return service.getById(id);
	}
	@GetMapping(value="login")
	public List<Employee> login(@RequestParam long regNo ,@RequestParam String name)
	{
			return service.emp(regNo,name);
	}
	@GetMapping(value="/searchby")
	public List<Employee> search(@RequestParam(value = "query") String name){
		return service.searchBy(name);
	}
}