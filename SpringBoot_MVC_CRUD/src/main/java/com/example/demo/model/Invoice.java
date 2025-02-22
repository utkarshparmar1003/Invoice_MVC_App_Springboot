package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Invoice {

	@Id
	@GeneratedValue
	private Long id;
	
	private String Name;
	private String Location;
	private Double Amount;
	
	public Invoice() {
		super();
	}

	public Invoice(Long id, String name, String location, Double amount) {
		super();
		this.id = id;
		Name = name;
		Location = location;
		Amount = amount;
	}

	@Override
	public String toString() {
		return "Invoice [id=" + id + ", Name=" + Name + ", Location=" + Location + ", Amount=" + Amount + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public Double getAmount() {
		return Amount;
	}

	public void setAmount(Double amount) {
		Amount = amount;
	}
	
}
