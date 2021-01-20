package com.skylibrary.controller;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skylibrary.service.BookService;
import com.skylibrary.vo.BookVO;
import com.skylibrary.vo.PagingVO;
import com.skylibrary.vo.SearchVO;
import com.skylibrary.vo.SessionVO;
import com.skylibrary.vo.UserVO;

@Controller
@RequestMapping(value = "/search")
public class SearchController {

	@Inject
	BookService bookService;
	
	@RequestMapping(value="/total", method=RequestMethod.GET)
	public String getTotal(Locale locale, Model model, SearchVO search, PagingVO paging) throws Exception {
		
		int total = bookService.countList(search); 

		if(paging.getNowPage() == 0 && paging.getCntPerPage() == 0) {
			paging.setNowPage(1);
			paging.setCntPerPage(5); 
			
		}else if(paging.getNowPage() == 0){
			paging.setNowPage(1);
			
		}else if(paging.getCntPerPage() == 0){
			paging.setCntPerPage(5);
		}
		
		paging = new PagingVO(total, paging.getNowPage(), paging.getCntPerPage());
		search.setStart(paging.getStart());
		search.setEnd(5);
		
		List<BookVO> totallist = bookService.TotalList(search);
		
		model.addAttribute("totallist", totallist);
		model.addAttribute("paging", paging);
		model.addAttribute("search", search);
		model.addAttribute("totalCount",total);
		
		return "/User/search/total"; 
	}	
		
	@RequestMapping(value="/totalView", method=RequestMethod.GET)
	public String getTotalView(@RequestParam("isbn") String isbn, Model model, HttpServletRequest request) throws Exception {
		
		BookVO vo = bookService.bookView(isbn);
		HttpSession session = request.getSession(true);
		
		SessionVO sessionVO = (SessionVO)session.getAttribute("user");
		int result = 0;
		
		if(sessionVO != null) {
			result = bookService.bookViewCnt(sessionVO.getUserID());	
		}
		
		model.addAttribute("bookView", vo);
		model.addAttribute("user", sessionVO);
		model.addAttribute("cnt", result);
		
		return "/User/search/totalView";
	}
	
	@RequestMapping(value= "/best", method=RequestMethod.GET)
	public String getBest(Locale locale, Model model, PagingVO paging) throws Exception {
		
		int total = bookService.bestCountList();

		if(paging.getNowPage() == 0 && paging.getCntPerPage() == 0) {
			paging.setNowPage(1);
			paging.setCntPerPage(5); 
			
		}else if(paging.getNowPage() == 0){
			paging.setNowPage(1);
			
		}else if(paging.getCntPerPage() == 0){
			paging.setCntPerPage(5);
		}
		paging = new PagingVO(total, paging.getNowPage(), paging.getCntPerPage());

		List<BookVO> bestlist = bookService.BestList(paging);
		
		model.addAttribute("bestlist", bestlist);
		model.addAttribute("paging", paging);
		
		return "/User/search/best"; 
	}
	
	@RequestMapping(value="/bestView", method=RequestMethod.GET)
	public String getBestView(@RequestParam("isbn") String isbn, Model model, HttpServletRequest request) throws Exception {
		
		BookVO vo = bookService.bookView(isbn);
		HttpSession session = request.getSession();
		
		SessionVO sessionVO = (SessionVO)session.getAttribute("user");
		int result = 0;
		
		if(sessionVO != null) {
			result = bookService.bookViewCnt(sessionVO.getUserID());	
		}
		
		model.addAttribute("bookView", vo);
		model.addAttribute("user", sessionVO);
		model.addAttribute("cnt", result);
		
		return "/User/search/bestView";
	}
	
	@RequestMapping(value="/bookViewAjax", method=RequestMethod.POST)
	@ResponseBody
	public BookVO AjaxUpdate(@RequestParam("isbn") String isbn,HttpServletRequest request) throws Exception {
		
		BookVO bookVO = new BookVO();
		bookVO.setBookISBN(isbn);
		
		HttpSession session = request.getSession();
		SessionVO vo = (SessionVO)session.getAttribute("user");
		
		if(vo != null) {
			bookVO.setUserID(vo.getUserID());
		}
		
		bookService.updateBook(bookVO);
		bookService.insertRent(bookVO);
		bookVO = bookService.selectRent(bookVO.getNo());
		
		return bookVO;
	}

	@RequestMapping(value="/new", method=RequestMethod.GET)
	public String getNew(Locale locale, Model model, PagingVO paging) throws Exception {
		
		int total = bookService.newCountList();

		if(paging.getNowPage() == 0 && paging.getCntPerPage() == 0) {
			paging.setNowPage(1);
			paging.setCntPerPage(5); 
			
		}else if(paging.getNowPage() == 0){
			paging.setNowPage(1);
			
		}else if(paging.getCntPerPage() == 0){
			paging.setCntPerPage(5);
		}
		paging = new PagingVO(total, paging.getNowPage(), paging.getCntPerPage());

		List<BookVO> newlist = bookService.NewList(paging);
		
		model.addAttribute("newlist", newlist);
		model.addAttribute("paging", paging);
		
		return "/User/search/new"; 
	}
	
	@RequestMapping(value="/newView", method=RequestMethod.GET)
	public String getNewView(@RequestParam("isbn") String isbn, Model model, HttpServletRequest request) throws Exception {
		
		BookVO vo = bookService.bookView(isbn);
		HttpSession session = request.getSession();
		
		SessionVO sessionVO = (SessionVO)session.getAttribute("user");
		int result = 0;
		
		if(sessionVO != null) {
			result = bookService.bookViewCnt(sessionVO.getUserID());	
		}
		
		model.addAttribute("bookView", vo);
		model.addAttribute("user", sessionVO);
		model.addAttribute("cnt", result);
		
		return "/User/search/newView";
	}
	
	@RequestMapping(value="/recommend", method=RequestMethod.GET)
	public String getRecommend(Locale locale, Model model, PagingVO paging) throws Exception {
		
		int total = bookService.recommendCountList();

		if(paging.getNowPage() == 0 && paging.getCntPerPage() == 0) {
			paging.setNowPage(1);
			paging.setCntPerPage(5); 
			
		}else if(paging.getNowPage() == 0){
			paging.setNowPage(1);
			
		}else if(paging.getCntPerPage() == 0){
			paging.setCntPerPage(5);
		}
		
		paging = new PagingVO(total, paging.getNowPage(), paging.getCntPerPage());

		List<BookVO> recommendlist = bookService.RecommendList(paging);
		
		model.addAttribute("recommendlist", recommendlist);
		model.addAttribute("paging", paging);
		
		return "/User/search/recommend"; 
	}
	
	@RequestMapping(value="/recommendView", method=RequestMethod.GET)
	public String getRecommendView(@RequestParam("isbn") String isbn, Model model) throws Exception {
		
		BookVO vo = bookService.bookView(isbn);
		
		model.addAttribute("bookView", vo);
		
		return "/User/search/recommendView";
	}
}
