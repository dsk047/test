package com.xwj.bms.entity;

public class Book {
	

	private long bookId;
		
	private String bookName;
	
	private int number;
	
	private String type;
	
	private String press;
	
	private String author;

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPress() {
		return press;
	}

	public void setPress(String press) {
		this.press = press;
	}

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", number=" + number + ", type=" + type
				+ ", press=" + press + ", author=" + author + "]";
	}

	public Book(String bookName, int number, String type, String press, String author) {
		super();
		this.bookName = bookName;
		this.number = number;
		this.type = type;
		this.press = press;
		this.author = author;
	}

	public Book(long bookId, String bookName, int number, String type, String press, String author) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.number = number;
		this.type = type;
		this.press = press;
		this.author = author;
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
