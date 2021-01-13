<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%

	String id = (String)session.getAttribute("idKey");
	if(id == null){ id = ""; }

%>	
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		
		<title>도서관 일정</title>
		
		<link rel="stylesheet" href="/css/common.css" type="text/css"/>
		<link rel="stylesheet" href="/css/intro/calendar.css" type="text/css"/>
		
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
						<li class="left_menu_title">도서관 소개</li>
						<a href="/notice/"><li class="left_menu_sub">공지사항</li></a>
						<a href="/moveCalendar"><li class="on left_menu_sub">월별 일정</li></a>
						<a href="/movePath"><li class="left_menu_sub last_sub">오시는 길</li></a>
					</ul>
				</nav>
				<div class="section">
					<div class="section_top">
						<span class="top_title">월별 일정</span>
						<span class="page_map">도서관 소개 > 월별 일정</span>
					</div>
					<div class="content">
					
						<div class="calendar">
							<h2><font color="orange">*</font>달력</h2>
							<img src="/image/homePage/12Calendar.jpg" width="700" alt="임시달력" style="margin-top:20px;">
						</div>
						<br>
						<br>
						<div class="info_box">
							<h2><font color="orange">*</font>이달의 행사정보</h2>
							<ul class="info">
								<li>작가와의 만남(12월2일 ~ 12월13일)</li>
								<li>어린이 도서 대출가능 권수 5권->7권</li>
								<li>우리마을 어르신에게 편지쓰기 대회</li>
							</ul>
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