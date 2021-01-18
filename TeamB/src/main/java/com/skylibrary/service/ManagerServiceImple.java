package com.skylibrary.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.skylibrary.dao.ManagerDAO;
import com.skylibrary.vo.ManagerVO;
import com.skylibrary.vo.SessionVO;
import com.skylibrary.vo.UserVO;

@Service
public class ManagerServiceImple implements ManagerService {
	
	@Inject
	ManagerDAO dao;
	
	@Override
	public void mjoin(ManagerVO vo) throws Exception{
		dao.mjoin(vo);
	}
	
	@Override
	public SessionVO mlogin(SessionVO vo) throws Exception {
		return dao.mlogin(vo);
	}
}
