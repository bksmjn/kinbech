package com.codebhatti.kinbech.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codebhatti.kinbech.domain.Credential;
import com.codebhatti.kinbech.repository.CredentialRepository;
import com.codebhatti.kinbech.service.CredentialService;

@Service
public class CredentialServiceImpl implements CredentialService {
	
	@Autowired
	private CredentialRepository credentialRepository;

	@Override
	public void save(Credential c) {
		this.credentialRepository.save(c);
		
	}

	@Override
	public Credential findById(String username) {
		return credentialRepository.findOne(username);
	}
	
	
	
	

}
