package com.skylibrary.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.skylibrary.vo.PagingVO;
import com.skylibrary.vo.QuestionVO;

@Repository
public class QuestionDAO {
	
	@Inject
	SqlSession sql;
	
	private static final String namespace = "com.skylibrary.mappers.questionMapper";
	
	public List<QuestionVO> list(PagingVO vo) throws Exception {
		return sql.selectList(namespace + ".list", vo);
	}
	
	public QuestionVO qView(QuestionVO vo) throws Exception {
		return sql.selectOne(namespace + ".qView", vo);
	}

	public int countList() throws Exception {
		return sql.selectOne(namespace + ".countList");
	}
	
	public int typeCountList(QuestionVO vo) throws Exception {
		return sql.selectOne(namespace + ".typeCountList", vo);
	}
	
	public List<QuestionVO> selectTypeList(QuestionVO vo) throws Exception {
		return sql.selectList(namespace + ".selectTypeList", vo);
	}
	
	public void typeUpdate(QuestionVO vo) throws Exception {
		sql.update(namespace + ".typeUpdate", vo);
	}
}
