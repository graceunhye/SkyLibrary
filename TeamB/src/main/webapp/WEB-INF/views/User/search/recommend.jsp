<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		
		<title>사서추천도서</title>
		
		<link rel="stylesheet" href="/css/common.css" type="text/css"/>
		<link rel="stylesheet" href="/css/recommend.css" type="text/css"/>
		
		<script src="../../../js/jquery-3.5.1.min.js"></script>
		<script src="../../../js/common.js"></script>
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
						<a href="best"><li class="left_menu_sub">인기도서</li></a>
						<a href="new"><li class="left_menu_sub">신착도서</li></a>
						<a href="recommend"><li class="on left_menu_sub last_sub">사서추천도서</li></a>
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
							<div class="recommend">					
								<table width="800px">
									<tr>
										<td rowspan="3" width="20%" align="center">
											<a href="recommendView.jsp?isbn="><img src="" alt=""></a>
										</td>
										<td colspan="2"><a href="recommendView.jsp?isbn="><b></b></a></td>
									</tr>
									<tr>
										<td colspan="2"></td>
									</tr>
									<tr>
										<td width="40%">저자 : </td>
										<td>출판사 : </td>
									</tr>
								</table>
							</div>							
							<br>
							<br>
							<div class="searchpage">	
								<a href="recommend.jsp?page=1">맨앞으로</a> 
								<a href="recommend.jsp?page=">이전</a>

								<b><a href="recommend.jsp?page="></a></b>
								   <a href="recommend.jsp?page="></a> 

									<a href="recommend.jsp?page=">다음</a>
									<a href="recommend.jsp?page=">맨뒤로</a>	
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