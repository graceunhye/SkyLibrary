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
		
		<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
		<script src="/js/jquery-3.5.1.min.js"></script>
		<script src="/js/use/userInfo.js"></script>
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
						<li class="left_menu_title">마이페이지</li>
						<a href="/myPage/userInfo"><li class="on left_menu_sub">회원정보</li></a>
						<a href="/myPage/wish"><li class="left_menu_sub">희망도서 신청</li></a>
						<a href="/myPage/renting"><li class="left_menu_sub last_sub">대출도서 조회</li></a>
					</ul>
				</nav>
				<div class="section">
					<div class="section_top">
						<span>회원정보</span>
						<span>마이페이지 > 회원정보</span>
					</div>
					<div class="content">
						<table class="userInfoTable">
							<tr>
								<th>ID</th>
								<td id="userID">${userInfo.userID }</td>
							</tr>
							<tr>
								<th>이름</th>
								<td id="userName">${userInfo.userName }</td>
							</tr>
							<tr>
								<th>연락처</th>
								<td id="userNum">
									<c:if test="${userInfo.userNum != null }">
									${userInfo.userNum }
									</c:if>
									<c:if test="${userInfo.userNum == null }">
									등록된 정보가 없습니다.
									</c:if>
								</td>
							</tr>
							<tr>
								<th>주소</th>
								<td id="userAddressInfo">
									<c:if test="${userInfo.userPostNum != null }">
									[<font id="userPostNum">${userInfo.userPostNum }</font>]&nbsp; 
									<font id="userAddr">${userInfo.userAddr }</font>&nbsp;
									<c:if test="${userInfo.userAddrDetail != null}">
									<font id="userAddrDetail">${userInfo.userAddrDetail }</font>
									</c:if>
									</c:if>
									<c:if test="${userInfo.userPostNum == null }">
									등록된 정보가 없습니다.
									</c:if>
								</td>
							</tr>
							<tr>	
								<th>이메일</th>
								<td id="userEmail">
									<c:if test="${userInfo.userEmail != null }">
									${userInfo.userEmail }@${userInfo.userEmailDomain }
									</c:if>
									<c:if test="${userInfo.userEmail == null }">
									등록된 정보가 없습니다.
									</c:if>
								</td>
							</tr>
						</table>
						<span id="buttonArea">
							<button type="button" onclick="userModify()">회원정보 수정</button>
						</span>
					</div>
				</div>
			</section>
			<!-- section end -->
			

			<jsp:include page="../include/footer.jsp"/>
			<!-- footer end -->
		</div>
	</body>
</html>