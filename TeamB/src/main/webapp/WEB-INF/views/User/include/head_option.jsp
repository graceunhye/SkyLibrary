<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="head_option">
	<div class="rightnow">
		<a href="#section"><span class="rightnow_click">본문 바로가기</span></a>
	</div>
	<div class="head_btns">
<<<<<<< HEAD
		<c:if test="${sessionScope.user == null}">
			<input class="head_btn" type="button" value="로그인" onclick="location.href='/User/loginout/moveLogin'">
			<input class="head_btn" type="button" value="회원가입" onclick="location.href='/User/join/moveJoin'">
=======
<<<<<<< HEAD
		<c:if test="${user == null }">
			<input class="head_btn" type="button" value="로그인" onclick="location.href='/loginout/login'">
			<input class="head_btn" type="button" value="회원가입" onclick="location.href='/join'">
=======
		<c:if test="${sessionScope.user == null}">
			<input class="head_btn" type="button" value="로그인" onclick="location.href='/User/loginout/moveLogin'">
			<input class="head_btn" type="button" value="회원가입" onclick="location.href='/User/join/moveJoin'">
>>>>>>> e9967f0dbb34331d6115a9616a13063f09d97c5a
>>>>>>> 4e1c0b5902272a82c80dcbb4b8cd1e4d05198201
		</c:if>
		<c:if test="${sessionScope.user != null}">
			<span class="head_id">${sessionScope.user.userID} 님 </span>
			<input class="head_btn" type="button" value="로그아웃" onclick="location.href='/User/loginout/logout'">
		</c:if>
	</div>
</div>