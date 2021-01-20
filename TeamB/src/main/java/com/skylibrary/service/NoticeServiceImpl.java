package com.skylibrary.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.skylibrary.dao.NoticeDAO;
import com.skylibrary.vo.NoticeVO;
import com.skylibrary.vo.PagingVO;
import com.skylibrary.vo.SearchVO;

@Service
public class NoticeServiceImpl implements NoticeService {

	
	@Inject
	NoticeDAO dao;
	
	@Override
	public List<NoticeVO> MainList() throws Exception {
		return dao.MainList();
	}

	@Override
	public List<NoticeVO> search(SearchVO vo) throws Exception {
		return dao.list(vo);
	}

	@Override
	public int countList(SearchVO vo) throws Exception {
		return dao.countList(vo);
	}

	@Override
	public NoticeVO view(NoticeVO vo) throws Exception {
		return dao.view(vo);
	}
	
	//사서 공지사항 목록
	@Override
	public List<NoticeVO> NoticeList(PagingVO vo) throws Exception{
		return dao.NoticeList(vo);
	}
		
	//사서 공지사항 작성
	@Override
	public void NoticeWrite(NoticeVO vo) throws Exception{
		dao.NoticeWrite(vo);
	}
	
	//사서 공지사항 조회
	@Override
	public NoticeVO NoticeView(int noticeNo) throws Exception{
		return dao.NoticeView(noticeNo);
	}
	
	//사서 공지사항 수정
	@Override
	public void NoticeModify(NoticeVO vo) throws Exception {
		dao.NoticeModify(vo);
	}

	//사서 공지사항 삭제
	@Override
	public void NoticeDelete(int noticeNo) throws Exception {
		dao.NoticeDelete(noticeNo);
	}
	
	//사서 공지사항 페이징
	@Override
	public int noticeCountList() throws Exception {
		return dao.noticeCountList();
	}

	//사서 공지사항 조회수
	@Override
	public void updateHit(int noticeNo) throws Exception {
		dao.updateHit(noticeNo);	
	}
}
