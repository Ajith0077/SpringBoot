package com.ajith;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeDao dao;
	@Autowired
	private Validator v;
//To check ALL DETAILS POST API
	public List<Employee> saveAll(List<Employee> emp) {
			List<Error>error=v.fullemployeeDetailsValidation(emp);
		if(error.size()>0)
			throw new BadRequestException("bad request", error);
		return dao.saveAll(emp);
	}

	public List<Employee> thirdHighestSalary() {
		return dao.thirdHighestSalary();
	}

	public String deleteById(int id) {
		// TODO Auto-generated method stub
		return dao.deleteById(id);
	}
//TO check single data post
	public Employee save(Employee emp) throws BadRequestException {
		List<Error> error = v.employeeDetailsValidation(emp);
		if (error.size() > 0) {
			throw new BadRequestException("bad request", error);
		} else {
			return dao.save(emp);
		}
	}

	public List<Employee> getAllList() {
		// TODO Auto-generated method stub
		return dao.getAllList();
	}
//To check get data by Id
	public Employee getById(int id) throws DetailsNotFound {
		List<Employee>emp=dao.getAllList();
		List<Employee> employeeGetById=emp.stream().filter(x->x.getId()==id).collect(Collectors.toList());
		if(employeeGetById.isEmpty())
			throw new DetailsNotFound("not found");
		return dao.getById(id);
}

	public List<Employee> emp(long regNo, String name) {
		
		List<Employee> emp=dao.getAllList();
		Predicate<Employee>p1=x->x.getName().equals(name);
		Predicate<Employee>p2=x->(x.getRegNo()==regNo);
		List<Employee>employeeGetByRegNoandName=emp.stream().filter(p1.and(p2)).collect(Collectors.toList());
	if(employeeGetByRegNoandName.isEmpty())
			{
		throw new DetailsNotFound("not found by this details");
	}
	else {
	    return employeeGetByRegNoandName;
	}
}

	public List<Employee> searchBy(String name) {
		// TODO Auto-generated method stub
		return dao.searchBy(name);
	}
}