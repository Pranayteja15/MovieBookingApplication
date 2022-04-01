package com.example.MovieBookingApplication.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MovieBookingApplication.Model.UsersData;



public interface UserRepository extends JpaRepository<UsersData, Integer> {

	Optional<UsersData>findByUserName(String userName);
}