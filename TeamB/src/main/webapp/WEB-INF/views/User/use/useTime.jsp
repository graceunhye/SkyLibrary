<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		
		<title>이용 시간 안내</title>
		
		<link rel="stylesheet" href="/css/common.css" type="text/css"/>
		<link rel="stylesheet" href="/css/use/useTime.css" type="text/css"/>
		
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
						<a href="/useTime"><li class="on left_menu_sub">이용시간</li></a>
						<a href="/useGuide"><li class="left_menu_sub">대출/반납/예약/연장</li></a>
						<a href="/qna/"><li class="left_menu_sub last_sub">질의응답</li></a>
					</ul>
			</nav>
			<div class="section">
				<div class="section_top">
					<span class="top_title">이용시간</span>
					<span class="page_map">도서관 이용 > 이용시간</span>
				</div>
				<div class="content">		
					<h3><font color="orange">*</font>자료실 운영시간</h3>
					<table class="timeTable" border="1">
						<tr>
							<th>일반</th>
							<th>주말</th>
						</tr>
						<tr>
							<td>오전 9시 ~ 오후 7시</td>
							<td>오전 9시 ~ 오후 5시</td>
						</tr>
					</table>		
					<span class="tip"><font color="orange">※</font>월요일.법정공휴일은 <font color="orange">휴관</font></span>
				</div>	
			</div>
		</section>
		<!-- section end -->
		
		<jsp:include page="../include/footer.jsp"/>
		<!-- footer end -->
		
		</div>
	</body>
</html>