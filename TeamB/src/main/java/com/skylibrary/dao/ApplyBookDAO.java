package com.skylibrary.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class ApplyBookDAO {
	
	@Inject
	SqlSession sql;
	
	private static final String namespace = "com.skylibrary.mappers.applyBookMapper";
	
	
}
