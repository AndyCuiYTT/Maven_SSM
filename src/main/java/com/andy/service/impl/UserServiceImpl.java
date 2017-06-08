package com.andy.service.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andy.dao.UserMapper;
import com.andy.pojo.User;
import com.andy.service.IUserService;

@Service("userService")  
public class UserServiceImpl implements IUserService{

	@Autowired
	private  UserMapper userMapper;
	
	@Override
	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		return this.userMapper.selectByPrimaryKey(userId);
	}

	@Override
	public int insertUser(User user) {
		// TODO Auto-generated method stub
		return this.userMapper.insert(user);
		
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		
		List<User> users = this.userMapper.getAllUsers();
		
		
		return users;
	}

	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.updateByPrimaryKeySelective(user);
	}
	
	
	
	

}
