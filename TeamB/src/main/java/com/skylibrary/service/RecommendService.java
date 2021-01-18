package com.skylibrary.service;

import java.util.List;

import com.skylibrary.vo.BookVO;

public interface RecommendService {
	public List<BookVO> list() throws Exception;
}
