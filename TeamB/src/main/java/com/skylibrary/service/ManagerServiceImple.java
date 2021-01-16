package com.skylibrary.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.skylibrary.dao.ManagerDAO;
import com.skylibrary.vo.ManagerVO;

@Service
public class ManagerServiceImple implements ManagerService {
	
	@Inject
	ManagerDAO dao;
	
	@Override
	public void mjoin(ManagerVO vo) throws Exception{
		dao.mjoin(vo);
	}
}
