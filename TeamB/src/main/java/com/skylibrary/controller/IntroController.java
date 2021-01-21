package com.skylibrary.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skylibrary.service.NoticeService;
import com.skylibrary.vo.NoticeVO;
import com.skylibrary.vo.PagingVO;
import com.skylibrary.vo.SearchVO;
import com.skylibrary.vo.UserVO;

@Controller
@RequestMapping(value = "/intro")
public class IntroController {

	@Inject
	NoticeService noticeService;
	
	@RequestMapping(value = "/calendar")
	public String calendar(Model model) throws Exception {
		System.out.println("In IntroController (value=/calendar)");
		System.out.println("In IntroController (value=/calendar)");
		return "/User/intro/calendar";
	}
	
	@RequestMapping(value = "/path")
	public String path(Model model) throws Exception {
		System.out.println("In IntroController (value=/path)");
		System.out.println("In IntroController (value=/path)");
		return "/User/intro/path";
	}
	
	
	@RequestMapping(value = "/notice")
	public String list(Model model, SearchVO search, PagingVO paging) throws Exception {
		
		System.out.println("In IntroController (value=/notice)");
		int total = noticeService.countList(search); //10
		
		//nowPage 현재페이지 //0
		//cntPerpage 페이지당 글 갯수 
		if(paging.getNowPage() == 0 && paging.getCntPerPage() == 0) {
			paging.setNowPage(1);
			paging.setCntPerPage(10); //페이지당 글 갯수 10개 셋팅
			
		}else if(paging.getNowPage() == 0){
			paging.setNowPage(1);
			
		}else if(paging.getCntPerPage() == 0){
			paging.setCntPerPage(10);
		}
		
		paging = new PagingVO(total, paging.getNowPage(), paging.getCntPerPage());
		search.setStart(paging.getStart());
		search.setEnd(10);	
		
		List<NoticeVO> list = noticeService.search(search);
		
		model.addAttribute("noticeList", list);
		model.addAttribute("paging", paging);
		System.out.println("Out IntroController (value=/notice)");
		return "/User/intro/notice";
	}
	
	
	
	@RequestMapping(value = "/notice/view")
	public String view(Model model, NoticeVO noticeVO) throws Exception {
		System.out.println("In IntroController (value=/notice/view)");
		NoticeVO resultVO = noticeService.view(noticeVO);
		model.addAttribute("noticeVO",resultVO);
		System.out.println("Out IntroController (value=/notice/view)");
		return "/User/intro/noticeView";
	}
	
}
