package com.xwj.bms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xwj.bms.dao.AppointmentDao;
import com.xwj.bms.entity.Appointment;
import com.xwj.bms.entity.Book;
import com.xwj.bms.service.AppointmentService;
@Service
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	private AppointmentDao appoint;
	
	public int insertAppointment(String bookId, String userName,String bookState) {
		// TODO Auto-generated method stub
		return appoint.insertAppointment(Long.parseLong(bookId), userName, bookState);
	}


	public Appointment queryByBookIdAndName(String bookId,String name) {
		
		return appoint.queryByBookIdAndName(Long.parseLong(bookId),name);
	}

	public List<Appointment> queryByUserName(String userName) {
		
		return appoint.queryByUserName(userName);
	}
	
	public List<Book> queryByUserNameWithBook(String userName){
		
		return appoint.queryByUserNameWithBook(userName);
		
	}


	public int reduceAppoint(String bookId,String name) {
		return appoint.reduceAppoint(Long.parseLong(bookId),name);
	}
			


}
