package com.capg.bsma.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.capg.bsma.entity.BookOrderEntity;
import com.capg.bsma.entity.CustomerEntity;
import com.capg.bsma.model.BookOrderModel;

@Repository
public interface IBookOrderRepository extends JpaRepository<BookOrderEntity,Long>{

}
