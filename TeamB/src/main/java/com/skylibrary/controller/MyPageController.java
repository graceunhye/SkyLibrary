package com.skylibrary.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skylibrary.service.RentService;
import com.skylibrary.vo.RentVO;
import com.skylibrary.vo.UserVO;

@Controller
@RequestMapping(value = "/myPage")
public class MyPageController {

	@Inject
	RentService rentService;
	
	
	@RequestMapping(value = "/renting")
	public String renting(Model model, UserVO vo, HttpServletRequest req) throws Exception {
		System.out.println("In MyPageController (value=/renting)");
		HttpSession session = req.getSession();
		UserVO user = null;
		
		if(session.getAttribute("user") != null) {
			user = (UserVO)session.getAttribute("user");
		}
		List<RentVO> rvo = rentService.list(vo);
		model.addAttribute("rentList", rvo);
		model.addAttribute("user",user);
		System.out.println("Out MyPageController (value=/renting)");
		return "/User/myPage/renting";
	}
	
	@RequestMapping(value = "/wish")
	public String wish(Model model, HttpServletRequest req) throws Exception {
		System.out.println("In MyPageController (value=/wish)");
		HttpSession session = req.getSession();
		UserVO user = null;
		
		if(session.getAttribute("user") != null) {
			user = (UserVO)session.getAttribute("user");
		}
		model.addAttribute("user",user);
		System.out.println("Out MyPageController (value=/wish)");
		return "/User/myPage/wish";
	}
	
	@RequestMapping(value = "/wishApply")
	public String wishApply(Model model, HttpServletRequest req) throws Exception {
		System.out.println("In MyPageController (value=/wishApply)");
		HttpSession session = req.getSession();
		UserVO user = null;
		
		if(session.getAttribute("user") != null) {
			user = (UserVO)session.getAttribute("user");
		}
		model.addAttribute("user",user);
		System.out.println("Out MyPageController (value=/wishApply)");
		return "/User/myPage/wishApply";
	}
	
	@RequestMapping(value = "/wishCheck") 
	public String wishCheck(Model model, UserVO vo, HttpServletRequest req) throws Exception {
		System.out.println("In MyPageController (value=/wishCheck)");
		HttpSession session = req.getSession();
		UserVO user = null;
		
		if(session.getAttribute("user") != null) {
			user = (UserVO)session.getAttribute("user");
		}
		model.addAttribute("user",user);
		System.out.println("Out MyPageController (value=/wishCheck)");
		//희망도서 신청 목록 조회
		return "/User/myPage/wishCheck";
	}
	
	
	@RequestMapping(value = "/userInfo")
	public String userInfo(Model model, HttpServletRequest req) throws Exception {
		System.out.println("In MyPageController (value=/userInfo)");
		HttpSession session = req.getSession();
		UserVO user = null;
		if(session.getAttribute("user") != null) {
			user = (UserVO)session.getAttribute("user");
		}
		
		//아이디값으로 정보 조회
		model.addAttribute("user",user);
		System.out.println("Out MyPageController (value=/userInfo)");
		return "/User/myPage/userInfo";
	}
	
	
	
}
