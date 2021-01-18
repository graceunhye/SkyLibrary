package com.skylibrary.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.skylibrary.service.ManagerService;
import com.skylibrary.vo.SessionVO;

@Controller
@RequestMapping(value = "/mloginout")
public class mLoginOutController {

		ManagerService managerService;
	
		//로그인
		@RequestMapping(value = "/loginOk", method = RequestMethod.POST) 
		public String login(SessionVO vo, HttpServletRequest req, RedirectAttributes rttr) throws Exception
		{
			System.out.println("In LoginoutController (value=/loginout/loginOk)");
			HttpSession session = req.getSession(true);
			
			SessionVO login = managerService.mlogin(vo);
			if(login == null ) {
				session.setAttribute("user", null);
				rttr.addFlashAttribute("msg", false);
			} else {
				login.setCheck("U");
				session.setAttribute("user", login);
			}
			System.out.println("Out LoginoutController (value=/loginout/loginOk)");
			return "/Manager/mnotice/mNotice";
		} 
}
