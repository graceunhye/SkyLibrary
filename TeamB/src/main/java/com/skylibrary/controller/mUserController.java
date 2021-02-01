package com.skylibrary.controller;

import java.io.PrintWriter;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skylibrary.service.AnswerService;
import com.skylibrary.service.ApplyBookService;
import com.skylibrary.service.ManagerService;
import com.skylibrary.service.QuestionService;
import com.skylibrary.service.RentService;
import com.skylibrary.service.UserService;
import com.skylibrary.vo.AnswerVO;
import com.skylibrary.vo.SearchVO;
import com.skylibrary.vo.SessionVO;
import com.skylibrary.vo.UserVO;

@Controller
@RequestMapping(value="/muser")
public class mUserController {

	@Inject
	UserService userService;
	
	@Inject
	RentService rentService;
	
	@Inject
	ApplyBookService applyService;
	
	@Inject
	QuestionService questionService;
	
	@Inject
	AnswerService answerService;
	
	@Inject
	ManagerService managerService;
	
	@RequestMapping(value="/mUser", method=RequestMethod.GET)
	public String getUserList(Locale locale, Model model, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		SessionVO sessionVO = (SessionVO)session.getAttribute("user");
		
		response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
		
		//비회원
        if(sessionVO == null) {
        	
        	out.println("<script>"
        				+"location.href='/';"
           		 		+"</script>");
            out.flush();
        }else if(managerService.isManager(sessionVO) != 1){
        	out.println("<script>"
       		 		+"location.href='/';"
       		 		+"</script>");
        out.flush();
        }
		
		return "/Manager/muser/mUser";
	}
	
	
	//검색
	@RequestMapping(value="/ajax/searchOk", method=RequestMethod.GET)
	@ResponseBody
	public List<Map<String,String>> searchOk(SearchVO vo) throws Exception {

		List<Map<String,String>> Result = userService.userSearchOk(vo);

		return Result;
	}
	
	
	
	//희망도서목록
	@RequestMapping(value="/ajax/userWishInfoOk", method=RequestMethod.GET)
	@ResponseBody
	public List<Map<String,String>> userWishInfoOk(SessionVO vo) throws Exception {
		List<Map<String,String>> Result = applyService.userWishInfoOk(vo);
		System.out.println("userWishInfoOk::"+Result);
		return Result;
	}
	
	//회원 대출정보 조회
	@RequestMapping(value="/ajax/userRentInfo", method=RequestMethod.GET)
	@ResponseBody
	public List<Map<String,String>> userRentInfo(SessionVO vo) throws Exception {
		System.out.println("userID::"+vo.getUserID());
		List<Map<String,String>> rentInfo = rentService.userRentInfo(vo);
		return rentInfo;
	}
	
	
	//회원 상세정보 조회
	@RequestMapping(value="/ajax/userInfoOk", method=RequestMethod.GET)
	@ResponseBody
	public UserVO userInfoOk(SessionVO vo) throws Exception {
		UserVO Result = userService.userInfoOk(vo);
		System.out.println("userInfoOk::"+Result);
		return Result;
	}
	
	//회원강제탈퇴
	@RequestMapping(value="/ajax/userRemoveOk", method=RequestMethod.GET)
	@ResponseBody
	public void userRemoveOk(SessionVO vo) throws Exception {
		System.out.println("인");
		
		//답변이 있는 질문의 번호 조회
		List<AnswerVO> answervo = questionService.userQuestionList(vo); 
		for(int i=0;i<answervo.size();i++) {
			//답변삭제
			answerService.answerRemove(answervo.get(i).getQuestionNo());
		} 
		//답변 없는 질문들 모두 삭제
		questionService.questionRemove(vo);
		//사용자가 등록한 희망도서신청 모두 삭제
		applyService.applyRemove(vo);
		
		//사용자 타입 2:강제탈퇴 로 업데이트
		userService.userRemove(vo);
	
	}
	
}
