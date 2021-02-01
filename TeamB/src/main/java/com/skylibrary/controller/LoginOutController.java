package com.skylibrary.controller;

import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.skylibrary.service.ManagerService;
import com.skylibrary.service.UserService;
import com.skylibrary.vo.SessionVO;
import com.skylibrary.vo.UserVO;

@Controller
public class LoginOutController {
	
	@Inject
	UserService userService;
	@Inject
	ManagerService managerService;
	
	
	
	@RequestMapping(value = "/loginout/login")
	public String login(Model model) throws Exception {
		return "/User/loginout/login";
	}
	
	
	//로그인
	@RequestMapping(value = "/loginout/loginOk", method = RequestMethod.POST) 
	public void login(Model model, SessionVO vo, HttpServletRequest req, 
					RedirectAttributes rttr, HttpServletResponse response) throws Exception
	{
		HttpSession session = req.getSession(true);
		SessionVO login = userService.login(vo);
		
		if(login == null) {
			 session.setAttribute("user", null);
			 response.setContentType("text/html; charset=UTF-8");
	         PrintWriter out = response.getWriter();
	         out.println( "<script>"
	        		 	+ "alert('비밀번호 혹은 아이디가 일치하지 않습니다. 다시 시도해주세요.');"
	        		 	+ "location.href='/loginout/login';"
	        		 	+ "</script>");
	         out.flush();
			
		} else {
			 UserVO uservo = userService.userInfoOk(login);
			 //강제탈퇴
			 if(uservo.getUserType()==2 || uservo.getUserType()==1) {
				 response.setContentType("text/html; charset=UTF-8");
		         PrintWriter out = response.getWriter();
		         out.println("<script>"
		        		 	+"alert('탈퇴한 계정입니다. 다시 시도해주세요.');"
		        		 	+"location.href='/loginout/login';"
		        		 	+"</script>");
		         out.flush();
			 }else {
				 session.setAttribute("user", login);
				 response.setContentType("text/html; charset=UTF-8");
		         PrintWriter out = response.getWriter();
		         out.println("<script>"
		        		 	+"alert('로그인에 성공하였습니다.');"
		        		 	+"location.href='/';"
		        		 	+"</script>");
		         out.flush();
			 }
		}
	}
	


	
	//사서 로그인
	@RequestMapping(value = "/mloginout/loginOk", method = RequestMethod.POST) 
	public void mlogin(Model model, SessionVO vo, HttpServletRequest req, 
					RedirectAttributes rttr, HttpServletResponse response) throws Exception
	{
		HttpSession session = req.getSession(true);
		SessionVO login = managerService.mlogin(vo);
		
		//로그인 실패
		if(login == null) {
			
			 session.setAttribute("user", null);
			 response.setContentType("text/html; charset=UTF-8");
	         PrintWriter out = response.getWriter();
	         out.println( "<script>"
	        		 	+ "alert('비밀번호 혹은 아이디가 일치하지 않습니다. 다시 시도해주세요.');"
	        		 	+ "location.href='/loginout/login';"
	        		 	+ "</script>");
	         out.flush();
	         
		//로그인 성공
		} else {

			 session.setAttribute("user", login);
			 response.setContentType("text/html; charset=UTF-8");
	         PrintWriter out = response.getWriter();
	         out.println( "<script>"
	        		 	+ "alert('로그인에 성공하였습니다.');"
	        		 	+ "if(confirm('관리자페이지로 이동하시겠습니까?')){"
	        		 	+ "		location.href='/muser/mUser';"
	        		 	+ "}else{"
	        		 	+ "		location.href='/';"
	        		 	+ "}"
	        		 	+ "</script>");
	         out.flush();
		}
	}
	
	
	
	//로그아웃
	@RequestMapping(value = "/loginout/logout", method = RequestMethod.GET) 
	public void logout(Model model, HttpSession session, RedirectAttributes rttr, HttpServletResponse response) throws Exception {
		session.invalidate();

		response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(  "<script>"
        			+ "alert('로그아웃 되었습니다.');"
        			+ "location.href='/';"
        			+ "</script>");
        out.flush();
	}
	
	
	//아이디 찾기 
	@RequestMapping(value="/loginout/findId")
	public String findId() throws Exception {
		
			return "/User/loginout/findId";		
	}

	
	@RequestMapping(value="/loginout/findIdAjax", method=RequestMethod.POST)
	@ResponseBody
	public String findIdAjax(String userNum, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
			
			String userID = userService.findId(userNum);
			
			return userID;		
	}
	

}
