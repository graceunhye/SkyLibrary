$(document).ready(function(){
	if($("#msg").val() != null){
		
		if($("#msg").val() == "qnaInsertOk"){
			alert("등록이 완료되었습니다.");
		}
	}
});

function qnaNeedLogin() {
	if(confirm("로그인이 필요한 서비스입니다. 로그인 하시겠습니까?") == true)
	{
		//확인
		location.href="/loginout/login";
	}else
	{
		//취소
	}			
}

 
 function qnaInsertCancelFn() {
	 if(confirm("정말 취소하시겠습니까? 작성하시던 내용이 사라집니다.") == true){
			location.href="/use/qna";
		}else{
			return;
		}			 
 }
 
function qnaDeleteFn(no) {
	
	 if(confirm("정말 삭제하시겠습니까? 삭제된 게시물은 복구 할 수 없습니다.")){
		 location.href="/use/qnaDeleteOk?questionNo="+questionNo;
		 
	 } else {
		 return;
	 }
}

function qnaNeedLogin(id) {
	if(id == null || id == "")
	{
		if(confirm("로그인이 필요한 서비스입니다. 로그인 하시겠습니까?") == true)
		{
			location.href="/loginout/login";
		}else
		{
			return;
		}			
	}else
	{
		location.href="/loginout/qnaInsert";
	}	
}