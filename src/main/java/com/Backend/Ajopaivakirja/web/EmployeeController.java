package com.Backend.Ajopaivakirja.web;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Backend.Ajopaivakirja.domain.Employee;
import com.Backend.Ajopaivakirja.domain.EmployeeRepository;
import com.Backend.Ajopaivakirja.domain.Shift;
import com.Backend.Ajopaivakirja.domain.ShiftRepository;



@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository erepository;
	
	@Autowired
	private ShiftRepository srepository;

	@RequestMapping("/")
	public String index() {
		return "index";
		
	}
	
	@RequestMapping("/user")
	public String user(Model model, Shift shift) {
		model.addAttribute("employees", erepository.findAll());
		model.addAttribute("shifts", srepository.findAll());
		model.addAttribute("shift", new Shift());
		return "userpage";
	}
	
	@RequestMapping(value="/employees", method = RequestMethod.GET)
	public @ResponseBody List<Employee> employeeRest() {
		return (List<Employee>) erepository.findAll();
	}
	
	@RequestMapping("/newemployee")
	public String newemployee(Model model) {
		model.addAttribute("employee", new Employee());
		return "newemployee";
	}
	
	@RequestMapping(value = "/saveEmp", method = RequestMethod.POST)
	public String saveEmp(Employee employee, Model model) {
		erepository.save(employee);
		return "redirect:/user";
	}
	
	@RequestMapping(value = "/deleteEmp/{id}", method = RequestMethod.GET)
	public String deleteEmployee(@PathVariable("id") Long employeeId, Model model) {
		erepository.deleteById(employeeId);
		return "redirect:../user";
	}
	
	@RequestMapping(value = "/editEmp/{id}")
	public String editbook(@PathVariable("id") Long bookId, Model model){
		model.addAttribute("employee", erepository.findById(bookId));
		return "editEmp";
	}
}
