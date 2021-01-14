<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		
		<title>이용 안내</title>
		
		<link rel="stylesheet" href="/css/common.css" type="text/css"/>
		<link rel="stylesheet" href="/css/use/useGuide.css" type="text/css"/>
		
		<script src="/js/jquery-3.5.1.min.js"></script>
		<script src="/js/common.js"></script>
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
						<li class="left_menu_title">도서관 이용</li>
						<a href="/use/useTime"><li class="left_menu_sub">이용시간</li></a>
						<a href="/use/useGuide"><li class="on left_menu_sub">대출/반납/예약/연장</li></a>
						<a href="/use/qna"><li class="on left_menu_sub last_sub">질의응답</li></a>
					</ul>
				</nav>
				<div class="section">
					<div class="section_top">
						<span class="top_title">이용시간</span>
						<span class="page_map">도서관 이용 > 대출/반납/예약/연장</span>
					</div>
					<div class="content">
						<div class="guide">
							<h3><font color="orange">*</font>대출</h3>
							<table border="1" width="800px" class="guideTable">
								<tr>
									<th>구분</th>
									<th>내용</th>
								</tr>
								<tr>
									<td class="subTitle">대출권수</td>
									<td>1개관 1인 10권</td>
								</tr>
								<tr>
									<td class="subTitle">대출대상</td>
									<td>본인
										<br>-14세 미만은 보호자가 대신 대출 가능
									</td>
								</tr>
								<tr>
									<td class="subTitle">회원가입자격</td>
									<td>-전주시 본인</td>
								</tr>
								<tr>
									<td class="subTitle">회원가입</td>
									<td>-본인인증을 통한 직접 회원가입</td>
								</tr>
								<tr>
									<td class="subTitle">대출 자료</td>
									<td>일반도서</td>
								</tr>
								<tr>
									<td class="subTitle">대출기간</td>
									<td>14일 (1회 한하여 7일 연장 가능)</td>
								</tr>
								<tr>
									<td class="subTitle">반납연체</td>
									<td>연체일수만큼 대출 정지</td>
								</tr>
							</table>
						</div>
						<div class="guide">
							<h3><font color="orange">*</font>반납</h3>
							- 도서관 자료실 안내데스크
							<br>
							- 무인반납함 (대출된 도서관)
						</div>
						<div class="guide">
							<h3><font color="orange">*</font>예약</h3>
							- 대출된 도서에 한하여 1인 2권까지 예약 가능합니다.
							<br>
							- 같은 도서에 한하여 1인만 예약 가능합니다. 
						</div>
						<div class="guide">
							<h3><font color="orange">*</font>연장</h3>
							- 1회 한하여 7일 연장 가능합니다.
							<br>
							- 대출 당일, 예약도서는 연장이 불가능합니다.
							<br>
							- 연체 회원의 경우 연장 신청이 불가능합니다.
							<br>
							- 방법 : 도서관 홈페이지 로그인->나의 도서관->대출도서/연장신청
						</div>
						<div class="guide">
							<h3><font color="orange">*</font>대출연체</h3>
							- 대출연체 반납기한을 넘겨서 반납할 경우 연체 일수만큼 대출이 불가능합니다.
						</div>
						<div class="guide">
							<h3><font color="orange">*</font>재대출</h3>
							- 예약자가 없을 경우 7일 이후 제대출이 가능합니다.
						</div>
						<div class="guide">
							<h3><font color="orange">*</font>자료변상</h3>
							- 대출자료를 훼손하거나 분실하였을 때에는 동일 자료로 변상해야 합니다.
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