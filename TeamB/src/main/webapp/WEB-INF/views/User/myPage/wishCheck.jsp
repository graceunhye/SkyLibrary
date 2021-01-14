<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		
		<title>희망도서 조회</title>
		
		<link rel="stylesheet" href="/css/common.css" type="text/css"/>
		<link rel="stylesheet" href="/css/myPage/wishCheck.css" type="text/css"/>
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
					<a href="/myPage/wish"><li class="on left_menu_sub">희망도서 신청</li></a>
					<a href="/myPage/renting"><li class="left_menu_sub last_sub">대출도서 조회</li></a>
				</ul>
			</nav>
			<!-- nav end -->
			<div class="section">
				<div class="section_top">
					<span class="top_title">희망도서 신청</span>
					<span class="page_map">마이페이지 > 희망도서 신청 > 희망도서 확인</span>
				</div>
				<div>
					<div class="searchOptionWrap">
						<form method="post" action="/myPage/wishCheck">
							날짜:: <input type="date" name="startDay"/> 일부터
							<input type="date" name="finishDay"/> 일까지
							<input type="submit" value="적용" class="normalBtn">
						</form> 
					</div>
					<div class="wishTableWrap">
						<table border="1" class="wishTable">
							<thead>
								<tr height="50px">
									<th width="50px">번호</th>
									<th width="300px">표제</th>
									<th width="150px">ISBN</th>
									<th width="100px">저자명</th>
									<th width="100px">발행자</th>
									<th width="150px">신청일자</th>
									<th width="100px">진행상태</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="" var="">
								<c:if test="">
								<tr height="40px;">
									<td class="mid"></td>
									<td></td>
									<td class="mid"></td>
									<td class="mid"></td>
									<td class="mid"></td>
									<td class="mid"></td>
									<td class="mid"></td>
								</tr>
								</c:if>
								<c:if test="">
								<tr>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
								</tr>
								</c:if>
								</c:forEach>
							</tbody>
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