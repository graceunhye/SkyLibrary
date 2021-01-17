package com.skylibrary.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.skylibrary.dao.QuestionDAO;
import com.skylibrary.vo.PagingVO;
import com.skylibrary.vo.QuestionVO;

@Service
public class QuestionServiceImpl implements QuestionService {
	@Inject
	QuestionDAO dao;
	
	@Override
	public List<QuestionVO> list(PagingVO vo) throws Exception {
		return dao.list(vo);
	}

	@Override
	public QuestionVO qView(QuestionVO vo) throws Exception {
		return dao.qView(vo);
	}
	
	@Override
	public int countList() throws Exception {
		return dao.countList();
	}

	@Override
	public int typeCountList(QuestionVO vo) throws Exception {
		return dao.typeCountList(vo);
	}
	
	@Override
	public List<QuestionVO> selectTypeList(QuestionVO vo) throws Exception {
		return dao.selectTypeList(vo);
	}

	@Override
	public void typeUpdate(QuestionVO vo) throws Exception {
		dao.typeUpdate(vo);
	}

}
