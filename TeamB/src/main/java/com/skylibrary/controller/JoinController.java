package com.skylibrary.controller;

import java.util.regex.Pattern;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skylibrary.service.UserService;
import com.skylibrary.vo.UserVO;

@Controller
public class JoinController {
	
	@Inject
	UserService userService;
	
	/*
	 * //중복확인 get
	 * 
	 * @RequestMapping(value = "/IDcheck", method = { RequestMethod.GET ,
	 * RequestMethod.POST }) public String isThereID() throws Exception {
	 * 
	 * return "/User/join/join"; }
	 */
	
	//회원가입 get
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String getJoin() throws Exception {
		return "/User/join/join";
	}
	
	//회원가입 post
	@RequestMapping(value = "/joinOk", method = RequestMethod.POST)
	public String postJoin(Model model, UserVO vo, HttpServletRequest request) throws Exception {
			
		vo.setUserNum(vo.getUserNumSplit1(),vo.getUserNumSplit2(),vo.getUserNumSplit3());
		userService.join(vo);
		
		//mailsender.mailSendWithUserKey(vo.getUserEmail(), vo.getUserID(), request);

		
		return "/User/loginout/login";
	}
	
	@RequestMapping(value = "/idCheck", method = RequestMethod.GET)
	public String idCheck(Model model, UserVO vo) throws Exception {
		
		String userID = vo.getUserID();
		
		int ExistResult = userService.userExist(vo);
		if(ExistResult == 1) 
		{
			model.addAttribute("idCheckResult", "alreadyUse");
		}
		
		if(ExistResult == 0) 
		{
			if(Pattern.matches("^[a-zA-Z0-9]*$", userID) == false) 
			{
				model.addAttribute("idCheckResult", "mismatch");
			}
			else if(userID == "") 
			{
				model.addAttribute("idCheckResult", "idEmpty");
			}else 
			{
				model.addAttribute("idCheckResult","pass");
			}
		}

		return "/User/join/join";
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
