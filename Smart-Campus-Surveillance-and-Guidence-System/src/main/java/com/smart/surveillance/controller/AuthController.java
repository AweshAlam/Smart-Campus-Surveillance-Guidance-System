package com.smart.surveillance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smart.surveillance.Security.JwtHelper;
import com.smart.surveillance.model.JwtRequest;
import com.smart.surveillance.model.JwtResponse;


@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

	 @Autowired
	    private UserDetailsService userDetailsService;

	    @Autowired
	    private AuthenticationManager authenticationManager;

	    @Autowired
	    private JwtHelper jwtHelper;
	    
	    @CrossOrigin(origins = "http://localhost:4200")
	    @PostMapping
	    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request) {
	        authenticate(request.getUsername(), request.getPassword());

	        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
	        String token = jwtHelper.generateToken(userDetails);

	        JwtResponse response = new JwtResponse.Builder()
	                .setJwtToken(token)
	                .setUsername(userDetails.getUsername())
	                .build();

	        return new ResponseEntity<>(response, HttpStatus.OK); 
	    }

	    private void authenticate(String username, String password) {
	        UsernamePasswordAuthenticationToken authenticationToken = 
	                new UsernamePasswordAuthenticationToken(username, password);

	        try {
	            authenticationManager.authenticate(authenticationToken);
	        } catch (BadCredentialsException e) {
	            throw new BadCredentialsException("Invalid Username or Password");
	        }
	    }

	    @ExceptionHandler(BadCredentialsException.class)
	    public ResponseEntity<String> handleBadCredentials() {
	        return new ResponseEntity<>("Invalid Credentials!", HttpStatus.UNAUTHORIZED);
	    }
}
