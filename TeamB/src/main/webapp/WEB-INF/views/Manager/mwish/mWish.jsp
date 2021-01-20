<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		
		<title>희망도서 관리</title>
		
		<link rel="stylesheet" href="/css/mCommon.css" type="text/css"/>
		<link rel="stylesheet" href="/css/mWish/mwish.css" type="text/css"/>
		
		<script src="/js/jquery-3.5.1.min.js"></script>
		<script src="/js/mWish/mwish.js" charset="UTF-8"></script>
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
			<section>
				<jsp:include page="../include/nav.jsp" />
				<div class="section">
					<div class="user_info">
						<span class="info_title">
							<span class="point">*</span>희망도서 신청 정보
						</span>
						<div class="optionBox">	
							조회::
							타입구분:
							<select name="selectType">
								<option value="4">전체</option>
								<option value="0">신청중</option>
								<option value="1">처리중</option>
								<option value="2">취소됨</option>
								<option value="3">소장중</option>
							</select>
							<span class="slot">|</span>
							처리일 구분:
							<input type="date" name="startDate">
							에서
							<input type="date" name="endDate">
							까지
							<input type="button" value="찾기" onclick="searchFn()">
							<span class="slot">|</span>
							처리::
							모두선택:
							<input type="checkbox"  id="checkAll">
							<span class="slot">|</span>
							선택된 글 처리:
							<select name="selectType">
								<option value="0">신청중</option>
								<option value="1">처리중</option>
								<option value="2">취소됨</option>
								<option value="3">소장중</option>
							</select>
							<input type="button" onclick="checkedSaveFn()" value="저장">
						</div>
						<table class="table" border="1">
							<thead>
								<tr class="fixTable">
									<td>번호</td>
									<td>아이디</td>
									<td>isbn</td>
									<td>책이름</td>
									<td>신청일</td>
									<td>처리일</td>
									<td>처리구분</td>
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