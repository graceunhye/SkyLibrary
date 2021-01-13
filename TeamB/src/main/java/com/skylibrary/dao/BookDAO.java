package com.skylibrary.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.skylibrary.vo.BookVO;

@Repository
public class BookDAO {
	
	@Inject
	SqlSession sql;
	
	private static final String namespace = "com.skylibrary.mappers.bookMapper";
	
	public List<BookVO> MainList() {
		return sql.selectList(namespace + ".listMain"); 
	}
}
