package com.skylibrary.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.skylibrary.service.NoticeService;
import com.skylibrary.vo.NoticeVO;
import com.skylibrary.vo.SessionVO;

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

	
	@RequestMapping(value="/mNoticeInsertOk", method=RequestMethod.POST)
	public String postNoticeWrite(NoticeVO vo, HttpServletRequest req) throws Exception {	
		
		HttpSession session = req.getSession(true);
		
		SessionVO sessionVO = (SessionVO)session.getAttribute("user");
		
		vo.setUserID(sessionVO.getUserID());
		noticeservice.NoticeWrite(vo);
		
		return "redirect:/Manager/mnotice/mNotice";
		
	}

	@RequestMapping(value="/mNoticeView", method=RequestMethod.GET)
	public void getNoticeView(@RequestParam("noticeNo") int noticeNo, Model model) throws Exception {		
		
		NoticeVO vo = noticeservice.NoticeView(noticeNo);
		model.addAttribute("noticeView", vo);
	}
	
}
