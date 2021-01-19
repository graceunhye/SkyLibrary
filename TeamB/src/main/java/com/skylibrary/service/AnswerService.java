package com.skylibrary.service;

import java.util.Map;

import com.skylibrary.vo.AnswerVO;
import com.skylibrary.vo.QuestionVO;

public interface AnswerService {

	//질문의 답변 조회
	public AnswerVO aView(QuestionVO vo) throws Exception;
	
	public int aViewCount(QuestionVO vo) throws Exception;
	
	public void answerAdd(AnswerVO vo) throws Exception;
	
	public void answerUpdate(AnswerVO vo) throws Exception;
	
	public Map<String,String> aViewMap(AnswerVO vo) throws Exception;
}
