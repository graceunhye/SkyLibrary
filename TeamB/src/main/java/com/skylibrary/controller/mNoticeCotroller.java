package com.skylibrary.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/mnotice")
public class mNoticeCotroller {
	
	@RequestMapping(value="/mnotice", method=RequestMethod.GET)
	public void getUserList(Locale locale, Model model) throws Exception {
		
	}
}
