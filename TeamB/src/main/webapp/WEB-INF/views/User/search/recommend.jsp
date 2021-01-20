<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ page session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		
		<title>사서추천도서</title>
		
		<link rel="stylesheet" href="/css/common.css" type="text/css"/>
		<link rel="stylesheet" href="/css/search/recommend.css" type="text/css"/>
		
		<script src="/js/jquery-3.5.1.min.js"></script>
		<script src="/js/common.js"></script>
	</head>
	<body style="margin:0px">
		<div class="wrap"> 
			<header>
				<jsp:include page="../include/head_option.jsp"/>
				<jsp:include page="../include/head_banner.jsp"/>
			</header>
			<!-- header end -->
			
			<section id="section">
				<nav class="left_menu">
					<ul>
						<li class="left_menu_title">도서검색</li>
						<a href="/search/total"><li class="left_menu_sub">통합검색</li></a>
						<a href="/search/best"><li class="left_menu_sub">인기도서</li></a>
						<a href="/search/new"><li class="left_menu_sub">신착도서</li></a>
						<a href="/search/recommend"><li class="on left_menu_sub last_sub">사서추천도서</li></a>
					</ul>
				</nav>
				<div class="section">
					<div class="section_top">
						<span class="top_title">사서추천도서</span>
						<span class="page_map">도서검색 > 사서추천도서</span>
					</div>
					<div class="content">
						<div class="booklist">	
						<br>
						<br>
							<c:forEach items="${recommendlist}" var="list">							
								<div class="recommend">					
									<table width="800px">
										<tr>
											<td rowspan="3" width="20%" align="center">
												<a href="/search/recommendView?isbn=${list.bookISBN}"><img src="${list.bookCoverImg}" alt="${list.bookSubject}"></a>
											</td>
											<td colspan="2"><a href="/search/recommendView?isbn=${list.bookISBN}"><b>${list.bookSubject}</b></a></td>
										</tr>
										<tr>
											<td colspan="2">${list.bookStory}</td>
										</tr>
										<tr>
											<td width="40%">저자 : ${list.bookWriter}</td>
											<td>출판사 : ${list.bookCompany}</td>
										</tr>
									</table>
								</div>
							</c:forEach>								
							<br>
							<br>
							<div class="searchpage">	
								<c:if test="${paging.startPage != 1}">
								<a href="/search/recommend?nowPage=${paging.startPage - 1}&cntPerPage=${paging.cntPerPage}">&lt;</a>
								</c:if>
								<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="p">
									<!-- 현재 페이지면 진하게, 아니면 링크갖고 진하지 않도록! -->
									<c:choose>
										<c:when test="${p eq paging.nowPage}">
											<b>${p}</b>
										</c:when>
										<c:when test="${p != paging.nowPage}">
											<a href="/search/recommend?nowPage=${p }&cntPerPage=${paging.cntPerPage}">${p }</a>
										</c:when>
									</c:choose>
								</c:forEach>
								<c:if test="${paging.endPage != paging.lastPage}">
								<a href="/search/recommend?nowPage=${paging.startPage + 1}&cntPerPage=${paging.cntPerPage}">&gt;</a>
								</c:if>
							</div>
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