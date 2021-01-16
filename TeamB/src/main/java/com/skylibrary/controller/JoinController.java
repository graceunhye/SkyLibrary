package com.skylibrary.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skylibrary.service.UserService;
import com.skylibrary.vo.UserVO;

@Controller
public class JoinController {
	
	@Inject
	UserService userService;
	
	//중복확인 get
	@RequestMapping(value = "/IDcheck", method = { RequestMethod.GET , RequestMethod.POST })
	public String isThereID() throws Exception {
		
		return "/User/join/join";
	}
	
	//회원가입 get
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String getJoin() throws Exception {
		return "/User/join/join";
	}
	
	//회원가입 post
	@RequestMapping(value = "/joinOk", method = RequestMethod.POST)
<<<<<<< HEAD
	public String postJoin(UserVO vo, String userNumSplit1, String userNumSplit2, String userNumSplit3) throws Exception {
		
		vo.setUserNum(userNumSplit1,userNumSplit2,userNumSplit3);
=======
	public String postJoin(UserVO vo)throws Exception {
>>>>>>> 4e1c0b5902272a82c80dcbb4b8cd1e4d05198201
		userService.join(vo);
		
		return "/User/loginout/login";
		
	}
	
	/*
	 * // 회원가입 post
	 * 
	 * @RequestMapping(value = "/joinOk", method = RequestMethod.POST) public String
	 * postJoin(UserVO vo, String num1, String num2, String num3) throws Exception {
	 * 
	 * vo.setUserNum(num1+num2+num3); userService.join(vo);
	 * 
	 * return "redirect:/loginout/login"; }
	 */
	



}
