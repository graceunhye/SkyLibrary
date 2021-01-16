package com.skylibrary.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skylibrary.service.ManagerService;
import com.skylibrary.vo.ManagerVO;


@Controller
<<<<<<< HEAD
=======
@RequestMapping(value = "/User")
>>>>>>> 4e1c0b5902272a82c80dcbb4b8cd1e4d05198201
public class ManagerController {

	@Inject
	ManagerService managerservice;
	
<<<<<<< HEAD
	// get
	@RequestMapping(value = "/mjoin", method = RequestMethod.GET)
=======
	// 사서 회원가입 get
	@RequestMapping(value = "/join/mjoin", method = RequestMethod.GET)
>>>>>>> 4e1c0b5902272a82c80dcbb4b8cd1e4d05198201
	public void getMjoin() throws Exception {

	}
	
<<<<<<< HEAD
	// post
	@RequestMapping(value = "/mjoinOk", method = RequestMethod.POST)
=======
	// 사서 회원가입 post
	@RequestMapping(value = "/join/mjoinOk", method = RequestMethod.POST)
>>>>>>> 4e1c0b5902272a82c80dcbb4b8cd1e4d05198201
	public String postMjoin(ManagerVO vo) throws Exception {
		
		managerservice.mjoin(vo);
		
		return "redirect:/";
	}
}
