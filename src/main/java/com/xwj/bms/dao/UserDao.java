package com.xwj.bms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xwj.bms.entity.User;

public interface UserDao {
	public void addUser(User user);
	
	public List<User> queryUser();
	
	public User queryUserByname(String userName);
	
	public int updateUserDay(@Param("day")int day,@Param("userName")String userName);
	
	public int addUserOverdue(String userName);
}
