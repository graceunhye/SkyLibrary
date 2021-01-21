package com.skylibrary.vo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ApplyBookVO extends SessionVO {
	private int    applyNo;              //신청도서번호
	private String userID;               //유저아이디
	private String applyISBN;            //isbn
	private String applySubject;         //희망도서명
	private String applyCompany;         //출판사
	private String applyPublicationDate; //출간일
	private String applyDate;            //신청일
	private String applyOkDate;          //신청완료일
	private String applyWriter;          //작가명
	private String applyPrice;           //가격
	private int    applyType;            //진행여부

	
	public void setApplyDate(String applyDate) {
		String array[] = applyDate.split(" ");
		this.applyDate = array[0];
	}


	@Override
	public String toString() {
		return "ApplyBookVO [applyNo=" + applyNo + ", userID=" + userID + ", applyISBN=" + applyISBN + ", applySubject="
				+ applySubject + ", applyCompany=" + applyCompany + ", applyPublicationDate=" + applyPublicationDate
				+ ", applyDate=" + applyDate + ", applyOkDate=" + applyOkDate + ", applyWriter=" + applyWriter
				+ ", applyPrice=" + applyPrice + ", applyType=" + applyType + "]";
	}

}
