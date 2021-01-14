package com.skylibrary.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.skylibrary.service.UserService;
import com.skylibrary.vo.UserVO;

@Controller
@RequestMapping(value = "/loginout")
public class LoginOutController {
	
	@Inject
	UserService userService;
	
	@RequestMapping(value = "/login")
	public String login() throws Exception {
		return "User/loginout/login";
	}
	
	//로그인
	@RequestMapping(value = "/loginOk", method = RequestMethod.POST) 
	public String login(UserVO vo, HttpServletRequest req, RedirectAttributes rttr) throws Exception
	{
		HttpSession session = req.getSession();
		
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
	@RequestMapping(value = "/logout", method = RequestMethod.GET) 
	public String logout(HttpSession session) throws Exception {
		
		session.invalidate();
		
		return "redirect:/";
	}
		
	
}
