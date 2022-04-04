package com.example.MovieBookingApplication.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MovieBookingApplication.Model.DAOUser;



public interface UserDao extends JpaRepository<DAOUser, Integer> {

	DAOUser findByUsername(String username);
}