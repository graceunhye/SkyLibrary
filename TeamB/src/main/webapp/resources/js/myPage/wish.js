
function wishCancelFn(){
	if(confirm("모든 내용이 사라집니다. 취소하시겠습니까?")){
		location.href='/myPage/wish';
	}else {
		return;
	}
}

function wishSearchFn(){
	$.ajax({
		url: "/myPage/wishCheck",
		type: "POST",
		data: {
			startDate:$("input[name='startDate']").val(),
			endDat:$("input[name='endDate']").val()
		},error:function(){
			alert("검색오류가 발생하였습니다. 다시 시도 해주세요.");
		},success:function(){
			
		}
	});
};


//
//function wishNeedLoginFn(value){
//	if(value == "0" ){
//		
//		location.href="/myPage/wishApply";
//				
//	}else if(value == "1" )
//	{
//		location.href="wishCheck";		
//	}
//}
//
