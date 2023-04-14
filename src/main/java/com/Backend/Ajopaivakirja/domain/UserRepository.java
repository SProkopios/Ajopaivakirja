package com.Backend.Ajopaivakirja.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Long>{
	
	List<User> findListByUsername(String username);
	
	User findByUsername(String username);
	

}
