package com.skylibrary.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.skylibrary.vo.BookVO;
import com.skylibrary.vo.RentVO;
import com.skylibrary.vo.SessionVO;

@Repository
public class RentDAO {

	@Inject
	SqlSession sql;
	
	private static final String namespace = "com.skylibrary.mappers.rentMapper";
	
	public List<RentVO> Rentlist(RentVO vo) throws Exception {
		return sql.selectList(namespace + ".selectRent", vo);
	}
	
	public int extensionBook(RentVO vo) {
		return sql.update(namespace + ".extensionBook", vo);
	}
	
	public RentVO extenstionSelect(RentVO vo) throws Exception{
		return sql.selectOne(namespace + ".extenstionSelect", vo);
	}
	
	public int updateBook(BookVO vo) {
		return sql.update(namespace + ".updateBook", vo);
	}
	
	public int deleteRent(RentVO vo) {
		return sql.delete(namespace + ".deleteRent", vo);
	}
	
	public List<Map<String, String>> userRentInfo(SessionVO vo) throws Exception {
		return sql.selectList(namespace + ".userRentInfo", vo);
	}
}
