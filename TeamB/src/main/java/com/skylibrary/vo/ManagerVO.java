package com.skylibrary.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ManagerVO extends SessionVO{
	
	private String userID;             //사서아이디
	private String managerPW;          //사서비밀번호
	private String managerName;        //사서이름
	private String managerNum;
	private String managerNumSplit1;
	private String managerNumSplit2;
	private String managerNumSplit3;
	private String managerEmail;       //사서 이메일아이디
	private String managerEmailID;
	private String managerEmailDomain; //사서 이메일도메인
	private String managerPostNum;
	private String managerAddr;
	private String managerAddrDetail;
	
	public void setManagerEmail(String managerEmailID, String managerEmailDomain) {
		this.managerEmail = managerEmailID+"@"+managerEmailDomain;
	}
	
	public void setManagerNum(String managerNumSplit1, String managerNumSplit2, String managerNumSplit3) 
	{
		this.managerNum = managerNumSplit1+"-"+managerNumSplit2+"-"+managerNumSplit3;
	}
	
}
