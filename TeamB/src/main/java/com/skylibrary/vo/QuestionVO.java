package com.skylibrary.vo;

/*import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString*/
public class QuestionVO {
	
	private int    questionNo;     //글번호
	private String userID;         //회원아이디
	private String questionTitle;  //제목
	private String questionBody;   //내용
	private String questionOkDate; //답변일
	private String questionDate;   //작성일
	private int    questionHit;    //조회수
	private int    questionType;   //답변여부
	private String startDate;
	private String endDate;
	
	
	
	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	//Override 하지 않아도 자동 대체
	public void setQuestionOkDate(String questionOkDate) {
		String[] array = questionOkDate.split(" ");
		this.questionOkDate = array[0];
	}
	
	public void setQuestionDate(String questionDate) {
		String[] array = questionDate.split(" ");
		this.questionDate = array[0];
	}

	public int getQuestionNo() {
		return questionNo;
	}

	public void setQuestionNo(int questionNo) {
		this.questionNo = questionNo;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getQuestionTitle() {
		return questionTitle;
	}

	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}

	public String getQuestionBody() {
		return questionBody;
	}

	public void setQuestionBody(String questionBody) {
		this.questionBody = questionBody;
	}

	public int getQuestionHit() {
		return questionHit;
	}

	public void setQuestionHit(int questionHit) {
		this.questionHit = questionHit;
	}

	public int getQuestionType() {
		return questionType;
	}

	public void setQuestionType(int questionType) {
		this.questionType = questionType;
	}

	public String getQuestionOkDate() {
		return questionOkDate;
	}

	public String getQuestionDate() {
		return questionDate;
	}
	
	
	
}
