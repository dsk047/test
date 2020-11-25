package com.xwj.bms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xwj.bms.entity.Book;
import com.xwj.bms.entity.User;

public interface BookDao {
	/**
	 * ��ѯ�Ƿ����ظ���ͼ��
	 */

	Book queryBook(@Param("bookName")String bookName,@Param("type")String type,@Param("press")String press,@Param("author")String author);
	/**
	 * ͨ��id����ͼ��
	 */

	List<Book> queryById(long bookId);
	/**
	 * ͨ����������ͼ��
	 */
	List<Book> queryByName(String bookName);
	/**
	 * ͨ��type����ͼ��
	 */

	List<Book> queryByType(String type);

	/**
	 * ͨ��press����ͼ��
	 */

	List<Book> queryByPress(String press);
	
	/**
	 * ͨ��author����ͼ��
	 */

	List<Book> queryByAuthor(String author);

	/**
	 * ���ٲ��������
	 */
	public int reduceNumber(long bookId);
	/**
	 * ���Ӳ��������
	 */
	public int addNumber(@Param("bookId")long bookId,@Param("number")int number);
	/**
	 * �޸�ͼ����Ϣ
	 */
	public int updateBook(Book book);
	/**
	 * ���ͼ��
	 */
	public void addBook(Book book);
	
	public List<Book> queryAllBook();
}
