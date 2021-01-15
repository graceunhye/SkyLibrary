package com.skylibrary.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skylibrary.service.UserService;
import com.skylibrary.vo.UserVO;

@Controller
@RequestMapping(value = "/join")
public class JoinController {
	
	@Inject
	UserService userService;
	
	// 회원가입 get
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String getJoin() throws Exception {
		return "/User/join/join";
	}
	
	// 회원가입 post
	@RequestMapping(value = "/joinOk", method = RequestMethod.POST)
	public String postJoin(UserVO vo, String num1, String num2, String num3) throws Exception {
		
		vo.setUserNum(num1+num2+num3);
		userService.join(vo);
		
		return "redirect:/";
	}

}
