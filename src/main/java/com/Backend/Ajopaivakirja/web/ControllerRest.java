package com.Backend.Ajopaivakirja.web;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Backend.Ajopaivakirja.domain.Employee;
import com.Backend.Ajopaivakirja.domain.EmployeeRepository;
import com.Backend.Ajopaivakirja.domain.Shift;
import com.Backend.Ajopaivakirja.domain.ShiftRepository;

@RestController
public class ControllerRest {
	
	private EmployeeRepository erepository;
	
	private ShiftRepository srepository;
	
	// REST kaikki työntekijät
	@RequestMapping(value="/employees", method = RequestMethod.GET)
	public @ResponseBody List<Employee> employeeRest() {
	return (List<Employee>) erepository.findAll();
	}
	
	// RESTful service to get all students
	@RequestMapping(value="/shifts", method = RequestMethod.GET)
	public @ResponseBody List<Shift> shiftRest() {
	return (List<Shift>) srepository.findAll();
	}

}
