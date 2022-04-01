package com.example.MovieBookingApplication.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
	private String token;
	private String message;
	
	public UserResponse(String token, String message) {
		super();
		this.token = token;
		this.message = message;
	}

	
	
}
