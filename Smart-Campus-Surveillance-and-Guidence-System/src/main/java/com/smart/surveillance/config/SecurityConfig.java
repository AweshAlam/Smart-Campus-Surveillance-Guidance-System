package com.smart.surveillance.config;

import java.util.Arrays;
import java.util.Collections;

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
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.smart.surveillance.Security.JwtAuthenticationEntryPoint;
import com.smart.surveillance.service.CustomeUserService;

import jakarta.servlet.http.HttpServletRequest;



@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@EnableWebMvc
public class SecurityConfig implements WebMvcConfigurer {
	
	@Autowired
	private CustomeUserService userDetailsService;
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
    	   
    	   
    	   
    	   
    	   .cors(corsConfig -> corsConfig.configurationSource(new CorsConfigurationSource() {
               @Override
               public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                   CorsConfiguration config = new CorsConfiguration();
                   config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
                   config.setAllowedMethods(Collections.singletonList("*"));
                   config.setAllowCredentials(true);
                   config.setAllowedHeaders(Collections.singletonList("*"));
                   config.setExposedHeaders(Arrays.asList("Authorization"));
                   config.setMaxAge(3600L);
                   return config;
               }
           }))
    	   
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
  
//    public void addCorsMappings(CorsRegistry corsRegistry) {
//        corsRegistry.addMapping("/**")
//                    .allowedOrigins("http://localhost:4200")
//                    .allowedMethods("*")
//                    .maxAge(3600L)
//                    .allowedHeaders("*")
//                    .exposedHeaders("Authorization")
//                    .allowCredentials(true);
//    }
   
}
