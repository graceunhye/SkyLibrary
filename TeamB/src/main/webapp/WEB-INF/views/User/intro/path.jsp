<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		
		<title>도서관 오시는 길</title>
		
		<link rel="stylesheet" href="/css/common.css" type="text/css"/>
		<link rel="stylesheet" href="/css/intro/path.css" type="text/css"/>
		
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
						<li class="left_menu_title">도서관 소개</li>
						<a href="/notice/"><li class="left_menu_sub">공지사항</li></a>
						<a href="/moveCalendar"><li class="left_menu_sub">월별 일정</li></a>
						<a href="/movePath"><li class="on left_menu_sub last_sub">오시는 길</li></a>
					</ul>
				</nav>
				<div class="section">
					<div class="section_top">
						<span class="top_title">오시는 길</span>
						<span class="page_map">도서관 소개 > 오시는 길</span>
					</div>
					<div class="content">
						<div class="mapWrap">
							<h2><font color="orange">*</font>지도</h2>
						<!-- 1. 지도 노드 -->
						<div id="daumRoughmapContainer1606983776975" class="root_daum_roughmap root_daum_roughmap_landing"></div>
						
						<!--
							2. 설치 스크립트
							* 지도 퍼가기 서비스를 2개 이상 넣을 경우, 설치 스크립트는 하나만 삽입합니다.
						-->
						<script charset="UTF-8" class="daum_roughmap_loader_script" src="https://ssl.daumcdn.net/dmaps/map_js_init/roughmapLoader.js"></script>
						
						<!-- 3. 실행 스크립트 -->
						<script charset="UTF-8">
							new daum.roughmap.Lander({
								"timestamp" : "1606983776975",
								"key" : "239tx",
								"mapWidth" : "700",
								"mapHeight" : "400"
							}).render();
						</script>
						<br>
						<br>
						<div>
							<div>
								<h2><font color="orange">*</font>버스 정류장</h2>
							</div>
							<div class="info_box">
								<ul class="info">
									<li><a href="https://map.kakao.com/?busStopId=BS303532">전북은행본점</a> | <b>99m</b></li>
									<li><a href="https://map.kakao.com/?busStopId=BS55036">전북대정문 덕진소방서</a> | <b>120m</b></li>
									<li><a href="https://map.kakao.com/?busStopId=BS303533">전주덕진소방서</a> | <b>155m</b></li>
									<li><a href="https://map.kakao.com/?busStopId=BS303027">전북일보사</a> | <b>266m</b></li>
									<li><a href="https://map.kakao.com/?busStopId=BS55841">국민은행금암지점</a> | <b>274m</b></li>
								</ul>
							</div>
						</div>
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