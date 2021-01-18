package com.skylibrary.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.skylibrary.dao.RentDAO;
import com.skylibrary.vo.RentVO;
import com.skylibrary.vo.UserVO;

@Service
public class RentServiceImpl implements RentService {

	@Inject
	RentDAO dao;

	@Override
	public List<RentVO> Rentlist(RentVO vo) throws Exception {
		
		return dao.Rentlist(vo);
	}

}
