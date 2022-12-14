package com.etiya.northwind.entities.concretes;

import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customers")

public class Customer {
	@Id
	@Column(name = "customer_id")
	private String customerId;
	
	@Column(name = "company_name")
	private String companyName;
	
	@Column(name = "contact_name")
	private String contactName;
	
	@Column(name = "contact_title")
	private String contactTitle;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "city")
	private String city;
	
	@OneToMany(mappedBy = "customer")
	private List<Order> orders;

	@OneToOne(mappedBy = "customer")
	private Cart cart;
}
