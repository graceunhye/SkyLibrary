package com.skylibrary.service;

import java.util.List;

import com.skylibrary.vo.QuestionVO;
import com.skylibrary.vo.SearchVO;

public interface QuestionService {
	public List<QuestionVO> list(SearchVO vo) throws Exception;
	public QuestionVO qView(QuestionVO vo) throws Exception;
	public int countList() throws Exception;
}
