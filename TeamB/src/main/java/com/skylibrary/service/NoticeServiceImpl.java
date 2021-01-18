package com.skylibrary.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.skylibrary.dao.NoticeDAO;
import com.skylibrary.vo.NoticeVO;
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
	public List<NoticeVO> NoticeList() throws Exception{
		return dao.NoticeList();
	}
		
	//사서 공지사항 작성
	@Override
	public void NoticeWrite(NoticeVO vo) throws Exception{
		dao.NoticeWrite(vo);
	}
	
	@Override
	public NoticeVO NoticeView(int noticeNo) throws Exception{
		return dao.NoticeView(noticeNo);
	}
}
