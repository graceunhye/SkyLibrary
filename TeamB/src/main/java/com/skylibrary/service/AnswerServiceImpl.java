package com.skylibrary.service;

import java.util.Map;

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

	@Override
	public int aViewCount(QuestionVO vo) throws Exception {
		return dao.aViewCount(vo);
	}

	@Override
	public void answerAdd(AnswerVO vo) throws Exception {
		dao.answerAdd(vo);	
	}

	@Override
	public void answerUpdate(AnswerVO vo) throws Exception {
		dao.answerUpdate(vo);
	}

	@Override
	public Map<String, String> aViewMap(AnswerVO vo) throws Exception {
		return dao.aViewMap(vo);
	}
}
