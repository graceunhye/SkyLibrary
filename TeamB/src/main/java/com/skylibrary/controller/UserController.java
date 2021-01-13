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
	public String login(Model model, UserVO vo, HttpServletRequest req, RedirectAttributes rttr) throws Exception
	{
		HttpSession session = req.getSession();
		if(userService.login(vo) == null) {
			session.setAttribute("user", null);
			rttr.addFlashAttribute("msg", false);
		}else {
			session.setAttribute("user", vo);
		}
		return "redirect:/";
	}
	
	//로그아웃
	@RequestMapping(value = "/loginout/logout", method = RequestMethod.GET) 
	public String logout(HttpSession session) throws Exception {
		
		session.invalidate();
		
		return "home";
	}
	
	
	/** join **/
	//회원가입
	@RequestMapping(value = "/join/join", method = RequestMethod.POST)
	public String join(Model model, UserVO vo) throws Exception {
		
		
		return "User/loginout/login";
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
