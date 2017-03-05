package com.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.dao.UserMapper;
import com.ssm.entity.User;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	public UserMapper getMapper() {
		return userMapper;
	}

	public void setMapper(UserMapper mapper) {
		this.userMapper = mapper;
	}

	public int deleteUser(User user) {
		return userMapper.deleteUser(user);
	}

	public User getUser(User user) {
		return userMapper.getUser(user);
	}

	public List<User> getUserList() {
		return userMapper.getUserList();
	}

	public int insertUser(User user) {
		return userMapper.insertUser(user);
	}

	public int updateUser(User user) {
		return userMapper.updateUser(user);
	}

	@Override
	public User findUser(User user) {
		return userMapper.findUser(user);
	}

}
