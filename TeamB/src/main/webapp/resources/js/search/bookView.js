function rentFn(isbn, cnt){
	if($("#session_id").val() != null) {
		if(cnt < 10 ) {
			if(confirm("대출 하시겠습니까?")){	
				$.ajax({
					url  : "/search/bookViewAjax", 
					type : "post",
					data : "isbn=" + isbn,
					success : function(data){
						var str1 = "대출불가 (대출중)";
						var str2 = data.rentEndDate;
						var str3 = "";
	
						$("#rent1").html(str1);
						$("#rent2").html(str2);
						$(".rentbtn").attr("disabled", true);
						$(".rentbtn").val("대출완료");
						alert("대출이 완료 되었습니다.");
					}	
				});
			}
		} else {
			alert("10권 이상 대여할 수 없습니다.");
		}	
	} else { 
		alert("로그인 후 이용 가능한 서비스 입니다.");
	}	
}