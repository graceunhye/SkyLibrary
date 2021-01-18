package com.skylibrary.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.skylibrary.dao.ApplyBookDAO;
import com.skylibrary.vo.ApplyBookVO;

@Service
public class ApplyBookServiceImpl implements ApplyBookService {

	@Inject
	ApplyBookDAO dao;
	
	@Override
	public List<ApplyBookVO> list() throws Exception {
		return null;
	}

	@Override
	public void insert(ApplyBookVO vo) throws Exception {
		dao.insert(vo);
	}
	


}
