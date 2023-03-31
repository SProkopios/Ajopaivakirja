package com.Backend.Ajopaivakirja.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Backend.Ajopaivakirja.domain.Employee;
import com.Backend.Ajopaivakirja.domain.EmployeeRepository;
import com.Backend.Ajopaivakirja.domain.Shift;
import com.Backend.Ajopaivakirja.domain.ShiftRepository;

@Controller
public class ShiftController {

	@Autowired
	private EmployeeRepository erepository;
	
	@Autowired
	private ShiftRepository srepository;
	
	@RequestMapping(value = "/saveShift", method = RequestMethod.POST)
	public String saveShift(Shift shift, Model model) {
		srepository.save(shift);
		return "redirect:/user";
	}
	
	@RequestMapping(value = "/deleteShift/{id}", method = RequestMethod.GET)
	public String deleteShift(@PathVariable("id") Long ShiftId, Model model) {
		srepository.deleteById(ShiftId);
		return "redirect:../user";
	}
	
	@RequestMapping(value = "/editShift/{id}")
	public String editShift(@PathVariable("id") Long shiftId, Model model) {
		Optional<Shift> shift = srepository.findById(shiftId);
		Shift normalShift = shift.get();
		Employee employee = normalShift.getEmployee();
		model.addAttribute("shift", shift);
		model.addAttribute("employee", employee);
		return "editshift";
	}
}
