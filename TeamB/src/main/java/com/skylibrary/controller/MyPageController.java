package com.skylibrary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/User/myPage")
public class MyPageController {

	@RequestMapping(value = "/renting")
	public String renting() throws Exception {
		return "/User/myPage/renting";
	}
	
	@RequestMapping(value = "/wish")
	public String wish() throws Exception {
		return "/User/myPage/wish";
	}
	
	@RequestMapping(value = "/wishApply")
	public String wishApply(Model model) throws Exception {
		return "/User/myPage/wishApply";
	}
	
	@RequestMapping(value = "/wishCheck") 
	public String wishCheck(Model model) throws Exception {
		return "/User/myPage/wishCheck";
	}
	
	@RequestMapping(value = "/userInfo")
	public String userInfo() throws Exception {
		return "/User/myPage/userInfo";
	}
	
	
}
