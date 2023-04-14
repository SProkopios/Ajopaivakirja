package com.Backend.Ajopaivakirja.domain;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface ShiftRepository extends CrudRepository<Shift, Long> {
	
	Optional<Shift> findById(Long id);

	
}
