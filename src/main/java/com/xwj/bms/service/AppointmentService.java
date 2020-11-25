package com.xwj.bms.service;

import java.util.List;

import com.xwj.bms.entity.Appointment;
import com.xwj.bms.entity.Book;

public interface AppointmentService {
	/**
	 * ����ԤԼͼ���¼
	 * 
	 * @param bookId
	 * @param studentId
	 * @return
	 */
	int insertAppointment(String bookId, String userName, String bookState);

	/**
	 * ͨ��ͼ���ź�������ѯԤԼͼ���¼
	 * 
	 * @param bookId
	 * @param name
	 * @return
	 */
	Appointment queryByBookIdAndName(String bookId,String name);

	/**
	 * ͨ���û����Ʋ�ѯԤԼͼ���¼
	 * 
	 * @param userName
	 * @return
	 */
	List<Appointment> queryByUserName(String userName);
	/**
	 * ͨ���û����Ʋ�ѯͼ��
	 * 
	 * @param userName
	 * @return
	 */
	List<Book> queryByUserNameWithBook(String userName);
	
	int reduceAppoint(String bookId,String name);
}
