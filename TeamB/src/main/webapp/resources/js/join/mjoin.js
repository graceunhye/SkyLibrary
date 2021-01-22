		var isCheck = false;
		var isCheckPost = false

		function idCheck(){
			var managerID = $("input[name='userID']").val();
		
			if(managerID != null && managerID != ""){
				
				$.ajax({
					url: "/join/ajax/idCheckOk?",
					type: "GET",
					data: {userID:managerID},
					error: function(){
						alert("idCheck function error");
					}, success: function(data)
					{
						if(data == "idEmpty") {
						
							$("#idCheckResult").css("color", "red");
							$("#idCheckResult").html("아이디를 입력해주세요.");
							$("input[name='userID']").focus();
							isCheck=false;
							alert("아이디를 입력해주세요.");
							
						}else if(data == "mismatch") {
						
							$("#idCheckResult").css("color", "red");
							$("#idCheckResult").html("아이디는 5~20자로 영어와 숫자만 사용하실 수 있습니다.");
							$("input[name='userID']").val("");
							isCheck=false;
							alert("아이디는 5~20자로 영어와 숫자만 사용하실 수 있습니다.");
								
						}else if(data == "alreadyUse") {
						
							$("#idCheckResult").css("color", "red");
							$("#idCheckResult").html("이미 사용중인 아이디 입니다.");
							isCheck=false;
							alert("이미 사용중인 아이디 입니다.");
							
						}else{
						
							$("#idCheckResult").css("color", "blue");
							$("#idCheckResult").html("사용 가능한 아이디입니다.");
							alert("사용 가능한 아이디입니다.");
							isCheck=true;
							
						}
				}
			});	
			}else {
				
				$("#idCheckResult").html("아이디를 입력해주세요.");
				$("#idCheckResult").css("color", "red");
				$("input[name='userID']").focus();
			}
		}
		
		function PW_check(){
		
		     var managerPW = $("input[name='managerPW']").val().trim();
		     
			 var pattern1 = /[0-9]/;
	         var pattern2 = /[a-zA-Z]/;
	         var pattern3 = /[~!@\#$%<>^&*]/; 
			 
			if(!managerPW){
				 
				 $("input[name='managerPW']").val("");	//비밀번호 초기값으로 초기화
				 $("#passwordCheckResult").html("비밀번호를 입력해주세요.");
				 $("#passwordCheckResult").css("color", "red");
				 
				 return false;
			 
			 }else if(managerPW.length < 8 || managerPW.length > 20){
			 
				 $("#passwordCheckResult").html("비밀번호는 8자리 이상 20자리 이하입니다.");
				 $("#passwordCheckResult").css("color","red");
				 $("input[name='managerPW']").val("");
				 $("input[name='managerPW']").focus();
				 return false;
			 
			 }else if(managerPW.search(/\s/) != -1){
			 
				  $("#passwordCheckResult").html("비밀번호엔 공백을 쓰실 수 없습니다.");
				  $("#passwordCheckResult").css("color","red");
				  $("input[name='managerPW']").val("");
				  $("input[name='managerPW']").focus();
				   
				  return false;
				  
			}else if(!pattern1.test(managerPW) || !pattern2.test(managerPW) || !pattern3.test(managerPW)){
				 
				 $("#passwordCheckResult").html("비밀번호는 영어, 숫자, 특수문자 1개씩은 포함하여야 합니다.");
				 $("#passwordCheckResult").css("color","red");
				 
				 $("input[name='managerPW']").val("");
				 $("input[name='managerPW']").focus();
				 return false;
				 
			 }else{
				 
				 $("#passwordCheckResult").html("사용 가능한 비밀번호 입니다.");
				 $("#passwordCheckResult").css("color","blue");
				 return true;
			 }
		}
		
		
		function RPW_check(){
			 var managerPW  = $("input[name='managerPW']").val().trim();
			 var managerRPW = $("input[name='managerRPW']").val().trim();
			 
			if(managerPW != managerRPW || managerRPW == "") {
				 
				 $("input[name='managerRPW']").val("");	//비밀번호 초기값으로 초기화
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
				    	$("input[name='managerPostNum']").val(data.zonecode);
				    	$("input[name='managerAddr']").val(data.address);
				    }
				}).open();
				
				isCheckPost = true;
				
		}
		
		function Email_Check(){
			var Email = $("input[name='managerEmailID']").val();
			
			if(Email == ""){
				$("#emailCheckResult").html("이메일을 입력해주세요.");
				$("#emailCheckResult").css("color","red");
			}else {
				$("#emailCheckResult").html("");
			}
			
		}
		
		function Num_Check(){
			var split2 = $("input[name='managerNumSplit2']").val();
			var split3 = $("input[name='managerNumSplit3']").val();
			if(split2 == "" || split3 == ""){
				$("#numCheckResult").html("번호를 입력해주세요.");
				$("#numCheckResult").css("color","red");
			}else {
				$("#numCheckResult").html("");
			}
			
		}
		
		function Name_Check(){
			var Name = $("input[name='managerName']").val();

			if(Name == ""){
				$("#nameCheckResult").html("이름을 입력해주세요.");
				$("#nameCheckResult").css("color","red");
				$("#nameCheckResult").html("");
			}
			
		}
		
		function Addr_Check(){
			var postNumValue = $("input[name='managerPostNum']").val();
			var addrValue = $("input[name='managerAddr']").val();
			
			if(postNumValue == "") {
				$("#postCheckResult").html("우편번호를 조회해주세요.");
				$("#postCheckResult").css("color","red");
			}else if(addrValue == "" || addrValue == "주소") {
				$("#postCheckResult").html("주소가 기입되지 않았습니다.");
			}else{
				$("#postCheckResult").html("");
			}
			
		}
		
		function Submit(){
		
			var managerIDValue        = $("input[name='userID']").val();
			var managerNameValue      = $("input[name='managerName']").val();
			var managerPWValue        = $("input[name='managerPW']").val();
			var managerRPWValue       = $("input[name='managerRPW']").val();
			var managerEmailValue     = $("input[name='managerEmailID']").val();
			var managerNumSplit2Value = $("input[name='managerNumSplit2']").val();
			var managerNumSplit3Value = $("input[name='managerNumSplit3']").val();
			var managerPostNumValue   = $("input[name='managerPostNum']").val();
			var managerAddrValue      = $("input[name='managerAddr']").val();
			
			
			if(managerIDValue == "")
			{
				alert("아이디는 필수 항목입니다.");
				$("input[name='userID']").focus();
				
			}else if(isCheck == false)
			{
				alert("아이디 중복체크를 해주세요.");
			}
			else if(managerPWValue == "") 
			{
				alert("비밀번호는 필수 항목입니다.");
				$("input[name='managerPW']").focus();
				
			}else if(managerRPWValue == "") 
			{
				alert("비밀번호 확인은 필수 항목입니다.");
				$("input[name='managerRPW']").focus();
			}
			else if(managerNameValue == "") 
			{
				alert("이름은 필수 항목입니다.");
				$("input[name='managerName']").focus();
				
			}else if(managerEmailValue == "") 
			{
				alert("이메일은 필수 항목입니다.");
				$("input[name='managerEmailID']").focus();
				
			}else if(managerEmailValue.trim() == "") 
			{
				alert("이메일에 공백은 넣을 수 없습니다. 다시 시도해주세요.");
				userEmailValue = "";
				$("input[name='managerEmailID']").focus();
				
			}else if(managerNumSplit2Value == "" && managerNumSplit3Value == "")
			{
				alert("연락처는 필수 항목 입니다.");
				if(managerNumSplit2Value == ""){
					$("input[name='managerNumSplit2']").focus();
				}
				if(userNumSplit3Value == ""){
					$("input[name='managerNumSplit3']").focus();
				}
			}
			else if(isNaN(managerNumSplit2Value)) //isNaN() true==숫자 아니다. false== 숫자다.
			{ 
				alert("올바른 형식의 전화번호를 입력해주세요");
				managerNumSplit2Value = "";
				$("input[name='managerNumSplit2']").focus();
			}
			else if(isNaN(managerNumSplit3Value))
			{
				alert("올바른 형식의 전화번호를 입력해주세요");
				managerNumSplit3Value = "";
				$("input[name='managerNumSplit3']").focus();
			}
			else if(managerNumSplit2Value == "" || managerNumSplit3Value == "")
			{
				alert("올바른 형식의 전화번호를 입력해주세요");
				if(managerNumSplit2Value == "") {
					$("input[name='managerNumSplit2']").focus();
				}
				if(managerNumSplit3Value == "") {
					$("input[name='managerNumSplit3']").focus();
				}
			}else if(managerPostNumValue == ""){
				alert("우편번호를 입력해주세요.");
				
			}else if(isCheckPost == false){
				alert("우편번호를 조회해주세요.")
				
			}else if(managerAddrValue == ""){
				alert("주소를 입력해주세요.")
				$("input[name='managerAddr']").focus();
			}else if(managerPostNumValue != "" && isNaN(managerPostNumValue))
			{
				alert("올바른 형식의 우편번호가 아닙니다. 다시 시도해주세요.");
			}
			else
			{
				document.joinfrm.submit();
			}
			
			isCheck = false;
	
		}