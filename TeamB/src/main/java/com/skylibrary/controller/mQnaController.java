package com.skylibrary.controller;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skylibrary.service.AnswerService;
import com.skylibrary.service.QuestionService;
import com.skylibrary.vo.AnswerVO;
import com.skylibrary.vo.QuestionVO;
import com.skylibrary.vo.SearchVO;

import net.sf.json.JSONArray;
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
	
	@RequestMapping(value="/ajax/aInsertOk")
	@ResponseBody
	public Map<String,String> ajaxAnswerInsert(AnswerVO avo) throws Exception {
		//등록
		answerService.answerAdd(avo);
		
		//업데이트
		QuestionVO qvo = new QuestionVO();
		qvo.setQuestionNo(avo.getQuestionNo());
		questionService.typeUpdate(qvo);

		//조회
		Map<String,String> answerMap = answerService.aViewMap(avo);

		
		System.out.println("map::"+answerMap);
		return answerMap;
	}
	
	
	@RequestMapping(value="/ajax/searchOk")
	@ResponseBody
	public List<QuestionVO> ajaxSearch(SearchVO search) throws Exception {
		
		List<QuestionVO> questionList = questionService.selectTypeList(search);

		System.out.println("questionList::"+questionList);
		return questionList;
	}
	

	@RequestMapping(value="/ajax/detailOk", method=RequestMethod.POST)
	@ResponseBody
	 public Map<String,String> ajaxDetail(QuestionVO vo) throws Exception {

		Map<String, String> map = questionService.qnaView(vo);

		
		System.out.println("in detailOk map::"+map);
		
		 return map;
	 }
	 
	 
	 
	 @RequestMapping(value="/ajax/aUpdateOk")
	 @ResponseBody
	 public Map<String,String> ajaxAnswerUpdate(AnswerVO vo) throws Exception{
	
		 answerService.answerUpdate(vo);
		 
		 QuestionVO qvo = new QuestionVO();
		 qvo.setQuestionNo(vo.getQuestionNo());
		 questionService.typeUpdate(qvo);
		 
		 Map<String,String> map = answerService.aViewMap(vo);
		 System.out.println("aUpdateOk map::"+map);
		 return map;
	 }
	 
}
