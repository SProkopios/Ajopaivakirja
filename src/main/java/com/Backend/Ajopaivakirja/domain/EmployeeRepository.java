package com.Backend.Ajopaivakirja.domain;


import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

	Optional<Employee> findById(Long id);
}
