package com.xwj.bms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xwj.bms.entity.Appointment;
import com.xwj.bms.entity.Book;

public interface AppointmentDao {
	/**
	 * ����ͼ���¼
	 * @param bookId
	 * @param studentId
	 * @return
	 */
	int insertAppointment(@Param("bookId") long bookId, @Param("userName") String userName,@Param("bookState") String bookState);
	/**
	 * ͨ��ͼ���ź�������ѯԤԼͼ���¼
	 * @param bookId
	 * @param userName
	 * @return
	 */
	Appointment queryByBookIdAndName(@Param("bookId")long bookId, @Param("userName")String userName); 
	/**
	 * ͨ���û����Ʋ�ѯԤԼͼ���¼
	 * @param userName
	 * @return
	 */
	List<Appointment> queryByUserName(String userName);

	/**
	 * �޸�ͼ��״̬
	 * @param bookId
	 * @param studentId
	 * @return
	 */
	int updateBook(String bookState);
	/**
	 * ͨ��������ѯ��Ӧ�鼮
	 * @param userName
	 * @return
	 */
	List<Book> queryByUserNameWithBook(String userName);
	/**
	 * ͨ��ͼ����ɾ��ͼ���¼
	 * @param bookId
	 * @return
	 */
	int reduceAppoint(@Param("bookId")long bookId,@Param("userName")String userName);
}
