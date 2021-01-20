package com.skylibrary.dao;

import java.util.List;

import java.util.Map;


import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;


import com.skylibrary.vo.SearchVO;

import com.skylibrary.vo.SessionVO;
import com.skylibrary.vo.UserVO;

@Repository
public class UserDAO {

	@Inject
	SqlSession sql;
	
	private static final String namespace = "com.skylibrary.mappers.userMapper";
	

	//로그인
	public SessionVO login(SessionVO vo) throws Exception {
		return sql.selectOne(namespace + ".login", vo);
	}
	
	//회원가입
	public void join(UserVO vo) throws Exception {
		sql.insert(namespace + ".join", vo);
	}
	

	public UserVO userInfo(UserVO vo) throws Exception {
		return sql.selectOne(namespace + ".userInfo", vo);
	}
	

	public int userExist(UserVO vo) throws Exception {
		return sql.selectOne(namespace + ".userExist", vo);
	}
	

	//유저들 정보 조회
	public List<UserVO> userList() throws Exception {
		return sql.selectList(namespace + ".userList");
	}
	

	//유저 정보 수정
	public void userModify(UserVO vo) throws Exception {
		sql.update(namespace + ".userModify", vo);
	}
	
	//유저 삭제
	public void userRemove(SessionVO vo) throws Exception {
		sql.delete(namespace + ".userRemove", vo);
	}
	
	//상제정보 조회
	public Map<String,String> userInfoOk(SessionVO vo)  throws Exception {
		return sql.selectOne(namespace + ".userInfoOk", vo);
	}
	
	//검색
	public List<Map<String,String>> userSearchOk(SearchVO vo) throws Exception {
		return sql.selectList(namespace + ".userSearchOk", vo);
	}
	
	//조회
	public List<Map<String,String>> userSelectOk(SearchVO vo) throws Exception {
		return sql.selectList(namespace + ".userSelectOk", vo);
	}


	public void userRemove(UserVO vo) throws Exception {
		sql.delete(namespace + ".userRemove", vo);
	}


	
}
