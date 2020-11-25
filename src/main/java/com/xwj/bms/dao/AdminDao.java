package com.xwj.bms.dao;

import com.xwj.bms.entity.Admin;

public interface AdminDao {
	
	public Admin queryAdminByname(String adminName);
}
