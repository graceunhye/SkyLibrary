<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>하늘도서관 메인</title>
	
	<link rel="stylesheet" href="/css/mainCommon.css"  type="text/css"/>
	<link rel="stylesheet" href="/css/mainSection.css" type="text/css"/>
</head>
<body style="margin:0px">
	<div class="wrap"> 
			<header>
				<jsp:include page="./User/include/head_option.jsp"/>
				<jsp:include page="./User/include/head_banner.jsp"/>
			</header>
			<!-- header end -->
			
			<section id="section">
				<div class="section">
					<jsp:include page="./User/include/section_banner.jsp"/>
					<br/><hr class="hr"/><br/>
					<div class="sub_content">
						<span class="sub_title newbook">신착도서</span>
						<div class="book"> 
							<ul class="book_list" id="book">
							
								<c:forEach items="${bookList}" var="list">
								<li>
									<div class="book_cover">
										<img src="${list.bookCoverImg }" class="books" alt="${list.bookSubject }" />
									</div>
									<div class="book_title">
										<a href="#">${list.bookSubject }</a>
									</div>
								</li>
								</c:forEach>
								
							</ul>
						</div>
						<div class="notice">
							<table class="notice_table">
								<tr height="50px">
									<td colspan="4"><span class="sub_title">공지사항</span></td>
								</tr>
								<tr>
									<td class="table_underline" align="center" width="40px">번호</td>
									<td class="table_underline" align="center" width="320px">제목</td>
									<td class="table_underline" align="center">작성일</td>
								</tr>
								<tbody id="notice">
									<c:forEach items="${noticeList}" var="list">
									<tr height="25px">
										<td align="center">${list.noticeNo }</td>
										<td class="table_move">
											<a href="#" ><span class="point"></span>${list.noticeTitle }</a>
										</td>
										<td>${list.noticeDate }</td>
									</tr>
									</c:forEach>
								</tbody>
								<tr height="20px">
									<td colspan="4" align="right">
										<a class="more" href="/User/intro/notice/">
											<span class="notice_more">더보기</span>
										</a>
									</td>
								</tr>
							</table>
						</div>
						<div class="intro">
							<table class="intro_table" width="640">
								<tr>
									<td colspan="2">
										<span class="sub_title">도서관 이용안내</span>
									</td>
								</tr>
								<tr height="180px">
									<td align="left"  width="250px;" height="50px" class="line_right intro_info">
										<span class="point2">월요일, 공휴일 휴무</span><br />
										<span class="point2">평일</span> 오전 09:00 ~ 오후 18:00<br />
										<span class="point2">주말</span> 오전 10:00 ~ 오후 18:00<br />
										<font color="orange">*</font><font class="font">위 사항은 사정에 따라 변경 될 수 있습니다.</font><br>
										<a href="/notice/"><span class="more use_time_more">더보기</span></a>
									</td>
									<td>
										<img class="sub_banner" src="/image/homePage/sub_banner1.jpg" width="300px"/>
									</td>
								</tr>
							</table>
						</div>
					</div>
				</div>
			</section>
			<!-- section end -->
			
			<jsp:include page="./User/include/footer.jsp" />
			<!-- footer end -->
			
		</div>
</body>
</html>
