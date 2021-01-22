package com.skylibrary.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.skylibrary.vo.NoticeVO;
import com.skylibrary.vo.PagingVO;
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
	public List<NoticeVO> NoticeList(PagingVO vo) throws Exception{
		return sql.selectList(namespace + ".noticeList", vo);
	}
	
	//사서 공지사항 작성
	public void NoticeWrite(NoticeVO vo) throws Exception{
		sql.insert(namespace + ".noticeWrite", vo);
	}
	
	//사서 공지사항 조회
	public NoticeVO NoticeView(int noticeNo) throws Exception{
		return sql.selectOne(namespace + ".noticeView", noticeNo);
	}
	
	//사서 공지사항 수정
	public void NoticeModify(NoticeVO vo) throws Exception{
		sql.update(namespace + ".noticeModify", vo);
	}
	
	//사서 공지사항 삭제
	public void NoticeDelete(int noticeNo) throws Exception{
		sql.delete(namespace + ".noticeDelete", noticeNo);
	}
	
	//사서 공지사항 페이징
	public int noticeCountList() throws Exception {
		return sql.selectOne(namespace + ".noticeCountList");
	}
	
	public void updateHit(int noticeNo) throws Exception { 
		sql.update(namespace + ".updateHit", noticeNo);
	}

}
