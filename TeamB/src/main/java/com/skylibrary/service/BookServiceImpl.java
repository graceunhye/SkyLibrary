package com.skylibrary.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.skylibrary.dao.BookDAO;
import com.skylibrary.vo.BookVO;
import com.skylibrary.vo.PagingVO;
import com.skylibrary.vo.SearchVO;

@Service
public class BookServiceImpl implements BookService {

	@Inject
	BookDAO dao;
	
	@Override
	public List<BookVO> MainList() throws Exception {
		return dao.MainList();
	}
	
	@Override
	public List<BookVO> TotalList(SearchVO vo) throws Exception{
		return dao.TotalList(vo);
	}
	
	@Override
	public List<BookVO> BestList(PagingVO vo) throws Exception{
		return dao.BestList(vo);
	}
	
	@Override
	public BookVO bookView(String isbn) throws Exception{
		return dao.bookView(isbn); 
	}
	
	@Override
	public int bookViewCnt(String id) throws Exception{
		return dao.bookViewCnt(id); 
	}
	
	@Override
	public int updateBook(BookVO vo) throws Exception {
		return dao.updateBook(vo); 
	}

	@Override
	public int insertRent(BookVO vo) throws Exception {
		return dao.insertRent(vo); 
	}

	@Override
	public BookVO selectRent(int rentNo) throws Exception {
		return dao.selectRent(rentNo); 
	}
	
	@Override
	public List<BookVO> NewList(PagingVO vo) throws Exception{
		return dao.NewList(vo);
	}
	
	@Override
	public List<BookVO> RecommendList(PagingVO vo) throws Exception{
		return dao.RecommendList(vo);
	}

	@Override
	public int countList(SearchVO vo) throws Exception {
		return dao.countList(vo);
	}

	@Override
	public int newCountList() throws Exception {
		return dao.newCountList();
	}

	@Override
	public int bestCountList() throws Exception {
		return dao.bestCountList();
	}
	
	@Override
	public int recommendCountList() throws Exception {
		return dao.recommendCountList();
	}

}
