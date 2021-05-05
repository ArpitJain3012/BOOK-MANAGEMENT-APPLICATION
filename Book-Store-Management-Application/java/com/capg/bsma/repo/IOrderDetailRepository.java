package com.capg.bsma.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.capg.bsma.entity.OrderDetailEntity;

//this interface includes all crud repository methods
@Repository
public interface IOrderDetailRepository extends JpaRepository<OrderDetailEntity, Long> {

}
