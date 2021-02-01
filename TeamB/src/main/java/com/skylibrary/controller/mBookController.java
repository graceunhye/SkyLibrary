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
import org.springframework.web.bind.annotation.ResponseBody;

import com.skylibrary.service.BookService;
import com.skylibrary.service.ManagerService;
import com.skylibrary.vo.BookVO;
import com.skylibrary.vo.SearchVO;
import com.skylibrary.vo.SessionVO;

@Controller
@RequestMapping(value="/mbook")
public class mBookController {

	@Inject
	BookService bookService;
	
	@Inject
	ManagerService managerService;
	
	@RequestMapping(value="/mBook")
	public String mbook(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
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
        
		return "/Manager/mbook/mBook";
	}
	
	@RequestMapping(value="/ajax/searchOk")
	@ResponseBody
	public List<BookVO> searchOk(SearchVO vo) throws Exception {
		List<BookVO> bookList = bookService.mBookList(vo);
		return bookList;
	}
	
	@RequestMapping(value="/ajax/bookAddOk")
	@ResponseBody
	public String bookAddOk(BookVO vo) throws Exception {

		try {
			bookService.bookAddOk(vo);	
		}catch(Exception e) {
			return "false";
		}
		return "true";
	}
	
	@RequestMapping(value="/ajax/bookDeleteOk")
	@ResponseBody
	public String bookDeleteOk(BookVO vo) throws Exception {
		try {
		bookService.bookDeleteOk(vo);
		}catch(Exception e) {
			
			e.printStackTrace();
			return "false";
		}
		return "true";
	}
	
}
