<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true" %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	
	<title>공지사항</title>
	
	<link rel="stylesheet" href="/css/mCommon.css" type="text/css"/>
	<link rel="stylesheet" href="/css/mNotice/mnotice.css" type="text/css"/>
	
	<script src="../mnotice/js/jquery-3.5.1.min.js"></script>
	
</head>
<body style="margin: 0px;">
	<div class="wrap">
		<header>
			<div class="header">
				<div class="title_box"><span class="head_title">관리자 페이지 </span><span class="name">하늘도서관</span></div>
			</div>
		</header>
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
						<c:forEach items="noticelist" var="list">
							<tr class="mid_tr">
								<td align="center">${list.noticeNo}</td>
								<td><a href="noticeView.?no=">${list.noticeTitle}</a></td>
								<td align="center">${sessionScope.user.userID}</td>
								<td align="center">${list.noticeDate}</td>
								<td align="center">${list.noticeHit}</td>
							</tr>
						</c:forEach>													
						</table>
						</div>
						<br>
						<div class="notice_page">	
						
						<a href="notice.jsp?page=1">맨앞으로</a> 
						<a href="notice.jsp?page=">이전</a>
						 
						<b><a href="notice.jsp?page="></a></b>
						<a href="notice.jsp?page="></a>
						
						<a href="notice.jsp?page=">다음</a>
						<a href="notice.jsp?page=">맨뒤로</a>		

						</div>													
					</div>
				</div>	
		</section>
	</div>
</body>
</html>