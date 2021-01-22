<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>	 
<%@page import="java.net.URLEncoder"%>
<%@ page session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	
	<title>사서 추천 도서관리</title>
	
	<link rel="stylesheet" href="/css/mCommon.css" type="text/css"/>
	<link rel="stylesheet" href="/css/mRecommend/mrecommend.css" type="text/css"/>
	
	<style>
		.logoicon{
			width : 300px;
			position : relative;
			padding-top : 20px;
			margin-right : 0px;
			margin-left : 1600px;
		}
		.icona{
			float : left;
		}
		.logout{
			width : 150px;
			height : 40px;
			background-color : #2C78D7;
			border : 1px solid #2C78D7;
			border-radius : 3px;
			color : white;
			font-size : 15px;
			margin-left : 10px;
		}
	</style>
	
	<script src="/js/jquery-3.5.1.min.js"></script>
</head>
<body style="margin: 0px;">
	<div class="wrap">
		<header>
			<div class="header">
				<div class="title_box"><span class="head_title">관리자 페이지 </span><span class="name">하늘도서관</span></div>
				<div class="logoicon">
					<a href="/" class="icona"><img src="/image/homePage/logoicon.png" alt="하늘도서관아이콘" width="45px"></a>
					<button type="button" class="logout" onclick="location.href='/loginout/logout'"> 로그아웃 </button>
				</div>
			</div>
		</header>
		<section>
			<jsp:include page="../include/nav.jsp" />
			<div class="section">
				<div class="user_info">
				<span class="info_title"><span class="point">*</span>도서 목록</span>				
				</div>
				<br>
				<br>
				<div class="rselect">
					<form action="/mrecommend/mRecommend" name="frm" id="frm" method="get">					
						<select id="select" class="select" name="searchType">
							<c:if test="${search.searchType eq 'all' }">
								<option value="all" selected>전체</option>
								<option value="bookSubject">도서명</option>
								<option value="bookWriter">저자</option>
								<option value="bookCompany">출판사</option>
							</c:if>
							<c:if test="${search.searchType eq 'bookSubject' }">
								<option value="all">전체</option>
								<option value="bookSubject" selected>도서명</option>
								<option value="bookWriter">저자</option>
								<option value="bookCompany">출판사</option>
							</c:if>
							<c:if test="${search.searchType eq 'bookWriter' }">
								<option value="all">전체</option>
								<option value="bookSubject">도서명</option>
								<option value="bookWriter" selected>저자</option>
								<option value="bookCompany">출판사</option>
							</c:if>
							<c:if test="${search.searchType eq 'bookCompany' }">
								<option value="all">전체</option>
								<option value="bookSubject">도서명</option>
								<option value="bookWriter">저자</option>
								<option value="bookCompany" selected>출판사</option>
							</c:if>
							<c:if test="${search.searchType eq null }">
								<option value="all">전체</option>
								<option value="bookSubject">도서명</option>
								<option value="bookWriter">저자</option>
								<option value="bookCompany">출판사</option>
							</c:if>
						</select>
						<input type="text" name="searchText" id="keyword" value="${search.searchText}">
						<input type="submit" value="검색" class="optionBox_btn_free">
					</form>	
				</div>	
				<div class="content">
					<div class="booklist">	
					<br>
					<br>
						<c:forEach items="${totallist}" var="list">
							<div class="recommend">					
								<table width="800px">
									<tr>
										<td rowspan="4" width="15%" align="center">
											<a href="/Manager/mrecommend/mRecommendView?isbn=${list.bookISBN}"><img src="${list.bookCoverImg}" alt="${list.bookSubject}" width="82px"></a>
										</td>
										<td colspan="2"><a href="/mrecommend/mRecommendView?isbn=${list.bookISBN}"><b>${list.bookSubject}</b></a></td>
									</tr>
									<tr>
										<td width="30%">저자 : ${list.bookWriter}</td>
										<td width="30%">ISBN : ${list.bookISBN}</td>
									</tr>
									<tr>
										<td width="30%">출판사 : ${list.bookCompany}</td>
										<td width="30%">소장기관 : 하늘 도서관</td>
									</tr>
									<tr>
										<td width="30%">발행일 : ${list.bookPublicationDate}</td>
										<td width="30%">자료실 : 일반자료실</td>
									</tr>
								</table>
							</div>
						</c:forEach>	
						<br>							
						<div class="searchpage">	
							<c:if test="${paging.startPage != 1}">
							<a href="/mrecommend/mRecommend?nowPage=${paging.startPage - 1}&cntPerPage=${paging.cntPerPage}">&lt;</a>
							</c:if>
							<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="p">
								<!-- 현재 페이지면 진하게, 아니면 링크갖고 진하지 않도록! -->
								<c:choose>
									<c:when test="${p eq paging.nowPage}">
										<b>${p}</b>
									</c:when>
									<c:when test="${p != paging.nowPage}">
										<a href="/mrecommend/mRecommend?nowPage=${p }&cntPerPage=${paging.cntPerPage}">${p }</a>
									</c:when>
								</c:choose>
							</c:forEach>
							<c:if test="${paging.endPage != paging.lastPage}">
								<a href="/mrecommend/mRecommend?nowPage=${paging.startPage + 1}&cntPerPage=${paging.cntPerPage}">&gt;</a>
							</c:if>
						</div>	
					</div>		
				</div>	
			</div>
		</section>
	</div>
</body>
</html>