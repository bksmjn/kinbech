package com.codebhatti.kinbech.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codebhatti.kinbech.domain.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
}
