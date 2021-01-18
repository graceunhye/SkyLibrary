 function needLoginFn(id) {
	 if(id==null || id==""){

		if(confirm("�α����� �ʿ��� �����Դϴ�. �α���â���� �̵��Ͻðڽ��ϱ�?") == true){
			location.href="../loginout/login.jsp";
		}else{
			return;
		}			
	 }else {
		 location.href="../myPage/userInfo.jsp";
	 }
	 
 } 
/*
	function qnaDeleteFn(no) {
		
		 if(confirm("���� ���� �Ͻðڽ��ϱ�?")) {
			 
			 //Ȯ�� ��ư Ŭ�� �� ����
			 location.href="qnaDeleteOk.jsp?no="+no;
			 
		 } else {
			 
			 //��� ��ư Ŭ�� �� ����
			 alert("����Ͽ����ϴ�.");
		 }
	}*/

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

function wishCancelFn(){
	if(confirm("����Ͻðڽ��ϱ�?")){
		// Ȯ�� ��ư Ŭ�� �� ����
		location.href='wish.jsp';
	}else {
		//��� ��ư Ŭ�� �� ����
	}
}


function wishNeedLoginFn(value){
	if(value == "0" ){

		location.href="wishApply.jsp";
				
	}else if(value == "1" )
	{
		location.href="wishCheck.jsp";		
	}
}

