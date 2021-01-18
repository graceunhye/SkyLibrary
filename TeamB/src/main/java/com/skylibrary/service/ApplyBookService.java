package com.skylibrary.service;

import java.util.List;

import com.skylibrary.vo.ApplyBookVO;

public interface ApplyBookService {
	
	//신청 도서 목록
	public List<ApplyBookVO> list() throws Exception;
	
	//신청 도서 작성
	public void insert(ApplyBookVO vo)throws Exception;
	
	
}
