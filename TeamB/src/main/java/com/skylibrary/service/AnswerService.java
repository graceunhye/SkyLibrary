package com.skylibrary.service;

import com.skylibrary.vo.AnswerVO;
import com.skylibrary.vo.QuestionVO;

public interface AnswerService {

	//질문의 답변 조회
	public AnswerVO aView(QuestionVO vo) throws Exception;
	
}
