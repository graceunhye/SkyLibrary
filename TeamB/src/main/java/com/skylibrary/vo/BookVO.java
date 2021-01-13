package com.skylibrary.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class BookVO {
	
	private String bookISBN;            //isbn
	private String bookSubject;         //책제목
	private String bookStory;           //줄거리
	private int    bookCount;           //책개수
	private String bookCompany;         //출판사
	private String bookWriter;          //지은이
	private String bookPublicationDate; //출판일
	private int    bookRent;            //대여여부
	private String bookCoverImg;        //책커버이미지
		
	
}
