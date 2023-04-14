package com.Backend.Ajopaivakirja.web;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
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
public class EmployeeController {

	@Autowired
	private EmployeeRepository erepository;

	@Autowired
	private ShiftRepository srepository;
	
	@Autowired
	private UserRepository urepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	//kirjautuminen
	@RequestMapping("/login")
	public String index() {
		return "index";
	}

	//Lataa etusivulle kaikki työntekijän tiedot ja vuorot jos rooli on "employer", lataa vain omat tiedot ja vuorot jos rooli on "employee"
	@RequestMapping("/user")
	public String employerUser(Model model, @AuthenticationPrincipal UserDetails userDetails) {
	    String username = userDetails.getUsername();
	    User user = urepository.findByUsername(username);
	    int wage = user.getEmployee().getWage();
	    if ("employer".equals(user.getRole())) {
	        model.addAttribute("shifts", srepository.findAll());
	        model.addAttribute("employees", erepository.findAll());
	    } else {
	        model.addAttribute("shifts", user.getEmployee().getShifts());
	        Optional<Employee> employee = erepository.findById(user.getEmployee().getId());
	        model.addAttribute("employees",  employee.orElse(null));
	    }
	    return "userpage";
	}

	//Uusi käyttäjä ja työntekijä
	@RequestMapping("/newemployee")
	public String newemployee(Model model) {
		model.addAttribute("user", new User());
		return "newemployee";
	}

	//Vaikka tässä lukee saveEmp, tässä tallenetaan enemmänkin User jonka kautta myös Employee
	@RequestMapping(value = "/saveEmp", method = RequestMethod.POST)
	public String saveEmp(User user) {
	    String hashedPassword = passwordEncoder.encode(user.getPassword());
	    user.setPassword(hashedPassword);
		urepository.save(user);
		return "redirect:/user";
	}

	//työntekijän poisto
	@RequestMapping(value = "/deleteEmp/{id}", method = RequestMethod.GET)
	public String deleteEmployee(@PathVariable("id") Long employeeId, Model model) {
		erepository.deleteById(employeeId);
		return "redirect:../user";
	}

	//työntekijän muokkaus
	@RequestMapping(value = "/editEmp/{id}")
	public String editbook(@PathVariable("id") Long bookId, Model model) {
		model.addAttribute("employee", erepository.findById(bookId));
		return "editEmp";
	}
}
