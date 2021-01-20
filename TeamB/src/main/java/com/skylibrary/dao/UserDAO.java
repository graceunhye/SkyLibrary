package com.skylibrary.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.skylibrary.vo.SessionVO;
import com.skylibrary.vo.UserVO;

@Repository
public class UserDAO {

	@Inject
	SqlSession sql;
	
	private static final String namespace = "com.skylibrary.mappers.userMapper";
	

	//濡쒓렇�씤
	public SessionVO login(SessionVO vo) throws Exception {

		return sql.selectOne(namespace + ".login", vo);
	}
	
	//�쉶�썝媛��엯
	public void join(UserVO vo) throws Exception {
		sql.insert(namespace + ".join", vo);
	}
	
	//�쑀�� �젙蹂� 議고쉶
	public UserVO userInfo(UserVO vo) throws Exception {
		return sql.selectOne(namespace + ".userInfo", vo);
	}
	
	//�븘�씠�뵒 以묐났 �뿬遺�
	public int userExist(UserVO vo) throws Exception {
		return sql.selectOne(namespace + ".userExist", vo);
	}
	
	//�쑀���뱾 �젙蹂� 議고쉶
	public List<UserVO> userList() throws Exception {
		return sql.selectList(namespace + ".userList");
	}
	
	//�쑀�� �젙蹂� �닔�젙
	public void userModify(UserVO vo) throws Exception {
		sql.update(namespace + ".userModify", vo);
	}
	
	//�쑀�� �궘�젣
	public void userRemove(UserVO vo) throws Exception {
		sql.delete(namespace + ".userRemove", vo);
	}

	
}
