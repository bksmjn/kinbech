package com.codebhatti.kinbech.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codebhatti.kinbech.domain.Credential;

@Repository
public interface CredentialRepository extends CrudRepository<Credential, String>{

}
