package com.ssm.service;

import java.util.List;

import com.ssm.entity.User;

public interface UserService {
	public List<User> getUserList();
	public User getUser(User user);
	public int insertUser(User user);
	public int deleteUser(User user);
	public int updateUser(User user);
	public User findUser(User user);
}
