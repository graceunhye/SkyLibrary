package com.skylibrary.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.skylibrary.service.ManagerService;
import com.skylibrary.vo.ManagerVO;
import com.skylibrary.vo.SessionVO;
import com.skylibrary.vo.UserVO;


@Controller
public class ManagerController {

	@Inject
	ManagerService managerservice;
	
	// get
	@RequestMapping(value = "/mjoin", method = RequestMethod.GET)
	public void getMjoin() throws Exception {

	}
	
	// post
	@RequestMapping(value = "/mjoinOk", method = RequestMethod.POST)
	public String postMjoin(ManagerVO vo) throws Exception {
		
		managerservice.mjoin(vo);
		
		return "redirect:/";
	}
	
	//사서 로그인
	@RequestMapping(value = "/loginout/mlogin", method = RequestMethod.POST) 
	public String login(SessionVO vo, HttpServletRequest req, RedirectAttributes rttr) throws Exception
	{
		HttpSession session = req.getSession(true);
		
		SessionVO login = managerservice.mlogin(vo);
		
		if(login == null ) {
			session.setAttribute("user", null);
			rttr.addFlashAttribute("msg", false);
		} else {
			login.setCheck("M");
			session.setAttribute("user", login);
		}
		return "Manager/muser/mUser";
	}
}
