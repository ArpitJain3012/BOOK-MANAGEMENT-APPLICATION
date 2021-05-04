package com.capg.bsma.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.bsma.entity.ReviewEntity;
import com.capg.bsma.entity.UserEntity;
import com.capg.bsma.model.ReviewModel;


@Repository
public interface IReviewRepository extends JpaRepository<ReviewEntity,Long>{
	
}
