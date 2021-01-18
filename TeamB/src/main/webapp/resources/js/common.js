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

 
 function qnaInsertCancelFn() {
	 if(confirm("���� ����Ͻðڽ��ϱ�?") == true){
			location.href="qna.jsp";
		}else{
			return;
		}			 
 }
 
function qnaDeleteFn(no) {
	
	 if(confirm("���� ���� �Ͻðڽ��ϱ�?")) {
		 
		 //Ȯ�� ��ư Ŭ�� �� ����
		 location.href="qnaDeleteOk.jsp?no="+no;
		 
	 } else {
		 
		 //��� ��ư Ŭ�� �� ����
		 alert("����Ͽ����ϴ�.");
	 }
}

function qnaNeedLogin(id) {
	if(id == null || id == "")
	{
		if(confirm("�α����� �ʿ��� �����Դϴ�. �α���â���� �̵��Ͻðڽ��ϱ�??") == true)
		{
			//Ȯ��
			location.href="../loginout/login";
		}else
		{
			//���
		}			
	}else
	{
		location.href="qnaInsert";
	}	
}

function wishCancelFn(){
	if(confirm("����Ͻðڽ��ϱ�?")){
		// Ȯ�� ��ư Ŭ�� �� ����
		location.href='wish';
	}else {
		//��� ��ư Ŭ�� �� ����
	}
}


function wishNeedLoginFn(value){
	if(value == "0" ){

		location.href="wishApply";
				
	}else if(value == "1" )
	{
		location.href="wishCheck";		
	}
}

