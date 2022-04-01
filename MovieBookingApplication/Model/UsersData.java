package com.example.MovieBookingApplication.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

@Entity
@Table(name="usersdata")
public class UsersData {
	
@Id

private int id;
private String userName;

private String email;

public String password;



public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

@Override
public String toString() {
	return "UsersData [id=" + id + ", userName=" + userName + ", email=" + email + ", password=" + password + "]";
}


}







