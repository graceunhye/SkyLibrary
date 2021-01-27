package com.skylibrary.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class BookVO extends SessionVO {

	//book 테이블
	private int no;
	private String bookISBN;            //isbn
	private String bookSubject;         //책제목
	private String bookStory;           //줄거리
	private int    bookCount;           //책개수
	private String bookCompany;         //출판사
	private String bookWriter;          //지은이
	private String bookPublicationDate; //출판일
	private int    bookRent;            //대여여부
	private String bookCoverImg;        //책커버이미지
	
	//rent 테이블
	private String userID;        //회원 아이디
	private String rentStartDate; //책 대여시작일
	private String rentEndDate;   //책 반납예정일
	private int rentNo;
	
	//rbook 테이블
	private int recommendNo;
	private String recommendWhy;
	

	public void setRentStartDate(String rentStartDate) {
		String[] array = rentStartDate.split(" ");
		this.rentStartDate = array[0];
	}

	public void setRentEndDate(String rentEndDate) {
		String[] array = rentEndDate.split(" ");
		this.rentEndDate = array[0];
	}

		
	
}
