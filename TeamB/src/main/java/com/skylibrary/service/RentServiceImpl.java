package com.skylibrary.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.skylibrary.dao.RentDAO;
import com.skylibrary.vo.BookVO;
import com.skylibrary.vo.RentVO;
import com.skylibrary.vo.SessionVO;

@Service
public class RentServiceImpl implements RentService {

	@Inject
	RentDAO dao;

	@Override
	public List<RentVO> Rentlist(RentVO vo) throws Exception {	
		return dao.Rentlist(vo);
	}

	@Override
	public int extensionBook(RentVO vo) throws Exception{
		return dao.extensionBook(vo);
	}
	
	@Override
	public RentVO extenstionSelect(RentVO vo) throws Exception{
		return dao.extenstionSelect(vo);
	}

	@Override
	public int updateBook(BookVO vo) throws Exception {
		return dao.updateBook(vo);
	}

	@Override
	public int deleteRent(RentVO vo) throws Exception {
		return dao.deleteRent(vo);
	}

	@Override
	public List<Map<String, String>> userRentInfo(SessionVO vo) throws Exception {
		return dao.userRentInfo(vo);
	}
}
