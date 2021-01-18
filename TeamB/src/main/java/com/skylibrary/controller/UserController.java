package com.skylibrary.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.skylibrary.service.UserService;
import com.skylibrary.vo.UserVO;

@Controller
@RequestMapping(value = "/User")
public class UserController {
	
	@Inject
	UserService userService;
	
	
	/** loginout **/
	
	//로그인
	@RequestMapping(value = "/loginout/login", method = RequestMethod.POST) 
	public String login(UserVO vo, HttpServletRequest req, RedirectAttributes rttr) throws Exception
	{
		HttpSession session = req.getSession(true);
		
		UserVO login = userService.login(vo);
		
		if(login == null ) {
			session.setAttribute("user", null);
			rttr.addFlashAttribute("msg", false);
		} else {
			session.setAttribute("user", login);
		}
		return "redirect:/";
	}
	
	//로그아웃
	@RequestMapping(value = "/loginout/logout", method = RequestMethod.GET) 
	public String logout(HttpSession session) throws Exception {
		
		session.invalidate();
		
		return "redirect:/";
	}
	
	
	/** join **/
	
	// 일반회원 회원가입 get
	@RequestMapping(value = "/join/join", method = RequestMethod.GET)
	public void getJoin() throws Exception {

	}
	
	// 일반회원 회원가입 post
	@RequestMapping(value = "/join/joinOk", method = RequestMethod.POST)
	public String postJoin(UserVO vo, String userNumSplit1, String userNumSplit2, String userNumSplit3) throws Exception {
		
		vo.setUserNum(userNumSplit1, userNumSplit3, userNumSplit3);
		userService.join(vo);
		
		return "redirect:/";
	}
	
	
	/** 데이터 값 받지 않고 단순히 이동용도의 메서드 **/
	
	
	/** loginout **/
	
	@RequestMapping(value = "/loginout/moveLogin")
	public String moveLogin() throws Exception {
		return "User/loginout/login";
	}
	
	
	
	/** join **/
	
	@RequestMapping(value = "/join/moveJoin")
	public String moveJoin() throws Exception {
		return "User/join/join";
	}
	
	
	
}
