package com.Backend.Ajopaivakirja;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.Backend.Ajopaivakirja.domain.User;
import com.Backend.Ajopaivakirja.domain.UserRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = AjopaivakirjaApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {

	@Autowired
	private UserRepository urepository;
    
	//Testataan käyttäjän luomista
    @Test
    public void createNewUser() {
    	User user = new User("Testaa", "Testaa", "Testaa");
    	urepository.save(user);
    	assertThat(user.getId()).isNotNull();
    }
    
    //Testataan käyttäjän etsimistä
    @Test
    public void findByNameShouldReturnEmployee() {
        List<User> user = urepository.findListByUsername("Testaa");
        
        assertThat(user).hasSize(1);
        assertThat(user.get(0).getUsername()).isEqualTo("Testaa");
    }
    
    //Testataan käyttäjän poistamista
    //Tämä toimii vasta toisella kerralla, jos käyttää tuota "Testaa" nimeä!
    @Test
    public void deleteNewEmployee() {
		List<User> user = urepository.findListByUsername("Testaa");
		User thisuser = user.get(0);
		urepository.delete(thisuser);
		List<User> newUsers = urepository.findListByUsername("Testaa");
		assertThat(newUsers).hasSize(0);
     }
}
