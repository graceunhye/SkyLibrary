package com.skylibrary.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class AnswerVO extends SessionVO {
	
	private int    questionNo;  //질문번호
	private String userID;      //사서아이디
	private String answerTitle; //답변제목
	private String answerBody;  //답변내용
	private String answerDate;  //답변날짜
	

	public void setAnswerDate(String answerDate) {
		String[] array = answerDate.split(" ");
		this.answerDate = array[0];
	}
	
	
}
