package com.skylibrary.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.skylibrary.dao.qnaDAO;
import com.skylibrary.vo.SearchVO;
import com.skylibrary.vo.aVO;
import com.skylibrary.vo.qVO;

@Service
public class qnaServiceImpl implements qnaService {

	@Inject
	qnaDAO dao;
	
	@Override
	public List<qVO> list(SearchVO vo) throws Exception {
		return dao.list(vo);
	}

	@Override
	public qVO qView(qVO vo) throws Exception {
		return dao.qView(vo);
	}

	@Override
	public aVO aView(qVO vo) throws Exception {
		return dao.aView(vo);
	}

	@Override
	public int countList() throws Exception {
		return dao.countList();
	}

}
