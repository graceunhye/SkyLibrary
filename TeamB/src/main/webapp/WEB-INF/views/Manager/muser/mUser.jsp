<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		
		<title>회원정보 관리</title>
		
		<link rel="stylesheet" href="/css/mCommon.css" type="text/css"/>
		
		<script src="/js/jquery-3.5.1.min.js"></script>
		<script src="/js/mUser/muser.js"></script>
	</head>
	<body style="margin: 0px;">
		<div class="wrap">
			<header>
				<div class="header">
					<div class="title_box"><span class="head_title">관리자 페이지 </span><span class="name">하늘도서관</span></div>
				</div>
			</header>
			<!-- header end -->
			
			<section>
				<jsp:include page="../include/nav.jsp" />
				<div class="section">
					<div class="user_info">
						<span class="info_title"><span class="point">*</span>회원 정보</span>
						
						<!-- 회원 검색기능 -->
					<div id="User_search">
						<div style="margin-bottom:10px;">
							<select id="search_type">
								<option value="typeId" selected>아이디</option>
								<option value="typeName">이름</option>
							</select>
							<input id="User_searchT" type="text" >
							<input id="User_searchB" type="button" value="검색"  onclick="user_Search()">
						</div>
						<span>
							<a href="javascript:user_Delete();" style="text-decoration:none; color:#2c78d7; font-size:17px;" >선택한 회원 삭제</a>
						</span>
					</div>
												
						<!-- 회원정보 테이블 -->
						<div class="user_content">
							<table class="content_table">	
								<tr class="top_tr">
									<td style='width:5%'>선택</td>
									<td style='width:15%'>아이디</td>
									<td style='width:15%'>이름</td>
									<td style='width:20%'>연락처</td>
									<td style='width:40%'>이메일</td>
									<td style='width:5%'>수정</td>
								</tr>
									<tr class="mid_tr">
										<td><input type='checkbox' style='zoom:1.5;' name='check' class="ckd" value=""></td>
										<td id="userId_"></td>
										<td id="userName_"></td>
										<td id="userNum_"></td>
										<td id="userE_">@naver.com</td>
										<td id="userE_">@nate.com</td>
										<td id="userE_">@gmail.com</td>
										<td id="userE_"> </td>
										<td id="userM_">
											<button type="button"  class="optionBox_btn_free" id="btnModify_" name="btnModify" onclick="user_modify('')">수정</button>
											<button type="button"  class="optionBox_btn_free" id="btnSave_" name="btnSave" style="display:none" onclick="user_modifyOK('')">저장</button>
										</td>
									</tr>

								
							</table>
						</div>
							<div class="searchpage" style="width: 1200px; text-align:center; margin:0px;">	
									<a href="mUser.jsp?page=1">맨앞으로</a> 
									<a href="mUser.jsp?page=">이전</a>
								
									<b><a href="mUser.jsp?page="></a></b>
								    <a href="mUser.jsp?page="></a>
									<a href="mUser.jsp?page=">다음</a>
									<a href="mUser.jsp?page=">맨뒤로</a>	
							</div>
						
					</div>
				</div>
			</section>
		</div>
	</body>
</html>