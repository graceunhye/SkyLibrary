package com.skylibrary.service;

import java.util.List;

import com.skylibrary.vo.ApplyBookVO;
import com.skylibrary.vo.UserVO;

public interface ApplyBookService {
	
	//신청 도서 목록
	public List<ApplyBookVO> list() throws Exception;
	
	//신청 도서 작성
	public void insert(ApplyBookVO vo)throws Exception;
	
	//신청 도서 조회
	public List<ApplyBookVO> view(String userID) throws Exception;
	
	
}
