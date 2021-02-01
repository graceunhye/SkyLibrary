package com.skylibrary.controller;

import java.io.PrintWriter;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skylibrary.service.BookService;
import com.skylibrary.service.ManagerService;
import com.skylibrary.service.RecommendService;
import com.skylibrary.vo.BookVO;
import com.skylibrary.vo.PagingVO;
import com.skylibrary.vo.RecommendVO;
import com.skylibrary.vo.SearchVO;
import com.skylibrary.vo.SessionVO;
//import com.skylibrary.vo.UserVO;

@Controller
@RequestMapping(value="/mrecommend")
public class mRecommendController {
	
	@Inject
	BookService bookService;
	
	@Inject
	RecommendService recommendService;
	
	@Inject
	ManagerService managerService;
	
	@RequestMapping(value="/mRecommend", method=RequestMethod.GET)
	public String getRecommendList(Locale locale, Model model, SearchVO search,
			PagingVO paging, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
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
	public String getRecommendView(@RequestParam("isbn") String isbn, Model model,
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
		
		BookVO vo = bookService.bookView(isbn);
		
		model.addAttribute("bookView", vo);
		
		return "/Manager/mrecommend/mRecommendView";
	}
	
	@RequestMapping(value="/insertAjax", method=RequestMethod.POST)
	@ResponseBody
	public BookVO AjaxInsert(@RequestParam("recommend") String recommendWhy, @RequestParam("isbn") String bookISBN, HttpServletRequest request) throws Exception {
		
		BookVO bookVO = new BookVO();
		bookVO.setRecommendWhy(recommendWhy);
		bookVO.setBookISBN(bookISBN);
		
		HttpSession session = request.getSession(true);
		
		SessionVO vo = (SessionVO)session.getAttribute("user");
		bookVO.setUserID(vo.getUserID());

		recommendService.insertRbook(bookVO);
		
		return bookVO;
	}
	
	@RequestMapping(value="/updateAjax", method=RequestMethod.GET)
	@ResponseBody
	public RecommendVO AjaxUpdate(@RequestParam("recommend") String recommendWhy, @RequestParam("no") int recommendNo, HttpServletRequest request) throws Exception {
		
		RecommendVO recommendVO = new RecommendVO();
		recommendVO.setRecommendWhy(recommendWhy);
		recommendVO.setRecommendNo(recommendNo);
		
		HttpSession session = request.getSession(true);
		
		SessionVO vo = (SessionVO)session.getAttribute("user");
		recommendVO.setManagerID(vo.getUserID());

		recommendService.updateRbook(recommendVO);
		
		return recommendVO;
	}
	
	@RequestMapping(value="/deleteAjax", method=RequestMethod.GET)
	@ResponseBody
	public RecommendVO AjaxDelete(@RequestParam("no") int recommendNo, HttpServletRequest request) throws Exception {
		
		RecommendVO recommendVO = new RecommendVO();
		recommendVO.setRecommendNo(recommendNo);
		
		HttpSession session = request.getSession(true);
		
		SessionVO vo = (SessionVO)session.getAttribute("user");
		recommendVO.setManagerID(vo.getUserID());

		recommendService.deleteRbook(recommendVO);
		
		return recommendVO;
	}	
	
}
