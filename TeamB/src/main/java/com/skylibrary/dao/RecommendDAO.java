package com.skylibrary.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.skylibrary.vo.BookVO;

@Repository
public class RecommendDAO {
	
	@Inject
	private SqlSession sql;
	
	private static String namespace = "com.skylibrary.mappers.recommendMapper";
	
	//Ã¥ ¸ñ·Ï
	public List<BookVO> list() throws Exception {
		return sql.selectList(namespace + ".mRecommend");
	}
	
}
