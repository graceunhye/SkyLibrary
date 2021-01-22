package com.skylibrary.controller;

import javax.inject.Inject;
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

		@Inject
		ManagerService managerService;
	
		//사서 로그인
		@RequestMapping(value = "/loginOk", method = RequestMethod.POST) 
		public String login(SessionVO vo, HttpServletRequest req, RedirectAttributes rttr) throws Exception
		{
			HttpSession session = req.getSession(true);
			
			SessionVO login = managerService.mlogin(vo);
			
			if(login == null ) {
				session.setAttribute("user", null);
				rttr.addFlashAttribute("msg", false);
			} else {
				login.setCheck("M");
				session.setAttribute("user", login);
			}
			return "/Manager/muser/mUser";
		}
}
