package com.example.MovieBookingApplication.IUserService;

import java.util.Optional;

import com.example.MovieBookingApplication.Model.UsersData;

public interface IuserService {
	Integer saveUser(UsersData usersdata);
	Optional<UsersData> findByUsername(String username);

}
