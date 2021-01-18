package com.skylibrary.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class NoticeVO extends SessionVO {
	private int noticeNo; //������ȣ
	private String noticeTitle; //��������
	private String noticeBody; //��������
	private String noticeDate; //������¥
	private int noticeHit; //���� ��ȸ��
	private String noticeFile; //÷������
	
//	
//	public int getNoticeNo() {
//		return noticeNo;
//	}
//	public void setNoticeNo(int noticeNo) {
//		this.noticeNo = noticeNo;
//	}
//	public String getManagerID() {
//		return managerID;
//	}
//	public void setManagerID(String managerID) {
//		this.managerID = managerID;
//	}
//	public String getNoticeTitle() {
//		return noticeTitle;
//	}
//	public void setNoticeTitle(String noticeTitle) {
//		this.noticeTitle = noticeTitle;
//	}
//	public String getNoticeBody() {
//		return noticeBody;
//	}
//	public void setNoticeBody(String noticeBody) {
//		this.noticeBody = noticeBody;
//	}
//	public String getNoticeDate() {
//		return noticeDate;
//	}
	public void setNoticeDate(String noticeDate) {
		//noticeDate �� timestamp �����̶�
		//yyyy-MM-dd hh:mm:ss ���·� ���� �޾ƿ�.
		//"����"�� �������� �߶� �迭�� �־��ش�.
		//array[0] = yyyy-MM-dd
		//array[1] = hh:mm:ss
		//array[0] = yyyy-MM-dd �� this.noticeDate�� �����Ѵ�.
		String[] array = noticeDate.split(" ");
		this.noticeDate = array[0];
	}
//	public int getNoticeHit() {
//		return noticeHit;
//	}
//	public void setNoticeHit(int noticeHit) {
//		this.noticeHit = noticeHit;
//	}
//	public String getNoticeFile() {
//		return noticeFile;
//	}
//	public void setNoticeFile(String noticeFile) {
//		this.noticeFile = noticeFile;
//	}
	
	
}
