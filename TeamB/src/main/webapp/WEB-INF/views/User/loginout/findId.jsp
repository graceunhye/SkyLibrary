<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		
		<title>아이디 찾기</title>
		
		<link rel="stylesheet" href="/css/mainCommon.css" type="text/css"/>
		
		<style>
			.point {
				color: orange;
				font-weight: bold;
			}
			
			.id {
				margin-right: 10px;
			}
			
			.id_title {
				margin-right: 6px;
				color: #2C78D7;
			}
			.login_input_box {
				border: 1px solid #e0e0e0;
				border-radius: 5px;
				width: 400px;
				height: 200px;
				padding: 40px;
			}
			.id {
				margin-right: 10px;
			}
			.login_title {
				border-left: 5px solid #124993;
				color: #124993;
				padding-left: 8px;
			}
			.login_box {
				margin: 80px 0 80px 410px;
			}
			.login_btn{
				border : 1px solid #124993;
				background-color : #124993;
				color : white;
				border-radius: 3px;
				width : 400px;
				height : 40px;
			}															
		</style>
		
		<script src="/js/jquery-3.5.1.min.js"></script>
		<script>
			function findIdFn(){
				
				var userNum = $("#userNum").val();
				
				$.ajax({
					url:"/loginout/findIdAjax",
					type:"post",
					data:"userNum="+userNum,
					success:function(data){
						var output = "회원님의 아이디는 " + data + " 입니다.";
						$("#id_span").html(output);
					},
					error:function(){						
					}
				});
			}
		</script>
	</head>
	<body style="margin:0px">
		<div class="wrap"> 
			<header>
				<jsp:include page="../include/head_option.jsp" />
				<jsp:include page="../include/head_banner.jsp" />
			</header>
			<!-- header end -->
		
		<section id="section">
			<div class="section">
				<div class="login_box">
				<h2 class="login_title">아이디 찾기</h2>
					<div class="login_input_box">
						<span class="point id">*</span><span class="id_title">휴대폰번호</span>
						<input type="text" id="userNum" name="userNum" class="input" size="30" placeholder="010-0000-0000 으로 입력해주세요.">
						<br>
						<br>
						<span id="id_span"></span>
						<br>
						<br>
						<input type="button" value="아이디 찾기" id="find_btn" class="login_btn" onclick="findIdFn()">
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