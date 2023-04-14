package com.Backend.Ajopaivakirja;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.Backend.Ajopaivakirja.domain.Shift;
import com.Backend.Ajopaivakirja.domain.ShiftRepository;

public class ShiftRepositoryTest {

	@Autowired
	private ShiftRepository srepository;
	
    @Test
    public void findByNameShouldReturnShift() {
        Optional<Shift> shifts = srepository.findById((long) 1);
        
        assertThat(shifts).isPresent();
    }
}
