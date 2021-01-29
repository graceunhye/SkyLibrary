package com.skylibrary.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skylibrary.service.BookService;
import com.skylibrary.vo.BookVO;
import com.skylibrary.vo.SearchVO;

@Controller
@RequestMapping(value="/mbook")
public class mBookController {

	@Inject
	BookService bookService;
	
	@RequestMapping(value="/mBook")
	public String mbook() throws Exception {
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
