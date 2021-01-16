package com.skylibrary.vo;


//import lombok.Getter;
//import lombok.Setter;
//import lombok.ToString;
//
//@Setter
//@Getter
//@ToString
public class UserVO {

	private String userID;          //아이디
	private String userPW;          //비밀번호
	private String userName;        //이름  
<<<<<<< HEAD
	private String userNum;         //전화번호
	private String userNumSplit1;   //"-" 기준으로 잘라낸 첫번재째 값
	private String userNumSplit2;
	private String userNumSplit3;
=======
	private String userNumSplit1;        //전화번호1 (첫번째 박스)
	private String userNumSplit2;        //전화번호2 (두번째 박스)
	private String userNumSplit3;        //전화번호3 (세번째 박스)
	private String userNum;
>>>>>>> 4e1c0b5902272a82c80dcbb4b8cd1e4d05198201
	private int    userPostNum;     //우편번호
	private String userAddr;        //주소
	private String userAddrDetail;  //상세주소
	private String userEmail;       //이메일아이디
	private String userEmailDomain; //이메일도메인
	private boolean loginCon;       //로그인 성공여부 || 보류
	
<<<<<<< HEAD
	UserVO(){
		setUserNum(userNumSplit1, userNumSplit2, userNumSplit3);
	}
=======
>>>>>>> 4e1c0b5902272a82c80dcbb4b8cd1e4d05198201
	
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserNum() {
		return userNum;
	}
<<<<<<< HEAD
	public void setUserNum(String userNumSplit1, String userNumSplit2, String userNumSplit3) {
		this.userNum = userNumSplit1+"-"+userNumSplit2+"-"+userNumSplit3;
	}
=======
	
	public void setUserNum(String userNumSplit1,String userNumSplit2,String userNumSplit3) {
		this.userNum = userNumSplit1 + "-" + userNumSplit2 + "-" + userNumSplit3;
	}		
	
>>>>>>> 4e1c0b5902272a82c80dcbb4b8cd1e4d05198201
	public int getUserPostNum() {
		return userPostNum;
	}
	public void setUserPostNum(int userPostNum) {
		this.userPostNum = userPostNum;
	}
	public String getUserAddr() {
		return userAddr;
	}
	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}
	public String getUserAddrDetail() {
		return userAddrDetail;
	}
	public void setUserAddrDetail(String userAddrDetail) {
		this.userAddrDetail = userAddrDetail;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserEmailDomain() {
		return userEmailDomain;
	}
	public void setUserEmailDomain(String userEmailDomain) {
		this.userEmailDomain = userEmailDomain;
	}
	public boolean isLoginCon() {
		return loginCon;
	}
	public void setLoginCon(boolean loginCon) {
		this.loginCon = loginCon;
	}

	
}
