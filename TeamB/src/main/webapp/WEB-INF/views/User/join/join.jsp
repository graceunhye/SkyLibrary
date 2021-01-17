<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		
		<title>회원가입</title>
		
		<link rel="stylesheet" href="/css/mainCommon.css" type="text/css"/>
		<link rel="stylesheet" href="/css/join/join.css" type="text/css"/>
		
		<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
		<script src="/js/jquery-3.5.1.min.js"></script>
		<script src="/js/join/join.js"></script>
		<script src="/js/common.js"></script>
	</head>
	<body style="margin:0px">
		<div class="wrap"> 
			<header>
				<jsp:include page="../include/head_option.jsp"/>
				<jsp:include page="../include/head_banner.jsp"/>
			</header>
			<!-- header end -->
			
			<section>
				<div class="section">
					<span class="top_title">회원가입</span>
					<br>
					<br>
					<form method="post" class="joinfrm" name="joinfrm" action="/joinOk">
						<div class="joinbox">
							<table style="width:550px; height:700px; border-collapse:collapse; margin-left:25px;" >
								<tr>
									<td>아이디<span class="star">*</span></td>
									<td>
										<input type="text" id="userID" name="userID">&nbsp;
										<input type="button" class="joinbtn1" onclick="idCheck()" value="중복확인">
										<a id="idCheckResult"></a>
									</td>
								</tr>
								<tr>
									<td>비밀번호<span class="star">*</span></td>
									<td>
										<input type="password" id="userPW" name="userPW" onblur="PW_check()"><br />
										<span id="passwordCheckResult"></span>
									</td>
								</tr>
								<tr>
									<td>비밀번호 확인<span class="star">*</span></td>
									<td>
										<input type="password" id="userRPW" name="userRPW" onblur="RPW_check()"><br />
										<span id="rePasswordCheckResult"></span>
									</td>
								</tr>
								<tr>
									<td>이름<span class="star">*</span></td>
									<td><input type="text" id="userName" name="userName"></td>
								</tr>
								<tr>
									<td>이메일<span class="star">*</span></td>
									<td>
										<input type="text" id="userEmail" name="userEmail"> @
										<select name="userEmailDomain">
											<option value="naver.com">naver.com
											<option value="nate.com">nate.com
											<option value="gmail.com">gmail.com
										</select>
									</td>
								</tr>
								<tr>
									<td>연락처<span class="star">*</span></td>
									<td>
										<select name="userNumSplit1">
											<option value="010">010
											<option value="011">011
											<option value="016">016										
										</select>
										 -
										<input type="text" id="userNumSplit2" name="userNumSplit2" maxlength="4">
										 - 
										<input type="text" id="userNumSplit3" name="userNumSplit3" maxlength="4">	
									</td>
								</tr>
								<tr>
									<td>주소</td>
									<td>
										<input type="text" id="userPostNum" name="userPostNum" size="7">&nbsp;
										<input type="button" class="joinbtn1" value="우편번호 찾기" onclick="PostOpen()"><br>
										<input type="text" id="userAddr" name="userAddr" size="50"><br>
										<input type="text" id="userAddrDetail" name="userAddrDetail" size="50">
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
			
			<jsp:include page="../include/footer.jsp"/>
			<!-- footer end -->
			
		</div>
	</body>
</html>