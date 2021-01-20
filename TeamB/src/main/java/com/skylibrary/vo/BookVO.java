package com.skylibrary.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class BookVO extends SessionVO {
	
	private String bookISBN;            //isbn
	private String bookSubject;         //책제목
	private String bookStory;           //줄거리
	private int    bookCount;           //책개수
	private String bookCompany;         //출판사
	private String bookWriter;          //지은이
	private String bookPublicationDate; //출판일
	private int    bookRent;            //대여여부
	private String bookCoverImg;        //책커버이미지
	
	private String userID;        //회원 아이디
	private String rentStartDate; //책 대여시작일
	private String rentEndDate;   //책 반납예정일
	private int rentNo;
	
	
//	
//	public int getNo() {
//		return no;
//	}
//	public void setNo(int no) {
//		this.no = no;
//	}
//	public String getUserID() {
//		return userID;
//	}
//	public void setUserID(String userID) {
//		this.userID = userID;
//	}
//	public String getRentStartDate() {
//		return rentStartDate;
//	}
//	public void setRentStartDate(String rentStartDate) {
//		this.rentStartDate = rentStartDate;
//	}
//	public String getRentEndDate() {
//		return rentEndDate;
//	}
//	public void setRentEndDate(String rentEndDate) {
//		this.rentEndDate = rentEndDate;
//	}
//	public int getRentNo() {
//		return rentNo;
//	}
//	public void setRentNo(int rentNo) {
//		this.rentNo = rentNo;
//	}
//	public String getBookISBN() {
//		return bookISBN;
//	}
//	public void setBookISBN(String bookISBN) {
//		this.bookISBN = bookISBN;
//	}
//	public String getBookSubject() {
//		return bookSubject;
//	}
//	public void setBookSubject(String bookSubject) {
//		this.bookSubject = bookSubject;
//	}
//	public String getBookStory() {
//		return bookStory;
//	}
//	public void setBookStory(String bookStory) {
//		this.bookStory = bookStory;
//	}
//	public int getBookCount() {
//		return bookCount;
//	}
//	public void setBookCount(int bookCount) {
//		this.bookCount = bookCount;
//	}
//	public String getBookCompany() {
//		return bookCompany;
//	}
//	public void setBookCompany(String bookCompany) {
//		this.bookCompany = bookCompany;
//	}
//	public String getBookWriter() {
//		return bookWriter;
//	}
//	public void setBookWriter(String bookWriter) {
//		this.bookWriter = bookWriter;
//	}
//	public String getBookPublicationDate() {
//		return bookPublicationDate;
//	}
//	public void setBookPublicationDate(String bookPublicationDate) {
//		this.bookPublicationDate = bookPublicationDate;
//	}
//	public int getBookRent() {
//		return bookRent;
//	}
//	public void setBookRent(int bookRent) {
//		this.bookRent = bookRent;
//	}
//	public String getBookCoverImg() {
//		return bookCoverImg;
//	}
//	public void setBookCoverImg(String bookCoverImg) {
//		this.bookCoverImg = bookCoverImg;
//	}
		
	
}
