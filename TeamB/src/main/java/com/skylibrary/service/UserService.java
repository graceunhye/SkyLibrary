package com.skylibrary.service;

import java.util.List;
import java.util.Map;

import com.skylibrary.vo.SearchVO;
import com.skylibrary.vo.SessionVO;
import com.skylibrary.vo.UserVO;

public interface UserService {
	
	//로그인하기
	public SessionVO login(SessionVO vo) throws Exception;
	
	//회원가입
	public void join(UserVO vo) throws Exception;
	
	//동일 아이디 존재 여부
	public int userExist(UserVO vo) throws Exception;
	
	
	//유저들 정보 조회
	public List<UserVO> userList() throws Exception;
	
	//유저 정보 수정
	public void userModify(UserVO vo) throws Exception;
	
	//조회
	public List<Map<String,String>> userSelectOk(SearchVO vo) throws Exception;
	
	//검색
	public List<Map<String,String>>  userSearchOk(SearchVO vo) throws Exception;
	
	//상제정보 조회
	public Map<String,String> userInfoOk(SessionVO vo) throws Exception;
	
	//유저 삭제 & 유저 탈퇴
	public void userRemove(SessionVO vo) throws Exception;
	
}
