package com.skylibrary.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.skylibrary.dao.ApplyBookDAO;
import com.skylibrary.vo.aBookVO;

@Service
public class ApplyBookServiceImpl implements ApplyBookService {

	@Inject
	ApplyBookDAO dao;
	
	@Override
	public List<aBookVO> list() throws Exception {
		return null;
	}

}
