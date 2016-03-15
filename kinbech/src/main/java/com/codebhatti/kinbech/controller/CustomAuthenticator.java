package com.codebhatti.kinbech.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

import com.codebhatti.kinbech.domain.Credential;
import com.codebhatti.kinbech.service.CredentialService;

public class CustomAuthenticator implements AuthenticationProvider {

	@Autowired
	private CredentialService credentialService;

	public CustomAuthenticator() {
		System.out.println("inside CustomAuthenticator");
	}

	@Override
	public Authentication authenticate(Authentication a) throws AuthenticationException {
		Credential c = credentialService.findById(a.getName());
		String hashedPassword = Base64.encodeBase64String(DigestUtils.sha256(a.getCredentials().toString()));
		if (c == null) {
			return null;
		} else {
			if (hashedPassword.equals(c.getPassword())) {
				List<GrantedAuthority> grantedAuth = new ArrayList<GrantedAuthority>();
				grantedAuth.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
				Authentication auth = new UsernamePasswordAuthenticationToken(a.getName(),
						a.getCredentials().toString(), grantedAuth);
				return auth;

			}
			return null;
		}
	}

	@Override
	public boolean supports(Class<?> type) {
		return type.equals(UsernamePasswordAuthenticationToken.class);
	}

}
