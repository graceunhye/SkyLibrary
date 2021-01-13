<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     
<%@ page import="java.sql.*" %>        
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		
		<title>인기도서</title>
		
		<link rel="stylesheet" href="/css/common.css" type="text/css"/>
		<link rel="stylesheet" href="/css/search/best.css" type="text/css"/>
		
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
						<a href="total"><li class="left_menu_sub">통합검색</li></a>
						<a href="best"><li class="on left_menu_sub">인기도서</li></a>
						<a href="new"><li class="left_menu_sub">신착도서</li></a>
						<a href="recommend"><li class="left_menu_sub last_sub">사서추천도서</li></a>
					</ul>
				</nav>
				<div class="section">
					<div class="section_top">
						<span class="top_title">인기도서</span>
						<span class="page_map">도서검색 > 인기도서</span>
					</div>
					<div class="content">
						<div class="booklist">	
							<br>
							<br>
							
							<c:forEach items="${bestlist}" var="list">
								<div class="best">					
									<table width="800px">
										<tr>
											<td rowspan="4" width="15%" align="center">
												<a href="/User/search/bestView?isbn=${list.bookISBN}"><img src="${list.bookCoverImg}" alt="${list.bookSubject}" width="82px"></a>
											</td>
											<td colspan="2"><a href="/User/search/bestView?isbn=${list.bookISBN}"><b>${list.bookSubject}</b></a></td>
										</tr>
										<tr>
											<td width="30%">저자 : ${list.bookWriter}</td>
											<td width="30%">ISBN : ${list.bookISBN}</td>
										</tr>
										<tr>
											<td width="30%">출판사 : ${list.bookCompany}</td>
											<td width="30%">소장기관 : 하늘 도서관</td>
										</tr>
										<tr>
											<td width="30%">발행일 : ${list.bookPublicationDate}</td>
											<td width="30%">자료실 : 일반자료실</td>
										</tr>
									</table>
								</div>
							</c:forEach>
														
							<br>
							<br>
							<div class="searchpage">	
								<a href="best.jsp?page=1">맨앞으로</a> 
								<a href="best.jsp?page=">이전</a>

								<b><a href="best.jsp?page="></a></b>
								   <a href="best.jsp?page="></a> 

									<a href="best.jsp?page=">다음</a>
									<a href="best.jsp?page=">맨뒤로</a>	
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