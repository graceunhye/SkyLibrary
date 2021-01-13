package com.skylibrary.service;

import java.util.List;

import com.skylibrary.vo.NoticeVO;
import com.skylibrary.vo.SearchVO;

public interface NoticeService {
	//main에  공지사항 리스트 구하는 메서드
	public List<NoticeVO> MainList() throws Exception;
	//검색어 받아 게시물 조회하는 메서드
	public List<NoticeVO> search(SearchVO vo) throws Exception;
	//리스트 갯수 구하는 메서드
	public int countList(SearchVO vo) throws Exception;
	
	public NoticeVO view(NoticeVO vo) throws Exception;
 }
