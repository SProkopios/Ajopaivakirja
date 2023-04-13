package com.Backend.Ajopaivakirja.domain;

import java.sql.Date;
import java.time.Duration;
import java.time.LocalTime;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="shift")
public class Shift {

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="employee")
	private Employee employee;
	
    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private LocalTime startingTime;

	private LocalTime endingTime;
	
	private Date date;
	
	public Shift(LocalTime startingTime, LocalTime endingTime, Date date, Employee employee) {
		super();
		this.startingTime = startingTime;
		this.endingTime = endingTime;
		this.employee = employee;
		this.date=date;
	}
	
	public Shift() {}
	
	public Employee getEmployee() {
		return employee;
	}
	
	public void setEmployee(Employee employee) {
		this.employee=employee;
	}
	
	@Column(name="id", nullable = false)
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "startingtime", nullable = false)
	public LocalTime getStartingTime() {
		return startingTime;
	}

	public void setStartingTime(LocalTime startingTime) {
		this.startingTime = startingTime;
	}
	
	@Column(name = "endingtime", nullable = false)
	public LocalTime getEndingTime() {
		return endingTime;
	}

	public void setEndingTime(LocalTime endingTime) {
		this.endingTime = endingTime;
	}
	
	@Column(name = "date", nullable = false)
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date=date;
	}
	
	public long Hours() {
		Duration duration = Duration.between(startingTime, endingTime);
		return duration.toHours();
	}
}
