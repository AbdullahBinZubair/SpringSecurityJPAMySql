package com.spring.servey.models;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
//import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserDetails implements UserDetails{
	
	public MyUserDetails(User user) {
		this.name=user.getName();
		this.password=user.getPassword();
		this.authorities=Arrays.stream(user.getRoles().split(","))
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
		
	}
	private String name;
	private String password;
	private List<GrantedAuthority> authorities;
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return name;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	

}
