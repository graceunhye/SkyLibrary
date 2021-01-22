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
			<jsp:include page="../include/head_option.jsp"/>
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
					<span class="page_map">도서관 소개 > 공지사항 > 공지사항 보기</span>
				</div>
				<div class="content_view">
					<table width="1200px">
						<tr class="top_tr">
							<th align="center" height="40px" width="15%" class="top_td" width="50">제목</th>
							<td colspan="2" class="top_td">&nbsp;&nbsp;${noticeVO.noticeTitle}</td>	
						</tr>		
						<tr class="mid_tr">
							<th align="center">작성일</th>
							<td>&nbsp;&nbsp;${noticeVO.noticeDate}</td>
						</tr>
						<tr class="mid_tr">
							<th align="center">조회수</th>
							<td>&nbsp;&nbsp;${noticeVO.noticeHit}</td>
						</tr>	
						<tr class="mid_tr">
							<th align="center" height="400px" class="mid_tr">내용</th>
							<td colspan="2">
							&nbsp;&nbsp;
							<c:choose>  
							    <c:when test="${noticeVO.noticeFile != null}"> 
							    	<c:out value="${noticeVO.noticeBody}"/>
							    	<br> 
									<img src="/upload/${noticeVO.noticeFile}">
							    </c:when>  
							    <c:otherwise>  
							        <c:out value="${noticeVO.noticeBody}"/>
							    </c:otherwise>   
							</c:choose> 											
							</td>	
						</tr>
						<tr class="mid_tr">
							<th align="center" height="50px">첨부파일</th>
							<td colspan="2">		
								<c:if test="${noticeVO.noticeFile != null}">
									<a href="/Manager/mnotice/noticeFileDown?fileName=${noticeVO.noticeFile}"><c:out value="${noticeVO.noticeFile}"/></a>
								</c:if>
								
							</td>
						</tr>
					</table>
					<br>
					<br>
					<div class="view_btn">
						<input class="listBtn" type="button" value="목록으로" onclick="location.href='/intro/notice'">
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