package com.skylibrary.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.skylibrary.vo.NoticeVO;
import com.skylibrary.vo.SearchVO;

@Repository
public class NoticeDAO {
	
	@Inject
	SqlSession sql;
	
	private static final String namespace = "com.skylibrary.mappers.noticeMapper";
	
	public List<NoticeVO> MainList() throws Exception {
		return sql.selectList(namespace + ".listMain");
	}
	
	public List<NoticeVO> list(SearchVO vo) throws Exception {
		return sql.selectList(namespace + ".list", vo);
	}
	
	public int countList(SearchVO vo) throws Exception {
		return sql.selectOne(namespace + ".countList", vo);
	}
	
	public NoticeVO view(NoticeVO vo) throws Exception {
		return sql.selectOne(namespace + ".view", vo);
	}
	
	//사서 공지사항 목록
	public List<NoticeVO> NoticeList() throws Exception{
		return sql.selectList(namespace + ".noticeList");
	}
	
	//사서 공지사항 작성
	public void NoticeWrite(NoticeVO vo) throws Exception{
		sql.insert(namespace + ".noticeWrite", vo);
	}
	
	//사서 공지사항 조회
	public NoticeVO NoticeView(int noticeNo) throws Exception{
		return sql.selectOne(namespace + ".noticeView", noticeNo);
	}	
}
