package com.skylibrary.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skylibrary.service.ManagerService;
import com.skylibrary.vo.ManagerVO;


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
}
