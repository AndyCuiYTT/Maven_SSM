package com.andy.service;

import java.util.List;

import com.andy.pojo.User;

public interface IUserService {

	
	public User getUserById(int userId);
	
	public int insertUser(User user);
	
	public List<User> getAllUsers();
	
	public int updateUser(User user); 
	

}
