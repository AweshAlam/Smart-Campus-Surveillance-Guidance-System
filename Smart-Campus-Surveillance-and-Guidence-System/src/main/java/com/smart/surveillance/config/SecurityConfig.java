package com.smart.surveillance.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        PasswordEncoder encoder = passwordEncoder();

        UserDetails admin = User.withUsername("admin")
                .password(encoder.encode("12345"))
                .roles("ADMIN")
                .build();

        UserDetails employee = User.withUsername("employee")
                .password(encoder.encode("12345"))
                .roles("EMPLOYEE")
                .build();
        
        UserDetails student = User.withUsername("student")
                .password(encoder.encode("12345"))
                .roles("STUDENT")
                .build();

        return new InMemoryUserDetailsManager(admin, employee, student);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
            .authorizeHttpRequests((requests) -> requests
                .requestMatchers(new AntPathRequestMatcher("/user")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/newuser")).permitAll()
                .anyRequest().authenticated()
            )
            .httpBasic(); // Enables basic authentication

        return http.build();
    }
//    public void securityFilterChain(HttpSecurity http) throws Exception{
//    	http.authorizeRequests()
//    			.anyRequest().authenticated()
//    			.and().oauth2Login();
//    	
//    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }
}