package com.skylibrary.service;

import org.springframework.stereotype.Service;

import com.skylibrary.vo.ManagerVO;

public interface ManagerService {
	
	//사서 회원가입
	public void mjoin(ManagerVO vo) throws Exception;
}
