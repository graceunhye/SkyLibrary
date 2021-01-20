package com.skylibrary.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.skylibrary.vo.BookVO;
import com.skylibrary.vo.RecommendVO;

@Repository
public class RecommendDAO {
	
	@Inject
	private SqlSession sql;
	
	private static String namespace = "com.skylibrary.mappers.recommendMapper";
	
	//도서 통합 목록
	public List<BookVO> list() throws Exception {
		return sql.selectList(namespace + ".mRecommend");
	}
	
	//도서 상세페이지
	public BookVO bookView(String isbn) throws Exception{
		return sql.selectOne(namespace + ".recommendView", isbn); 
	}
	
	//추천 등록
	public int insertRbook(BookVO vo) {
		return sql.insert(namespace + ".insertRbook", vo);
	}
	
	//추천 수정
	public int updateRbook(RecommendVO vo) {
		return sql.update(namespace + ".updateRbook", vo);
	}
	
	//추천 삭제
	public int deleteRbook(RecommendVO vo) {
		return sql.delete(namespace + ".deleteRbook", vo);
	}
}
