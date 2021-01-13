<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		
		<title>공지사항</title>
		
		<link rel="stylesheet" href="/css/common.css" type="text/css"/>
		<link rel="stylesheet" href="/css/intro/noticeView.css" type="text/css"/>
		
		<script src="/js/common.js"></script>
		<script src="/js/jquery-3.5.1.min.js"></script>
	</head>
	<body style="margin:0px">
		<div class="wrap"> 
		<header>
			<div class="head_option">
				<div class="rightnow">
					<a href="#section"><span class="rightnow_click">본문 바로가기</span></a>
				</div>
				<div class="head_btns">
					<input class="head_btn" type="button" value="로그인" onclick="location.href='../../User/loginout/login.jsp'">
					<input class="head_btn" type="button" value="회원가입" onclick="location.href='./User/join/join.jsp'">
				</div>
			</div>
			<jsp:include page="../include/head_banner.jsp"/>
		</header>
		<!-- header end -->
		
		<section id="section">
			<nav class="left_menu">
				<ul>
					<li class="left_menu_title">도서관 소개</li>
					<a href="/notice"><li class="on left_menu_sub">공지사항</li></a>
					<a href="/calendar"><li class="left_menu_sub">월별 일정</li></a>
					<a href="/path"><li class="left_menu_sub last_sub">오시는 길</li></a>
				</ul>
			</nav>
			<div class="section">
				<div class="section_top">
					<span class="top_title">공지사항</span>
					<span class="page_map">도서관 소개 > 공지사항 > 공지사항 보기</span>
				</div>
				<div class="content_view">
					<table width="1200px">
						<tr class="top_tr">
							<th align="center" height="40px" width="15%" class="top_td" width="50">제목</th>
							<td colspan="2" class="top_td">${noticeVO.noticeTitle}</td>	
						</tr>		
						<tr class="mid_tr">
							<th align="center">작성일</th>
							<td>${noticeVO.noticeDate}</td>
						</tr>
						<tr class="mid_tr">
							<th align="center">조회수</th>
							<td>${noticeVO.noticeHit}</td>
						</tr>	
						<tr class="mid_tr">
							<th align="center" height="400px" class="mid_tr">내용</th>
							<td colspan="2">
							
								<c:if test="${noticeVO.noticeFile != null}">
									<img src="../../Manager/mnotice/noticeFileDown.jsp?type=img&nfile=${noticeVO.noticeFile}">
									${noticeVO.noticeBody}
								</c:if>
								<c:if test="${noticeVO.noticeFile eq null}">
									${noticeVO.noticeBody}
								</c:if>
								
							</td>	
						</tr>
						<tr class="mid_tr">
							<th align="center" height="50px">첨부파일</th>
							<td colspan="2">
							
								<c:if test="${noticeVO.noticeFile != null}">
									<img src="../../Manager/mnotice/noticeFileDown.jsp?type=img&nfile=${noticeVO.noticeFile}">
									${noticeVO.noticeFile}
								</c:if>
								
							</td>
						</tr>
					</table>
					<br>
					<br>
					<div class="view_btn">
						<input class="listBtn" type="button" value="목록으로" onclick="location.href='/notice/'">
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