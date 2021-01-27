<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<header>
	<div class="header">
		<div>
			<span>관리자 페이지&nbsp;</span>
			<span>하늘도서관</span>
		</div>
		<c:if test="${sessionScope.user != null}">
		<div>
			<span>
				<span>${sessionScope.user.userID}님</span>
				<a href="/">
				<img src="/image/homePage/homeLog.png" alt="홈 화면으로 이동">
				</a>
			</span>
			<a href="/loginout/logout">로그아웃</a>
		</div>
		</c:if>
	</div>
</header>