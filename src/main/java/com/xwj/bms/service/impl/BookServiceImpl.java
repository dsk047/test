package com.xwj.bms.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xwj.bms.dao.BookDao;
import com.xwj.bms.entity.Book;
import com.xwj.bms.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookDao bookDao;
	
	public List<Book> getByName(String name) {
		if(name==""){
			return  new ArrayList<Book>();
		}else{
			return bookDao.queryByName(name);
		}

	}
	public List<Book> getById(String bookId) {
		Pattern pattern = Pattern.compile("[0-9]*");
		if(bookId==""){
			return  new ArrayList<Book>();		
		}else{
			Matcher isNum = pattern.matcher(bookId);
			if(!isNum.matches()){
	        	return new ArrayList<Book>();
	        }else{
	        	return bookDao.queryById(Long.parseLong(bookId));
	        }
		}

	}
	public List<Book> getByType(String type) {
		if(type==""){
			return  new ArrayList<Book>();
		}else{
			return bookDao.queryByType(type);
		}
	}
	public List<Book> getByPress(String press) {
		if(press==""){
			return  new ArrayList<Book>();
		}else{
			return bookDao.queryByPress(press);
		}

	}
	public List<Book> getByAuthor(String author){
		if(author==""){
			return  new ArrayList<Book>();
		}else{
			return bookDao.queryByAuthor(author);
		}
	}
	public int reduceNumber(long bookId) {
		return bookDao.reduceNumber(bookId);

	}
	public int addNumber(long bookId,String number) {
		return bookDao.addNumber(bookId,Integer.valueOf(number));

	}
	
	public int updateBook(Book book){
		return bookDao.updateBook(book);
		
	}
	public void addBook(String name, String number, String type, String press, String author) {
		Book book=new Book(name, Integer.valueOf(number).intValue(), type, press, author);
		bookDao.addBook(book);
	}
	public Book queryBook(String bookName, String type, String press, String author) {
		// TODO Auto-generated method stub
		return bookDao.queryBook(bookName, type, press, author);
	}
	public List<Book> queryAllBook() {
		// TODO Auto-generated method stub
		return bookDao.queryAllBook();
	}
	
	}
	
	
	


