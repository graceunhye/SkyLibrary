package com.skylibrary.service;

import com.skylibrary.vo.UserVO;

public interface UserService {
	
	//로그인하기
	public UserVO login(UserVO vo) throws Exception;
	//회원가입
	public void join(UserVO vo) throws Exception;

}
