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
		<link rel="stylesheet" href="/css/myPage/userInfoModify.css" type="text/css"/>
		
		<script src="/js/jquery-3.5.1.min.js"></script>
		<script src="/js/common.js"></script>
		<script src="/js/myPage/userInfoModify.js"></script>
		<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
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
						<span class="page_map">마이페이지 > 회원정보 > 회원정보 수정</span>
					</div>
					<form method="post" class="modifyfrm" name="modifyfrm" action="/myPage/userModifyOk">
						<div class="content">
							<table class="content_table">
								<tr class="top_tr">
									<th style="width:25%;">ID</th>
									<td class="top_td">${userInfo.userID }</td>
								</tr>
								<tr class="mid_tr">
									<th>이름</th>
									<td class="mid_td"><input type="text" value="${userInfo.userName }" id="name" name="name"></td>
								</tr>
								<tr class="mid_tr">
									<th>연락처</th>
									<td class="mid_td">
										<select name="userNumSplit1">
											<c:if test="${userInfo.userNumSplit1 eq '010'}">
												<option value="010" selected>010</option>
												<option value="011">011</option>
												<option value="016">016</option>
											</c:if>
											<c:if test="${userInfo.userNumSplit1 eq '011'}">
												<option value="010">010</option>
												<option value="011" selected>011</option>
												<option value="016">016</option>
											</c:if>
											<c:if test="${userInfo.userNumSplit1 eq '016'}">
												<option value="010">010</option>
												<option value="011">011</option>
												<option value="016" selected>016</option>
											</c:if>
										</select>
										<span>-</span>
										<input type="text" value="${userInfo.userNumSplit2}" id="num2" name="userNumSplit2">
										<span>-</span>
										<input type="text" value="${userInfo.userNumSplit3}" id="num3" name="userNumSplit3">
									</td>
								</tr>
								<tr class="mid_tr">
									<th>주소</th>
									<td class="mid_td">
										<input type="text" id="postnum" name="userPostNum" size="7" value=${userInfo.userPostNum }>&nbsp;
										<input type="button" class="joinbtn1" value="우편번호 찾기" onclick="PostOpen()"><br />
										<input type="text" id="addr1" name="userAddr" size="50" value="${userInfo.userAddr }"><br />
										<input type="text" id="addr2" name="userAddrDetail" size="50" value="${userInfo.userAddrDetail }">
									</td>
								</tr>
								<tr class="mid_tr">
									<th>이메일</th>
									<td class="mid_td">
										<input type="text" value="${userInfo.userEmail }" id="email1" name="userEmail">@
										<select name="userEmailDomain">
											<c:if test="${userInfo.userEmail eq 'e1'}">
												<option value="e1" selected>naver.com</option>
												<option value="e2">nate.com</option>
												<option value="e3">gmail.com</option>
											</c:if>
											<c:if test="${userInfo.userEmail eq 'e2'}">
												<option value="e1">naver.com</option>
												<option value="e2" selected>nate.com</option>
												<option value="e3">gmail.com</option>
											</c:if>
											<c:if test="${userInfo.userEmail eq 'e3'}">
												<option value="e1">naver.com</option>
												<option value="e2">nate.com</option>
												<option value="e3" selected>gmail.com</option>
											</c:if>
										</select>
									</td>
								</tr>
							</table>
							<div class="btns">
								<button type="button"  class="modifyOk_b" onclick="Submit()">저장</button>
								<button type="button"  class="modifyOk_b" onclick="cancleFn()'">취소</button>
							</div>
							<br>
							<br>
							<div style="position:relative; left:30%;">
								<a style="color:gray;">하늘도서관을 더 이상 이용하지 않는다면? </a>
								<a style="text-decoration:underline;"href="javascript:userDelete(<c:out value="${rentInfo.rentCount }" />,<c:out value="${user.userID }" />)">회원탈퇴 하기</a>
							</div>				
						</div>
					</form>
				</div>
			</section>
			<!-- section end -->
			
			<footer>
				<div class="footer">
					<ul class="kind">
						<li class="footer_title">&nbsp;사서</li>
						<li>Song EunHye</li>
						<li>Park Sujin</li>
						<li>Kang GoEun</li>
					</ul>
					<ul class="kind">
						<li class="footer_title">&nbsp;제작기간</li>
						<li>2020.12.03~2020.12.31</li>
					</ul>
					<ul class="copy">
						<li>&copy; Sky Library</li>
					</ul>
				</div>
			</footer>
			<!-- footer end -->
		
		</div>
	</body>
</html>