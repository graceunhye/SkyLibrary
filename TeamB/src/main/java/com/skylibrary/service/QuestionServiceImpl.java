package com.skylibrary.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.skylibrary.dao.QuestionDAO;
import com.skylibrary.vo.PagingVO;
import com.skylibrary.vo.QuestionVO;
import com.skylibrary.vo.SearchVO;

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
	public List<QuestionVO> selectTypeList(SearchVO vo) throws Exception {
		return dao.selectTypeList(vo);
	}

	@Override
	public void typeUpdate(QuestionVO vo) throws Exception {
		dao.typeUpdate(vo);
	}

	@Override
	public void questionAdd(QuestionVO vo) throws Exception {
		
	}

	@Override
	public void questionModify(QuestionVO vo) throws Exception {
		
	}


	@Override
	public void questionDelete(QuestionVO vo) throws Exception {
		dao.questionDelete(vo);
	}

	@Override
	public void questionOkDateUpdate(QuestionVO vo) throws Exception {
		dao.questionOkDateUpdate(vo);	
	}

	@Override
	public Map<String,String> qnaView(QuestionVO vo) throws Exception {
		
		return dao.qnaView(vo);
	}

}
