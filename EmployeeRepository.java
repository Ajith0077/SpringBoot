package com.ajith;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	@Query(value = "select * from employeesalary.employee where salary=(select distinct(salary) from employeesalary.employee order by salary desc limit 1 offset 2)", nativeQuery = true)

	List<Employee> thirdHighestSalary();

	@Query(value = "select * from employeesalary.employee having reg_no=? and name=?", nativeQuery = true)
	Employee logInByRegNo(long regNo, String name);

	@Query(value = "select * FROM employeesalary.employee where name like concat('%',:query,'%')", nativeQuery = true)
	List<Employee> search(String query);
}
