package com.spring.servey.authentications;

public class AuthenticationRequest {

	private String name;
	private String password;
	public String getUsername() {
		return name;
	}
	public AuthenticationRequest() {
		super();
	}
	public void setUsername(String username) {
		this.name = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public AuthenticationRequest(String username, String password) {
		super();
		this.name = username;
		this.password = password;
	}
	
	
	
	
}
