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
import com.codebhatti.kinbech.domain.Identity;
import com.codebhatti.kinbech.domain.User;
import com.codebhatti.kinbech.service.UserService;

public class CustomAuthenticator implements AuthenticationProvider {

	@Autowired
	private UserService userService;
	@Autowired
	private Identity identity;

	public CustomAuthenticator() {
		System.out.println("inside CustomAuthenticator");
	}

	@Override
	public Authentication authenticate(Authentication a) throws AuthenticationException {
		User user=this.userService.findByUserName(a.getName());
		String hashedPassword = Base64.encodeBase64String(DigestUtils.sha256(a.getCredentials().toString()));
		if (user == null) {
			return null;
		} else {
			if(user.getPassword().equals(hashedPassword)){
				identity.setUserName(user.getUserName());
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

	public Identity getIdentity() {
		return identity;
	}

	public void setIdentity(Identity identity) {
		this.identity = identity;
	}

	

}
