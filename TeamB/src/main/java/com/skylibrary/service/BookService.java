package com.skylibrary.service;

import java.util.List;

import com.skylibrary.vo.BookVO;

public interface BookService {
	public List<BookVO> MainList() throws Exception;
}
