package com.codebhatti.kinbech.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codebhatti.kinbech.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, String>{

}
