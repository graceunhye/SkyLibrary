package com.skylibrary.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.skylibrary.vo.SearchVO;
import com.skylibrary.vo.aVO;
import com.skylibrary.vo.qVO;

@Repository
public class qnaDAO {
	
	@Inject
	SqlSession sql;
	
	private static final String namespace = "com.skylibrary.mappers.qnaMapper";
	
	public List<qVO> list(SearchVO vo) throws Exception {
		return sql.selectList(namespace + ".list", vo);
	}
	public qVO qView(qVO vo) throws Exception {
		return sql.selectOne(namespace + ".qView", vo);
	}
	public aVO aView(qVO vo) throws Exception {
		return sql.selectOne(namespace + ".aView", vo);
	}
	public int countList() throws Exception {
		return sql.selectOne(namespace + ".countList");
	}
}
