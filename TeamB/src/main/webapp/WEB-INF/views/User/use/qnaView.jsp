<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		
		<title>질의응답</title>
		
		<link rel="stylesheet" href="/css/common.css" type="text/css"/>
		<link rel="stylesheet" href="/css/use/qna.css" type="text/css"/>
		
		<script src="/js/jquery-3.5.1.min.js"></script>
		<script src="/js/common.js"></script>
	</head>
	<body style="margin:0px">
		<div class="wrap"> 
			<header>
				<jsp:include page="../include/head_option.jsp" />
				<jsp:include page="../include/head_banner.jsp" />
			</header>
			<!-- header end -->
			
			<section id="section">
				<nav class="left_menu">
					<ul>
						<li class="left_menu_title">도서관 이용</li>
						<a href="/use/useTime"><li class="left_menu_sub">이용시간</li></a>
						<a href="/use/useGuide"><li class="left_menu_sub">대출/반납/예약/연장</li></a>
						<a href="/use/qna/"><li class="on left_menu_sub last_sub">질의응답</li></a>
					</ul>
				</nav>
				<!-- nav end -->
				
				<div class="section">
					<div class="section_top">
						<span class="top_title">질의응답</span>
						<span class="page_map">도서관 이용 > 질의응답 > 질문 보기</span>
					</div>
					<div class="content">
						<div class="qTableWrap">
							<h2 class="subTitle"><span class="point">*</span>질문</h2>
							<table border="1" width="1200px" class="qTable">
								<tr height="40px;">
									<th>질문번호</th>
									<td>${q.questionNo }</td>
									<th>질문자</th>
									<td>${q.userID }</td>
									<th>작성일</th>
									<td>${q.questionDate }</td>
								</tr>
								<tr height="40px;">
									<th>질문</th>
									<td colspan="5">${q.questionTitle }</td>
								</tr>
								<tr>
									<td colspan="6" class="body">${q.questionBody }</td>
								</tr>
							</table>
							<input type="button" value="목록으로" onclick="location.href='/use/qna'" class="qna_btn gotolist">
						</div>
						<div>
							<hr class="hr">
							<c:if test="${q.questionType eq 1 }">
								<h2 class="subTitle"><span class="point">*</span>답변</h2>
							<table border="1" class="aTable" width="1200px;" >
								<tr height="40px">
									<th>제목</th>
									<td>${a.answerTitle }</td>
									<th>작성자</th>
									<td>${a.managerID }</td>
									<th>답변일</th>
									<td>${a.answerDate }</td>
								</tr>
								<tr>
									<td colspan="6" class="body">
									${a.answerBody }
									</td>
								</tr>
							</table>
							</c:if>
							<c:if test="${q.questionType != 1 }">
								<span class="aEmpty"><span class="point">*</span>등록된 답변이 없습니다.</span>
							</c:if>
						</div>
					</div>
				</div>
			</section>
			<!-- section end -->
		
			<jsp:include page="../include/footer.jsp"/>
			<!-- footer end -->
		</div>
	</body>
</html>