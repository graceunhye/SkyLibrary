package com.skylibrary.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skylibrary.service.AnswerService;
import com.skylibrary.service.QuestionService;
import com.skylibrary.vo.AnswerVO;
import com.skylibrary.vo.PagingVO;
import com.skylibrary.vo.QuestionVO;
import com.skylibrary.vo.SessionVO;

@Controller
@RequestMapping(value = "/use")
public class UseController {

	@Inject
	QuestionService questionService;
	
	@Inject
	AnswerService answerService;
	
	@RequestMapping(value = "/useGuide")
	public String moveUseGuide() throws Exception {
		System.out.println("In UseController (value=/useGuide)");
		System.out.println("Out UseController (value=/useGuide)");
		return "/User/use/useGuide";
	}
	
	@RequestMapping(value = "/useTime")
	public String moveUseTime() throws Exception {
		System.out.println("In UseController (value=/useTime)");
		System.out.println("Out UseController (value=/useTime)");
		return "/User/use/useTime";
	}
	
	@RequestMapping(value = "/qna")
	public String qnaList(Model model, PagingVO paging) throws Exception {
		int total = questionService.countList();
		
		if(paging.getNowPage() == 0 && paging.getCntPerPage() == 0) {
			paging.setNowPage(1);
			paging.setCntPerPage(15); //페이지당 글 갯수 10개 셋팅
			
		}else if(paging.getNowPage() == 0){
			paging.setNowPage(1);
			
		}else if(paging.getCntPerPage() == 0){
			paging.setCntPerPage(15);
		}
		paging = new PagingVO(total, paging.getNowPage(), paging.getCntPerPage());
		paging.setStart(paging.getStart());
		paging.setEnd(15);
		
		List<QuestionVO> qList = questionService.list(paging);
		model.addAttribute("paging", paging);
		model.addAttribute("questionList",qList);
		
		System.out.println("Out UseController (value=/qna)");
		return "/User/use/qna";
	}
	
	@RequestMapping(value="/qna/qnaView")
	public String qView(Model model, QuestionVO vo) throws Exception {
		System.out.println("In UseController (value=/qna/view)");
		QuestionVO q = questionService.qView(vo);
		System.out.println(vo);
		try {
		int aCount = answerService.aViewCount(vo); //1
		if(aCount == 0) {
			model.addAttribute("a", null);
		}else {
			AnswerVO a = answerService.aView(vo);
			model.addAttribute("a",a);
			System.out.println("a:::"+a);
		}		
		}catch(Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("q",q);
		System.out.println("Out UseController (value=/qna/view)");
		return "/User/use/qnaView";
	}
	
	
	  @RequestMapping(value="/qna/qnaInsert") 
	  public String qInsert(HttpServletRequest request, HttpServletResponse response) throws Exception {
		  
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
	        }
	  return "/User/use/qnaInsert"; }
	 
	
	@RequestMapping(value="/qna/qnaInsertOk")
	public String qInsertOk(Model model, QuestionVO qvo, 
				HttpServletRequest request, HttpServletResponse response) throws Exception {

		questionService.questionAdd(qvo);
		
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
	        }else {
	        	out.println("<script>"
           		 		+"location.href='/use/qna';"
           		 		+"</script>");
            out.flush();
	        }
		
		return "redirect:/use/qna";
	}
	
	@RequestMapping(value="/qna/modify")
	public String qModify(Model model, QuestionVO qvo) throws Exception {
		QuestionVO resultVO = questionService.qView(qvo);
		model.addAttribute("q",resultVO);
		
		return "/User/use/qnaModify";
	}
	
	@RequestMapping(value="/qna/modifyOk")
	public String qModifyOk(Model model, QuestionVO qvo) throws Exception {

		questionService.questionModify(qvo);
		
		return "redirect:/use/qna/qnaView?questionNo="+qvo.getQuestionNo();
	}
	
	@RequestMapping(value="/qna/delete")
	public String qDeleteOk(Model model, QuestionVO qvo) throws Exception {
		
		questionService.questionDelete(qvo);
		model.addAttribute("msg","deleteOk");
		return "redirect:/use/qna";
	}
		
}
