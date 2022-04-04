package com.example.MovieBookingApplication.Model;

public class UserResponse {
	
	private final String jwt;

	public String getJwt() {
		return jwt;
	}

	public UserResponse(String jwt) {
		super();
		this.jwt = jwt;
	}


	

}
