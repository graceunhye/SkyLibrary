package com.skylibrary.service;

import java.util.List;

import com.skylibrary.dao.RecommendDAO;
import com.skylibrary.vo.BookVO;

public class RecommendServiceImpl implements RecommendService {
	
	private RecommendDAO dao;
	
	public List<BookVO> list() throws Exception{
		return dao.list();
	}
}
