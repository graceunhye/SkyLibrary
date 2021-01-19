package com.skylibrary.service;

import java.util.List;
import java.util.Map;

import com.skylibrary.vo.PagingVO;
import com.skylibrary.vo.QuestionVO;
import com.skylibrary.vo.SearchVO;

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
	public List<QuestionVO> selectTypeList(SearchVO vo) throws Exception;
	
	//질문 상태 변경
	public void typeUpdate(QuestionVO vo) throws Exception; 
	
	//질문 등록
	public void questionAdd(QuestionVO vo) throws Exception;
	
	//질문 수정
	public void questionModify(QuestionVO vo) throws Exception;
	
	public void questionDelete(QuestionVO vo) throws Exception;
	
	public void questionOkDateUpdate(QuestionVO vo) throws Exception;
	
	public Map<String, String> qnaView(QuestionVO vo) throws Exception;
		
}
