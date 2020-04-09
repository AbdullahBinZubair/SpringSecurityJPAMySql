package com.spring.servey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.servey.JwtUtil;
import com.spring.servey.authentications.AuthenticationRequest;
import com.spring.servey.authentications.AuthenticationResponse;


@RestController
public class HomeResource {

	
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private MyUserDetailsService userdetailservice;
	@Autowired
	private JwtUtil jwtUtilToken;
	
	@GetMapping("/")
	public String home() {
		return "<h>Welcome Home</h>";
	}
	
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/user")
	public String user() {
		return "Welcome user";
		
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/admin")
	public String admin () {
	return "Welcome Admin";
	}

	@RequestMapping(value = "/authenticate",method =RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
		try {
			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),authenticationRequest.getPassword()) ;
		
			System.out.println(authenticationManager.authenticate(usernamePasswordAuthenticationToken))   ;
			
		}
		catch (	BadCredentialsException e) {
			throw new Exception("Incorrect name or password",e);
		}
		//final UserDetails userdetails=userdetailservice.loadUserByUsername(authenticationRequest.getUsername());
		
		//final String jwt=jwtUtilToken.generateToken(userdetails);
		final UserDetails userdetails=userdetailservice.loadUserByUsername(authenticationRequest.getUsername());
		
		System.out.println(userdetails);
		final String jwt=jwtUtilToken.generateToken(userdetails);
	
		AuthenticationResponse authenticationResponse=new AuthenticationResponse(jwt);
		return ResponseEntity.ok(authenticationResponse);
		}
	
}

