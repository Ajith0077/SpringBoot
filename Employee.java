package com.ajith;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table
public class Employee {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private long regNo;
private String name;
private int salary;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public long getRegNo() {
	return regNo;
}
public void setRegNo(long regNo) {
	this.regNo = regNo;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getSalary() {
	return salary;
}
public void setSalary(int salary) {
	this.salary = salary;
}


}
