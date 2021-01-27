<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		
		<title>사서추천도서 상세정보</title>
		
		<link rel="stylesheet" href="/css/common.css" type="text/css"/>
		<link rel="stylesheet" href="/css/search/bookView.css" type="text/css"/>
		
		<script src="/js/jquery-3.5.1.min.js"></script>
		<script src="/js/common.js"></script>
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
						<a href="/search/total"><li class="left_menu_sub">통합검색</li></a>
						<a href="/search/best"><li class="left_menu_sub">인기도서</li></a>
						<a href="/search/new"><li class="left_menu_sub">신착도서</li></a>
						<a href="/search/recommend"><li class="on left_menu_sub last_sub">사서추천도서</li></a>
					</ul>
				</nav>
				<div class="section">
					<div class="section_top">
						<span class="top_title">신착도서</span>
						<span class="page_map">도서검색 > 신착도서</span>
					</div>
					<div class="content">
						<div class="searchview">
							<br>
							<br>
							<div class="searchview1">
								<table width="800px" class="viewTable" >
									<tr height="80px;">
										<td colspan="3" align="center" height="50" class="view_td">
											<h2>&lt;&lt;&nbsp;&nbsp; <c:out value="${bookView.bookSubject}" /> &nbsp;&nbsp;&gt;&gt;</h2>
										</td>
									</tr>
									<tr class="tr">
										<td rowspan="6" width="15%" align="center" class="imgtd">
											<img src="<c:out value="${bookView.bookCoverImg}" />" alt="<c:out value="${bestView.bookSubject}" />" width="82px">
										</td>
										<th>저자</th>
										<td><c:out value="${bookView.bookWriter}" /></td>
									</tr>
									<tr class="tr">
										<th>출판사</th>
										<td><c:out value="${bookView.bookCompany}" /></td>							
									</tr>
									<tr class="tr">
										<th>발행일</th>
										<td><c:out value="${bookView.bookPublicationDate}" /></td>							
									</tr>
									<tr class="tr">
										<th>ISBN</th>
										<td><c:out value="${bookView.bookISBN}"/></td>							
									</tr>
									<tr class="tr lasttd">
										<th>소장기관</th>
										<td>하늘 도서관</td>							
									</tr>
								</table>
							</div>
							<br>
							<div class="searchview2">
								<h3><font color="orange">*</font>책 내용</h3>
								<div class="storyDiv">
									<c:out value="${bookView.bookStory}"/>
								</div>
							</div>
							<br>
							<div class="searchview3">
								<h3><font color="orange">*</font>추천 이유</h3>
								<div class="storyDiv">
									${bookView.recommendWhy}
								</div>
							</div>					
							<br>
							<br>
							<button type="button" onclick="location.href='recommend'" class="listbtn">목록으로</button>
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