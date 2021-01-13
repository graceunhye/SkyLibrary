<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		
		<title>질의응답</title>
		
		<link rel="stylesheet" href="/css/common.css" type="text/css"/>
		<link rel="stylesheet" href="/css/use/qna.css" type="text/css"/>
		
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
						<a href="/moveUseTime"><li class="left_menu_sub">이용시간</li></a>
						<a href="/moveUseGuide"><li class="left_menu_sub">대출/반납/예약/연장</li></a>
						<a href="/qna/"><li class="on left_menu_sub last_sub">질의응답</li></a>
					</ul>
				</nav>
				<div class="section">
					<div class="section_top">
						<span class="top_title">질의응답</span>
						<span class="page_map">도서관 이용 > 질의응답</span>
					</div>
					<div class="content">
						<div align="center">
							<span class="searchResultNum">검색된 결과수:: <font color="orange"></font></span>		
							<div class="searchBox">
								<form id="frm" name="frm" method="post" action="qna.jsp">
									<select id="select" class="select" name="select">
										<option value="0">전체</option>
										<option value="title">제목</option>
										<option value="body">내용</option>
									</select>
									<input type="text" name="keyword" id="keyword" class="keyword" value="">
									<input type="submit" value="검색" class="searchBtn">
								</form>
							</div>		
							<table width="1200px" class="qnaTable">
								<tr height="50px" class="top_tr">
									<th align="center" class="top_td">글번호</th>
									<th width="500" class="top_td">제목</th>
									<th align="center" class="top_td">작성자</th>
									<th align="center" class="top_td">작성일</th>
									<th align="center" class="top_td">상태</th>
								</tr>
								<tr>
									<td></td>
									<td>
										<a href="qnaView.jsp?no="></a>
									</td>
									<td></td>
									<td></td>
									<td>
										<font color="blue">답변대기</font>
									</td>
								</tr>
							</table>
							<br>
							<span class="btns">
								<input class="btn" type="button" value="글쓰기" onclick="qnaNeedLogin()">
							</span>
							<br>
						</div>
						<div class="searchpage">	
						</div>	
					</div>
				</div>
			</section>
			<!-- section end -->
		
			<jsp:include page="../include/footer.jsp"/>
			<!-- footer end -->
		</div>
	</body>
</html></html>