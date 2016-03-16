package com.codebhatti.kinbech.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codebhatti.kinbech.domain.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
	
}
