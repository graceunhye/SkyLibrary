		var idCheck = "false";

		function idCheck(){				
			var id = document.joinfrm.id.value;
			
			$.ajax({
				url: "/IDcheck?id=" + id,
				type:"get",
				success: function(data)
				{
					if(data.trim() == "idEmpty") {
					
						$("#idCheckResult").css("color", "red");
						$("#idCheckResult").html("아이디를 입력해주세요.");
						$("#userID").focus();
						
					}else if(data.trim() == "mismatch") {
					
						$("#idCheckResult").css("color", "red");
						$("#idCheckResult").html("아이디는 5~20자로 영어와 숫자만 사용하실 수 있습니다.");
							
					}else if(data.trim() == "alreadyUse") {
					
						$("#idCheckResult").css("color", "red");
						$("#idCheckResult").html("이미 사용중인 아이디 입니다.");
						
					}else{
					
						$("#idCheckResult").css("color", "blue");
						$("#idCheckResult").html("사용 가능한 아이디입니다.");
						idCheck = "true";
						
					}
				}
			});	
		} 

		function PW_check(){
		
		     var userPW = $("#userPW").val().trim();
		     
			 var pattern1 = /[0-9]/;
	         var pattern2 = /[a-zA-Z]/;
	         var pattern3 = /[~!@\#$%<>^&*]/; 
			 
			if(!userPW){
				 
				 $("#userPW").val("");	//비밀번호 초기값으로 초기화
				 $("#passwordCheckResult").html("비밀번호를 입력해주세요.");
				 return false;
			 
			 }else if(pw.length < 8 || pw.length > 20){
			 
				 $("#passwordCheckResult").css("color","red");
				 $("#passwordCheckResult").html("비밀번호는 8자리 이상 20자리 이하입니다.");
				 $("#userPW").val("");
				 $("#userPW").focus();
				 return false;
			 
			 }else if(userPW.search(/\s/) != -1){
			 
				  $("#passwordCheckResult").css("color","red");
				  $("#passwordCheckResult").html("비밀번호엔 공백을 쓰실 수 없습니다.");
				  $("#userPW").val("");
				   $("#userPW").focus();
				   
				  return false;
				  
			}else if(!pattern1.test(userPW) || !pattern2.test(userPW) || !pattern3.test(userPW)){
				 
				 $("#passwordCheckResult").css("color","red");
				 $("#passwordCheckResult").html("비밀번호는 영어, 숫자, 특수문자 1개씩은 포함하여야 합니다.");
				 
				 $("#userPW").val("");
				 $("#userPW").focus();
				 return false;
				 
			 }else{
				 
				 $("#passwordCheckResult").css("color","blue");
				 $("#passwordCheckResult").html("사용 가능한 비밀번호 입니다.");
				 return true;
			 }
		}
		
		
		function RPW_check(){
			 var userPW  = $("#userPW").val().trim();
			 var userRPW = $("#userRPW").val().trim();
			 
			 if(userPW != userRPW) {
				 
				 $("#userRPW").val("");	//비밀번호 초기값으로 초기화
				 $("#rePasswordCheckResult").css("color","red");
				 $("#rePasswordCheckResult").html("비밀번호가 일치하지 않습니다.");

				 return false;
				 
			}else {
				
				 $("#rePasswordCheckResult").html(" ");
				 return true;
			}
		}
		
		
		function PostOpen(){
				new daum.Postcode({
				    oncomplete: function(data) {
				        //data는 사용자가 선택한 주소 정보를 담고 있는 객체
				    	$("#userPostNum").val(data.zonecode);
						$("#userAddr").val(data.address);
				    }
				}).open();
				
		}
		
		
		
		function Submit(){
		
			var userIDValue        = $("#userID").val();
			var userNameValue      = $("#userName").val();
			var userPWValue        = $("#userPW").val();
			var userRPWValue       = $("#userRPW").val();
			var userEmailValue     = $("#userEmail").val();
			var userNumSplit2Value = $("#userNumSplit2").val();
			var userNumSplit3Value = $("#userNumSplit3").val();
			var userPostNumValue   = $("#userPostNum").val();
			
			
			if(userIDValue == "")
			{
				alert("아이디는 필수 항목입니다.");
				$("#userID").focus();
				
			}else if(idCheck == "false")
			{
				alert("아이디 중복체크를 해주세요.");
			}
			else if(userPWValue == "") 
			{
				alert("비밀번호는 필수 항목입니다.");
				$("#userPW").focus();
				
			}else if(userRPWValue == "") 
			{
				alert("비밀번호 확인은 필수 항목입니다.");
				$("#userRPW").focus();
			}
			else if(userNameValue == "") 
			{
				alert("이름은 필수 항목입니다.");
				$("#userName").focus();
				
			}else if(userEmailValue == "") 
			{
				alert("이메일은 필수 항목입니다.");
				$("#userEmail").focus();
				
			}else if(userEmailValue.trim() == "") 
			{
			
				alert("이메일에 공백은 넣을 수 없습니다. 다시 시도해주세요.");
				userEmailValue = "";
				$("#userEmail").focus();
				
			}else if(userNumSplit2Value == "" && userNumSplit3Value == "")
			{
				alert("연락처는 필수 항목 입니다.");
				if(userNumSplit2Value == ""){
					$("#userNumSplit2").focus();
				}
				if(userNumSplit3Value == ""){
					$("#userNumSplit3").focus();
				}
			}
			else if(isNaN(userNumSplit2Value)) //isNaN() true==숫자 아니다. false== 숫자다.
			{ 
				alert("올바른 형식의 전화번호를 입력해주세요");
				userNumSplit2Value = "";
				$("#userNumSplit2").focus();
			}
			else if(isNaN(userNumSplit3Value))
			{
				alert("올바른 형식의 전화번호를 입력해주세요");
				userNumSplit3Value = "";
				$("#userNumSplit3").focus();
			}
			else if(userNumSplit2Value == "" || userNumSplit3Value == "")
			{
				alert("올바른 형식의 전화번호를 입력해주세요");
				if(userNumSplit2Value == "") {
					$("#userNumSplit2").focus();
				}
				if(userNumSplit3Value == "") {
					$("#userNumSplit3").focus();
				}
			}
			else if(userPostNumValue != "" && isNaN(userPostNumValue))
			{
				alert("올바른 형식의 우편번호가 아닙니다. 다시 시도해주세요.");
			}
			else
			{
				document.joinfrm.submit();
			}
			
			idCheck = "false";
	
		}