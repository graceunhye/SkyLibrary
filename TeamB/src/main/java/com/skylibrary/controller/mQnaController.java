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
	public JSONArray ajaxAnswerInsert(AnswerVO avo) throws Exception {
		answerService.answerAdd(avo);
		QuestionVO qvo = new QuestionVO();
		qvo.setQuestionNo(avo.getQuestionNo());
		questionService.typeUpdate(qvo);
		answerService.aView(qvo);
		
		JSONArray  qnaArrList = new JSONArray(); 
		JSONObject qnaObject    = new JSONObject(); 
		
		qnaObject.put("answerTitle",avo.getAnswerTitle());
		qnaObject.put("answerBody",avo.getAnswerBody());
		qnaObject.put("answerDate",avo.getAnswerDate());
		qnaObject.put("managerID",avo.getManagerID());
		
		qnaArrList.add(qnaObject);
		return qnaArrList;
	}
	
	
	@RequestMapping(value="/ajax/searchOk")
	public JSONArray ajaxSearch(SearchVO search) throws Exception {
		
		JSONArray qList = new JSONArray();
		
		List<QuestionVO> questionList = questionService.selectTypeList(search);
		for(int i=0; i<questionList.size(); i++) {
			JSONObject qObject = new JSONObject();
			qObject.put("questionNo", questionList.get(i).getQuestionNo());
			qObject.put("questionTitle", questionList.get(i).getQuestionTitle());
			qObject.put("questionBody", questionList.get(i).getQuestionBody());
			qObject.put("questionDate", questionList.get(i).getQuestionDate());
			qObject.put("questionOkDate", questionList.get(i).getQuestionOkDate());
			qObject.put("userID", questionList.get(i).getUserID());
			qList.add(qObject);
		}
		
		return qList;
	}
	
	
	 @RequestMapping(value="/ajax/detailOk") 
	 public JSONArray ajaxDetail(QuestionVO vo) throws Exception {
		JSONObject qnaObject = new JSONObject();
		//번호에 해당하는 질문정보 가져오기
		QuestionVO qvo = questionService.qView(vo);
		AnswerVO avo;
		
		qnaObject.put("questionNo", qvo.getQuestionNo());
		qnaObject.put("questionTitle", qvo.getQuestionTitle());
		qnaObject.put("questionBody", qvo.getQuestionBody());
		qnaObject.put("userID", qvo.getUserID());
		qnaObject.put("questionDate", qvo.getQuestionDate());
		qnaObject.put("questionOkDate", qvo.getQuestionOkDate());
		qnaObject.put("questionType", qvo.getQuestionType());
		
		if(qvo.getQuestionType() == 1) {
			avo = answerService.aView(vo);
			qnaObject.put("answerTitle",avo.getAnswerTitle());
			qnaObject.put("answerBody",avo.getAnswerBody());
			qnaObject.put("answerDate",avo.getAnswerDate());
			qnaObject.put("managerID",avo.getManagerID());
		}
		
		JSONArray qnaArrList = new JSONArray();
		qnaArrList.add(qnaObject);
		
		 return qnaArrList;
	 }
	 
	 @RequestMapping(value="/ajax/aUpdateOk")
	 public JSONArray ajaxAnswerUpdate(AnswerVO vo) throws Exception{
		 JSONArray  jsonArrList = new JSONArray(); 
		 JSONObject jsonList    = new JSONObject();
		 
		 answerService.answerUpdate(vo);
		 
		 QuestionVO qvo = new QuestionVO();
		 qvo.setQuestionNo(vo.getQuestionNo());
		 questionService.typeUpdate(qvo);
		 
		 vo = answerService.aView(qvo);
		 
		 jsonList.put("questionNo",vo.getQuestionNo());
		 jsonList.put("managerID",vo.getManagerID());
		 jsonList.put("answerBody",vo.getAnswerBody());
		 jsonList.put("answerTitle",vo.getAnswerTitle());
		 jsonList.put("answerDate",vo.getAnswerDate());
		 jsonArrList.add(jsonList);
		 
		 return jsonArrList;
	 }
	 
}
