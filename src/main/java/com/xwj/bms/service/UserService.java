package com.xwj.bms.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xwj.bms.entity.BookReturn;
import com.xwj.bms.entity.User;

public interface UserService {
	boolean addUser(User u);

	boolean loginUser(String userName,String userPassword);
	
	List<User> queryUser();
	
	List<BookReturn> getBookReturnList(String name);
	
	User queryUserByname(String userName);
	
	int updateUserDay(int day,String userName);
	
	int addUserOverdue(String userName);

}
