	function InsertFn(){			
		if(confirm("추천 이유를 등록하시겠습니까?") == true) {
			$.ajax({
				url : "/mrecommend/insertAjax",
				type : "post",
				data : "recommend="+$("#recommend").val()+"&isbn="+$("#bookISBN").val(),
				success : function(data){				
					var str = "";
					str += "<span id='titleSp_"+data.recommendNo+"' style='display:inline-block;width:90%;'>" + data.recommendWhy + "</span><br><br>"
					str += "<span id='btnSp_"+data.recommendNo+"'><button type='button' class='optionBox_btn_free' onclick='modifyFn("+data.recommendNo+")'>수정</button> <button type='button' class='optionBox_btn_free' onclick='deleteFn("+data.recommendNo+")'>삭제</button></span>"
					$("#recommend_box").html(str);
				}
			});
			alert("등록되었습니다.");
		}	
	}
	
	function modifyFn(no){
		var titleVal = $("#titleSp_"+no).text();
		var str1 = "<textarea id='text_"+no+"' cols='100' rows='15'></textarea>";
		var str2 = "<button type='button' class='optionBox_btn_free' onclick='saveFn("+no+")'>저장</button> <button class='optionBox_btn_free' type='button' onclick='deleteFn("+no+")'>삭제</button>";
		$("#titleSp_"+no).html(str1);
		$("#btnSp_"+no).html(str2);
		$("#text_"+no).val(titleVal);
	}
	
	
	function saveFn(no){
		if(confirm("추천 이유를 수정하시겠습니까?") == true) {
			$.ajax({
				url : "/mrecommend/updateAjax",
				type : "get",
				data : "recommend="+$("#text_"+no).val()+"&no="+no, 
				success : function(data){
					$("#titleSp_"+no).html(data.recommendWhy);
					
					var str = "<button type='button' class='optionBox_btn_free' onclick='modifyFn("+no+")'>수정</button> <button class='optionBox_btn_free' type='button' onclick='deleteFn("+no+")'>삭제</button>";
					$("#btnSp_"+no).html(str);
				}
			})
			alert("수정되었습니다.");
		}
	}
	
	function deleteFn(no){
		if(confirm("추천 이유를 삭제하시겠습니까?") == true) {
			$.ajax({
				url : "/mrecommend/deleteAjax",
				type : "get",
				data : "no="+no, 
				success : function(data){
					alert("삭제되었습니다.");
					location.href = "mRecommendView?isbn="+$("#bookISBN").val();
				}
			});
		}	
	}