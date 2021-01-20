package com.skylibrary.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.skylibrary.dao.RecommendDAO;
import com.skylibrary.vo.BookVO;
import com.skylibrary.vo.RecommendVO;

@Service
public class RecommendServiceImpl implements RecommendService {
	
	@Inject
	private RecommendDAO dao;
	
	@Override
	public List<BookVO> list() throws Exception{
		return dao.list();
	}

	@Override
	public BookVO recommendView(String isbn) throws Exception {
		return dao.bookView(isbn);
	}
	
	@Override
	public int insertRbook(BookVO vo) throws Exception {
		return dao.insertRbook(vo); 
	}
	
	@Override
	public int updateRbook(RecommendVO vo) throws Exception{
		return dao.updateRbook(vo); 
	}
	
	@Override
	public int deleteRbook(RecommendVO vo) throws Exception{
		return dao.deleteRbook(vo);
	}
}
