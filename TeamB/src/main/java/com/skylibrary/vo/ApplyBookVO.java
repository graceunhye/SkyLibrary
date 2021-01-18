package com.skylibrary.vo;

public class ApplyBookVO {
	private int    applyNo; //신청도서번호
	private String userID; //유저아이디
	private String applyISBN; //isbn
	private String applySubject; //희망도서명
	private String applyCompany; //출판사
	private String applyPublicationDate; //출간일
	private String applyDate; //신청일
	private String applyOkDate; //신청완료일
	private String applyWriter; //작가명
	private String applyPrice; //가격
	private int    applyType; //진행여부
	
	public int getApplyNo() {
		return applyNo;
	}
	public void setApplyNo(int applyNo) {
		this.applyNo = applyNo;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getApplyISBN() {
		return applyISBN;
	}
	public void setApplyISBN(String applyISBN) {
		this.applyISBN = applyISBN;
	}
	public String getApplySubject() {
		return applySubject;
	}
	public void setApplySubject(String applySubject) {
		this.applySubject = applySubject;
	}
	public String getApplyCompany() {
		return applyCompany;
	}
	public void setApplyCompany(String applyCompany) {
		this.applyCompany = applyCompany;
	}
	public String getApplyPublicationDate() {
		return applyPublicationDate;
	}
	public void setApplyPublicationDate(String applyPublicationDate) {
		this.applyPublicationDate = applyPublicationDate;
	}
	public String getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(String applyDate) {
		String array[] = applyDate.split(" ");
		this.applyDate = array[0];
	}
	public String getApplyOkDate() {
		return applyOkDate;
	}
	public void setApplyOkDate(String applyOkDate) {
		this.applyOkDate = applyOkDate;
	}
	public String getApplyWriter() {
		return applyWriter;
	}
	public void setApplyWriter(String applyWriter) {
		this.applyWriter = applyWriter;
	}
	public String getApplyPrice() {
		return applyPrice;
	}
	public void setApplyPrice(String applyPrice) {
		this.applyPrice = applyPrice;
	}
	public int getApplyType() {
		return applyType;
	}
	public void setApplyType(int applyType) {
		this.applyType = applyType;
	}
	
	@Override
	public String toString() {
		return "ApplyBookVO [applyNo=" + applyNo + ", userID=" + userID + ", applyISBN=" + applyISBN + ", applySubject="
				+ applySubject + ", applyCompany=" + applyCompany + ", applyPublicationDate=" + applyPublicationDate
				+ ", applyDate=" + applyDate + ", applyOkDate=" + applyOkDate + ", applyWriter=" + applyWriter
				+ ", applyPrice=" + applyPrice + ", applyType=" + applyType + "]";
	}
}
