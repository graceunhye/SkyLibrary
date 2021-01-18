package com.skylibrary.controller;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skylibrary.service.AnswerService;
import com.skylibrary.service.QuestionService;
import com.skylibrary.vo.AnswerVO;
import com.skylibrary.vo.QuestionVO;
import com.skylibrary.vo.SearchVO;

import net.sf.json.JSONObject;

@Controller
@RequestMapping(value="/mqna")
public class mQnaController {
	
	@Inject
	QuestionService questionService;
	@Inject
	AnswerService answerService;

	
	@RequestMapping(value="/mQna", method=RequestMethod.GET)
	public String getQnaList(Locale locale, Model model) throws Exception {
		return "/Manager/mqna/mQna";
	}
	
	@RequestMapping(value="/ajax/searchOk")
	public List<QuestionVO> ajaxSearch(SearchVO search) throws Exception {
		
		List<QuestionVO> questionList = questionService.selectTypeList(search);
		
		return questionList;
	}
	
	
	 @RequestMapping(value="/ajax/detailOk") 
	 public JSONObject ajaxDetail(QuestionVO vo) throws Exception {
		JSONObject qObject = new JSONObject();
		JSONObject aObject = new JSONObject();
		//번호에 해당하는 질문정보 가져오기
		QuestionVO qvo = questionService.qView(vo);
		AnswerVO avo;
		
		qObject.put("questionNo", qvo.getQuestionNo());
		qObject.put("questionTitle", qvo.getQuestionTitle());
		qObject.put("questionBody", qvo.getQuestionBody());
		qObject.put("userID", qvo.getUserID());
		qObject.put("questionDate", qvo.getQuestionDate());
		qObject.put("questionOkDate", qvo.getQuestionOkDate());
		qObject.put("questionType", qvo.getQuestionType());
		
		if(qvo.getQuestionType() == 1) {
			avo = answerService.aView(vo);
			
		}
		
		 return null;
	 }
	 
}
