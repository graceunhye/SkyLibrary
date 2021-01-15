<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>	 
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	
	<title>사서 추천 도서관리</title>
	
	<link rel="stylesheet" href="/css/mCommon.css" type="text/css"/>
	<link rel="stylesheet" href="/css/mRecommend/mrecommend.css" type="text/css"/>
	
	<script src="/js/jquery-3.5.1.min.js"></script>
</head>
<body style="margin: 0px;">
	<div class="wrap">
		<header>
			<div class="header">
				<div class="title_box"><span class="head_title">관리자 페이지 </span><span class="name">하늘도서관</span></div>
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
					<form action="recommendSearch.jsp" name="frm" id="frm" method="post">					
						<select id="select" name="select">
							<option value="1" selected>전체</option>
							<option value="2">제목</option>
							<option value="3">저자</option>
						</select>
						<input type="text" name="keyword" id="keyword">
						<input type="submit" value="검색"  class="optionBox_btn_free">
					</form>	
				</div>	
				<div class="content">
					<div class="booklist">	
					<br>
					<br>				
						<div class="recommend">					
							<table width="800px">
								<tr>
									<td rowspan="4" width="15%" align="center">
										<a href="recommendView?isbn="><img src="" alt="" width="82px"></a>
									</td>
									<td colspan="2"><a href="recommendView?isbn="><b></b></a></td>
								</tr>
								<tr>
									<td width="30%">저자 : </td>
									<td width="30%">ISBN : </td>
								</tr>
								<tr>
									<td width="30%">출판사 : </td>
									<td width="30%">소장기관 : 하늘 도서관</td>
								</tr>
								<tr>
									<td width="30%">발행일 : </td>
									<td width="30%">자료실 : 일반자료실</td>
								</tr>
							</table>
						</div>													
							<div class="searchpage">	
							<a href="recommend.jsp?page=1">맨앞으로</a>
							<a href="recommend.jsp?page=">이전</a>
							
							<b><a href="recommend.jsp?page="></a></b>
							<a href="recommend.jsp?page="></a>
							
							<a href="recommend.jsp?page=">다음</a>
							<a href="recommend.jsp?page=">맨뒤로</a>		 
							</div>	
					</div>		
				</div>	
			</div>
		</section>
	</div>
</body>
</html>