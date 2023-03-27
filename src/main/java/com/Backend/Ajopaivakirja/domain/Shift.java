package com.Backend.Ajopaivakirja.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="shift")
public class Shift {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String startingTime;

	private String endingTime;
	
	public Shift(String startingTime, String endingTime) {
		super();
		this.startingTime = startingTime;
		this.endingTime = endingTime;
	}
	
	public Shift() {}
	
	@Column(name = "startingtime", nullable = false)
	public String getStartingTime() {
		return startingTime;
	}

	public void setStartingTime(String startingTime) {
		this.startingTime = startingTime;
	}
	
	@Column(name = "endingtime", nullable = false)
	public String getEndingTime() {
		return endingTime;
	}

	public void setEndingTime(String endingTime) {
		this.endingTime = endingTime;
	}
}
