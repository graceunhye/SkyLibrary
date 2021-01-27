<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>하늘도서관 메인</title>
	<script src="/js/jquery-3.5.1.min.js"></script>
	<link rel="stylesheet" href="/css/mainCommon.css"  type="text/css"/>
	<link rel="stylesheet" href="/css/mainSection.css" type="text/css"/>
	
	<style>
		.details{
			position : relative;
			margin-top : 200px;
			margin-left : 800px;
			height : 400;
		}
	</style>
</head>
<body style="margin:0px">
	<div class="wrap"> 
			<header>
				<jsp:include page="./User/include/head_option.jsp"/>
				<jsp:include page="./User/include/head_banner.jsp"/>
			</header>
			<!-- header end -->
			
			<section id="section">
				<div class="row">
				    <div class="col-md-12 page-404">
				        <div class="details">
				            <table>
				            	<tr align="center">
				            		<td><img src="/image/homePage/prohibited.png" width="150"></td>
				            	</tr>
				            	<tr></tr>
				            	<tr></tr>
				            	<tr></tr>
				            	<tr align="center">
				            		<td><h1>잘못된 접근입니다.</h1></td>
				            	</tr>
				            	<tr align="center">
				            		<td><a href="<c:url value='/'/>"> [HOME] </a>을 클릭하시면, 홈으로 돌아갑니다.</td>
				            	</tr>
				            </table>			                   
				        </div>
				    </div>
				</div>				
			</section>
			<!-- section end -->
			
			<jsp:include page="./User/include/footer.jsp" />
			<!-- footer end -->
			
		</div>
</body>
</html>
