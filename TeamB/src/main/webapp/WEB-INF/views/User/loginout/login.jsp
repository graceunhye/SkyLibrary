<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		
		<title>로그인</title>
		
		<link rel="stylesheet" href="/css/mainCommon.css" type="text/css"/>
		<link rel="stylesheet" href="/css/loginout/loginoutSection.css" type="text/css"/>
		
		<script src="/js/jquery-3.5.1.min.js"></script>
		<script src="/js/loginout/login.js"></script>
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
				<h2 class="login_title">로그인</h2>
					<div class="login_input_box">
						<form action="/loginout/loginOk" method="post" name="login_frm">
							<table>
								<tr height="50" class="login_txt">
									<td width="100" align="right" class="login_input"><span class="point id">*</span><span class="id_title">아이디</span>:</td>
									<td width="300"><input type="text" class="input" name="userID" size="38" placeholder=" 아이디를 입력해주세요."></td>
								</tr>
								<tr height="50" class="login_txt">
									<td align="right" class="login_input"><span class="point">*</span>비밀번호:</td>
									<td><input type="password" name="userPW"  class="input" size="38" placeholder=" 비밀번호를 입력해주세요."></td>
								</tr>
								<tr class="login_option">
									<td colspan="2" align="center">
										<a href="#">아이디/비밀번호찾기</a>
										<font color="#2C78D7">&nbsp;|&nbsp;</font>
										<a href="/join">회원가입</a>
										<font color="#2C78D7">&nbsp;|&nbsp;</font>
										<a href="javascript:m_login()">사서 로그인</a>
									</td>
								</tr>
								<tr height="70">
									<td colspan="2" align="center">
										<button type="button" class="login_btn" onclick="login()" >로그인</button>
									</td>
								</tr>
							</table>
						</form>
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