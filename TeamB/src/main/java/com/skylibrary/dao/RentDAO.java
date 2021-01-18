package com.skylibrary.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.skylibrary.vo.RentVO;
import com.skylibrary.vo.UserVO;

@Repository
public class RentDAO {

	@Inject
	SqlSession sql;
	
	private static final String namespace = "com.skylibrary.mappers.rentMapper";
	
	public List<RentVO> Rentlist(RentVO vo) throws Exception {

		return sql.selectList(namespace + ".selectRent", vo);
	}
}
