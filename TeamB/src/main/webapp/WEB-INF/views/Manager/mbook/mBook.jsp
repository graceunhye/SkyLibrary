<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		
		<title>도서 관리</title>
		
		<link rel="stylesheet" href="/css/mCommon.css" type="text/css"/>
		
		<script src="/js/jquery-3.5.1.min.js"></script>
	</head>
	<body style="margin: 0px;">
		<input type="hidden" value="${sessionScope.user.userID }" id="userID">
		<div class="wrap">
			<header>
				<div class="header">
					<div>
						<span>관리자 페이지 </span>
						<span>하늘도서관</span>
					</div>
				</div>
			</header>
			<section>
				<jsp:include page="../include/nav.jsp" />
				<div class="section">
					<div class="user_info">
						<span class="info_title"><span class="point">*</span>질문 정보</span>
						<div class="optionBox">	
							조회::
							타입구분:
							<select name="selectType" id="selectType">
								<option value="2">전체</option>
								<option value="0">답변대기</option>
								<option value="1">답변완료</option>
							</select>
							<span class="slot">|</span>
							질문일자 구분:
							<input type="date" name="startDate" id="startDate">
							에서
							<input type="date" name="endDate" id="endDate">
							까지
							<input type="button" class="optionBox_btn" value="찾기" onclick="searchFn()">
						</div>
						<table class="table" border="1">
							<thead>
								<tr class="fixTable">
									<th>번호</th>
									<th>제목</th>
									<th>작성자</th>
									<th>작성일</th>
									<th>답변일</th>
									<th>상태</th>
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