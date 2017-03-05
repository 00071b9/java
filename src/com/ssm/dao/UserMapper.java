package com.ssm.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssm.entity.User;
/**
 * UserMapper
 * @author xiao
 *
 */
@Repository
public interface UserMapper {
	public List<User> getUserList();
	public User getUser(User user);
	public int insertUser(User user);
	public int deleteUser(User user);
	public int updateUser(User user);
	public User findUser(User user);
	
}
