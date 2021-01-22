<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항</title>

<link rel="stylesheet" href="/css/common.css" type="text/css"/>
<link rel="stylesheet" href="/css/intro/notice.css" type="text/css"/>
</head>
<body style="margin:0px">
	<div class="wrap"> 
	<header>
		<jsp:include page="../include/head_option.jsp" />
		<jsp:include page="../include/head_banner.jsp"/>
	</header>
	<!-- header end -->
	
	<section id="section">
		<nav class="left_menu">
			<ul>
				<li class="left_menu_title">도서관 소개</li>
				<a href="/intro/notice"><li class="on left_menu_sub">공지사항</li></a>
				<a href="/intro/calendar"><li class="left_menu_sub">월별 일정</li></a>
				<a href="/intro/path"><li class="left_menu_sub last_sub">오시는 길</li></a>
			</ul>
		</nav>
		<div class="section">
			<div class="section_top">
				<span class="top_title">공지사항</span>
				<span class="page_map">도서관 소개 > 공지사항</span>
				<div class="content">
					<div class="selectBox">
						<form id="frm" name="frm" method="get" action="/intro/notice">
							<select class="select" name="searchType">
								<option value="all">전체</option>
								<option value="title">제목</option>
								<option value="body">내용</option>
								<option value="writer">작성자</option>
							</select>
							<input type="text" name="searchText" class="searchbox">
							<input type="submit" value="검색" class="search_btn">
						</form>
					</div>		
					<br>
					<br>
					<table class="content_table" style="border-collapse:collapse" width="1200">
						<tr class="top_tr">
							<th align="center" class="top_td">글번호</th>
							<th align="center" class="top_td">제목</th>
							<th align="center" class="top_td">작성자</th>
							<th align="center" class="top_td">작성일</th>
							<th align="center" class="top_td">조회수</th>
						</tr>
						<c:forEach var="list" items="${noticeList}" varStatus="status">
						<tr class="mid_tr">
							<th align="center" class="mid_td">${status.count + paging.start}</th>
							<td>
								<a href="/intro/notice/view?noticeNo=${list.noticeNo }" class="mid_td">
								${list.noticeTitle }
								</a>
							</td>
							<td align="center" class="mid_td">${list.userID }</td>
							<td align="center" class="mid_td">${list.noticeDate }</td>
							<td align="center" class="mid_td">${list.noticeHit }</td>
						</tr>												
						</c:forEach>
					</table>
					<br>
					<br>
					<div class="notice_page">	
						<c:if test="${paging.startPage != 1}">
						<a href="/intro/notice?nowPage=${paging.startPage - 1}&cntPerPage=${paging.cntPerPage}">&lt;</a>
						</c:if>
						<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="p">
							<!-- 현재 페이지면 진하게, 아니면 링크갖고 진하지 않도록! -->
							<c:choose>
								<c:when test="${p eq paging.nowPage}">
									<b>${p}</b>
								</c:when>
								<c:when test="${p != paging.nowPage}">
									<a href="/intro/notice?nowPage=${p }&cntPerPage=${paging.cntPerPage}">${p }</a>
								</c:when>
							</c:choose>
						</c:forEach>
						<c:if test="${paging.endPage != paging.lastPage}">
							<a href="/intro/notice?nowPage=${paging.startPage + 1}&cntPerPage=${paging.cntPerPage}">&gt;</a>
						</c:if>
					</div>			
				</div>										
			</div>
		</div>
	</section>
	<!-- section end -->
	
	<jsp:include page="../include/footer.jsp" />
	<!-- footer end -->
	</div>
</body>
</html>