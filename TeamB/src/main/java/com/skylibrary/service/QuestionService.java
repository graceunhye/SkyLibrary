package com.skylibrary.service;

import java.util.List;

import com.skylibrary.vo.PagingVO;
import com.skylibrary.vo.QuestionVO;

public interface QuestionService {
	public List<QuestionVO> list(PagingVO vo) throws Exception;
	public QuestionVO qView(QuestionVO vo) throws Exception;
	public int countList() throws Exception;
}
