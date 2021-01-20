package com.skylibrary.vo;

import org.springframework.web.multipart.MultipartFile;

public class NoticeVO extends SessionVO {
	private int noticeNo; //공지번호
	private String noticeTitle; //공지제목
	private String noticeBody; //공지내용
	private String noticeDate; //공지날짜
	private int noticeHit; //공지 조회수
	private String noticeFile; //첨부파일
	
	private String userID;        //회원 아이디
	
	//파일 업로드
	private String fileName;
	private MultipartFile uploadFile;
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public MultipartFile getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}
	public int getNoticeNo() {
		return noticeNo;
	}
	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getNoticeBody() {
		return noticeBody;
	}
	public void setNoticeBody(String noticeBody) {
		this.noticeBody = noticeBody;
	}
	public int getNoticeHit() {
		return noticeHit;
	}
	public void setNoticeHit(int noticeHit) {
		this.noticeHit = noticeHit;
	}
	public String getNoticeFile() {
		return noticeFile;
	}
	public void setNoticeFile(String noticeFile) {
		this.noticeFile = noticeFile;
	}
	public String getNoticeDate() {
		return noticeDate;
	}
	public void setNoticeDate(String noticeDate) {
		//noticeDate 는 timestamp 형식이라
		//yyyy-MM-dd hh:mm:ss 형태로 값을 받아옴.
		//"공백"을 기준으로 잘라 배열에 넣어준다.
		//array[0] = yyyy-MM-dd
		//array[1] = hh:mm:ss
		//array[0] = yyyy-MM-dd 를 this.noticeDate에 셋팅한다.
		String[] array = noticeDate.split(" ");
		this.noticeDate = array[0];
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	@Override
	public String toString() {
		return "NoticeVO [noticeNo=" + noticeNo + ", noticeTitle=" + noticeTitle + ", noticeBody=" + noticeBody
				+ ", noticeDate=" + noticeDate + ", noticeHit=" + noticeHit + ", noticeFile=" + noticeFile
				+ ", getNoticeNo()=" + getNoticeNo() + ", getNoticeTitle()=" + getNoticeTitle() + ", getNoticeBody()="
				+ getNoticeBody() + ", getNoticeHit()=" + getNoticeHit() + ", getNoticeFile()=" + getNoticeFile()
				+ ", getNoticeDate()=" + getNoticeDate() + ", getUserID()=" + getUserID() + ", getUserPW()="
				+ getUserPW() + ", getCheck()=" + getCheck() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
}
