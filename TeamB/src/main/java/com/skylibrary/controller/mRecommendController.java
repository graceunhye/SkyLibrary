package com.skylibrary.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/mrecommend")
public class mRecommendController {
	
	@RequestMapping(value="/mRecommend", method=RequestMethod.GET)
	public void getRecommendList(Locale locale, Model model) throws Exception {
		
	}
}
