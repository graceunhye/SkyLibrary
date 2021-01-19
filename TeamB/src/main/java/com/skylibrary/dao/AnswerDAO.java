package com.skylibrary.dao;

import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.skylibrary.vo.AnswerVO;
import com.skylibrary.vo.QuestionVO;

@Repository
public class AnswerDAO {
	
	@Inject
	SqlSession sql;
	
	private static final String namespace = "com.skylibrary.mappers.answerMapper";
	
	//답변 조회
	public AnswerVO aView(QuestionVO vo) throws Exception {
		return sql.selectOne(namespace + ".aView", vo);
	}
	
	//답변여부 조회 (임시)
	public int aViewCount(QuestionVO vo) throws Exception {
		return sql.selectOne(namespace + ".aViewCount", vo);
	}
	
	//답변 등록
	public void answerAdd(AnswerVO vo) throws Exception {
		sql.insert(namespace + ".answerAdd", vo);
	}
	
	//답변 수정
	public void answerUpdate(AnswerVO vo) throws Exception {
		sql.update(namespace + ".answerUpdate", vo);
	}
	
	public Map<String,String> aViewMap(AnswerVO vo) throws Exception {
		return sql.selectOne(namespace + ".aViewMap", vo);
	}
}
