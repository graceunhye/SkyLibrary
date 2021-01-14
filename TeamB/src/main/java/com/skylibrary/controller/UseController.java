package com.skylibrary.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skylibrary.service.qnaService;
import com.skylibrary.vo.PagingVO;
import com.skylibrary.vo.SearchVO;
import com.skylibrary.vo.aVO;
import com.skylibrary.vo.qVO;

@Controller
@RequestMapping(value = "/User/use")
public class UseController {

	@Inject
	qnaService qnaservice;	
	
	@RequestMapping(value = "/useGuide")
	public String moveUseGuide() throws Exception {
		return "/User/use/useGuide";
	}
	
	@RequestMapping(value = "/useTime")
	public String moveUseTime() throws Exception {
		return "/User/use/useTime";
	}
	
	@RequestMapping(value="/qna")
	public String qnaList(Model model, PagingVO paging, SearchVO search) throws Exception {
		System.out.println("int qnaController");
		int total = qnaservice.countList();
		
		if(paging.getNowPage() == 0 && paging.getCntPerPage() == 0) {
			paging.setNowPage(1);
			paging.setCntPerPage(15); //페이지당 글 갯수 10개 셋팅
			
		}else if(paging.getNowPage() == 0){
			paging.setNowPage(1);
			
		}else if(paging.getCntPerPage() == 0){
			paging.setCntPerPage(15);
		}
		paging = new PagingVO(total, paging.getNowPage(), paging.getCntPerPage());
		search.setStart(paging.getStart());
		search.setEnd(15);
		List<qVO> qList = qnaservice.list(search);
		model.addAttribute("paging", paging);
		model.addAttribute("qList",qList);
		System.out.println("out qnaController");
		return "/User/use/qna";
	}
	
	@RequestMapping(value="/qna/view")
	public String qView(Model model, qVO vo) throws Exception {
		
		qVO q = qnaservice.qView(vo);
		
		if(q.getQuestionType() == 1) {
		
			aVO a = qnaservice.aView(vo);
			model.addAttribute("a",a);
		}
		
		model.addAttribute("q",q);
		
		
		return "/User/use/qnaView";
	}
		
}
