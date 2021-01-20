<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.net.URLEncoder"%>
<%@ page session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사서 추천 도서관리</title>
<link rel="stylesheet" href="/css/mCommon.css" type="text/css"/>
<link rel="stylesheet" href="/css/mRecommend/mrecommendView.css" type="text/css"/>
<script src="/js/jquery-3.5.1.min.js"></script>
<script>
	function InsertFn(){			
		$.ajax({
			url : "/Manager/mrecommend/insertAjax",
			type : "post",
			data : "recommend="+$("#recommend").val()+"&isbn="+$("#bookISBN").val(),
			success : function(data){				
				var str = "";
				str += "<span id='titleSp_"+data.recommendNo+"' style='display:inline-block;width:90%;'>" + data.recommendWhy + "</span><br><br>"
				str += "<span id='btnSp_"+data.recommendNo+"'><button type='button' class='optionBox_btn_free' onclick='modifyFn("+data.recommendNo+")'>수정</button> <button type='button' class='optionBox_btn_free' onclick='deleteFn("+data.recommendNo+")'>삭제</button></span>"
				$("#recommend_box").html(str);
			}
		});	
	}
	
	function modifyFn(no){
		var titleVal = $("#titleSp_"+no).text();
		var str1 = "<textarea id='text_"+no+"' cols='100' rows='15'></textarea>";
		var str2 = "<button type='button' class='optionBox_btn_free' onclick='saveFn("+no+")'>저장</button> <button class='optionBox_btn_free' type='button' onclick='deleteFn("+no+")'>삭제</button>";
		$("#titleSp_"+no).html(str1);
		$("#btnSp_"+no).html(str2);
		$("#text_"+no).val(titleVal);
	}
	
	
	function saveFn(no){
		$.ajax({
			url : "/Manager/mrecommend/updateAjax",
			type : "get",
			data : "recommend="+$("#text_"+no).val()+"&no="+no, //"title=tttt&no=17"처럼 파라미터 문자열로 변경해줌
			success : function(data){
				$("#titleSp_"+no).html(data.recommendWhy);
				
				var str = "<button type='button' class='optionBox_btn_free' onclick='modifyFn("+no+")'>수정</button> <button class='optionBox_btn_free' type='button' onclick='deleteFn("+no+")'>삭제</button>";
				$("#btnSp_"+no).html(str);
			}
		});
	}
	
	function deleteFn(no){
		if(confirm("추천 이유를 삭제하시겠습니까?") == true) {
			$.ajax({
				url : "/Manager/mrecommend/deleteAjax",
				type : "get",
				data : "no="+no, //"title=tttt&no=17"처럼 파라미터 문자열로 변경해줌
				success : function(data){
					alert("삭제되었습니다.");
					location.href = "mRecommendView?isbn="+$("#bookISBN").val();
				}
			});
		}	
	}
</script>
</head>
<body style="margin: 0px;">
	<div class="wrap">
		<header>
			<div class="header">
				<div class="title_box"><span class="head_title">관리자 페이지 </span><span class="name">하늘도서관</span></div>
			</div>
		</header>
		<section>
			<jsp:include page="../include/nav.jsp" />
			<div class="section">
				<div class="user_info">
				<span class="info_title"><span class="point">*</span>사서 추천 도서</span>				
				</div>
				<br>
				<br>	
				<div class="content">		
				<div class="searchview">
					<input type="hidden" id="bookISBN" value="${bookView.bookISBN}">
					<div class="searchview1">
						<table border="1" width="800px" style="border-collapse:collapse">
							<tr>
								<td colspan="3" align="center" height="50"><b>${bookView.bookSubject}"</b></td>
							</tr>
							<tr>
								<td rowspan="6" width="15%" align="center">
									<img src="${bookView.bookCoverImg}" alt="${bestView.bookSubject}" width="82px">
								</td>
								<th>저자</th>
								<td>${bookView.bookWriter}</td>
							</tr>
							<tr>
								<th>출판사</th>
								<td>${bookView.bookCompany}</td>							
							</tr>
							<tr>
								<th>발행일</th>
								<td>${bookView.bookPublicationDate}</td>							
							</tr>
							<tr>
								<th>ISBN</th>
								<td>${bookView.bookISBN}</td>							
							</tr>
							<tr>
								<th>소장기관</th>
								<td>하늘 도서관</td>							
							</tr>
						</table>
					</div>
					<br>
					<div class="searchview2">
					| 상세정보
					<br>
					<br>
						<table border="1" width="800px" style="border-collapse:collapse">
							<tr>
								<td>${bookView.bookStory}
								</td>
							</tr>
						</table>
					</div>
					<br>
					<div class="searchview3">
					| 추천이유
					<br>
					<br>
			
					<table border="1" width="800px" style="border-collapse:collapse">  
						<c:choose>  
						    <c:when test="${bookView.recommendWhy != null}">  
								<tr>
									<td>
										<span id="titleSp_${bookView.recommendNo}">${bookView.recommendWhy}</span>
										<br>
										<br>
										<span id="btnSp_${bookView.recommendNo}"><input type="button" class="optionBox_btn_free" id="modify_btn" name="modify_btn" value="수정" onclick="modifyFn(${bookView.recommendNo})">	
										<input type="button" id="delete_btn" name="delete_btn" value="삭제" class="optionBox_btn_free" onclick="deleteFn(${bookView.recommendNo})"></span>	
									</td>
								</tr>  
						    </c:when>   
						    <c:otherwise>  
								<tr>
									<td id="recommend_box">
										<textarea id="recommend" name="recommendWhy" cols="100" rows="15"></textarea>
										<input type="hidden" id="recommend_num" name="recommend_num" value="">
										<input type="button" id="insert_btn" name="insert_btn" value="등록"  class="optionBox_btn_free" onclick="InsertFn()">
									</td>
								</tr>
						    </c:otherwise>  
						</c:choose>  												
					</table> 
					</div>
				</div>
			</div>
			</div>
		</section>
	</div>
</body>
</html>