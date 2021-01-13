package com.skylibrary.service;

import java.util.List;

import com.skylibrary.vo.SearchVO;
import com.skylibrary.vo.aVO;
import com.skylibrary.vo.qVO;

public interface qnaService {
	public List<qVO> list(SearchVO vo) throws Exception;
	public qVO qView(qVO vo) throws Exception;
	public aVO aView(qVO vo) throws Exception;
	public int countList() throws Exception;
}
