package com.Backend.Ajopaivakirja;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.Backend.Ajopaivakirja.web.ControllerRest;
import com.Backend.Ajopaivakirja.web.EmployeeController;
import com.Backend.Ajopaivakirja.web.ShiftController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class AjopaivakirjaApplicationTests {

	@Autowired
	 private EmployeeController econtroller;
	
	@Autowired
	 private ShiftController scontroller;
	
	@Autowired
	 private ControllerRest rcontroller;

	 @Test
	 public void contextLoads() throws Exception {
	 assertThat(econtroller).isNotNull();
	 assertThat(scontroller).isNotNull();
	 assertThat(rcontroller).isNotNull();
	 }
	 
	
}
