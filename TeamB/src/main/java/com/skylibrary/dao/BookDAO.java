package com.skylibrary.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.skylibrary.vo.BookVO;
import com.skylibrary.vo.PagingVO;
import com.skylibrary.vo.SearchVO;

@Repository
public class BookDAO {
	
	@Inject
	SqlSession sql;
	
	private static final String namespace = "com.skylibrary.mappers.bookMapper";
	
	public List<BookVO> MainList() {
		return sql.selectList(namespace + ".listMain"); 
	}
	
	public List<BookVO> TotalList(SearchVO vo) throws Exception {
		return sql.selectList(namespace + ".total", vo); 
	}
	
	public int countList(SearchVO vo) throws Exception {
		return sql.selectOne(namespace + ".countList", vo);
	}
	
	public List<BookVO> BestList(PagingVO vo) throws Exception {
		return sql.selectList(namespace + ".best", vo); 
	}
	
	public BookVO bookView(String isbn) throws Exception{
		return sql.selectOne(namespace + ".bookView", isbn); 
	}

	public int bookViewCnt(String id) throws Exception{
		return sql.selectOne(namespace + ".bookCnt", id); 
	}
	
	public int updateBook(BookVO vo) {
		return sql.update(namespace + ".updateBook", vo);
	}
	
	public int insertRent(BookVO vo) {
		return sql.insert(namespace + ".insertRent", vo);
	}
	
	public BookVO selectRent(int rentNo) {
		return sql.selectOne(namespace + ".selectRent", rentNo);
	}
	
	public List<BookVO> NewList(PagingVO vo) throws Exception {
		return sql.selectList(namespace + ".new", vo); 
	}
	
	public List<BookVO> RecommendList(PagingVO vo) throws Exception {
		return sql.selectList(namespace + ".recommend", vo); 
	}
	
	public int newCountList() throws Exception {
		return sql.selectOne(namespace + ".newCountList");
	}
	
	public int bestCountList() throws Exception {
		return sql.selectOne(namespace + ".bestCountList");
	}
	
	public int recommendCountList() throws Exception {
		return sql.selectOne(namespace + ".recommendCountList");
	}
	
	public List<BookVO> mBookList(SearchVO vo) throws Exception {
		return sql.selectList(namespace + ".mBookList", vo);
	}
	
	public void bookAddOk(BookVO vo) throws Exception {
		sql.insert(namespace + ".bookAddOk", vo);
	}
	
	public void bookDeleteOk(BookVO vo) throws Exception {
		sql.delete(namespace + ".bookDeleteOk", vo);
	}
	
	
}
