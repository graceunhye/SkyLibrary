package com.skylibrary.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/mqna")
public class mQnaController {
	
	@RequestMapping(value="/mqna", method=RequestMethod.GET)
	public void getQnaList(Locale locale, Model model) throws Exception {
		
	}
}
