package com.skylibrary.service;

import java.util.List;

import com.skylibrary.vo.PagingVO;
import com.skylibrary.vo.QuestionVO;

public interface QuestionService {
	
	//회원페이지 질문 목록 조회
	public List<QuestionVO> list(PagingVO vo) throws Exception;
	
	//질문 조회
	public QuestionVO qView(QuestionVO vo) throws Exception;
	
	//질문 총 수
	public int countList() throws Exception;
	
	//타입별 질문 총 수
	public int typeCountList(QuestionVO vo) throws Exception;
	
	//관리자페이지 질문 목록 조회
	public List<QuestionVO> selectTypeList(QuestionVO vo) throws Exception;
	
	//질문 상태 변경
	public void typeUpdate(QuestionVO vo) throws Exception; 
}
