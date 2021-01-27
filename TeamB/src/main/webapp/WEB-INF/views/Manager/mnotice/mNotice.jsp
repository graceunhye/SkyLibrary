<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	
	<title>공지사항</title>
	
	<link rel="stylesheet" href="/css/mCommon.css" type="text/css"/>
	<link rel="stylesheet" href="/css/mNotice/mnotice.css" type="text/css"/>
	
	<script src="../mnotice/js/jquery-3.5.1.min.js"></script>
	
	<style>
		.m_logout{
			position : relative;
			margin-top : 20px;
			margin-left : 950px;
			border-radius : 7px;
			width : 150px;
			height: 40px;
			border : 1px solid #4A90E2;
			background-color : #4A90E2;
			color : white;
			font-size : 15px;
			font-weight : bold;
		}
	</style>
	
</head>
<body style="margin: 0px;">
	<div class="wrap">
		<jsp:include page="../include/header.jsp" />
		<section>
			<jsp:include page="../include/nav.jsp" />
			<div class="section">
				<div class="user_info">
					<span class="info_title"><span class="point">*</span>공지사항</span>
					<br>
					<br>
					<div class="user_content">										
					<br>
					<button id="insert_btn" type="button" class="optionBox_btn_free" width="200" onclick="location.href='mNoticeInsert'">공지사항 작성</button>
						<table class="content_table">
						<tr class="top_tr">
							<td>글번호</td>
							<td>제목</td>
							<td>작성자</td>
							<td>작성일</td>
							<td>조회수</td>
						</tr>
						<c:forEach items="${noticelist}" var="list" varStatus="status">
							<tr class="mid_tr">
								<td align="center">${paging.total - ((paging.nowPage-1)*paging.cntPerPage+status.index)}</td>
								<td><a href="mNoticeView?noticeNo=${list.noticeNo}">${list.noticeTitle}</a></td>
								<td align="center">${list.userID}</td>
								<td align="center">${list.noticeDate}</td>
								<td align="center">${list.noticeHit}</td>
							</tr>
						</c:forEach>													
						</table>
						</div>
						<br>
						<div class="notice_page">	
							<c:if test="${paging.startPage != 1}">
							<a href="/mnotice/mNotice?nowPage=${paging.startPage - 1}&cntPerPage=${paging.cntPerPage}">&lt;</a>
							</c:if>
							<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="p">
								<!-- 현재 페이지면 진하게, 아니면 링크갖고 진하지 않도록! -->
								<c:choose>
									<c:when test="${p eq paging.nowPage}">
										<b>${p}</b>
									</c:when>
									<c:when test="${p != paging.nowPage}">
										<a href="/mnotice/mNotice?nowPage=${p}&cntPerPage=${paging.cntPerPage}">${p}</a>
									</c:when>
								</c:choose>
							</c:forEach>
							<c:if test="${paging.endPage != paging.lastPage}">
								<a href="/mnotice/mNotice?nowPage=${paging.nowPage + 1}&cntPerPage=${paging.cntPerPage}">&gt;</a>
							</c:if>
						</div>														
					</div>
				</div>	
		</section>
	</div>
</body>
</html>