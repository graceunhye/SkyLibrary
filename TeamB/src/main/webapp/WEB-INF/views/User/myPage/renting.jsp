<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		
		<title>대출도서 조회</title>
		
		<link rel="stylesheet" href="/css/common.css" type="text/css"/>
		<link rel="stylesheet" href="/css/myPage/renting.css" type="text/css"/>
		
		<script src="/js/jquery-3.5.1.min.js"></script>
		<script src="/js/common.js"></script>
		<script src="/js/myPage/renting.js"></script>
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
						<li class="left_menu_title">마이페이지</li>
						<a href="/myPage/userInfo"><li class="left_menu_sub">회원정보</li></a>
						<a href="/myPage/wish"><li class="left_menu_sub">희망도서 신청</li></a>
						<a href="/myPage/renting"><li class="on left_menu_sub last_sub">대출도서 조회</li></a>
					</ul>
				</nav>
				<!-- nav end -->
				
				<div class="section">
					<div class="section_top">
						<span class="top_title">대출도서 조회 / 연장</span>
						<span class="page_map">도서관 이용 > 대출도서 조회</span>
					</div>
					<div class="content">
						<div class="rentTableWrap">
							<table width="1200" class="rentTable">
								<tr align="center"  class="top_tr">
									<th width="25%" class="top_td">제목</th>
									<th width="20%" class="top_td">저자</th>
									<th width="15%" class="top_td">출판사</th>
									<th width="10%" class="top_td">대출일자</th>
									<th width="10%" class="top_td">반납예정일</th>
									<th width="10%" class="top_td">도서반납</th>
									<th width="10%" class="top_td">도서연장</th>
								</tr>
								<tr id="rent_tr" align="center">
									<td class="mid_td">${rentList.bookSubject}</td>
									<td class="mid_td">${rentList.bookWriter}</td>
									<td class="mid_td">${rentList.bookCompany}</td>
									<td class="mid_td">${rentList.rentStartDate}</td>
									<td class="mid_td" class="endd_td">${rentList.rentEndDate}</td>
									<td class="mid_td">
										<input type="button" value="반납" class="normalBtn" onclick="returnFn(this,'<c:out value="${sessionScope.user.userID}"/>','<c:out value="${rentList.bookISBN}"/>')"> 
									</td>
									<c:choose>
										<c:when test="${rentList.compare > 0}"> 									
											<td class="mid_td" id="extension_td">
												<input type="button" value="연장불가" class="normalBtn" disabled>
											</td>
										</c:when>	
										<c:when test="${rentList.compare <= 0}">
											<td id="extension_td" class="mid_td">
												<input type="button" class="normalBtn" value="연장" onclick="extensionFn(this, '<c:out value="${rentList.bookISBN}"/>')">
											</td>											
										</c:when>
									</c:choose>										
								</tr>															
							</table> 
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