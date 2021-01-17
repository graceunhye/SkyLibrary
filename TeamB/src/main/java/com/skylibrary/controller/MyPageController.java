package com.skylibrary.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skylibrary.service.RentService;
import com.skylibrary.service.UserService;
import com.skylibrary.vo.RentVO;
import com.skylibrary.vo.UserVO;

@Controller
@RequestMapping(value = "/myPage")
public class MyPageController {

	@Inject
	RentService rentService;
	UserService userService;
	
	
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

		System.out.println("Out MyPageController (value=/wish)");
		return "/User/myPage/wish";
	}
	
	@RequestMapping(value = "/wishApply")
	public String wishApply(Model model, HttpServletRequest req) throws Exception {
		System.out.println("In MyPageController (value=/wishApply)");
		
		System.out.println("Out MyPageController (value=/wishApply)");
		return "/User/myPage/wishApply";
	}
	
	@RequestMapping(value = "/wishCheck") 
	public String wishCheck(Model model, UserVO vo, HttpServletRequest req) throws Exception {
		System.out.println("In MyPageController (value=/wishCheck)");
	
		System.out.println("Out MyPageController (value=/wishCheck)");
		//희망도서 신청 목록 조회
		return "/User/myPage/wishCheck";
	}
	
	
	@RequestMapping(value = "/userInfo")
	public String userInfo(Model model, HttpServletRequest req) throws Exception {
		System.out.println("In MyPageController (value=/userInfo)");
		
		System.out.println("Out MyPageController (value=/userInfo)");
		return "/User/myPage/userInfo";
	}
	
	@RequestMapping(value = "/userInfoModify")
	public String userInfoModify(Model model) throws Exception {
		return "/User/myPage/userInfoModify";
	}
	
	@RequestMapping(value = "/userInfoModifyOk")
	public String userInfoModifyOk(Model model, UserVO vo) {
		System.out.println("In MyPageController (value=/userInfoModifyOk)");
		
		//수정한 정보를 업데이트문에 넣고 돌림
		//다시 userVO에 셋팅해 넘겨줌.
		
		System.out.println("Out MyPageController (value=/userInfoModifyOk)");
		return "/User/myPage/userInfo";
	}
	
	
	
}
