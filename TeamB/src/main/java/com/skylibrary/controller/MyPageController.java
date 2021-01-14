package com.skylibrary.controller;

import java.util.List;

import javax.inject.Inject;

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
	public String renting(Model model, UserVO vo) throws Exception {
		System.out.println("In MyPageController (value=/renting)");
		List<RentVO> rvo = rentService.list(vo);
		model.addAttribute("rentList", rvo);
		System.out.println("Out MyPageController (value=/renting)");
		return "/User/myPage/renting";
	}
	
	@RequestMapping(value = "/wish")
	public String wish() throws Exception {
		System.out.println("In MyPageController (value=/wish)");
		System.out.println("Out MyPageController (value=/wish)");
		return "/User/myPage/wish";
	}
	
	@RequestMapping(value = "/wishApply")
	public String wishApply(Model model) throws Exception {
		System.out.println("In MyPageController (value=/wishApply)");
		System.out.println("Out MyPageController (value=/wishApply)");
		return "/User/myPage/wishApply";
	}
	
	@RequestMapping(value = "/wishCheck") 
	public String wishCheck(Model model, UserVO vo) throws Exception {
		System.out.println("In MyPageController (value=/wishCheck)");
		System.out.println("Out MyPageController (value=/wishCheck)");
		//희망도서 신청 목록 조회
		return "/User/myPage/wishCheck";
	}
	
	@RequestMapping(value = "/userInfo")
	public String userInfo() throws Exception {
		System.out.println("In MyPageController (value=/userInfo)");
		System.out.println("Out MyPageController (value=/userInfo)");
		return "/User/myPage/userInfo";
	}
	
	
}
