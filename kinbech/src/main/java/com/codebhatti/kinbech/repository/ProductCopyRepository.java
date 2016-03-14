package com.codebhatti.kinbech.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codebhatti.kinbech.domain.ProductCopy;

@Repository
public interface ProductCopyRepository extends CrudRepository<ProductCopy, Long> {

}
