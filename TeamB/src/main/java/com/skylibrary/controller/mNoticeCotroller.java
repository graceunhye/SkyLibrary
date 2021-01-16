package com.skylibrary.controller;

import java.util.List;
<<<<<<< HEAD

import javax.inject.Inject;
=======
import java.util.Locale;
>>>>>>> 4e1c0b5902272a82c80dcbb4b8cd1e4d05198201

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skylibrary.service.NoticeService;
import com.skylibrary.vo.NoticeVO;

@Controller
@RequestMapping(value="/Manager/mnotice")
public class mNoticeCotroller {
	
	@Inject
	NoticeService noticeservice;
	
	@RequestMapping(value="/mNotice", method=RequestMethod.GET)
	public void getNoticeList(Model model) throws Exception {
		
		List<NoticeVO> NoticeList = null;
		NoticeList = noticeservice.NoticeList();
		
		model.addAttribute("noticelist", NoticeList);
	}
	
	@RequestMapping(value="/mNoticeInsert", method=RequestMethod.GET)
	public void getNoticeWrite() throws Exception {		
	}

	@RequestMapping(value="/mNoticeInsert", method=RequestMethod.POST)
	public String postNoticeWrite(NoticeVO vo) throws Exception {	
		noticeservice.NoticeWrite(vo);
		
		return "redirect:/Manager/mnotice/mNotice";
		
	}
}
