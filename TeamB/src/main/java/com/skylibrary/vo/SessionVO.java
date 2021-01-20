package com.skylibrary.vo;

<<<<<<< HEAD
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class SessionVO {
	private String userID;             
	private String userPW;            
	private String check;
	
//	public String getUserID() {
//		return userID;
//	}
//	public void setUserID(String userID) {
//		this.userID = userID;
//	}
//	public String getUserPW() {
//		return userPW;
//	}
//	public void setUserPW(String userPW) {
//		this.userPW = userPW;
//	}
//	public String getCheck() {
//		return check;
//	}
//	public void setCheck(String check) {
//		this.check = check;
//	}
//	
=======
public class SessionVO {
	private String userID;             //회원 아이디
	private String userPW;             //비밀번호
	private String check;
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserPW() {
		return userPW;
	}
	public void setUserPW(String userPW) {
		this.userPW = userPW;
	}
	public String getCheck() {
		return check;
	}
	public void setCheck(String check) {
		this.check = check;
	}
	
>>>>>>> da08ed998bdb39dcf4778bf7528d74a6046dfc40
}
