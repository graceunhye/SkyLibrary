package com.skylibrary.vo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Setter
@Getter
public class NoticeVO extends SessionVO {
	
	private String userID;
	private int    noticeNo;
	private String noticeTitle; 
	private String noticeBody; 
	private String noticeDate; 
	private int    noticeHit; 
	private String noticeFile; 
	private String fileName;
	private MultipartFile uploadFile;

	
	public void setNoticeDate(String noticeDate) {
		String[] array = noticeDate.split(" ");
		this.noticeDate = array[0];
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
