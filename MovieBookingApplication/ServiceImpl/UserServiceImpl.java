package com.example.MovieBookingApplication.ServiceImpl;

import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import com.example.MovieBookingApplication.IUserService.IuserService;
import com.example.MovieBookingApplication.Model.UsersData;
import com.example.MovieBookingApplication.repo.UserRepository;

import antlr.collections.List;

public class UserServiceImpl implements IuserService {
	@Autowired
	private UserRepository repo;
	@Autowired
	private BCryptPasswordEncoder pwdEncoder;
	@Override
public Integer saveUser(UsersData usersdata)
{
		usersdata.setPassword(
		pwdEncoder.encode(usersdata.getPassword()));
	return repo.save(usersdata).getId();
}
	@Override
	public Optional<UsersData> findByUsername(String username)
	{
		return repo.findByUserName(username);
	}
	@Transactional
	public User loadUserByUsername(String username) 
			throws UsernameNotFoundException 
	{
		Optional<UsersData> user=findByUsername(username); 
		if(user==null) 
			throw new UsernameNotFoundException(
					new StringBuffer()
					.append("User name ")
					.append(username)
					.append(" not found!")
					.toString()
					);

		
		return new org.springframework.security.core.userdetails.User(
				username, 
				null, null);
	}
}
