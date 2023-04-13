package com.Backend.Ajopaivakirja.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Backend.Ajopaivakirja.domain.Employee;
import com.Backend.Ajopaivakirja.domain.EmployeeRepository;
import com.Backend.Ajopaivakirja.domain.Shift;
import com.Backend.Ajopaivakirja.domain.ShiftRepository;
import com.Backend.Ajopaivakirja.domain.User;
import com.Backend.Ajopaivakirja.domain.UserRepository;

@Controller
public class ShiftController {

	@Autowired
	private EmployeeRepository erepository;
	
	@Autowired
	private UserRepository urepository;
	
	@Autowired
	private ShiftRepository srepository;
	
	
	//Vuoron lisääminen
	@RequestMapping(value = "/saveShift", method = RequestMethod.POST)
	public String saveShift(Shift shift, Model model) {
		srepository.save(shift);
		return "redirect:/user";
	}
	
	//Vuoron poistaminen
	@RequestMapping(value = "/deleteShift/{id}", method = RequestMethod.GET)
	public String deleteShift(@PathVariable("id") Long ShiftId, Model model) {
		srepository.deleteById(ShiftId);
		return "redirect:../user";
	}
	
	//Vuoron muokkaaminen
	@RequestMapping(value = "/editShift/{id}")
	public String editShift(@PathVariable("id") Long shiftId, Model model) {
		Optional<Shift> shift = srepository.findById(shiftId);
		Shift normalShift = shift.get();
		Employee employee = normalShift.getEmployee();
		model.addAttribute("shift", shift);
		model.addAttribute("employee", employee);
		return "editshift";
	}
	
	//Jos rooli on "employer" käyttäjä voi lisätä kenelle tahanssa vuoron, jos käyttäjä on "employee" voi hän lisätä vain itselleen uuden vuoron
	@RequestMapping(value="/newshift")
	public String newShift(Model model, @AuthenticationPrincipal UserDetails userDetails) {
	    String username = userDetails.getUsername();
	    User user = urepository.findByUsername(username);
	    if ("employer".equals(user.getRole())) {
			model.addAttribute("shift", new Shift());
			model.addAttribute("employees", erepository.findAll());
	    } else {
	    	model.addAttribute("shift", new Shift());
	        Optional<Employee> employee = erepository.findById(user.getEmployee().getId());
	        model.addAttribute("employees",  employee.orElse(null));
	    }
		return "/newshift";
	}
}
