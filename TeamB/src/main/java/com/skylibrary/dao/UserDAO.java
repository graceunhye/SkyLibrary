package com.skylibrary.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.skylibrary.vo.UserVO;

@Repository
public class UserDAO {

	@Inject
	SqlSession sql;
	
	private static final String namespace = "com.skylibrary.mappers.userMapper";
	
	//로그인
	public UserVO login(UserVO vo) throws Exception {
		return sql.selectOne(namespace + ".login", vo);
	}
	
	//회원가입
	public void join(UserVO vo) throws Exception {
		sql.insert(namespace + ".join", vo);
	}
	
	//유저 정보 조회
	public UserVO userInfo(UserVO vo) throws Exception {
		return sql.selectOne(namespace + ".userInfo", vo);
	}
	
	//아이디 중복 여부
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
	public void userRemove(UserVO vo) throws Exception {
		sql.delete(namespace + ".userRemove", vo);
	}

	
}
