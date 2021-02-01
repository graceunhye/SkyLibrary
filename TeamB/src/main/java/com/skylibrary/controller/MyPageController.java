package com.skylibrary.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skylibrary.service.ApplyBookService;
import com.skylibrary.service.ManagerService;
import com.skylibrary.service.RentService;
import com.skylibrary.service.UserService;
import com.skylibrary.vo.ApplyBookVO;
import com.skylibrary.vo.BookVO;
import com.skylibrary.vo.RentVO;
import com.skylibrary.vo.SearchVO;
import com.skylibrary.vo.SessionVO;
import com.skylibrary.vo.UserVO;

@Controller
@RequestMapping(value = "/myPage")
public class MyPageController {

	@Inject
	RentService rentService;
	@Inject
	UserService userService;
	@Inject
	ApplyBookService applyBookService;
	@Inject
	ManagerService managerService;
	
	
		//사용자정보
		@RequestMapping(value = "/userInfo")
		public String userInfo(Model model, HttpServletRequest req, HttpServletResponse response) throws Exception {
	
			HttpSession session = req.getSession(true);
			SessionVO sessionVO = (SessionVO)session.getAttribute("user");
			
			response.setContentType("text/html; charset=UTF-8");
	        PrintWriter out = response.getWriter();
			
			//비회원
	        if(sessionVO == null) {
	        	
	        	out.println( "<script>"
	           		 		+"alert('로그인이 필요한 서비스입니다. 로그인 화면으로 이동합니다.');"
	           		 		+"location.href='/loginout/login';"
	           		 		+"</script>");
	            out.flush();
	        }
	        
	        //관리자
	        if(managerService.isManager(sessionVO) == 1){
	        	
	        	out.println( "<script>"
	     					+"alert('관리자페이지로 이동합니다.');"
	        				+"location.href='/muser/mUser';"
	        				+"</script>");
	            out.flush();
	        }
	        
	        UserVO vo = userService.userInfoOk(sessionVO);
	        model.addAttribute("userInfo",vo);	
	        
	        return "/User/myPage/userInfo";
		}


