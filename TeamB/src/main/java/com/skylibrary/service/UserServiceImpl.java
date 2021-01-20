package com.skylibrary.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.skylibrary.dao.UserDAO;
import com.skylibrary.vo.SessionVO;
import com.skylibrary.vo.UserVO;

@Service
public class UserServiceImpl implements UserService {

	@Inject
	UserDAO dao;
	
	@Override
	public SessionVO login(SessionVO vo) throws Exception {
		return dao.login(vo);
	}

	@Override
	public void join(UserVO vo) throws Exception {
		dao.join(vo);
	}

	@Override
	public int userExist(UserVO vo) throws Exception {
		return dao.userExist(vo);
	}

	@Override
	public List<UserVO> userList() throws Exception {
		return dao.userList();
	}

	@Override
	public void userModify(UserVO vo) throws Exception {
		dao.userModify(vo);	
	}

	@Override
	public void userRemove(UserVO vo) throws Exception {
		dao.userRemove(vo);
	}

	


}
