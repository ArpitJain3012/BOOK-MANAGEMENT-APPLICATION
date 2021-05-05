package com.capg.bsma.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import com.capg.bsma.entity.BookEntity;

//this interface includes all crud repository methods

@Repository
public interface IBookRepository extends JpaRepository<BookEntity, Long> {

}