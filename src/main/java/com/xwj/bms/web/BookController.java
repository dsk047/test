package com.xwj.bms.web;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xwj.bms.entity.Book;
import com.xwj.bms.entity.BookReturn;
import com.xwj.bms.entity.User;
import com.xwj.bms.service.AppointmentService;
import com.xwj.bms.service.BookService;
import com.xwj.bms.service.UserService;

@Controller
@RequestMapping("/book") 
public class BookController {

	@Autowired
	private BookService bookService;

	@Autowired
	private AppointmentService appointment;

	@Autowired
	private UserService userService;


	@RequestMapping("/userBorrow")
	private String userBorrow(HttpSession session,String name,Model model) {
		
		String aa=(String)session.getAttribute("loginUser");
		model.addAttribute("name", aa);
		return "userBorrow";
	}

	/*
	 * 图书归还界面
	 */
	@RequestMapping("/userReturn")
	private String userReturn(Model model,HttpSession session) {
		String aa=(String)session.getAttribute("loginUser");
		List<BookReturn> brList = userService.getBookReturnList(aa);
		/*
		 * 删除无需的内容
		 */
		for (int i = brList.size() - 1; i >= 0; i--) {
			if (!brList.get(i).getState().equals("借阅中")) {
				brList.remove(i);
			}
		}
		model.addAttribute("brList", brList);
		model.addAttribute("name", aa);
		return "userReturn";
	}

	/*
	 * 图书归还功能
	 */
	@ResponseBody
	@RequestMapping("/bookReturn")
	private int bookReturn(String id,Model model,HttpSession session) {
		String aa=(String)session.getAttribute("loginUser");
		Date date=appointment.queryByBookIdAndName(id, aa).getAppointTime();
		User user=userService.queryUserByname(aa);
		int day=user.getDay();
		Date now=new Date();
		int betweenDays = (int) ((now.getTime() - date.getTime()) / (1000*3600*24))+1;
		appointment.reduceAppoint(id, aa);
		bookService.addNumber(Long.parseLong(id), "1");
		if(day>=betweenDays){
			return 1;			
		}else{
			userService.addUserOverdue(aa);
			return 0;				
		}
	}

	/*
	 * 判断查阅图书方式
	 */
	@ResponseBody
	@RequestMapping("/queryBook")
	private List<Book> getBook(Model model, String key, Integer method) {
		System.out.println(key + method);
		List<Book> bList = new ArrayList<Book>();
		switch (method) {
		case 1:
			bList = bookService.getById(key);
			break;
		case 2:
			bList = bookService.getByName(key);
			break;
		case 3:
			bList = bookService.getByPress(key);
			break;
		case 4:
			bList = bookService.getByAuthor(key);
			break;
		case 5:
			bList = bookService.getByType(key);
			break;
		default:
			break;
		}
		if (bList.size() == 0) {
			System.out.println("meiy");
			model.addAttribute("bList", bList);
		} else {
			System.out.println(bList.size());
			model.addAttribute("bList", bList);
		}

		return bList;
	}

	/*
	 * 租借图书
	 */
	@ResponseBody
	@RequestMapping(value = "/getBook", produces = "text/plain;charset=UTF-8")
	private String getBook(String id,HttpSession session) {
		String aa=(String)session.getAttribute("loginUser");
		List<Book> bList = new ArrayList<Book>();
		bList = bookService.getById(id);
		System.out.println(id);
		System.out.println(bList.size());
		if (bList.get(0).getNumber() == 0) {
			return "fail";
		} else {
			if (null == appointment.queryByBookIdAndName(id, aa)) {
				bookService.reduceNumber(bList.get(0).getBookId());
				appointment.insertAppointment(id, aa, "借阅中");
				return "success";
			} else {
				return "more";
			}

		}
	}

	/*
	 * 预约图书
	 */
	@ResponseBody
	@RequestMapping(value = "/appointBook", produces = "text/plain;charset=UTF-8")
	private String appointBook(String id,HttpSession session) {
		String aa=(String)session.getAttribute("loginUser");
		System.out.println("shihou" + appointment.queryByBookIdAndName(id, aa));
		if (bookService.getById(id).get(0).getNumber() > 0) {
			return "预约失败，图书库存充足，请借阅";
		} else if (null != appointment.queryByBookIdAndName(id, aa)) {
			return "已预约，请勿重复操作";
		} else {
			appointment.insertAppointment(id, aa, "预约中");
			return "预约成功，请在七日内查阅图书情况";
		}
	}

}
