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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
	
	@OneToOne(mappedBy = "employee")
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;
	private int wage;

	public Employee(String name, int wage) {
		super();
		this.name = name;
		this.wage = wage;
	}
	
	public Employee() {
		
	}
	
	
	@Column(name= "id", nullable = false)
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
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
