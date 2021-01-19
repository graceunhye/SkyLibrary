package com.skylibrary.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.skylibrary.vo.PagingVO;
import com.skylibrary.vo.QuestionVO;
import com.skylibrary.vo.SearchVO;

@Repository
public class QuestionDAO {
	
	@Inject
	SqlSession sql;
	
	private static final String namespace = "com.skylibrary.mappers.questionMapper";
	
	//목록
	public List<QuestionVO> list(PagingVO vo) throws Exception {
		return sql.selectList(namespace + ".list", vo);
	}
	
	//질문 보기
	public QuestionVO qView(QuestionVO vo) throws Exception {
		return sql.selectOne(namespace + ".qView", vo);
	}

	//목록 갯수
	public int countList() throws Exception {
		return sql.selectOne(namespace + ".countList");
	}
	
	//타입별 목록 갯수
	public int typeCountList(QuestionVO vo) throws Exception {
		return sql.selectOne(namespace + ".typeCountList", vo);
	}
	
	//타입별 목록
	public List<QuestionVO> selectTypeList(SearchVO vo) throws Exception {
		return sql.selectList(namespace + ".selectTypeList", vo);
	}
	
	//타입 변경
	public void typeUpdate(QuestionVO vo) throws Exception {
		sql.update(namespace + ".typeUpdate", vo);
	}
	
	//글 등록
	public void questionAdd(QuestionVO vo) throws Exception {
		sql.insert(namespace + ".questionAdd", vo);
	}
	
	//글 수정
	public void questionModify(QuestionVO vo) throws Exception {
		sql.update(namespace + ".questionModify", vo);
	}
	
	
	public void questionDelete(QuestionVO vo) throws Exception {
		sql.delete(namespace + ".questionDelete" , vo);	
	}
	
	public void questionOkDateUpdate(QuestionVO vo) throws Exception {
		sql.update(namespace + ".questionOkDateUpdate", vo);
		
	}
	
	public Map<String,String> qnaView(QuestionVO vo) throws Exception {
		return sql.selectOne(namespace + ".qnaView", vo);
				
	}
}
