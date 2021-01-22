
function wishCancelFn(){
	if(confirm("모든 내용이 사라집니다. 취소하시겠습니까?")){
		location.href='/myPage/wish';
	}else {
		return;
	}
}

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
