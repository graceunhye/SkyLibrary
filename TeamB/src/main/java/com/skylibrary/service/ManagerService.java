package com.skylibrary.service;

import com.skylibrary.vo.ManagerVO;
import com.skylibrary.vo.SessionVO;

public interface ManagerService {
	
	public void mjoin(ManagerVO vo) throws Exception;
	

	public SessionVO mlogin(SessionVO vo) throws Exception;
}
