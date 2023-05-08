package com.dal.firstsprboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.RequestMatcher;

@Configuration
@EnableWebSecurity(debug=true)
@EnableMethodSecurity
public class TravellerSecurityConfig {
	
	@Autowired
	TravellerAuthProvider travellerAuthProvider;
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests().requestMatchers("/welcome/**").permitAll()
		.requestMatchers("/addtraveller/**").authenticated()
		.requestMatchers("/listtravellers").authenticated()
		.requestMatchers("/deletebyid/**").authenticated()
		.requestMatchers("requestlocaltour/**").authenticated()
		.requestMatchers("requestforeigntour/**").authenticated();
		
		http.httpBasic();
		http.csrf().disable();
		
		return http.build();
		
	}
	
	@Bean
	public AuthenticationManager authManager(HttpSecurity http) throws Exception {

		AuthenticationManagerBuilder authenticationManagerBuilder = http
				.getSharedObject(AuthenticationManagerBuilder.class);
		authenticationManagerBuilder.authenticationProvider(travellerAuthProvider);
		return authenticationManagerBuilder.build();
	}
	
	

}
