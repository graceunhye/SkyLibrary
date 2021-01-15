package com.skylibrary.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skylibrary.service.AnswerService;
import com.skylibrary.service.QuestionService;
import com.skylibrary.vo.AnswerVO;
import com.skylibrary.vo.PagingVO;
import com.skylibrary.vo.QuestionVO;
import com.skylibrary.vo.SearchVO;

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
		System.out.println("In UseController (value=/qna)");
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
		model.addAttribute("qList",qList);
		System.out.println("Out UseController (value=/qna)");
		return "/User/use/qna";
	}
	
	@RequestMapping(value="/qna/view")
	public String qView(Model model, QuestionVO vo) throws Exception {
		System.out.println("In UseController (value=/qna/view)");
		QuestionVO q = questionService.qView(vo);
		
		if(q.getQuestionType() == 1) {
		
			AnswerVO a = answerService.aView(vo);
			model.addAttribute("a",a);
		}
		
		model.addAttribute("q",q);
		System.out.println("Out UseController (value=/qna/view)");
		return "/User/use/qnaView";
	}
		
}
