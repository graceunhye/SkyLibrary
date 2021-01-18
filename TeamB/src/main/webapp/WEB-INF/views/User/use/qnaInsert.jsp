<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>질의응답 작성하기</title>
		<link rel="stylesheet" href="/css/common.css" type="text/css"/>
		<link rel="stylesheet" href="/css/use/qna.css" type="text/css"/>
		
		<script src="/js/jquery-3.5.1.min.js"></script>
		<script src="/js/common.js"></script>
		<script>
			$("#cancleBtn").onclick(function(){
				if(confirm("작업하던 내용이 모두 사라집니다. 정말 취소하시겠습니까?") == true){
					location.href="/use/qna";
				}else{
					return;
				}		
			})
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
				<nav class="left_menu">
					<ul>
						<li class="left_menu_title">도서관 이용</li>
						<a href="/use/useTime"><li class="left_menu_sub">이용시간</li></a>
						<a href="/use/useGuide"><li class="left_menu_sub">대출/반납/예약/연장</li></a>
						<a href="/use/qna"><li class="on left_menu_sub last_sub">질의응답</li></a>
					</ul>
				</nav>
				<div class="section">
					<div class="section_top">
						<span class="top_title">질의응답</span>
						<span class="page_map">도서관 이용 > 질의응답 > 질문하기</span>
					</div>
					<div class="content">
						<div class="qInsertTableWrap">
							<form action="/use/qna/insertOk" method="post">
								<table class="qInsertTable">
									<tr>
										<th align="center" width="100">제목</th>
										<td class="qInsertTableTd">
											<input type="text" size="115" placeholder="제목을 입력해주세요."  name="questionTitle">
										</td>
									</tr>
									<tr>
										<th>내용</th>
										<td width="800" height="400" class="qInsertTableTd">
											<textarea name="questionBody" cols="120" rows="25" placeholder="내용을 입력해주세요." style="resize:none"></textarea>
										</td>
									</tr>
									<tr>
										<td colspan="2">
											<div align="right">
												<input type="hidden" value="${sessionScope.user.userID}" name="userID">
												<input type="submit" value="등록하기" class="qna_btn">
												<input type="button" value="취소하기" id="cancleBtn" class="qna_btn">
											</div>
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