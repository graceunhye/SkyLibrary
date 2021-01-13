<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@page import="java.net.URLEncoder"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     
<%@ page import="java.sql.*" %> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		
		<title>통합검색</title>
		
		<link rel="stylesheet" href="/css/common.css" type="text/css"/>
		<link rel="stylesheet" href="/css/total.css" type="text/css"/>
		
		<script src="/js/common.js"></script>
		<script src="/js/jquery-3.5.1.min.js"></script>
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
						<a href="total"><li class="on left_menu_sub">통합검색</li></a>
						<a href="best"><li class="left_menu_sub">인기도서</li></a>
						<a href="new"><li class="left_menu_sub">신착도서</li></a>
						<a href="recommend"><li class="left_menu_sub last_sub">사서추천도서</li></a>
					</ul>
				</nav>
				<div class="section">
					<div class="section_top">
						<span class="top_title">통합검색</span>
						<span class="page_map">도서검색 > 통합검색</span>
					</div>
					<div class="content">
						<div class="searchOptionBox">	
							<form action="total.jsp" method="post">
								<span class="options">
								<select id="select" class="select" name="select">
									<option value="0">전체</option>
									<option value="subject">도서명</option>
									<option value="writer">저자</option>
									<option value="company">출판사</option>
								</select>
								<input type="text" size="60" id="keyword" class="keyword" name="keyword" value="">
								<input type="submit" value="검색" class="searchBtn">
								</span>
							</form>		
						</div>
						<div class="booklist" id="booklist">	
							<span class="resultSum">검색결과:: <b><font color="orange"></font></b>건</span>
							<div class="new">					
								<table width="800px">
									<tr>
										<td rowspan="4" width="15%" align="center">
											<a href="totalView.jsp?isbn=">
												<img src="" alt="" width="82px">
											</a>
										</td>
										<td colspan="2">
											<a href="totalView.jsp?isbn=">
												<b></b>
											</a>
										</td>
									</tr>
									<tr>
										<td width="30%">저자 : </td>
										<td width="30%">ISBN : </td>
									</tr>
									<tr>
										<td width="30%">출판사 : </td>
										<td width="30%">소장기관 : 하늘 도서관</td>
									</tr>
									<tr>
										<td width="30%">발행일 : </td>
										<td width="30%">자료실 : 일반자료실</td>
									</tr>
								</table>
							</div>
														
							<br>
							<br>
							<div class="searchpage">	
								<a href="new.jsp?page=1">맨앞으로</a> 
								<a href="new.jsp?page=">이전</a>

								<b><a href="new.jsp?page="></a></b>
								   <a href="new.jsp?page="></a> 

									<a href="new.jsp?page=">다음</a>
									<a href="new.jsp?page=">맨뒤로</a>	
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