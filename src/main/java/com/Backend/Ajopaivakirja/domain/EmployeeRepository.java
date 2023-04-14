package com.Backend.Ajopaivakirja.domain;


import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

	Optional<Employee> findById(Long id);
	
	List<Employee> findByName(String name);
	
	void deleteById(Long id);
	
	void delete(Employee employee);
}
