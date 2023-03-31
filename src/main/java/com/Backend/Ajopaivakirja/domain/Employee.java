package com.Backend.Ajopaivakirja.domain;

import java.util.List;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy="employee")
	private List<Shift> shifts;
	
	public List<Shift> getShifts() {
		return shifts;
	}
	
    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String role;
	private String name;
	private int wage;

	public Employee(String role, String name, int wage) {
		super();
		this.role = role;
		this.name = name;
		this.wage = wage;
	}
	
	public Employee() {
		
	}
	
	@Column(name= "id", nullable = false)
	public Long getId() {
		return id;
	}
	
	@Column(name = "role", nullable = false)
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "wage", nullable = false)
	public int getWage() {
		return wage;
	}

	public void setWage(int wage) {
		this.wage = wage;
	}
}
