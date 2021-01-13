package com.skylibrary.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.skylibrary.dao.BookDAO;
import com.skylibrary.vo.BookVO;

@Service
public class BookServiceImpl implements BookService {

	@Inject
	BookDAO dao;
	
	@Override
	public List<BookVO> MainList() throws Exception {
		return dao.MainList();
	}

}
