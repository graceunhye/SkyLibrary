package com.skylibrary.vo;

public class AnswerVO {
	
	private int    questionNo; //질문번호
	private String managerID; //사서아이디
	private String answerTitle; //답변제목
	private String answerBody; //답변내용
	private String answerDate; //답변날짜
	
	
	public int getQuestionNo() {
		return questionNo;
	}
	public void setQuestionNo(int questionNo) {
		this.questionNo = questionNo;
	}
	public String getManagerID() {
		return managerID;
	}
	public void setManagerID(String managerID) {
		this.managerID = managerID;
	}
	public String getAnswerTitle() {
		return answerTitle;
	}
	public void setAnswerTitle(String answerTitle) {
		this.answerTitle = answerTitle;
	}
	public String getAnswerBody() {
		return answerBody;
	}
	public void setAnswerBody(String answerBody) {
		this.answerBody = answerBody;
	}
	public String getAnswerDate() {
		return answerDate;
	}
	public void setAnswerDate(String answerDate) {
		String[] array = answerDate.split(" ");
		this.answerDate = array[0];
	}
	
	
}
