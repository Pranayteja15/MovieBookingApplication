package com.example.MovieBookingApplication.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.MovieBookingApplication.Jwtutil.JwtUtil;
import com.example.MovieBookingApplication.ServiceImpl.MyUserDetailsService;



@Controller
public class SpringController {
    @Autowired
	private MyUserDetailsService userDetailsService;
	
    @Autowired
    private JwtUtil jwtTokenUtil;
    
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@GetMapping("/")
	public String hello() {
		
		return "Index.jsp";
	}
	

	
}