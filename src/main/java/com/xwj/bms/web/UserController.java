package com.xwj.bms.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.xwj.bms.entity.BookReturn;
import com.xwj.bms.entity.User;
import com.xwj.bms.service.AppointmentService;
import com.xwj.bms.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	@Autowired
	private AppointmentService appointment;
	
	@RequestMapping("/main")
	private String user(HttpSession session,Model model) {		
		String aa=(String)session.getAttribute("loginUser");
		model.addAttribute("name", aa);
		return "user";
	}
	
	
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String loginUser(HttpSession session,User user) {
		System.out.println(user.getUserName());		
		boolean istrue = userService.loginUser(user.getUserName(), user.getUserPassword());
		if(istrue){
			System.out.println("renming"+user.getUserName());
			
			return "success";
			
		}else
		return "error";
	}
	
	@RequestMapping("/userInformation")
	public String userInformation(Model model,HttpSession session){
		
		String aa=(String)session.getAttribute("loginUser");
		List<BookReturn> brList = userService.getBookReturnList(aa);

		
		model.addAttribute("brList", brList);

		model.addAttribute("name", aa);
		model.addAttribute("overdue",userService.queryUserByname(aa).getOverdue());
		model.addAttribute("time",userService.queryUserByname(aa).getDay());
		return "userInformation";		
	}
}