		//도서대여 목록
		@RequestMapping(value = "/renting")
		public String renting(Model model, RentVO vo, HttpServletRequest req) throws Exception {

			HttpSession session = req.getSession(true);
				
			SessionVO sessionVO = (SessionVO)session.getAttribute("user");
			vo.setUserID(sessionVO.getUserID());
				
			List<RentVO> rvo = rentService.Rentlist(vo);
			model.addAttribute("rentList", rvo);
			
			return "/User/myPage/renting";
		}

		
		//희망도서
		@RequestMapping(value = "/wish")
		public String wish(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
			
			HttpSession session = request.getSession();
			SessionVO sessionVO = (SessionVO)session.getAttribute("user");
			
			
			response.setContentType("text/html; charset=UTF-8");
	        PrintWriter out = response.getWriter();
			
			//비회원
	        if(sessionVO == null) {
	        	
	        	out.println("<script>"
	           		 		+"alert('로그인이 필요한 서비스입니다. 로그인 화면으로 이동합니다.');"
	           		 		+"location.href='/loginout/login';"
	           		 		+"</script>");
	            out.flush();
	        
	        //관리자
	        }
	        if(managerService.isManager(sessionVO) == 1){
	        	
	        	out.println("<script>"
	        				+"alert('관리자페이지로 이동합니다.');"
	        				+"location.href='/muser/mUser';"
	        				+"</script>");
	            out.flush();
	            
	        }
			return "/User/myPage/wish";
		}
		
		
		//희망도서 신청
		@RequestMapping(value = "/wishApply")
		public String wishApply(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {

			HttpSession session = request.getSession();
			SessionVO sessionVO = (SessionVO)session.getAttribute("user");
			
			
			response.setContentType("text/html; charset=UTF-8");
	        PrintWriter out = response.getWriter();
			
			//비회원
	        if(sessionVO == null) {
	        	
	        	out.println("<script>"
	           		 		+"alert('로그인이 필요한 서비스입니다. 로그인 화면으로 이동합니다.');"
	           		 		+"location.href='/loginout/login';"
	           		 		+"</script>");
	            out.flush();
	        
	        //관리자
	        }
	        if(managerService.isManager(sessionVO) == 1){
	        	
	        	out.println("<script>"
	        				+"alert('관리자페이지로 이동합니다.');"
	        				+"location.href='/muser/mUser';"
	        				+"</script>");
	            out.flush();
	            
	        }
			
			return "/User/myPage/wishApply";
		}
		
		//희망도서 신청처리
		@RequestMapping(value="/wishOk", method = RequestMethod.POST)
		public String wisthApplied(ApplyBookVO vo,HttpServletRequest request, HttpServletResponse response)throws Exception{
			
			HttpSession session = request.getSession();
			SessionVO sessionVO = (SessionVO)session.getAttribute("user");
			
			
			vo.setUserID(sessionVO.getUserID());
			System.out.println("boardVO:"+ vo.toString());
			applyBookService.insert(vo);	
			
			 response.setContentType("text/html; charset=UTF-8");
	         PrintWriter out = response.getWriter();
	         out.println("<script>"
	        		 	+"alert('신청이 완료되었습니다.');"
	        		 	+"location.href='/myPage/wishCheck';"
	        		 	+"</script>");
	         out.flush();
			
			 return "/User/myPage/wishApplyOk";
		}
		
		
		//희망도서 신청 목록
		@RequestMapping(value = "/wishCheck") 
		public String wishCheck(SearchVO searchVO, Model model,  HttpServletRequest req, HttpServletResponse response) throws Exception {
			
			HttpSession session = req.getSession();
			SessionVO sessionVO = (SessionVO)session.getAttribute("user");
			
			response.setContentType("text/html; charset=UTF-8");
	        PrintWriter out = response.getWriter();
			
			//비회원
	        if(sessionVO == null) {
	        	
	        	out.println("<script>"
	           		 		+"alert('로그인이 필요한 서비스입니다. 로그인 화면으로 이동합니다.');"
	           		 		+"location.href='/loginout/login';"
	           		 		+"</script>");
	            out.flush();
	        
	        //관리자
	        }
	        if(managerService.isManager(sessionVO) == 1){
	        	
	        	out.println("<script>"
	     					+"alert('관리자페이지로 이동합니다.');"
	        				+"location.href='/muser/mUser';"
	        				+"</script>");
	            out.flush();
	            
	        }
	        
	        searchVO.setUserID(sessionVO.getUserID());
	        List<ApplyBookVO> vo = applyBookService.view(searchVO);
			model.addAttribute("wishCheckData",vo);
			
			return "/User/myPage/wishCheck";
		}
		
		
	
		@RequestMapping(value = "/ajax/userInfoModifyOk")
		@ResponseBody
		public int userInfoModifyOk(Model model, UserVO vo) throws Exception {
	
			vo.setUserEmail(vo.getUserEmailID(),vo.getUserEmailDomain());
			vo.setUserNum(vo.getUserNumSplit1(), vo.getUserNumSplit2(), vo.getUserNumSplit3());
			userService.userModify(vo);
	
			return 1;
		}
	
		@RequestMapping(value = "/bookExtensionAjax")
		@ResponseBody
		public RentVO extensionBook(@RequestParam("isbn") String bookISBN, Model model, HttpServletRequest req) throws Exception {
			
			RentVO rentVO = new RentVO();
			rentVO.setBookISBN(bookISBN);
			
			HttpSession session = req.getSession(true);
				
			SessionVO sessionVO = (SessionVO)session.getAttribute("user");
			rentVO.setUserID(sessionVO.getUserID());
			
			rentService.extensionBook(rentVO);
			rentVO = rentService.extenstionSelect(rentVO);
			return rentVO;
	
		}
			
		@RequestMapping(value = "/bookReturnAjax")
		@ResponseBody
		public RentVO returnBook(@RequestParam("isbn") String bookISBN, Model model, HttpServletRequest req) throws Exception {
	
			RentVO rentVO = new RentVO();
			rentVO.setBookISBN(bookISBN);
			
			BookVO bookVO = new BookVO();
			bookVO.setBookISBN(bookISBN);
			
			HttpSession session = req.getSession(true);
				
			SessionVO sessionVO = (SessionVO)session.getAttribute("user");
			rentVO.setUserID(sessionVO.getUserID());
			
			rentService.updateBook(bookVO);
			rentService.deleteRent(rentVO);
			
			return rentVO;
		}
	
}
