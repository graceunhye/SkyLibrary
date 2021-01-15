<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true" %>  
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	
	<title>공지사항</title>
	
	<link rel="stylesheet" href="/css/mCommon.css" type="text/css"/>
	
	<script src="/js/jquery-3.5.1.min.js"></script>
	
	<style>
		/** notice.jsp css **/
		#insert_btn{
			position : relative;
			margin-left : 5%;
		}
		.notice_page{
			positon : relative;
			margin-left : 40%;
		}
		a{
			color : black;
			text-decoration: none;
		}
	</style>
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
					<button id="insert_btn" type="button" class="optionBox_btn_free" width="200" onclick="location.href='noticeInsert.jsp'">공지사항 작성</button>
						<table class="content_table">
						<tr class="top_tr">
							<td>글번호</td>
							<td>제목</td>
							<td>작성자</td>
							<td>작성일</td>
							<td>조회수</td>
						</tr>
							<tr class="mid_tr">
								<td align="center"></td>
								<td><a href="noticeView.jsp?no="></a></td>
								<td align="center"></td>
								<td align="center"></td>
								<td align="center"></td>
							</tr>												
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