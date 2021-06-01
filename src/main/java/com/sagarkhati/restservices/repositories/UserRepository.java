package com.sagarkhati.restservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sagarkhati.restservices.entities.User;

//Repository
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	//Custom method
	User findByUsername(String username);
}
