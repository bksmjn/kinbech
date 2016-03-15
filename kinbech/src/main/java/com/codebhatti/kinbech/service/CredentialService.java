package com.codebhatti.kinbech.service;

import com.codebhatti.kinbech.domain.Credential;

public interface CredentialService {
	
	public void save(Credential c);
	public Credential findById(String username);

}
