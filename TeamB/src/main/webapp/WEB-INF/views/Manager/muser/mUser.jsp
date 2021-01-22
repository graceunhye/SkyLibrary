<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		
		<title>회원정보 관리</title>
		
		<link rel="stylesheet" href="/css/mCommon.css" type="text/css"/>
		<link rel="stylesheet" href="/css/mUser/muser.css" type="text/css"/>

		
		<script src="/js/jquery-3.5.1.min.js"></script>
		<script src="/js/mUser/muser.js"></script>
	</head>
	<body style="margin: 0px;">
		<div class="wrap">
			<header>
				<div class="header">
					<div class="title_box">
						<span class="head_title">관리자 페이지 </span>
						<span class="name">하늘도서관</span>
					</div>
				</div>
			</header>
			<!-- header end -->
			
			<section>
				<jsp:include page="../include/nav.jsp" />
				<div class="section">
					<div class="user_info">
						<span class="info_title">
							<span class="point">*</span>
						회원 정보</span>
						<div class="optionBox">
						조회:: 
							  회원구분::
							 <select name="selectType">
							 	<option value="0">일반회원</option>
							 	<option value="1">탈퇴회원</option>
							 	<option value="2">강제탈퇴회원</option>
							 </select>
							&nbsp;
							   가입일:: 
							 <input type="date" name="startDate"> - 
							 <input type="date" name="endDate">
						    &nbsp;
						          키워드::
						     <select name="searchType">
								<option value="userID">아이디</option>
								<option value="userName">이름</option>
							</select>
							<input type="text" name="searchText">
							&nbsp;
							<input type="button" value="조회" onclick="userSearchFn()">
							<a id="userRemove" href="javascript:userRemoveFn()">선택한 회원 강제탈퇴</a>
						</div>
						<table class="table" border="1">	
							<thead>
								<tr class="fixTable">
									<td>번호</td>
									<td>회원구분</td>
									<td>아이디</td>
									<td>이름</td>
									<td>연락처</td>
									<td>이메일</td>
									<td>대출중(권)</td>
									<td>선택</td>
								</tr>
							</thead>
							<tbody id="result">
							</tbody>
						</table>
					</div>
					<div id="userInfoView" class="userInfoView">
					
					</div>
				</div>
			</section>
		</div>
	</body>
</html>