<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		
		<title>질의응답</title>
		
		<link rel="stylesheet" href="/css/common.css" type="text/css"/>
		<link rel="stylesheet" href="/css/use/qna.css" type="text/css"/>
		
		<script src="/js/jquery-3.5.1.min.js"></script>
		<script src="/js/use/qna.js"></script>
	</head>
	<body style="margin:0px">
		<input type="hidden" id="msg" value="${msg }">
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
						<a href="/use/qna"><li class="on left_menu_sub last_sub">질의응답</li></a>
					</ul>
				</nav>
				<div class="section">
					<div class="section_top">
						<span>질의응답</span>
						<span>도서관 이용 > 질의응답</span>
					</div>
					<div class="content">
						<div align="center">	
							<table width="1200px" class="qnaTable">
								<tr height="50px" class="top_tr">
									<th align="center" class="top_td">글번호</th>
									<th width="500" class="top_td">제목</th>
									<th align="center" class="top_td">작성자</th>
									<th align="center" class="top_td">작성일</th>
									<th align="center" class="top_td">상태</th>
								</tr>
								<c:forEach items="${questionList }" var="list" varStatus="status">
								<tr>
									<td>${status.count + paging.start}</td>
									<td>
										<a href="/use/qna/qnaView?questionNo=${list.questionNo }">${list.questionTitle }</a>
									</td>
									<td>${list.userID }</td>
									<td>${list.questionDate }</td>
									<td>
										<c:if test="${list.questionType eq 1 }">
											<font color="orange">답변완료</font>
										</c:if>
										<c:if test="${list.questionType eq 0 }">
											<font color="blue">답변대기</font>
										</c:if>
									</td>
								</tr>
								</c:forEach>
							</table>
							<br>
							<span class="btns">
								<c:if test="${sessionScope.user != null }">
								<input class="btn" type="button" value="글쓰기" onclick="location.href='/use/qna/qnaInsert'">
								</c:if>
								<c:if test="${sessionScope.user == null }">
								<input class="btn" type="button" value="글쓰기" onclick="qnaNeedLogin()">
								</c:if>
							</span>
							<br>
						</div>
						<div class="searchpage">	
						<c:if test="${paging.startPage != 1}">
						<a href="/use/qna?nowPage=${paging.startPage - 1}&cntPerPage=${paging.cntPerPage}">&lt;</a>
						</c:if>
						<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="p">
							<!-- 현재 페이지면 진하게, 아니면 링크갖고 진하지 않도록! -->
							<c:choose>
								<c:when test="${p eq paging.nowPage}">
									<b>${p}</b>
								</c:when>
								<c:when test="${p != paging.nowPage}">
									<a href="/use/qna?nowPage=${p }&cntPerPage=${paging.cntPerPage}">${p }</a>
								</c:when>
							</c:choose>
						</c:forEach>
						<c:if test="${paging.endPage != paging.lastPage}">
							<a href="/use/qna?nowPage=${paging.startPage + 1}&cntPerPage=${paging.cntPerPage}">&gt;</a>
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
</html></html>