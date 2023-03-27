package com.Backend.Ajopaivakirja.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Backend.Ajopaivakirja.domain.Employee;
import com.Backend.Ajopaivakirja.domain.EmployeeRepository;
import com.Backend.Ajopaivakirja.domain.ShiftRepository;

@Controller
public class AjoController {
	
	@Autowired
	private EmployeeRepository erepository;
	
	@Autowired
	private ShiftRepository srepository;

	@RequestMapping("/")
	public String index() {
		return "index";
		
	}
	
	@RequestMapping("/user")
	public String user(Model model) {
		model.addAttribute("employee", erepository.findAll());
		model.addAttribute("shift", srepository.findAll());
		return "userpage";
	}
	
	@RequestMapping("/newemployee")
	public String newemployee(Model model) {
		model.addAttribute("employee", new Employee());
		return "newemployee";
	}
}
