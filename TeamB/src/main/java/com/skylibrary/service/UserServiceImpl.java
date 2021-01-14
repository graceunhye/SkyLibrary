package com.skylibrary.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.skylibrary.dao.UserDAO;
import com.skylibrary.vo.UserVO;

@Service
public class UserServiceImpl implements UserService {

	@Inject
	UserDAO dao;
	
	@Override
	public UserVO login(UserVO vo) throws Exception {
		return dao.login(vo);
	}

	@Override
	public void join(UserVO vo) throws Exception {
		dao.join(vo);
	}

	@Override
	public UserVO userInfo(UserVO vo) throws Exception {
		return dao.userInfo(vo);
	}


}
