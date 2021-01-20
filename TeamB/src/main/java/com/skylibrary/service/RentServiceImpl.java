package com.skylibrary.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.skylibrary.dao.RentDAO;
import com.skylibrary.vo.RentVO;
import com.skylibrary.vo.SessionVO;
import com.skylibrary.vo.UserVO;

@Service
public class RentServiceImpl implements RentService {

	@Inject
	RentDAO dao;

	@Override
	public List<RentVO> list(UserVO vo) throws Exception {

		return null;
	}
	
	@Override
	public List<Map<String, String>> userRentInfoOk(RentVO vo) throws Exception {
		return dao.userRentInfoOk(vo);
	}

}
