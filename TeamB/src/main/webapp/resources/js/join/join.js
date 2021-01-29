		var isCheck = false;
		var dice = 0;
		var checkNumResult = false;
		
		function idCheck(){
			if(userID != null && userID != ""){
				
				$.ajax({
					url: "/join/ajax/idCheckOk?",
					type: "GET",
					data: {userID:$("#userID").val()},
					error: function(){
						alert("idCheck function error");
					}, success: function(data)
					{
						if(data == "mismatch") {
						
							$("#idCheckResult").css("color", "red");
							$("#idCheckResult").html("아이디는 5~20자로 영어와 숫자만 사용하실 수 있습니다.");
							$("input[name='userID']").val("");
							isCheck = false;
							alert("아이디는 5~20자로 영어와 숫자만 사용하실 수 있습니다.");
								
						}else if(data == "alreadyUse") {
						
							$("#idCheckResult").css("color", "red");
							$("#idCheckResult").html("이미 사용중인 아이디 입니다.");
							isCheck = false;
							alert("이미 사용중인 아이디 입니다.");
							
						}else{
						
							$("#idCheckResult").css("color", "blue");
							$("#idCheckResult").html("사용 가능한 아이디입니다.");
							alert("사용 가능한 아이디입니다.");
							isCheck = true;
							
						}
				}
			});	
			}else {
				
				$("#idCheckResult").html("아이디를 입력해주세요.");
				$("#idCheckResult").css("color", "red");
				$("#userID").focus();
				isCheck = false;
			}
		}
		
		function PW_check(){
		
		     var userPW = $("input[name='userPW']").val().trim();
		     
			 var pattern1 = /[0-9]/;
	         var pattern2 = /[a-zA-Z]/;
	         var pattern3 = /[~!@\#$%<>^&*]/; 
			 
			if(!userPW){
				 
				 $("input[name='userPW']").val("");	//비밀번호 초기값으로 초기화
				 $("#passwordCheckResult").html("비밀번호를 입력해주세요.");
				 $("#passwordCheckResult").css("color", "red");
				 
				 return false;
			 
			 }else if(userPW.length < 8 || userPW.length > 20){
			 
				 $("#passwordCheckResult").html("비밀번호는 8자리 이상 20자리 이하입니다.");
				 $("#passwordCheckResult").css("color","red");
				 $("input[name='userPW']").val("");
				 $("input[name='userPW']").focus();
				 return false;
			 
			 }else if(userPW.search(/\s/) != -1){
			 
				  $("#passwordCheckResult").html("비밀번호엔 공백을 쓰실 수 없습니다.");
				  $("#passwordCheckResult").css("color","red");
				  $("input[name='userPW']").val("");
				  $("input[name='userPW']").focus();
				   
				  return false;
				  
			}else if(!pattern1.test(userPW) || !pattern2.test(userPW) || !pattern3.test(userPW)){
				 
				 $("#passwordCheckResult").html("비밀번호는 영어, 숫자, 특수문자 1개씩은 포함하여야 합니다.");
				 $("#passwordCheckResult").css("color","red");
				 
				 $("input[name='userPW']").val("");
				 $("input[name='userPW']").focus();
				 return false;
				 
			 }else{
				 
				 $("#passwordCheckResult").html("사용 가능한 비밀번호 입니다.");
				 $("#passwordCheckResult").css("color","blue");
				 return true;
			 }
		}
		
		
		function RPW_check(){
			 var userPW  = $("input[name='userPW']").val().trim();
			 var userRPW = $("input[name='userRPW']").val().trim();
			 
			if(userPW != userRPW || userRPW == "") {
				 
				 $("input[name='userRPW']").val("");	//비밀번호 초기값으로 초기화
				 $("#rePasswordCheckResult").css("color","red");
				 $("#rePasswordCheckResult").html("비밀번호가 일치하지 않습니다.");

				 return false;
				 
			}else {
				 $("#rePasswordCheckResult").css("color","blue");
				 $("#rePasswordCheckResult").html("비밀번호가 일치합니다.");
				 return true;
			}
		}
		
		
		function PostOpen(){
				new daum.Postcode({
				    oncomplete: function(data) {
				        //data는 사용자가 선택한 주소 정보를 담고 있는 객체
				    	$("input[name='userPostNum']").val(data.zonecode);
				    	$("input[name='userAddr']").val(data.address);
				    }
				}).open();
				
		}
		
		function Email_Check(){
			var Email = $("input[name='userEmail']").val();
			
			if(Email == ""){
				$("#emailCheckResult").html("이메일을 입력해주세요.");
				$("#emailCheckResult").css("color","red");
			}else {
				$("#emailCheckResult").html("");
			}
			
		}
		
		function Num_Check(){
			var split2 = $("input[name='userNumSplit2']").val();
			var split3 = $("input[name='userNumSplit3']").val();
			if(split2 == "" || split3 == ""){
				$("#numCheckResult").html("번호를 입력해주세요.");
				$("#numCheckResult").css("color","red");
			}else {
				$("#numCheckResult").html("");
			}
			
		}
		
		function Name_Check(){
			var Name = $("input[name='userName']").val();

			if(Name == ""){
				$("#nameCheckResult").html("이름을 입력해주세요.");
				$("#nameCheckResult").css("color","red");
				$("#nameCheckResult").html("");
			}
			
		}
		
		function Submit(){
		
			var userIDValue        = $("input[name='userID']").val();
			var userNameValue      = $("input[name='userName']").val();
			var userPWValue        = $("input[name='userPW']").val();
			var userRPWValue       = $("input[name='userRPW']").val();
			var userEmailValue     = $("input[name='userEmail']").val();
			var userNumSplit2Value = $("input[name='userNumSplit2']").val();
			var userNumSplit3Value = $("input[name='userNumSplit3']").val();
			var userPostNumValue   = $("input[name='userPostNum']").val();
			
			
			if(userIDValue == "")
			{
				alert("아이디는 필수 항목입니다.");
				$("input[name='userID']").focus();
				
			}else if(isCheck == "false")
			{
				alert("아이디 중복체크를 해주세요.");
			}
			else if(userPWValue == "") 
			{
				alert("비밀번호는 필수 항목입니다.");
				$("input[name='userPW']").focus();
				
			}else if(userRPWValue == "") 
			{
				alert("비밀번호 확인은 필수 항목입니다.");
				$("input[name='userRPW']").focus();
			}
			else if(userNameValue == "") 
			{
				alert("이름은 필수 항목입니다.");
				$("input[name='userName']").focus();
				
			}else if(userEmailValue == "") 
			{
				alert("이메일은 필수 항목입니다.");
				$("input[name='userEmail']").focus();
				
			}else if(userEmailValue.trim() == "") 
			{
				alert("이메일에 공백은 넣을 수 없습니다. 다시 시도해주세요.");
				userEmailValue = "";
				$("input[name='userEmail']").focus();
				
			}else if(checkNumResult != true)
			{
				alert("true??::"+checkNumResult);
				alert("이메일 인증은 필수입니다.");
				
			}else if(userNumSplit2Value == "" && userNumSplit3Value == "")
			{
				alert("연락처는 필수 항목 입니다.");
				if(userNumSplit2Value == ""){
					$("input[name='userNumSplit2']").focus();
				}
				if(userNumSplit3Value == ""){
					$("input[name='userNumSplit3']").focus();
				}
			}
			else if(isNaN(userNumSplit2Value)) //isNaN() true==숫자 아니다. false== 숫자다.
			{ 
				alert("올바른 형식의 전화번호를 입력해주세요");
				userNumSplit2Value = "";
				$("input[name='userNumSplit2']").focus();
			}
			else if(isNaN(userNumSplit3Value))
			{
				alert("올바른 형식의 전화번호를 입력해주세요");
				userNumSplit3Value = "";
				$("input[name='userNumSplit3']").focus();
			}
			else if(userNumSplit2Value == "" || userNumSplit3Value == "")
			{
				alert("올바른 형식의 전화번호를 입력해주세요");
				if(userNumSplit2Value == "") {
					$("input[name='userNumSplit2']").focus();
				}
				if(userNumSplit3Value == "") {
					$("input[name='userNumSplit3']").focus();
				}
			}
			else if(userPostNumValue != "" && isNaN(userPostNumValue))
			{
				alert("올바른 형식의 우편번호가 아닙니다. 다시 시도해주세요.");
			}
			else
			{
				isCheck = false;
				emailCheckResult = false;
				document.joinfrm.submit();
			}

		}
		
		
		function EmailCheck(){
			$.ajax({
				url: "/email",
				type: "post",
				data: {
					userEmailID: $("#userEmail").val(),
					userEmailDomain: $("#userEmailDomain").val()
				},error:function(){
					alert("이메일 인증 오류가 발생했습니다. 다시 시도해주세요.");
				},success:function(data){
					dice = data;
					var str = "";
					str += "<input type='text' id='emailCheck' placeholder='인증번호'>";
					str += "&nbsp;<input type='button' value='인증' onclick='EmailCheckOkFn()'>";
					str += "<br />이메일 인증번호가 전송 되었습니다.";
					$("#emailCheckResult").html(str);	
				}
			})

		}
		
		function EmailCheckOkFn(){
			var checkNum = $("#emailCheck").val();
			
			if(checkNum == dice){
				checkNumResult = true;
				alert("인증성공");
				$("#emailCheckResult2").html("<font color='blue'>인증성공</font>");
			}else {
				checkNumResult = false;
				alert("인증실패");
				$("#emailCheckResult2").html("<font color='red'>인증실패</font>");
			}
			
		}