var getData  ="";
	
	function checkedSaveFn() {

		var TypeSaveSelect = $("#TypeSaveSelect").val();

		for(var i=0; i<getData.length ; i++) {
			if($("#checked_"+getData[i].no).prop("checked")){ 
				$.ajax({
					url: "/mwish/ajax/checkedSave",
					type: "post",
					data: 
					{
						applyNo : getData[i].no , //체크된 번호
						applyType : $("#TypeSaveSelect").val() //설정한 속성값
					},
					success: function(data){
						searchFn();
					}				 
				}) 
			}
		}		
	}
	
	
	//처음 데이터 표 가져올 때
	function searchFn() {
		
//		var selectType  = document.getElementById("selectType").value;
//		var startDate   = document.getElementById("startDate").value;
//		var endDate     = document.getElementById("endDate").value;
		$.ajax({
			url: "/mwish/ajax/searchOk",
			type: "post",
			data: {
				selectType : $("#selectType").val(),
				startDate : $("#startDate").val(),
				endDate : $("#endDate").val()
			},
			error: function(){
				var str = "<h2><font color='orange'>신청중</font></h2>";
				$("#result").html(str);
			}
			,
			success: function(data) {
				var str = "";
//				getData = JSON.parse(data);

				for(var i=0; i<data.length; i++){
					if(data[i].applyOkDate == null){ data[i].applyOkDate = ""; }
					str += "<tr id='tr_"+data[i].applyNo+"' onclick='viewFn("+data[i].applyNo+")'>";
					str += "<td  width='50px' align='center'>"+data[i].applyNo+"</td>";
					str += "<td width='150px' align='center'>"+data[i].userID+"</td>";
					str += "<td width='250px' align='center'>"+data[i].applyISBN+"</td>";
					str += "<td width='700px'><a href='javascript:viewFn("+data[i].applyNo+")'>"+data[i].applySubject+"</a></td>";
					str += "<td width='200px' align='center'>"+data[i].applyDate+"</td>";
					str += "<td width='200px' align='center'>"+data[i].applyOkDate+"</td>";
					if(data[i].atype == "0"){
						str += "<td width='100px' align='center'><font color='blue'>신청중</font></td>";
					}else if(data[i].applyType == "1") {
						str += "<td width='100px' align='center'><font color='orange'>처리중</font></td>";
					}else if(data[i].applyType == "2") {
						str += "<td width='100px' align='center'><font color='gray'>취소됨</font></td>";
					}else if(data[i].applyType == "3") {
						str += "<td width='100px' align='center'>소장중</td>";
					}
					str += "<td width='50px' align='center'><input type='checkbox' name='check' id='checked_"+data[i].applyNo+"' value='1'></td>";
					str += "</tr>";
				}
				$("#result").html(str);
			}
		})
	}
	
	

	$(function(){
		$("#checkAll").click(function(){ 
			if($("#checkAll").prop("checked")) {  
				$("input[type='checkbox']").prop("checked",true); 

			}else {
				$("input[type='checkbox']").prop("checked",false);
			}
		})
	})

	
	
	function viewFn(no) {
		$.ajax({
			url: "/mwish/ajax/detailOk",
			type: "post",
			data: {
				applyNo : no,
			},
			error:function(){
				var str = "오류가 발생했습니다.";
			},
			success: function(data) {
//				var applyInfo = JSON.parse(data);
				var str = "";
				var type = "";
				if(data.applyType == "1"){ type="<font color='orange'>처리중</font>";}
				if(data.applyType == "2"){ type="<font color='gray'>취소됨</font>";}
				if(data.applyType == "3"){ type="소장중";}
				if(data.applyType == "0"){ type="<font color='blue'>신청중</font>";}
				
				str += "<table border='1' width='1300' height='300' class='viewTable'>";
				str += "	<tr height='30'>";
				str += "		<th width='100'>번호</th>";
				str += "		<td width='100'>"+ data.applyNo +"</td>";
				str += "		<th width='100'>ISBN</th>";
				str += "		<td width='150' >";
				str += "			<span id='isbnValue'>"+ data.applyISBN +"</span>";
				str += "			<a href='javascript:copyToClipboard("+ data.applyISBN +")'>복사</a>";
				str += "		</td>";
				str += "		<th width='100'>제목</th>";
				str += "		<td colspan='5'>"+ data.applySubject +"</td>";
				str += "	</tr>";
				str += "	<tr height='30'>";
				str += "		<th width='100'>작가명</th>";
				str += "		<td>"+ data.applyWriter +"</td>";
				str += "		<th width='100'>출판사</th>";
				str += "		<td>"+ data.applyCompany +"</td>";
				str += "		<th width='100'>출판일</th>";
				str += "		<td>"+ data.applyPublicationDate +"</td>";
				str += "		<th width='100'>처리상태</th>";
				str += "		<td>"+ type +"</td>";
			    str += "	</tr>";
				str += "	<tr>";
				str += "		<td colspan='8'>"+ data.applyWhy +"</td>";
				str += "	</tr>";
				str += "</table>";
				
				$("#userInfoView").html(str);
			}
		})
	}
	
	
	function copyToClipboard(val) {
			
		  var t = document.createElement("textarea");
		  document.body.appendChild(t);
		  t.value = val;
		  t.select();
		  document.execCommand('copy');
		  document.body.removeChild(t);
		  alert("복사완료!");
	}
	
				