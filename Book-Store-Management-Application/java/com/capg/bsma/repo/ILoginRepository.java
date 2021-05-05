package com.capg.bsma.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.capg.bsma.entity.UserEntity;

//this interface includes all crud repository methods

@Repository
public interface ILoginRepository extends JpaRepository<UserEntity, Long> {
	// calling exist by password method in service and API
	boolean existsByPassword(String password);
	
	// calling find by password method in service and API
	UserEntity findByPassword(String password);
}
