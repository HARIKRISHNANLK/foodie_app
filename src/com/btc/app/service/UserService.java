package com.btc.app.service;

import java.sql.SQLException;
import java.util.List;

import com.btc.app.model.Restaurant;
import com.btc.app.model.User;

public interface UserService {
public User addUser(User user) throws SQLException;
	
	public User searchUserById(int userId) throws SQLException;
	
	public boolean deleteUserById(int userId) throws SQLException;
	
	public boolean userLogIn(String email,String password) throws SQLException;
	
	public User updateUser(User user) throws SQLException;
	
	public List<User> getAllUser() throws SQLException;




}