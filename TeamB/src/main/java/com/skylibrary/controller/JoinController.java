package com.skylibrary.controller;

import java.util.regex.Pattern;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skylibrary.service.ManagerService;
import com.skylibrary.service.UserService;
import com.skylibrary.vo.ManagerVO;
import com.skylibrary.vo.UserVO;

@Controller
public class JoinController {
	
	@Inject
	UserService userService;
	@Inject
	ManagerService managerService;
	
	//회원가입 get
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String getJoin() throws Exception {
		return "/User/join/join";
	}
	
	//회원가입 post
	@RequestMapping(value = "/joinOk", method = RequestMethod.POST)
	public String postJoin(Model model, UserVO vo, HttpServletRequest request) throws Exception {
		System.out.println(vo);
		vo.setUserNum(vo.getUserNumSplit1(),vo.getUserNumSplit2(),vo.getUserNumSplit3());
		userService.join(vo);
		
		//mailsender.mailSendWithUserKey(vo.getUserEmail(), vo.getUserID(), request);
		return "/User/loginout/login";
	}
	
	@RequestMapping(value = "/join/ajax/idCheckOk", method = RequestMethod.GET)
	@ResponseBody
	public String idCheck(Model model, UserVO vo) throws Exception {
		
		String checkResult = null;
		int ExistResult = userService.userExist(vo);
		if(ExistResult == 1) 
		{
			checkResult="alreadyUse";
		}
		
		if(ExistResult == 0) 
		{
			if(Pattern.matches("^[a-zA-Z0-9]*$", vo.getUserID()) == false) 
			{
				checkResult="mismatch";
			}else 
			{
				checkResult="pass";
			}
		}
		System.out.println("checkResult::"+checkResult);

		return checkResult;
	}
	
	
		// 사서 회원가입 get
		@RequestMapping(value = "/mjoin", method = RequestMethod.GET)
		public String getMjoin() throws Exception {
			return "/Manager/mjoin/mjoin";
		}
		
		// 사서 회원가입 post
		@RequestMapping(value = "/mjoinOk", method = RequestMethod.POST)
		public String postMjoin(ManagerVO vo) throws Exception {
			vo.setManagerEmail(vo.getManagerEmailID(),vo.getManagerEmailDomain());
			vo.setManagerNum(vo.getManagerNumSplit1(),vo.getManagerNumSplit2(),vo.getManagerNumSplit3());
			System.out.println("managerVO::"+vo);
			managerService.mjoin(vo);	
			return "redirect:/";
		}
		



}
