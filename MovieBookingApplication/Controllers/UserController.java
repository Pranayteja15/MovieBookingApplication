package com.example.MovieBookingApplication.Controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MovieBookingApplication.IUserService.IuserService;
import com.example.MovieBookingApplication.Jwtutil.JwtUtil;
import com.example.MovieBookingApplication.Model.UserRequests;
import com.example.MovieBookingApplication.Model.UserResponse;
import com.example.MovieBookingApplication.Model.UsersData;



@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private IuserService service;

	@Autowired
	private JwtUtil jwtUtil;

	@PostMapping("/save")
	public ResponseEntity<String> saveUser(@RequestBody UsersData user) {
		Integer id=service.saveUser(user);
		return ResponseEntity.ok("User saved with id"+id);
	}

	@PostMapping("/login")
	public ResponseEntity<UserResponse> loginUser(@RequestBody UserRequests userRequest)
	{

		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						userRequest.getUserName(),
						userRequest.getPassword()
						)
				);

		String token=jwtUtil.generateToken(userRequest.getUserName());

		return ResponseEntity.ok(new UserResponse(token,"Token Generated"));
	}
	
	@PostMapping("/welcome")
	public ResponseEntity<String> accessUserData(Principal p) {
		return ResponseEntity.ok("Hello user:"+p.getName());
	}


}