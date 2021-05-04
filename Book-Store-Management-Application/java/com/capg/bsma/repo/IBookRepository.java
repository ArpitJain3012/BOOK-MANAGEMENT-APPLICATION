package com.capg.bsma.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.capg.bsma.entity.BookEntity;
import com.capg.bsma.entity.CustomerEntity;
import com.capg.bsma.model.BookModel;

@Repository
public interface IBookRepository extends JpaRepository<BookEntity, Long> {
	
}