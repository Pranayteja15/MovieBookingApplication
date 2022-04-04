package com.example.MovieBookingApplication.Controllers;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.MovieBookingApplication.Jwtutil.JwtUtil;
import com.example.MovieBookingApplication.Model.UserDTO;
import com.example.MovieBookingApplication.ServiceImpl.CookieService;
import com.example.MovieBookingApplication.ServiceImpl.MyUserDetailsService;



@Controller
public class UserController {

    @Autowired
	private MyUserDetailsService userDetailsService;
	
    @Autowired
    private JwtUtil jwtTokenUtil;
    
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	CookieService cookieService;

	@GetMapping("/login")
	public String login(){	
		return "Login.jsp";
}
	@GetMapping("/signup")
	public String signup(){	
		return "Signup.jsp";
}
	
	@PostMapping("/register")
	public String saveUser(UserDTO user) throws Exception {
		userDetailsService.save(user);
		
		return "redirect:/login";
}
	
	
	@PostMapping("/checkLogin")
	public String checkUser(@RequestParam("username") String email,
			@RequestParam("password") String password,HttpServletResponse resp) throws Exception {
		
		
		try {
			authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(email, password));
			
			final UserDetails userDetails = userDetailsService.loadUserByUsername(email);
			
			final String jwt = jwtTokenUtil.generateToken(userDetails);
			
			resp.addCookie(cookieService.getJwtCookie(jwt));
			
			return "redirect:/";	
	        }	
		catch(BadCredentialsException e) {
			return "redirect:/users/login?messasg=Invalid+email+or+password&status=danger&show=show";
		}
	
	}	
	
}