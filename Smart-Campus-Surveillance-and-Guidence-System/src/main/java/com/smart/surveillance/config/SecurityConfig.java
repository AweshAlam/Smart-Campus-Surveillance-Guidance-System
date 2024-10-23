package com.smart.surveillance.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.smart.surveillance.Security.JwtAuthenticationEntryPoint;
import com.smart.surveillance.service.CustomeUserService;



@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
	
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	 private JwtAuthenticationEntryPoint point;
	
	 @Autowired
	 private JwtAuthenticationFilter filter;


	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
		
	
	
	@Bean
	public DaoAuthenticationProvider AuthenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService( userDetailsService);
		provider.setPasswordEncoder(passwordEncoder());
		return provider;
	}
	
	 @Bean
	    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
	        return authenticationConfiguration.getAuthenticationManager();
	    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    	   http
           .csrf(csrf -> csrf.disable())
           .authorizeHttpRequests(authz -> authz
               .requestMatchers("/auth/login").permitAll() // allow login without authentication
               .requestMatchers("/admin/**").hasRole("ADMIN")
               .requestMatchers("/student/**").hasRole("STUDENT")
               .anyRequest().authenticated() // other requests must be authenticated
           )
           .exceptionHandling(ex -> ex.authenticationEntryPoint(point))
           .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

       http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);

       return http.build();
    }

   
}
