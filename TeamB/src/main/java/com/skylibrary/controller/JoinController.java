package com.skylibrary.controller;

import java.io.PrintWriter;
import java.util.regex.Pattern;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.skylibrary.service.ManagerService;
import com.skylibrary.service.UserService;
import com.skylibrary.vo.ManagerVO;
import com.skylibrary.vo.UserVO;

@Controller
public class JoinController {
	
	@Inject
	UserService userService;
	@Inject
	ManagerService managerService;
	
	
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() throws Exception {
		return "/User/join/join";
	}
	
	
	@RequestMapping(value = "/mjoin", method = RequestMethod.GET)
	public String mjoin() throws Exception {
		return "/Manager/mjoin/mjoin";
	}
	
	
	//회원가입
	@RequestMapping(value = "/joinOk", method = RequestMethod.POST)
	public void postJoin(Model model, UserVO vo, RedirectAttributes rttr, HttpServletResponse response) throws Exception {

		vo.setUserNum(vo.getUserNumSplit1(),vo.getUserNumSplit2(),vo.getUserNumSplit3());
		vo.setUserEmail(vo.getUserEmailID(), vo.getUserEmailDomain());
		userService.join(vo);
		
		 response.setContentType("text/html; charset=UTF-8");
         PrintWriter out = response.getWriter();
         out.println( "<script>"
        		 	+ "alert('회원가입에 성공하였습니다. 로그인을 해주세요!');"
        		 	+ "location.href='/loginout/login';"
        		 	+ "</script>");
         out.flush();
	}
	

	//사서 회원가입
	@RequestMapping(value = "/mjoinOk", method = RequestMethod.POST)
	public String postMjoin(Model model, ManagerVO vo, HttpServletResponse response) throws Exception {
		
		vo.setManagerEmail(vo.getManagerEmailID(),vo.getManagerEmailDomain());
		vo.setManagerNum(vo.getManagerNumSplit1(),vo.getManagerNumSplit2(),vo.getManagerNumSplit3());

		managerService.mjoin(vo);	
		
		response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<script>"
       		 		+"alert('회원가입에 성공하였습니다. 로그인을 해주세요!');"
       		 		+"loation.href='/loginout/login';"
       		 		+"</script>");
        out.flush();
		
		return "/User/loginout/login";
	}
	
	
	@RequestMapping(value = "/join/ajax/idCheckOk", method = RequestMethod.GET)
	@ResponseBody
	public String idCheck(Model model, UserVO vo) throws Exception {
		
		String checkResult = null;
		int ExistResult = userService.userExist(vo);
		if(ExistResult == 1) 
		{
			checkResult="alreadyUse";
		}
		
		if(ExistResult == 0) 
		{
			if(Pattern.matches("^[a-zA-Z0-9]*$", vo.getUserID()) == false) 
			{
				checkResult="mismatch";
			}else 
			{
				checkResult="pass";
			}
		}

		return checkResult;
	}
	

}
