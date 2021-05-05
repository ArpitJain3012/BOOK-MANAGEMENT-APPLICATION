package com.capg.bsma.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.capg.bsma.entity.ReviewEntity;

//this interface includes all crud repository methods

@Repository
public interface IReviewRepository extends JpaRepository<ReviewEntity, Long> {

}
