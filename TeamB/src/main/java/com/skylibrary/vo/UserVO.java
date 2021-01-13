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
	private String userNum;         //전화번호
	private int    userPostNum;     //우편번호
	private String userAddr;        //주소
	private String userAddrDetail;  //상세주소
	private String userEmail;       //이메일아이디
	private String userEmailDomain; //이메일도메인
	private boolean loginCon;       //로그인 성공여부 || 보류
	
}
