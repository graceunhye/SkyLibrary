
	function Submit(){

		var userID			= $("#userID").val();
		var userName        = $("input[name='userName']").val();
		var userEmail       = $("input[name='userEmail']").val();
		var userEmailDomain = $("input[name='userEmailDomain']").val();
		var userNumSplit1   = $("input[name='userNumSplit1']").val();
		var userNumSplit2   = $("input[name='userNumSplit2']").val();
		var userNumSplit3   = $("input[name='userNumSplit3']").val();
		
		if(userName == ""){
			alert("이름을 기입해주세요.");
		}else if(userEmail == "" || userEmailDomain == ""){
			
			alert("이메일을 기입해주세요.");
		}else if(userNumSplit2 == "" || userNumSplit3 == "" || userNumSplit1 == ""){
		 	
			alert("번호를 입력해주세요.");
		}else{

				$.ajax({
					url: "/myPage/ajax/userInfoModifyOk",
					type: "GET",
					data: {
						userID: userID,
						userName: userName,
						userEmail: userEmail,
						userEmailDomain: userEmailDomain,
						userNumSplit1: userNumSplit1,
						userNumSplit2: userNumSplit2,
						userNumSplit2: userNumSplit3
					},error: function(){
						alert("submit function error");
					},success: function(data){
						
					}
					
				})
		}
 
	}
	
	function userDelete(rentcount,id){
			var Rentcount  = rentcount;
			if(Rentcount >0){
				
				alert("반납되지 않은 도서가 있습니다. 반납 후 탈퇴해주세요.");
				return false;
				
			}
		
		
			 var seletedId = id; 
			 var text = "정말 탈퇴하시겠습니까?";
			 var result = confirm(text);
				if(result){ 
					userDeleteOk(seletedId); 
				} 
		
	}
	
	function userDeleteOk(id){
			
		
		var seletedId = id;
		
		$.ajax({
			url:"userDeleteOk.jsp",
			type:"POST",
			data: {
				"SelectedIds" : seletedId
			},
			success: function(data)
			{
				window.location.href = "userDeleted.jsp";
			},
			error:function(xhr, status, error){
				alert("��Ž���!");
			}
		});	
				
		
	}
	