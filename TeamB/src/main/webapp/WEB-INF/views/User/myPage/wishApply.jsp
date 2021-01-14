<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		
		<title>희망 도서 신청</title>
		
		<link rel="stylesheet" href="/css/common.css" type="text/css"/>
		<link rel="stylesheet" href="/css/myPage/wish.css"   type="text/css"/>
		
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
						<li class="left_menu_title">마이페이지</li>
						<a href="/User/myPage/userInfo"><li class="left_menu_sub">회원정보</li></a>
						<a href="/User/myPage/wish"><li class="on left_menu_sub">희망도서 신청</li></a>
						<a href="/User/myPage/renting"><li class="left_menu_sub last_sub">대출도서 조회</li></a>
					</ul>
				</nav>
				<!-- nav end -->
				
				<div class="section">
					<div class="section_top">
						<span class="top_title">희망도서 신청</span>
						<span class="page_map">마이페이지 > 희망도서 신청 > 신청하기</span>
					</div>
					<div class="content">
						<form method="post" action="/User/myPage/wishOk">
						<p class="tip"><span class="point">*</span> 표시된 항목은 필수 입력 항목입니다</p>
						<table class="wish_table" >
							<tbody>
								<tr>
									<th scope="row">
										<label for="subject">도서명<span class="point">*</span></label>
									</th>
									<td>
										<input type="text" id="subject" name="applySubject" />
									</td>
								</tr>
								<tr>
									<th scope="row">
										<label for="isbn">isbn <span class="point">*</span></label>
									</th>
									<td>
										<input type="text" id="isbn"  name="applyISBN"/>
									</td>
								</tr>
								<tr>
									<th scope="row">
										<label for="pdate">발행년도 <span class="point">*</span></label>
									</th>
									<td>
										<input type="text" id="pdate" name="applyPublicationDate" />
									</td>
								</tr>
								<tr>
									<th scope="row">
										<label for="price">가격<span class="point">*</span></label>
									</th>
									<td>
										<input type="text" name="price" id="applyPrice" />
									</td>
								</tr>
								<tr>
									<th scope="row">
										<label for="writer">저자명</label>
									</th>
									<td>
										<input type="text" name="writer" id="applyWriter" />
									</td>
								</tr>
								<tr>
									<th scope="row">
										<label for="company">발행자</label>
									</th>
									<td>
										<input type="text" id="company" name="applyCompany" />
									</td>
								</tr>
								<tr>
									<th class="last" scope="row">
										<label for="why">신청이유</label>
									</th>
									<td class="last">
										<textarea id="why" name="applyWhy" class="textarea" cols="85" rows="10"></textarea>
									</td>
								</tr>
							</tbody>
						</table>
						<div class="btns">
							<input class="btn" type="submit" value="신청"/>
							<input class="btn" type="button" value="취소" onclick="wishCancelFn()"/>
						</div>
						</form>
					</div>
				</div>
			</section>
			<!-- section end -->
				
			<jsp:include page="../include/footer.jsp"/>
			<!-- footer end -->
			
		</div>
	</body>
</html>