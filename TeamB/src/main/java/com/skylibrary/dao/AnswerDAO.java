package com.skylibrary.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

import com.skylibrary.vo.AnswerVO;
import com.skylibrary.vo.QuestionVO;

public class AnswerDAO {
	
	@Inject
	SqlSession sql;
	
	private static final String namespace = "com.skylibrary.mappers.answerMapper";
	
	public AnswerVO aView(QuestionVO vo) throws Exception {
		return sql.selectOne(namespace + ".aView", vo);
	}
}
