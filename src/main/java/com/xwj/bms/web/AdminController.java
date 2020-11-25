package com.xwj.bms.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xwj.bms.entity.Book;
import com.xwj.bms.entity.User;
import com.xwj.bms.service.BookService;
import com.xwj.bms.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private UserService userService;
	@Autowired
	private BookService bookService;
	/**
	 * 显示首页
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("/main")
	private String main(HttpSession session,Model model) {
		
		String aa=(String)session.getAttribute("loginAdmin");
		model.addAttribute("name", aa);
		return "admin";
	}
	/**
	 * 跳转添加用户界面
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("/addUsers")
	public String addUsers(HttpSession session,Model model) {
		String aa=(String)session.getAttribute("loginAdmin");
		model.addAttribute("name", aa);		
		return "addUser";
		
	}
	/**
	 * 添加用户
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addUser")
	public int addUser(HttpSession session,Model model,String name,String passage,String day,String phone) {
		String aa=(String)session.getAttribute("loginAdmin");
		model.addAttribute("name", aa);
		User user = new User(name, passage, phone,Integer.parseInt(day),0);
		if (userService.addUser(user)) {
			return 1;
		} else {
			return 0;
		}
	}
	/**
	 * 显示添加界面
	 * @return
	 */
	@RequestMapping("/addBooks")
	public String addBooks(HttpSession session,Model model){
		String aa=(String)session.getAttribute("loginAdmin");
		model.addAttribute("name", aa);
		return "addBooks";
	}
	/**
	 * 添加书籍功能
	 * @param name
	 * @param number
	 * @param type
	 * @param press
	 * @param author
	 * @return
	 */
	@RequestMapping("/addBook")
	public String manageBooks(String name,String number,String type, String press,String author,HttpSession session,Model model){
		String aa=(String)session.getAttribute("loginAdmin");
		model.addAttribute("name", aa);
		if(null==bookService.queryBook(name, type, press, author)){
			bookService.addBook(name, number, type, press, author);
		}else{
			long bookId=bookService.queryBook(name, type, press, author).getBookId();
			bookService.addNumber(bookId, number);
		}		
		return "addBooks";
	}
	/**
	 * 显示所有用户界面
	 * @param name
	 * @param model
	 * @return
	 */
	@RequestMapping("/manageUsers")
	public String manageUsers(String name,HttpSession session,Model model){
		String aa=(String)session.getAttribute("loginAdmin");
		model.addAttribute("name", aa);
		List<User> uList=userService.queryUser();
		model.addAttribute("uList", uList);
		return "manageUsers";
	}
	/**
	 * 修改用户借阅时间
	 * @param name
	 * @param day
	 * @param model
	 * @return
	 */
	@RequestMapping("updateDay")
	public String updateDay(String name,int day,Model model,HttpSession session){
		String aa=(String)session.getAttribute("loginAdmin");
		model.addAttribute("name", aa);
		userService.updateUserDay(day, name);
		List<User> uList=userService.queryUser();
		model.addAttribute("uList", uList);
		return "manageUsers";
	}
	/**
	 * 修改图书界面
	 * @param model
	 * @return
	 */
	@RequestMapping("/updateBooks")
	public String updateBooks(Model model,HttpSession session){
		String aa=(String)session.getAttribute("loginAdmin");
		model.addAttribute("name", aa);
		List<Book> bList= bookService.queryAllBook();
		model.addAttribute("bList", bList);
		return "updateBooks";
	}
	@ResponseBody
	@RequestMapping("/updateBook")
	public int updateBooks(@RequestParam("arr[]")List<String> arr,Model model,HttpSession session){
		String aa=(String)session.getAttribute("loginAdmin");
		model.addAttribute("name", aa);
		
		Book book=new Book(Long.parseLong(arr.get(0)),arr.get(1),Integer.parseInt(arr.get(5)), arr.get(2), arr.get(3), arr.get(4));
		bookService.updateBook(book);
		return 1;
	}
	
}
