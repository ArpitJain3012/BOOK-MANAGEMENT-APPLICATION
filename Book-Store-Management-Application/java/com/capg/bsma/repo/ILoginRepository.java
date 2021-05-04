package com.capg.bsma.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.bsma.entity.CustomerEntity;
import com.capg.bsma.entity.UserEntity;

@Repository
public interface ILoginRepository extends JpaRepository<UserEntity,Long> {
	boolean existsByPassword(String password);
	UserEntity findByPassword(String password);
}



