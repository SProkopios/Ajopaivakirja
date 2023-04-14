package com.Backend.Ajopaivakirja;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.Backend.Ajopaivakirja.domain.Employee;
import com.Backend.Ajopaivakirja.domain.EmployeeRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = AjopaivakirjaApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EmployeeRepositoryTest {
	
    @Autowired
    private EmployeeRepository erepository;	
    
    @Test
    public void createNewEmployee() {
    	Employee employee = new Employee("Mickey", 10);
    	erepository.save(employee);
    	assertThat(employee.getId()).isNotNull();
    }
    
    @Test
    public void findByNameShouldReturnEmployee() {
        List<Employee> employees = erepository.findByName("Mickey");
        
        assertThat(employees).hasSize(1);
        assertThat(employees.get(0).getName()).isEqualTo("Mickey");
    }
    
    @Test
    public void deleteNewEmployee() {
		List<Employee> employees = erepository.findByName("Mickey");
		Employee employee = employees.get(0);
		erepository.delete(employee);
		List<Employee> newEmployees = erepository.findByName("Mickey");
		assertThat(newEmployees).hasSize(0);
     }
}
