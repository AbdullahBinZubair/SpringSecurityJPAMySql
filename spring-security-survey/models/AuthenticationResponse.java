package com.spring.security.models;

public class AuthenticationResponse {

	public AuthenticationResponse() {
		super();
	}

	public AuthenticationResponse(String jwt) {
		super();
		this.jwt = jwt;
	}

	private String jwt;

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
	
	
}
