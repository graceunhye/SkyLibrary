package com.skylibrary.controller;

//import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.regex.Pattern;

import javax.inject.Inject;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.skylibrary.service.ManagerService;
import com.skylibrary.service.UserService;
import com.skylibrary.vo.ManagerVO;
import com.skylibrary.vo.SessionVO;
import com.skylibrary.vo.UserVO;

@Controller
public class JoinController {
	
	@Inject
	JavaMailSender mailSender; 
	@Inject
	UserService userService;
	@Inject
	ManagerService managerService;
	
	
	@RequestMapping(value="/email")
	@ResponseBody
	public int email(UserVO vo, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//vo.setUserEmail(userEmailID,userEmailDomain);
		
		 Random r = new Random();
         int dice = r.nextInt(4589362) + 49311; //이메일로 받는 인증코드 부분 (난수)
         
         String setfrom = "9rac.eun@gmail.com";
         String tomail = vo.getUserEmailID()+"@"+vo.getUserEmailDomain(); // 받는 사람 이메일
         System.out.println("tomail::"+tomail);
         String title = "회원가입 인증 이메일 입니다."; // 제목
         String content =
         
         System.getProperty("line.separator")+ //한줄씩 줄간격을 두기위해 작성
         
         System.getProperty("line.separator")+
                 
         "안녕하세요 회원님 저희 도서관을 찾아주셔서 감사합니다"
         
         +System.getProperty("line.separator")+
         
         System.getProperty("line.separator")+
 
         " 인증번호는 " +dice+ " 입니다. "
         
         +System.getProperty("line.separator")+
         
         System.getProperty("line.separator")+
         
         "받으신 인증번호를 홈페이지에 입력해 주시면 다음으로 넘어갑니다."; // 내용
         
         
         try {
             MimeMessage message = mailSender.createMimeMessage();
             MimeMessageHelper messageHelper = new MimeMessageHelper(message,
                     true, "UTF-8");

             messageHelper.setFrom(setfrom); // 보내는사람 생략하면 정상작동을 안함
             messageHelper.setTo(tomail); // 받는사람 이메일
             messageHelper.setSubject(title); // 메일제목은 생략이 가능하다
             messageHelper.setText(content); // 메일 내용
             
             mailSender.send(message);
         } catch (Exception e) {
             System.out.println(e);
         }
         
         return dice;
         
     }
 
	
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
		System.out.println("userID:::::"+vo.getUserID());
		String checkResult = null;
		int ExistResult = userService.userExist(vo);
		if(ExistResult == 1) 
		{
			checkResult="alreadyUse";
		}else if(ExistResult == 0) 
		{
			if(Pattern.matches("^[a-zA-Z0-9]*$", vo.getUserID()) == false) 
			{
				checkResult="mismatch";
			}else 
			{
				checkResult="pass";
			}
		}else {
			ExistResult = 0; 
		}
		System.out.println("ExistResult:::"+ExistResult);
		return checkResult;
	}
	
	@RequestMapping(value = "/mjoin/ajax/idCheckOk", method = RequestMethod.GET)
	@ResponseBody
	public String mIdCheck(Model model, SessionVO vo) throws Exception {
		System.out.println("userID:::::"+vo.getUserID());
		String checkResult = null;
		int ExistResult = managerService.isManager(vo);
		if(ExistResult == 1) 
		{
			checkResult="alreadyUse";
		}else if(ExistResult == 0) 
		{
			if(Pattern.matches("^[a-zA-Z0-9]*$", vo.getUserID()) == false) 
			{
				checkResult="mismatch";
			}else 
			{
				checkResult="pass";
			}
		}else {
			ExistResult = 0; 
		}
		System.out.println("ExistResult:::"+ExistResult);
		return checkResult;
	}
	
	@RequestMapping(value = "/mjoin/ajax/codeCheckOk", method = RequestMethod.GET)
	@ResponseBody
	public String codeCheckOk(ManagerVO vo) throws Exception {
		String userInsertCode = vo.getManagerCode();
		System.out.println("userInsertCode::"+userInsertCode);
		String realCode = "ezen007";
		String checkResult = "";
		if(userInsertCode.equals(realCode)) {
			checkResult = "ok";
		}else {
			checkResult = "no";
		}
		System.out.println("checkResult::"+checkResult);
		return checkResult;
	}

}
