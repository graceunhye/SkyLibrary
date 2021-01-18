package com.skylibrary.vo;


public class NoticeVO extends SessionVO {
	private int noticeNo; //공지번호
	private String noticeTitle; //공지제목
	private String noticeBody; //공지내용
	private String noticeDate; //공지날짜
	private int noticeHit; //공지 조회수
	private String noticeFile; //첨부파일
	
	
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
	
	
}
