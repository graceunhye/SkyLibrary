package com.skylibrary.service;

import org.springframework.stereotype.Service;

import com.skylibrary.vo.ManagerVO;
import com.skylibrary.vo.SessionVO;
import com.skylibrary.vo.UserVO;

public interface ManagerService {
	
	//사서 회원가입
	public void mjoin(ManagerVO vo) throws Exception;
	
	//사서 로그인
	public SessionVO mlogin(SessionVO vo) throws Exception;
}
