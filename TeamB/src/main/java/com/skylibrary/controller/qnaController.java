package com.skylibrary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/qna")
public class qnaController {
	
	@RequestMapping(value="/")
	public String qnaList() throws Exception {
		
		
		
		return "/User/intro/qna";
	}
	
}
