package com.codebhatti.kinbech.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codebhatti.kinbech.domain.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

}
