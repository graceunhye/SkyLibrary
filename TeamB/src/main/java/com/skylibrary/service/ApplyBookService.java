package com.skylibrary.service;

import java.util.List;
import java.util.Map;

import com.skylibrary.vo.ApplyBookVO;
import com.skylibrary.vo.SearchVO;

public interface ApplyBookService {
	
	//신청 도서 목록
	public List<ApplyBookVO> list() throws Exception;
	
	//신청 도서 작성
	public void insert(ApplyBookVO vo)throws Exception;
	
	public void checkedSave(ApplyBookVO vo) throws Exception;
	
	public List<Map<String,String>> wishSearchOk(SearchVO vo) throws Exception;
	
	public Map<String,String> wishDetailOk(ApplyBookVO vo) throws Exception;
}
