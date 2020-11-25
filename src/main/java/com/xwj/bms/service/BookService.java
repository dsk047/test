package com.xwj.bms.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xwj.bms.entity.Book;

/**
 * ҵ��ӿڣ�վ��"ʹ����"�Ƕ���ƽӿ� �������棺�����������ȣ��������������ͣ�return ����/�쳣��
 */
public interface BookService {

    /**
     * ��ѯһ��ͼ��
     * 
     * @param bookId
     * @return
     */
	Book queryBook(String bookName,String type,String press,String author);
	
    List<Book> getById(String bookId);
    
    List<Book> getByName(String name);

    List<Book> getByType(String type);
    
    List<Book> getByPress(String press);
    
    List<Book> getByAuthor(String Author);
    
    int reduceNumber(long bookId);
    
    int addNumber(long bookId,String number);
    
    int updateBook(Book book);

    void addBook(String name,String number,String type, String press,String author);
    
    List<Book> queryAllBook();
}
