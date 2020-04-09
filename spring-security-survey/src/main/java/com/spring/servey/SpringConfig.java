package com.spring.servey;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//import com.spring.servey.filters.JwtRequestFilter;

@Configuration
public class SpringConfig {

	@Bean
	public JwtUtil jwtutil() {
		return new JwtUtil();
	}
	
	@Bean
	public com.spring.servey.filters.JwtRequestFilter jwtRequestFilter() {
		return new com.spring.servey.filters.JwtRequestFilter();
	}
}
