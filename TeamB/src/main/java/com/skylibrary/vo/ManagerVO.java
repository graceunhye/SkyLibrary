package com.skylibrary.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ManagerVO {
	
	private String managerID;          //사서아이디
	private String managerPW;          //사서비밀번호
	private String managerName;        //사서이름
	private String managerEmail;       //사서 이메일아이디
	private String managerEmailDomain; //사서 이메일도메인
	
	
}
