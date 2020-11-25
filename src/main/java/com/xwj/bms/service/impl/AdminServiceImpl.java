package com.xwj.bms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xwj.bms.dao.AdminDao;
import com.xwj.bms.entity.Admin;
import com.xwj.bms.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminDao adminDao;

	public boolean loginAdmin(String adminName, String adminPassword) {
		Admin admin = adminDao.queryAdminByname(adminName);

		if (admin == null) {
			return false;
		} else if (adminPassword.equals(admin.getAdminPassword())) {
			return true;
		} else
			return false;
	}

}
