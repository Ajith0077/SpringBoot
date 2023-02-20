package com.ajith;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class Validator {
 
	public  List<Error> employeeDetailsValidation(Employee emp) {
		List<Error> error=new ArrayList<>();
    if(emp.getRegNo()<=0)
		error.add(new Error("Register", "Register Number should give correctly"));
	if(emp.getName()==null)
		error.add(new Error("Name","plaese Fill the Name"));
	if(emp.getSalary()<=0)
		error.add(new Error("Salary", "Please give salary details in properly"));
	return error;	
}

	public List<Error> fullemployeeDetailsValidation(List<Employee> employee) {
		List<Error> error=new ArrayList<>();
	 for(Employee e:employee) {
		    if(e.getRegNo()<=0)
				error.add(new Error("Register", "Register Number should give correctly : "+e.getId()));
			if(e.getName()==null)
				error.add(new Error("Name","plaese Fill the Name : "+e.getId()));
			if(e.getSalary()<=0)
				error.add(new Error("Salary", "Please give salary details in properly : "+e.getId()));
	 }
		return error;
	}
}