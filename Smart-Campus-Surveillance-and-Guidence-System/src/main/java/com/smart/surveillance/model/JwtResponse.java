package com.smart.surveillance.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Data
//@Builder
//@Setter
//@Getter
//@AllArgsConstructor
//@NoArgsConstructor
public class JwtResponse {
	
	 private String jwtToken;
	    private String username;

	    // Private constructor to prevent direct instantiation
	    private JwtResponse(Builder builder) {
	        this.jwtToken = builder.jwtToken;
	        this.username = builder.username;
	    }

	    // Getters
	    public String getJwtToken() {
	        return jwtToken;
	    }

	    public String getUsername() {
	        return username;
	    }

	    // Static Builder class
	    public static class Builder {
	        private String jwtToken;
	        private String username;

	        // Setter method for jwtToken
	        public Builder setJwtToken(String jwtToken) {
	            this.jwtToken = jwtToken;
	            return this;
	        }

	        // Setter method for username
	        public Builder setUsername(String username) {
	            this.username = username;
	            return this;
	        }

	        // Build method to create an instance of JwtResponse
	        public JwtResponse build() {
	            return new JwtResponse(this);
	        }
	    }

	    // toString method for easy representation
	    @Override
	    public String toString() {
	        return "JwtResponse{" +
	                "jwtToken='" + jwtToken + '\'' +
	                ", username='" + username + '\'' +
	                '}';
	    }

		
	
	
	

}
