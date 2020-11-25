package com.xwj.bms.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xwj.bms.service.AdminService;
import com.xwj.bms.service.UserService;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	@Autowired
	private AdminService adminService;
	
	@RequestMapping("/user")
	private String user(Model model,String name) {
		model.addAttribute("name", name);
		return "user";
	}
	
	@RequestMapping("/admin")
	private String admin(Model model,String name) {
		model.addAttribute("name", name);
		return "admin";
	}
	/**
	 * µÇÂ¼¹¦ÄÜ
	 * @param name
	 * @param password
	 * @param type
	 * @param session
	 * @return
	 */
	@ResponseBody 
	@RequestMapping("/login")
	public int login(String name, String password, String type,HttpSession session) {
		if (type.equals("user")) {
			session.setAttribute("loginUser", name);
			if (userService.loginUser(name, password)) {				
				return 0;
			} else {				
				return 1;
			}
		} else {
			session.setAttribute("loginAdmin", name);
			if (adminService.loginAdmin(name, password)) {
				return 2;
			} else {
				return 3;
			}
		}

	}



}
