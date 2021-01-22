package com.skylibrary.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	@RequestMapping(value="/qna/view")
	public String qView(Model model, QuestionVO vo) throws Exception {
		System.out.println("In UseController (value=/qna/view)");
		QuestionVO q = questionService.qView(vo);
		/*
		 * if(q.getQuestionType() == 1) {
		 * 
		 * AnswerVO a = answerService.aView(vo); model.addAttribute("a",a); }
		 */
		
		int aCount = answerService.aViewCount(vo);
		if(aCount == 0) {
			model.addAttribute("a", null);
		}else {
			AnswerVO a = answerService.aView(vo);
			model.addAttribute("a",a);
		}		
		model.addAttribute("q",q);
		System.out.println("Out UseController (value=/qna/view)");
		return "/User/use/qnaView";
	}
	
	
	  @RequestMapping(value="/qna/insert") public String qInsert(Model model,
	  QuestionVO vo) throws Exception {
	  
	  return "/User/use/qnaInsert"; }
	 
	
	@RequestMapping(value="/qna/insertOk")
	public String qInsertOk(Model model,
			QuestionVO qvo/* , HttpServletRequest request, RedirectAttributes rttr */) throws Exception {
		
		/*
		 * HttpSession session = request.getSession(); SessionVO vo = (SessionVO)
		 * session.getAttribute("user");
		 * 
		 * String userID = vo.getUserID(); qvo.setUserID(userID);
		 */
		System.out.println("qvo::"+ qvo.getUserID() + "," + qvo.getQuestionTitle() + "," + qvo.getQuestionBody());
		questionService.questionAdd(qvo); //userID, questionBody, questionTitle
		
		System.out.println("Out UseController (value=/qna/insertOk)");
		
		/*
		 * //마지막으로 등록된 no값 반환 int lastNo = questionService.lastNo();
		 * null 에러
		 */
		
		//qView에 no값 전달
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
		System.out.println("qvo-questionNo::"+qvo.getQuestionNo());
		System.out.println("body::"+qvo.getQuestionBody());
		System.out.println("title::"+qvo.getQuestionTitle());
		//qvo를 업데이트하고
		//qna/view로 연결
		questionService.questionModify(qvo);
		
		return "redirect:/use/qna/view?questionNo="+qvo.getQuestionNo()+"";
	}
	
	@RequestMapping(value="/qna/delete")
	public String qDeleteOk(Model model, QuestionVO qvo) throws Exception {
		
		questionService.questionDelete(qvo);
		model.addAttribute("msg","deleteOk");
		return "redirect:/use/qna";
	}
		
}
