package com.codebhatti.kinbech.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class CustomAuthenticator implements AuthenticationProvider {

	public CustomAuthenticator() {
		System.out.println("inside CustomAuthenticator");
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		List<GrantedAuthority> grantedAuth = new ArrayList<GrantedAuthority>();
		grantedAuth.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		Authentication auth = new UsernamePasswordAuthenticationToken("admin", "admin", grantedAuth);
		return auth;
	}

	@Override
	public boolean supports(Class<?> type) {
		return type.equals(UsernamePasswordAuthenticationToken.class);
	}

}
