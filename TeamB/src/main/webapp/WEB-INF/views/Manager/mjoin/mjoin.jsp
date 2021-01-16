<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		
		<title>사서 회원가입</title>
		
		<link rel="stylesheet" href="/css/mainCommon.css" type="text/css"/>
		<link rel="stylesheet" href="/css/join/join.css" type="text/css"/>
		
		<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
		<script src="/js/jquery-3.5.1.min.js"></script>
		<script src="/js/join/mjoin.js"></script>
		<script src="/js/common.js"></script>
	</head>
	<body style="margin:0px">
		<div class="wrap"> 
			<header>
				<jsp:include page="../../User/include/head_option.jsp"/>
				<jsp:include page="../../User/include/head_banner.jsp"/>
			</header>
			<!-- header end -->
			
			<section>
				<div class="section">
					<span class="top_title">사서 회원가입</span>
					<br>
					<br>
					<form method="post" class="joinfrm" name="joinfrm" action="/User/join/mjoinOk">
						<div class="joinbox">
							<table style="width:550px; height:700px; border-collapse:collapse; margin-left:25px;" >
								<tr>
									<td>아이디<span class="star">*</span></td>
									<td>
										<input type="text" id="id" name="managerID">&nbsp;
										<input type="button" class="joinbtn1" onclick="ID_check()" value="중복확인">
										<a id="id_message"></a>
									</td>
								</tr>
								<tr>
									<td>비밀번호<span class="star">*</span></td>
									<td><input type="password" id="pw1" name="managerPW" onblur="Password_check()"><p/><a id="password_message"></a></td>
								</tr>
								<tr>
									<td>비밀번호 확인<span class="star">*</span></td>
									<td><input type="password" id="pw2" name="pw2" onblur="Password_check2()"><p/><a id="password_message2"></a></td>
								</tr>
								<tr>
									<td>이름<span class="star">*</span></td>
									<td><input type="text" id="name" name="managerName"></td>
								</tr>
								<tr>
									<td>이메일<span class="star">*</span></td>
									<td>
										<input type="text" id="email1" name="managerEmail"> @
										<select name="managerEmailDomain">
											<option value="e1">naver.com
											<option value="e2">nate.com
											<option value="e3">gmail.com
										</select>
									</td>
								</tr>
							</table>
							<br>
						</div>
						<br>
						<button type="button" class="joinbtn2" onclick="Submit()">가입</button>
					</form>
				</div>	
			</section>
			<!-- section end -->
			
			<jsp:include page="../../User/include/footer.jsp"/>
			<!-- footer end -->
			
		</div>
	</body>
</html>