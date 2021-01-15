package com.skylibrary.controller;

import java.util.List;
/*import java.text.DateFormat;
import java.util.Date;*/
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/*import org.slf4j.Logger;
import org.slf4j.LoggerFactory;*/
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skylibrary.service.BookService;
import com.skylibrary.service.NoticeService;
import com.skylibrary.vo.BookVO;
import com.skylibrary.vo.NoticeVO;
import com.skylibrary.vo.UserVO;

@Controller
public class HomeController {
	
	
	@Inject
	NoticeService noticeService;
	
	@Inject
	BookService bookService;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpServletRequest req) throws Exception {
		System.out.println("In HomeController (value=/)");
		
		UserVO user = loginSession(model, req);
		
		List<BookVO> bookList = bookService.MainList();
		List<NoticeVO> noticeList = noticeService.MainList();
		
		model.addAttribute("bookList",bookList);
		model.addAttribute("noticeList",noticeList);
		model.addAttribute("user",user);
		
		System.out.println("Out HomeController (value=/)");
		return "home";
	}
	
	public UserVO loginSession(Model model,  HttpServletRequest req) throws Exception {
		
		HttpSession session = req.getSession();
		UserVO user = null;
		
		if(session.getAttribute("user") != null) {
			user = (UserVO)session.getAttribute("user");
		}
		
		return user;
	}
	
}
