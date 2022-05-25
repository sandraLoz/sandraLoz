package com.opplus.demoUser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import com.opplus.demoUser.domain.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

	
	
}

