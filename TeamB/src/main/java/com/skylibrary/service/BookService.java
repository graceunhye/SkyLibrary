package com.skylibrary.service;

import java.util.List;

import com.skylibrary.vo.BookVO;
import com.skylibrary.vo.PagingVO;
import com.skylibrary.vo.SearchVO;

public interface BookService {
	public List<BookVO> MainList() throws Exception;
	
	public int countList(SearchVO vo) throws Exception;
	
	public List<BookVO> TotalList(SearchVO vo) throws Exception;
	
	public List<BookVO> BestList(PagingVO vo) throws Exception;
	
	public BookVO bookView(String isbn) throws Exception;
	
	public int bookViewCnt(String id) throws Exception;
	
	public int updateBook(BookVO vo) throws Exception;
	
	public int insertRent(BookVO vo) throws Exception;
	
	public BookVO selectRent(int no) throws Exception;
	
	public List<BookVO> NewList(PagingVO vo) throws Exception;
	
	public List<BookVO> RecommendList(PagingVO vo) throws Exception;
	
	public int newCountList() throws Exception;
	
	public int bestCountList() throws Exception;
	
	public int recommendCountList() throws Exception;
}
