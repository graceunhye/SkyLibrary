<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="head_option">
	<div class="rightnow">
		<a href="#section"><span class="rightnow_click">본문 바로가기</span></a>
	</div>
	<div class="head_btns">
		<c:if test="${sessionScope.user == null}">
			<input type="button" value="로그인" onclick="location.href='/loginout/login'">
			<input type="button" value="회원가입" onclick="location.href='/join'">
		</c:if>
		<c:if test="${sessionScope.user != null}">
			<span>${sessionScope.user.userID} 님 </span>
			<input type="button" value="로그아웃" onclick="location.href='/loginout/logout'">
		</c:if>
	</div>
</div>