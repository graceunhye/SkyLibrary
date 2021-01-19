package com.skylibrary.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.skylibrary.vo.ApplyBookVO;
import com.skylibrary.vo.SearchVO;
import com.skylibrary.vo.UserVO;

@Repository
public class ApplyBookDAO {
	
	@Inject
	SqlSession sql;
	
	private static final String namespace = "com.skylibrary.mappers.applyBookMapper";
	
	public List<ApplyBookVO> list(UserVO vo) throws Exception {
		return sql.selectList(namespace + ".list", vo);
	}
	
	//신청 도서 작성
	public void insert(ApplyBookVO vo) throws Exception{
		sql.insert(namespace + ".insert",vo);
	}
	
	public void checkedSave(ApplyBookVO vo) throws Exception {
		sql.update(namespace + ".checkedSave", vo);
	}
	
	public List<Map<String,String>> wishSearchOk(SearchVO vo) throws Exception {
		return sql.selectList(namespace + ".wishSearchOk", vo);
	}
	
	public Map<String,String> wishDetailOk(ApplyBookVO vo) throws Exception {
		return sql.selectOne(namespace + ".wishDetailOk", vo);
	}
}
