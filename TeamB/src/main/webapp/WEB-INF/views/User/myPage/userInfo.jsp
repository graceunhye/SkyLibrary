<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		
		<title>회원정보</title>
			
		<link rel="stylesheet" href="/css/common.css" type="text/css"/>
		<link rel="stylesheet" href="/css/myPage/userInfo.css" type="text/css"/>
		
		<script src="/js/jquery-3.5.1.min.js"></script>
		<script src="/js/common.js"></script>
		<script>
			function userInfoModify{
				
			}
		</script>
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
						<a href="/myPage/userInfo"><li class="on left_menu_sub">회원정보</li></a>
						<a href="/myPage/wish"><li class="left_menu_sub">희망도서 신청</li></a>
						<a href="/myPage/renting"><li class="left_menu_sub last_sub">대출도서 조회</li></a>
					</ul>
				</nav>
				<div class="section">
					<div class="section_top">
						<span class="top_title">회원정보</span>
						<span class="page_map">마이페이지 > 회원정보</span>
					</div>
					<div class="content">
						<div>
							<table class="content_table">
								<tr class="top_tr">
									<th style="width:25%;">ID</th>
									<td class="top_td">${user.userID }</td>
								</tr>
								<tr class="mid_tr">
									<th>이름</th>
									<td class="mid_td">${user.userName }</td>
								</tr>
								<tr class="mid_tr">
									<th>연락처</th>
									<td class="mid_td">
										<c:if test="${user.userNum != null }">
										${user.userNum }
										</c:if>
										<c:if test="${user.userNum == null }">
										등록된 정보가 없습니다.
										</c:if>
									</td>
								</tr>
								<tr class="mid_tr">
									<th>주소</th>
									<td class="mid_td">
										<c:if test="${user.userPostNum != null }">
										[${user.userPostNum }]${user.userAddr }
										<c:if test="${useruser.userAddrDetail != null}">
										${user.userAddrDetail }
										</c:if>
										</c:if>
										<c:if test="${user.userPostNum == null }">
										등록된 정보가 없습니다.
										</c:if>
									</td>
								</tr>
								<tr class="mid_tr">
									<th >이메일</th>
									<td>
										<c:if test="${user.userEmail != null }">
										${user.userEmail }@${user.userEmailDomain }
										</c:if>
										<c:if test="${user.userEmail == null }">
										등록된 정보가 없습니다.
										</c:if>
									</td>
								</tr>
							</table>
							<button id="modify_b" type="button" onclick="location.href='/myPage/userInfoModify'">회원정보 수정</button>
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