var getData  ="";
	
	function checkedSaveFn() {
		for(var i=0; i<getData.length ; i++) {
			if($("#checked_"+getData[i].applyNo).prop("checked")){ 
				$.ajax({
					url: "/mwish/ajax/checkedSave",
					type: "get",
					data: 
					{
						applyNo : getData[i].applyNo ,
						applyType : $("input[name='selectType']").val()
					},
					success: function(data){
						
						var str = "";
						var type = "";
						var color = "";
						
						for(var i=0; i<data.length; i++){
							
							if(data[i].applyOkDate == null){ data[i].applyOkDate = ""; }
							
							str += "<tr class='resultTable' onclick='viewFn("+data[i].applyNo+")'>";
							str += "	<td>"+data[i].applyNo+"</td>";
							str += "    <td>"+data[i].userID+"</td>";
							str += "    <td>"+data[i].applyISBN+"</td>";
							str += "    <td>"+data[i].applySubject+"</td>";
							str += "    <td>"+data[i].applyDate+"</td>";
							str += "    <td>"+data[i].applyOkDate+"</td>";
							
							if(data[i].applyType == "0"){ type="신청중"; color="blue"; }
							if(data[i].applyType == "1"){ type="처리중"; color="orange";}
							if(data[i].applyType == "2"){ type="취소됨"; color="gray";}
							if(data[i].applyType == "3"){ type="소장중"; color="green";}
							
							str += "    <td><font color='"+color+"'>"+type+"</font></td>";
							str += "    <td>";
							str += "		<input type='checkbox' id='checked_"+data[i].applyNo+"'>";
							str += "	</td>";
							str += "</tr>";
						}
						$("#result").html(str);
					}				 
				})
			}
		}
		alert("적용이 되었습니다.");
	}
	
	
	//처음 데이터 표 가져올 때
	function searchFn() {
	
		$.ajax({
			url: "/mwish/ajax/searchOk",
			type: "post",
			data: {
				selectType : $("input[name='selectType']").val(),
				startDate : $("input[name='startDate']").val(),
				endDate : $("input[name='endDate']").val()
			},
			error: function(){
				alert("search function error");
			}
			,
			success: function(data) {
				var str = "";
				var type = "";
				var color = "";
				getData = data;
				for(var i=0; i<data.length; i++){
					
					if(data[i].applyOkDate == null){ data[i].applyOkDate = ""; }
					
					str += "<tr class='resultTable' onclick='viewFn("+data[i].applyNo+")'>";
					str += "	<td>"+(data.length-i)+"</td>";
					str += "    <td>"+data[i].userID+"</td>";
					str += "    <td>"+data[i].applyISBN+"</td>";
					str += "    <td>"+data[i].applySubject+"</td>";
					str += "    <td>"+data[i].applyDate+"</td>";
					str += "    <td>"+data[i].applyOkDate+"</td>";
					
					if(data[i].applyType == "0"){ type="신청중"; color="blue"; }
					if(data[i].applyType == "1"){ type="처리중"; color="orange";}
					if(data[i].applyType == "2"){ type="취소됨"; color="gray";}
					if(data[i].applyType == "3"){ type="소장중"; color="green";}
					
					str += "    <td><font color='"+color+"'>"+type+"</font></td>";
					str += "    <td>";
					str += "		<input type='checkbox' id='checked_"+data[i].applyNo+"'>";
					str += "	</td>";
					str += "</tr>";
				}
				$("#result").html(str);
				alert("총 "+data.length+"건이 조회 되었습니다.");
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
				alert("view function error");
			},
			success: function(data) {
				var str = "";
				var color = "";
				var type = "";
				if(data.applyType == "0"){ type="신청중"; color="blue"; }
				if(data.applyType == "1"){ type="처리중"; color="orange";}
				if(data.applyType == "2"){ type="취소됨"; color="gray";}
				if(data.applyType == "3"){ type="소장중"; color="green";}
				
				
				str += "<table border='1' class='viewTable'>";
				str += "	<tr>";
				str += "		<td>번호</td>";
				str += "		<td>"+data.applyNo+"</td>";
				str += "		<td>ISBN</td>";
				str += "		<td>";
				str += "			<span id='isbnValue'>"+data.applyISBN+"</span>";
				str += "			<a href='javascript:copyToClipboard("+data.applyISBN+")'>복사</a>";
				str += "		</td>";
				str += "		<td>제목</td>";
				str += "		<td colspan='3'>"+data.applySubject+"</td>";
				str += "	</tr>";
				str += "	<tr>";
				str += "		<td>작가명</td>";
				str += "		<td>"+data.applyWriter+"</td>";
				str += "		<td>출판사</td>";
				str += "		<td>"+data.applyCompany+"</td>";
				str += "		<td>출판일</th>";
				str += "		<td>"+data.applyPublicationDate+"</td>";
				str += "		<td>처리상태</td>";
				str += "		<td><font color='"+color+"'>"+type+"</font></td>";
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
	
				