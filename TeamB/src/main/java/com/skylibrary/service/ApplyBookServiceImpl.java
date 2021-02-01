package com.skylibrary.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.skylibrary.dao.ApplyBookDAO;
import com.skylibrary.vo.ApplyBookVO;
import com.skylibrary.vo.SearchVO;
import com.skylibrary.vo.SessionVO;

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

	@Override
	public void checkedSave(ApplyBookVO vo) throws Exception {
		dao.checkedSave(vo);
	}

	@Override
	public List<Map<String, String>> wishSearchOk(SearchVO vo) throws Exception {
		return dao.wishSearchOk(vo);
	}

	@Override
	public Map<String, String> wishDetailOk(ApplyBookVO vo) throws Exception {
		return dao.wishDetailOk(vo);
	}

	@Override
	public List<Map<String, String>> userWishInfoOk(SessionVO vo) throws Exception {
		return dao.userWishInfoOk(vo);
	}

	@Override
	public List<ApplyBookVO> view(SearchVO vo) throws Exception {
		 return dao.view(vo);
	}

	@Override
	public void applyRemove(SessionVO vo) throws Exception {
		dao.applyRemove(vo);
	}
	


}
