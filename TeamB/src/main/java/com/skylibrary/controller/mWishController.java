package com.skylibrary.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/Manager/mwish")
public class mWishController {
	
	@RequestMapping(value="/mWish", method=RequestMethod.GET)
	public void getWishList(Locale locale, Model model) throws Exception {
		
	}
}
