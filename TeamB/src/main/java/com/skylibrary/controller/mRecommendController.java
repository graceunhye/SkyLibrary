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

import com.skylibrary.service.BookService;
import com.skylibrary.vo.BookVO;
import com.skylibrary.vo.PagingVO;
import com.skylibrary.vo.SearchVO;
import com.skylibrary.vo.UserVO;

@Controller
@RequestMapping(value="/Manager/mrecommend")
public class mRecommendController {
	
	@Inject
	BookService bookService;
	
	@RequestMapping(value="/mRecommend", method=RequestMethod.GET)
	public String getRecommendList(Locale locale, Model model, SearchVO search, PagingVO paging) throws Exception {
		
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
		
		return "/Manager/mrecommend/mRecommend"; 
	}
	
	@RequestMapping(value="/mRecommendView", method=RequestMethod.GET)
	public String getTotalView(@RequestParam("isbn") String isbn, Model model, HttpServletRequest request) throws Exception {
		
		BookVO vo = bookService.bookView(isbn);
		HttpSession session = request.getSession();
		
		UserVO user = (UserVO) session.getAttribute("user");
		int result = 0;
		
		if(user != null) {
			result = bookService.bookViewCnt(user.getUserID());	
		}
		
		model.addAttribute("bookView", vo);
		model.addAttribute("user", user);
		model.addAttribute("cnt", result);
		
		return "/Manager/mrecommend/mRecommendView";
	}
}
