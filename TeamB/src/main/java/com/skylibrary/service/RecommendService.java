package com.skylibrary.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skylibrary.vo.BookVO;
import com.skylibrary.vo.RecommendVO;

@Service
public interface RecommendService {
	public List<BookVO> list() throws Exception;
	
	public BookVO recommendView(String isbn) throws Exception;
	
	public int insertRbook(BookVO vo) throws Exception;
	
	public int updateRbook(RecommendVO vo) throws Exception;
	
	public int deleteRbook(RecommendVO vo) throws Exception;
}
