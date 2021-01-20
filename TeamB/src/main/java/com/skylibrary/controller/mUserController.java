package com.skylibrary.controller;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skylibrary.service.AnswerService;
import com.skylibrary.service.ApplyBookService;
import com.skylibrary.service.QuestionService;
import com.skylibrary.service.RentService;
import com.skylibrary.service.UserService;
import com.skylibrary.vo.RentVO;
import com.skylibrary.vo.SearchVO;
import com.skylibrary.vo.SessionVO;

@Controller
@RequestMapping(value="/muser")
public class mUserController {

	@Inject
	UserService userService;
	
	@Inject
	RentService rentService;
	
	@Inject
	ApplyBookService applyService;
	
	@Inject
	QuestionService questionService;
	
	@Inject
	AnswerService answerService;
	
	
	@RequestMapping(value="/mUser", method=RequestMethod.GET)
	public String getUserList(Locale locale, Model model) throws Exception {
		return "/Manager/muser/mUser";
	}
	
	//조회
	@RequestMapping(value="/ajax/selectOk", method=RequestMethod.GET)
	@ResponseBody
	public List<Map<String,String>> selectOk(SearchVO vo) throws Exception {
		List<Map<String,String>> Result = userService.userSelectOk(vo);
		System.out.println("selectOk::"+Result);
		return Result;
	}
	
	//검색
	@RequestMapping(value="/ajax/searchOk", method=RequestMethod.GET)
	@ResponseBody
	public List<Map<String,String>> searchOk(SearchVO vo) throws Exception {
		List<Map<String,String>> Result = userService.userSearchOk(vo);
		System.out.println("searchOk::"+Result);
		return Result;
	}
	
	
	//대출도서목록
	@RequestMapping(value="/ajax/userRentInfoOk", method=RequestMethod.GET)
	@ResponseBody
	public List<Map<String,String>> userRentInfoOk(RentVO vo) throws Exception {
		List<Map<String,String>> Result = rentService.userRentInfoOk(vo);
		System.out.println("userRentInfoOk::"+Result);
		return Result;
	}
	
	//희망도서목록
	@RequestMapping(value="/ajax/userWishInfoOk", method=RequestMethod.GET)
	@ResponseBody
	public List<Map<String,String>> userWishInfoOk(SessionVO vo) throws Exception {
		List<Map<String,String>> Result = applyService.userWishInfoOk(vo);
		System.out.println("userWishInfoOk::"+Result);
		return Result;
	}
	
	
	//회원 상세정보 조회
	@RequestMapping(value="/ajax/userInfoOk", method=RequestMethod.GET)
	@ResponseBody
	public Map<String,String> userInfoOk(SessionVO vo) throws Exception {
		Map<String,String> Result = userService.userInfoOk(vo);
		System.out.println("userInfoOk::"+Result);
		return Result;
	}
	
	//회원강제탈퇴
	@RequestMapping(value="/ajax/userRemoveOk", method=RequestMethod.GET)
	public void userRemoveOk(SessionVO vo) throws Exception {
		userService.userRemove(vo);
	}
	
}
