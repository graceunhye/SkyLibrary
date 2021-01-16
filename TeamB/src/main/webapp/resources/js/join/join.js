function ID_check(){				
			var id = document.joinfrm.id.value;
		
			$.ajax({
				url:"/IDcheck?id=" + id,
				type:"get",
				success: function(data)
				{
					if(data.trim() == "result1"){
						$("#id_message").html("<br>���̵� �Է����ּ���.");
						document.joinfrm.id.value = "";
					}else if(data.trim() == "result4"){
						$("#id_message").html("<br>���̵�� 5~20���� ����� ���ڸ� ����Ͻ� �� �ֽ��ϴ�.");
					}else if(data.trim() == "result2"){
						$("#id_message").html("<br>�̹� ������� ���̵� �Դϴ�.");
					}else{
						$("#id_message").html("<br>���� ���̵�׿� *^��^*");
					}
				}
			});	
		}
	
		/* Password_check */
		function Password_check(){
			 var pw 	= $("#pw1").val().trim();
			 
			  
			 var pattern1 = /[0-9]/;
	
	         var pattern2 = /[a-zA-Z]/;
	
	         var pattern3 = /[~!@\#$%<>^&*]/; 
			 
			 
			if(!pw){
				 
				 $("#pw1").val("");	//��й�ȣ �ʱⰪ���� �ʱ�ȭ
				 $("#password_message").html("<br>��й�ȣ�� �Է����ּ���.");
				 return false;
			 
			 }else if(pw.length < 8 || pw.length > 20){
				 $("#password_message").html("<br>��й�ȣ�� 8�ڸ� �̻� 20�ڸ� �����Դϴ�.");
				 $("#pw1").val("");
				 $("#pw1").focus();
				 return false;
			 
			 }else if(pw.search(/\s/) != -1){
				  alert("��й�ȣ�� ���� ���� �Է����ּ���.");
				  return false;
				  
			}else if(!pattern1.test(pw)||!pattern2.test(pw)||!pattern3.test(pw)){
				 
				 $("#password_message").html("<br>��й�ȣ�� ����, ����, Ư������ 1������ �����Ͽ��� �մϴ�.");
				 $("#pw1").val("");
				 $("#pw1").focus();
				 return false;
				 
			 }else{
				 
				 $("#password_message").html(" ");
				 return true;
			 }
		}
		
		/* Password_check2 */	 
		function Password_check2(){
			 var pw 	= $("#pw1").val().trim();
			 var pw2 	= $("#pw2").val().trim();
			 
			 if(!(pw==pw2)){
				 
				 $("#pw2").val("");	//��й�ȣ �ʱⰪ���� �ʱ�ȭ
				 $("#password_message2").html("<br>��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
				 return false;
				 
			}else{
				
				 $("#password_message2").html(" ");
				 return true;
			}
		}
		
		function PostOpen(){
				new daum.Postcode({
				    oncomplete: function(data) {
				        //data�� ����ڰ� ������ �ּ� ������ ��� �ִ� ��ü
				    	$("#postnum").val(data.zonecode);
						$("#addr1").val(data.address);
				    }
				}).open();
				
		}
		
		
		
		function Submit(){
			
			var numCheck1 = $('#num2').val();
			var numCheck2 = $('#num3').val();
			var postCheck = $('#postnum').val();
			var emailCheck = $("#email1").val();
			
			if($("#id").val()==""){
				alert("���̵�� �ʼ� �׸��Դϴ�.");
			}else if($("#pw1").val()==""){
				alert("��й�ȣ�� �ʼ� �׸��Դϴ�.");
			}else if($("#pw2").val()==""){
				alert("��й�ȣ Ȯ���� �ʼ� �׸��Դϴ�.");
			}else if($("#name").val()==""){
				alert("�̸��� �ʼ� �׸��Դϴ�.");
			}else if($("#email1").val()==""){
				alert("�̸����� �ʼ� �׸��Դϴ�.");
			}else if(emailCheck.trim()==""){
				alert("���� ���������䤻�� �ʼ� �׸��Դϴ�.");
			}else if($("#num2").val()=="" && $("#num3").val()==""){
				alert("����ó�� �ʼ� �׸� �Դϴ�.");
			}else if(isNaN(numCheck1)){ //isNaN() true==���� �ƴϴ�. false== ���ڴ�.
				alert("�ùٸ� ������ ��ȭ��ȣ�� �Է����ּ���");
			}else if(isNaN(numCheck2)){
				alert("�ùٸ� ������ ��ȭ��ȣ�� �Է����ּ���");
			}else if($("#num2").val()=="" || $("#num3").val()==""){
				alert("�ùٸ� ������ ��ȭ��ȣ�� �Է����ּ���");
			}else if(postCheck!=""&&isNaN(postCheck)){
				alert("�����ȣ�� ���ڸ� �� �� �ֽ��ϴ�.");
			}else{
				document.joinfrm.submit();
			}
	
		}