package com.etiya.northwind.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {
	
	@Id
	@Column(name = "employee_id")
	private int employeeId;
	
	@Column(name ="first_name")
	private String firstName;
	
	@Column(name ="last_name")
	private String lastName;
	
	@Column(name ="title")
	private String title;
	
	@Column(name ="birth_date")
	private LocalDate birthDate;
	
	@Column(name ="address")
	private String address;
	
	@OneToMany(mappedBy = "employee")
	private List<Order> orders;
	
	@Column(name = "reports_to")
	private Integer reportsTo;
	
}
