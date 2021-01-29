<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		
		<title>도서 관리</title>
		
		<link rel="stylesheet" href="/css/mCommon.css" type="text/css"/>
		<link rel="stylesheet" href="/css/mBook/mbook.css" type="text/css"/>
		
		<script src="/js/jquery-3.5.1.min.js"></script>
		<script src="/js/mBook/mbook.js" charset="UTF-8"></script>
	</head>
	<body style="margin: 0px;">
		<div class="wrap">
			<jsp:include page="../include/header.jsp" />
			<section>
				<jsp:include page="../include/nav.jsp" />
				<div class="section">
					<div class="user_info">
						<span class="info_title">
							<span class="point">*</span>도서관리 정보
						</span>
						<div class="optionBox">	
							소장도서조회::
							<select name="searchType">
								<option value="all">전체</option>
								<option value="bookSubject">도서명</option>
								<option value="bookISBN">ISBN</option>
							</select>
							<input type="text" name="searchText">
							<input type="button" value="검색" id="search">
							<span class="slot">|</span>
							외부도서조회::
							<select id="searchType_outside">
								<option value="">전체</option>
								<option value="title">도서명</option>
								<option value="isbn">ISBN</option>
								<option value="publisher">출판사</option>
							</select>
							<input type="text" id="searchText_outside">
							<input type="button" value="검색" id="search_outside">
						</div>
						<table class="table" border="1">
							<thead>
								<tr class="fixTable">
									<td>번호</td>
									<td>ISBN</td>
									<td>도서명</td>
									<td>작가명</td>
									<td>출판사</td>
									<td>발행일</td>
									<td>소장</td>
								</tr>
							</thead>
							<tbody id="result">
							</tbody>
						</table>
					</div>
					<div id="viewArea" class="userInfoView">
						
					</div>
				</div>
			</section>
		</div>
		<script>
		$("#search").click( function(){

				searchFn($("input[name='searchText']").val(),
							$("select[name='searchType']").val());
		}); 
		
		$("#search_outside").click( function(){

			if($("#searchText_outside").val() == '') {
				alert("검색어를 입력해주세요.");
				$("#searchText_outside").focus();
			}else {
				searchOutSideFn($("#searchText_outside").val(),
							$("#searchType_outside").val());
			}
		});
		</script>
	</body>
</html>