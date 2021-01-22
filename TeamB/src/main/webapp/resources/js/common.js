
function wishCancelFn(){
	if(confirm("����Ͻðڽ��ϱ�?")){

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

