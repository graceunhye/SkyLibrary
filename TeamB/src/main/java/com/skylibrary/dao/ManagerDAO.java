package com.skylibrary.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.skylibrary.vo.ManagerVO;
import com.skylibrary.vo.SessionVO;
import com.skylibrary.vo.UserVO;

@Repository
public class ManagerDAO {
	
	@Inject
	SqlSession sql;
	
	private static final String namespace = "com.skylibrary.mappers.managerMapper";
	
	public void mjoin(ManagerVO vo) throws Exception {
		sql.insert(namespace + ".mjoin", vo);
	}
	
	public SessionVO mlogin(SessionVO vo) throws Exception {
		return sql.selectOne(namespace + ".mlogin", vo);
	}
}
