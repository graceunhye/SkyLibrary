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
					<form method="post" class="joinfrm" name="joinfrm" action="/mjoinOk">
						<div class="joinbox">
							<table style="width:550px; height:700px; border-collapse:collapse; margin-left:25px;" >
								<tr>
									<td>아이디<span class="star">*</span></td>
									<td>
										<input type="text" id="id" name="userID">&nbsp;
										<input type="button" class="joinbtn1" onclick="idCheck()" value="중복확인">
										<br /><a id="idCheckResult"></a>
									</td>
								</tr>
								<tr>
									<td>비밀번호<span class="star">*</span></td>
									<td>
										<input type="password" id="managerPW" name="managerPW" onblur="PW_check()"><br />
										<span id="passwordCheckResult"></span>
									</td>
								</tr>
								<tr>
									<td>비밀번호 확인<span class="star">*</span></td>
									<td><input type="password" id="managerRPW" name="managerRPW" onblur="RPW_check()">
									<br /><a id="rePasswordCheckResult"></a></td>
								</tr>
								<tr>
									<td>이름<span class="star">*</span></td>
									<td>
										<input type="text" id="managerName" name="managerName">
										<br /><span id="nameCheckResult"></span>
									</td>
								</tr>
								<tr>
									<td>이메일<span class="star">*</span></td>
									<td>
										<input type="text" id="managerEmailID" name="managerEmailID" onblur="Email_Check()"> @
										<select name="managerEmailDomain">
											<option value="naver.com">naver.com
											<option value="nate.com">nate.com
											<option value="gmail.com">gmail.com
										</select>
										<br /><span id="emailCheckResult"></span>
									</td>
								</tr>
								<tr>
									<td>연락처<span class="star">*</span></td>
									<td>
										<select name="managerNumSplit1">
											<option value="010">010
											<option value="011">011
											<option value="016">016										
										</select>
										 -
										<input type="text" id="managerNumSplit2" name="managerNumSplit2" maxlength="4" onblur="Num_Check()">
										 - 
										<input type="text" id="managerNumSplit3" name="managerNumSplit3" maxlength="4" onblur="Num_Check()">
										<br /><span id="numCheckResult"></span>	
									</td>
								</tr>
								<tr>
									<td>주소<span class="star">*</span></td>
									<td>
										<input type="text" id="managerPostNum" name="managerPostNum" size="7" onblur="Addr_Check()">&nbsp;
										<input type="button" class="joinbtn1" value="우편번호 찾기" onclick="PostOpen()"><br />
										<input type="text" id="managerAddr" name="managerAddr" size="50" placeholder="주소"><br />
										<input type="text" id="managerAddrDetail" name="managerAddrDetail" size="50" placeholder="상세주소"><br />
										<span id="postCheckResult"></span>
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