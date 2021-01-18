package com.skylibrary.vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class RentVO {
	
	private int    rentNo; //대출번호
	private String userID; //사용자아이디
	private String bookISBN; //isbn
	private String bookSubject; //책제목
	private String bookWriter; //작가명
	private String rentStartDate; //대출시작일
	private String rentEndDate; //반납예정일
	private int    compare; //연장 기준값
	
	public RentVO() throws ParseException {
		setCompare(this.rentStartDate, this.rentEndDate);
	}
	
	public int getCompare() {
		return compare;
	}
	
	public void setCompare(String rentStartDate, String rentEndDate) throws ParseException {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date start_d = dateFormat.parse(rentStartDate);
		Date end_d = dateFormat.parse(rentEndDate);
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(start_d);
		cal.add(Calendar.DATE,14);
		
		String startd_add = dateFormat.format(cal.getTime());
		Date startadd_d = dateFormat.parse(startd_add);
		
		this.compare = end_d.compareTo(startadd_d);
	}
	
	public String getBookSubject() {
		return bookSubject;
	}
	public void setBookSubject(String bookSubject) {
		this.bookSubject = bookSubject;
	}

	public String getBookWriter() {
		return bookWriter;
	}
	public void setBookWriter(String bookWriter) {
		this.bookWriter = bookWriter;
	}
	public int getRentNo() {
		return rentNo;
	}
	public void setRentNo(int rentNo) {
		this.rentNo = rentNo;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getBookISBN() {
		return bookISBN;
	}
	public void setBookISBN(String bookISBN) {
		this.bookISBN = bookISBN;
	}
	public String getRentStartDate() {
		return rentStartDate;
	}
	public void setRentStartDate(String rentStartDate) {
		String[] array = rentStartDate.split(" ");
		this.rentStartDate = array[0];
	}
	public String getRentEndDate() {
		return rentEndDate;
	}
	public void setRentEndDate(String rentEndDate) {
		String[] array = rentEndDate.split(" ");
		this.rentEndDate = array[0];
	}
	
	
}
