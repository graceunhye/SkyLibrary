package com.skylibrary.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.skylibrary.dao.AnswerDAO;
import com.skylibrary.vo.AnswerVO;
import com.skylibrary.vo.QuestionVO;

@Service
public class AnswerServiceImpl implements AnswerService {
	
	@Inject
	AnswerDAO dao;
	
	@Override
	public AnswerVO aView(QuestionVO vo) throws Exception {
		return dao.aView(vo);
	}
}
