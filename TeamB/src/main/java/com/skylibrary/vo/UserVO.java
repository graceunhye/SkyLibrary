package com.skylibrary.vo;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class UserVO {

	private String userID;          //아이디
	private String userPW;          //비밀번호
	private String userName;        //이름  
	private String userNumSplit1;   //전화번호1 (첫번째 박스)
	private String userNumSplit2;   //전화번호2 (두번째 박스)
	private String userNumSplit3;   //전화번호3 (세번째 박스)
	private String userNum;
	private int    userPostNum;     //우편번호
	private String userAddr;        //주소
	private String userAddrDetail;  //상세주소
	private String userEmail;       //이메일아이디
	private String userEmailDomain; //이메일도메인
	private int    userType;        //유저타입 {0:일반회원,1:탈퇴회원,2:강퇴회원}
	private String userJoinDate;    //가입일
	

	public UserVO(){
		setUserNum(this.userNumSplit1, this.userNumSplit2, this.userNumSplit3);
	}
	
	public void setUserNum(String userNumSplit1, String userNumSplit2, String userNumSplit3) {
		this.userNum = userNumSplit1+"-"+userNumSplit2+"-"+userNumSplit3;
	}

	
}
