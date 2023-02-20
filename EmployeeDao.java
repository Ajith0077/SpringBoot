package com.ajith;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class EmployeeDao {
@Autowired
private EmployeeRepository rep;
	public List<Employee> saveAll(List<Employee> emp) {
		// TODO Auto-generated method stub
		return rep.saveAll(emp);
	}
	public List<Employee> thirdHighestSalary() {
		// TODO Auto-generated method stub
		return rep.thirdHighestSalary();
	}
	public String deleteById(int id) {
		// TODO Auto-generated method stub
		rep.deleteById(id);
		return "Deleted Successfully";
	}
	public Employee save(Employee emp) {
		// TODO Auto-generated method stub
		return rep.save(emp);
	}
	public List<Employee> getAllList() {
		// TODO Auto-generated method stub
		return rep.findAll();
	}
	public Employee getById(int id) throws DetailsNotFound {
		// TODO Auto-generated method stub
		return rep.findById(id).get();
	}
	public Employee loginBy(long regNo, String name) {
		// TODO Auto-generated method stub
		return rep.logInByRegNo(regNo,name);
	}
	public List<Employee> searchBy(String name) {
		// TODO Auto-generated method stub
		return rep.search(name);
	}
}
