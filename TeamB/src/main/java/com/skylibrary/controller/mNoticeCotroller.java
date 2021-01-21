package com.skylibrary.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.mysql.cj.util.StringUtils;
import com.skylibrary.service.NoticeService;
import com.skylibrary.vo.NoticeVO;
import com.skylibrary.vo.PagingVO;
import com.skylibrary.vo.SessionVO;

@Controller
@RequestMapping(value="/Manager/mnotice")
public class mNoticeCotroller {
	
	@Inject
	NoticeService noticeservice;
	
	@RequestMapping(value="/mNotice", method=RequestMethod.GET)
	public String getNoticeList(Locale locale, Model model, PagingVO paging) throws Exception {
		
		int total = noticeservice.noticeCountList();
		
		if(paging.getNowPage() == 0 && paging.getCntPerPage() == 0) {
			paging.setNowPage(1);
			paging.setCntPerPage(10); 
			
		}else if(paging.getNowPage() == 0){
			paging.setNowPage(1);
			
		}else if(paging.getCntPerPage() == 0){
			paging.setCntPerPage(10);
		}
		paging = new PagingVO(total, paging.getNowPage(), paging.getCntPerPage());
		
		List<NoticeVO> NoticeList = null;
		NoticeList = noticeservice.NoticeList(paging);
		
		model.addAttribute("noticelist", NoticeList);
		model.addAttribute("paging", paging);
		
		return "/Manager/mnotice/mNotice";
	}
	
	@RequestMapping(value="/mNoticeInsert", method=RequestMethod.GET)
	public void getNoticeWrite() throws Exception {		
	}

	
	@RequestMapping(value="/mNoticeInsertOk", method=RequestMethod.POST)
	public String postNoticeWrite(NoticeVO vo, HttpServletRequest req) throws Exception {	
		
		HttpSession session = req.getSession(true);
		
		SessionVO sessionVO = (SessionVO)session.getAttribute("user");
		
	
		// 파일 업로드 처리
		String fileName=null;
		
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) req;

		MultipartFile uploadFile = multipartRequest.getFile("notice_file");
		
		if (!uploadFile.isEmpty()) {
			
			String originalFileName = uploadFile.getOriginalFilename();
			String ext = FilenameUtils.getExtension(originalFileName);	//확장자 구하기
			
			UUID uuid = UUID.randomUUID();	//UUID 구하기
			
			fileName = uuid + "." + ext;
			
			uploadFile.transferTo(new File("D:\\gitgit\\TeamB\\src\\main\\webapp\\resources\\upload\\" + fileName));
		}
		
		vo.setUserID(sessionVO.getUserID());
		vo.setFileName(fileName);
		
		noticeservice.NoticeWrite(vo);
					
		
		return "redirect:/Manager/mnotice/mNotice";
		
	}

	@RequestMapping(value="/mNoticeView", method=RequestMethod.GET)
	public String getNoticeView(@RequestParam("noticeNo") int noticeNo, Model model, HttpServletResponse response, HttpServletRequest request) throws Exception {		
		
		// 저장된 쿠키 불러오기 
		Cookie cookies[] = request.getCookies(); 
		Map mapCookie = new HashMap(); 
		if(request.getCookies() != null){ 
			for (int i = 0; i < cookies.length; i++) { 
				Cookie obj = cookies[i]; 
				mapCookie.put(obj.getName(),obj.getValue()); 
			} 
		}
		
		// 저장된 쿠키중에 read_count 만 불러오기 
		String cookie_read_count = (String) mapCookie.get("noticeHit"); 
		
		// 저장될 새로운 쿠키값 생성 
		String new_cookie_read_count = "|" + noticeNo;
		
		// 저장된 쿠키에 새로운 쿠키값이 존재하는 지 검사 
		if ( StringUtils.indexOfIgnoreCase(cookie_read_count, new_cookie_read_count) == -1 ) { 
		
			// 없을 경우 쿠키 생성 
			Cookie cookie = new Cookie("noticeHit", cookie_read_count + new_cookie_read_count); 
		
			//cookie.setMaxAge(1000); // 초단위 
			response.addCookie(cookie); 
		
			// 조회수 업데이트 
			noticeservice.updateHit(noticeNo); 
		}
		
		NoticeVO vo = noticeservice.NoticeView(noticeNo);
		model.addAttribute("noticeView", vo);
		model.addAttribute("noticeNo", vo.getNoticeNo());
		
		return "Manager/mnotice/mNoticeView";

	}
	
	@RequestMapping(value="/mNoticeModify", method=RequestMethod.GET)
	public void getNoticeModify(@RequestParam("noticeNo") int noticeNo, Model model) throws Exception {		
		
		NoticeVO vo = noticeservice.NoticeView(noticeNo);
		model.addAttribute("noticeView", vo);
	}
	
	@RequestMapping(value="/mNoticeModifyOk", method=RequestMethod.POST)
	public String postNoticeModify(NoticeVO vo, HttpServletRequest req) throws Exception {	
		
		HttpSession session = req.getSession(true);
		
		SessionVO sessionVO = (SessionVO)session.getAttribute("user");
		
		// 파일 업로드 처리
		String fileName=null;
		
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) req;

		MultipartFile uploadFile = multipartRequest.getFile("notice_file");
		
		if (!uploadFile.isEmpty()) {
			
			String originalFileName = uploadFile.getOriginalFilename();
			String ext = FilenameUtils.getExtension(originalFileName);	//확장자 구하기
			
			UUID uuid = UUID.randomUUID();	//UUID 구하기
			
			fileName = uuid + "." + ext;
			
			uploadFile.transferTo(new File("D:\\gitgit\\TeamB\\src\\main\\webapp\\resources\\upload\\" + fileName));
		}
		
		vo.setUserID(sessionVO.getUserID());
		vo.setFileName(fileName);
		
		noticeservice.NoticeModify(vo);
					
		return "redirect:/Manager/mnotice/mNoticeView?noticeNo=" + vo.getNoticeNo();
		
	}
	
	@RequestMapping(value="/mNoticeDelete", method=RequestMethod.GET)
	public String getNoticeDelete(@RequestParam("noticeNo") int noticeNo) throws Exception {		
		
		noticeservice.NoticeDelete(noticeNo);
	
		return "redirect:/Manager/mnotice/mNotice";
	}
	
}
