package com.skylibrary.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.skylibrary.service.BookService;
import com.skylibrary.service.NoticeService;
import com.skylibrary.vo.BookVO;
import com.skylibrary.vo.NoticeVO;


@Controller
public class HomeController {
	
	
	@Inject
	NoticeService noticeService;
	@Inject
	BookService bookService;
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) throws Exception {
		
		List<BookVO> bookList = bookService.MainList();
		List<NoticeVO> noticeList = noticeService.MainList();
		
		model.addAttribute("bookList",bookList);
		model.addAttribute("noticeList",noticeList);
		
		return "home";
	}
	
	// web에서 error location url 뒤에 오는 값을 변수로 받겠다는 의미
	 @RequestMapping(value="/error{error_code}")
	    public ModelAndView error(HttpServletRequest request, @PathVariable String error_code) {
	        
		 	//return page /error
	    	ModelAndView mv = new ModelAndView("/error");
	    	
	        String msg = "";
	       //(String) request.getAttribute("javax.servlet.error.message"); 
	       // error_code = (String) request.getAttribute("javax.servlet.error.status_code");
	        
	        Map<String, Object> map = new HashMap<String, Object>();
	        
	        map.put("STATUS_CODE", request.getAttribute("javax.servlet.error.status_code"));
	       // map.put("REQUEST_URI", request.getAttribute("javax.servlet.error.request_uri"));
	       // map.put("EXCEPTION_TYPE", request.getAttribute("javax.servlet.error.exception_type"));
	       // map.put("EXCEPTION", request.getAttribute("javax.servlet.error.exception"));
	       // map.put("SERVLET_NAME", request.getAttribute("javax.servlet.error.servlet_name"));
	         
	        try {
	            int status_code = Integer.parseInt(error_code);
	            switch (status_code) {
	            case 400: msg = "잘못된 요청입니다."; break;
	            case 403: msg = "접근이 금지되었습니다."; break;
	            case 404: msg = "페이지를 찾을 수 없습니다."; break;
	            case 405: msg = "요청된 메소드가 허용되지 않습니다."; break;
	            case 500: msg = "서버에 오류가 발생하였습니다."; break;
	            case 503: msg = "서비스를 사용할 수 없습니다."; break;
	            default: msg  = "알 수 없는 오류가 발생하였습니다."; break;
	            }
	            
	        } catch(Exception e) {
	            msg = "기타 오류가 발생하였습니다.";
	        } finally {
	            map.put("MASSAGE", msg);
	        }
	         
	        //logging
	        /*if(map.isEmpty() == false ) {
	            Iterator<Entry<String,Object>> iterator = map.entrySet().iterator();
	            Entry<String,Object> entry = null;
	            while(iterator.hasNext()) {
	                entry = iterator.next();
	            }
	        }*/
	         
	        mv.addObject("error", map);
	        return mv;
	    }
	
}
