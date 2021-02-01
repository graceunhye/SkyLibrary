
var getData = "";

function userRemoveFn(){
	if(confirm("정말 삭제하시겠습니까?") == true){
		var checkIDs = $("input[name=checkDel]:checked"); //배열
		checkIDs.each(function(){ //forEach
			$.ajax({
				url: "/muser/ajax/userRemoveOk",
				type: "get",
				data: "userID="+$(this).val(),
				error:function(){
					alert("회원 삭제 과정 중 에러가 발생했습니다.");
				},
				success:function(data){

				}
			})	
		});
		alert("강제탈퇴처리 되었습니다");
		userSearchFn();
	}
	else{
	    return ;
	}
}

//검색
function userSearchFn() {

	$.ajax({
		url: "/muser/ajax/searchOk",
		type: "GET",
		data: {
			searchType : $("select[name='searchType']").val(),
			searchText : $("input[name='searchText']").val(),
			selectType : $("select[name='selectType']").val(),
			endDate : $("input[name='endDate']").val(),
			startDate : $("input[name='startDate']").val() 
		},error: function(){
			alert("search function error");
		},success: function(data){
			var str = "";
			var type = "";
			var rentType = "";
			getData = data;
			for(var i=0; i<data.length; i++){
				
				str += "<tr class='resultTable' data-u='"+data[i].userID+"' onclick='userInfoViewFn(this)'>";
				str += "	<td>"+(i+1)+"</td>";
				if(data[i].userType==0){ type="일반"}
				if(data[i].userType==1){ type="<font color='gray'>탈퇴</font>"}
				if(data[i].userType==2){ type="<font color='red'>강제탈퇴</font>" }
				str += "	<td>"+type+"</td>";
				str += "	<td>"+data[i].userID+"</td>";
				str += "	<td>"+data[i].userName+"</td>";
				str += "	<td>"+data[i].userNum+"</td>";
				str += "	<td>"+data[i].userEmail+"</td>";
				str += "	<td>"+data[i].rentCount+"</td>";
				if(data[i].lateRentCount == 0){ rentType="<font color='green'>정상</font>" }
				if(data[i].lateRentCount != 0){ rentType="<font color='red'>연체중</font>"}
				if(data[i].userType==2 || data[i].userType==1){ rentType="<font>해당없음</font>"}
				str += "	<td>"+rentType+"</td>";
				str += "	<td><input type='checkbox' name='checkDel' value='"+data[i].userID+"'></td>";
				str += "</tr>";			
			}
			$("#result").html(str);

		}
		
	})
}


function userInfoViewFn(node) {
	
	var userID = $(node).data("u");
	
	$.ajax({
		url: "/muser/ajax/userRentInfo",
		type: "GET",
		data: {userID:$(node).data("u")},
		error:function(){
			alert("userInfoView function error");
		},success:function(data){
			var str = "";
			var addr = "";
			
			str += "<table border='1' class='viewTable'>";
			str += "<thead>";
			str += "<tr class='viewFixTable'>";
			str += "<td>번호</td>";
			str += "<td>ISBN</td>";
			str += "<td>책제목</td>";
			str += "<td>저자</td>";
			str += "<td>출판사</td>";
			str += "<td>대출일</td>";
			str += "<td>반납예정일</td>";
			str += "<td>연체일</td>";
			str += "</tr>";
			str += "</thead>";
			str += "<tbody>";
			for(var i=0; i<10; i++)
			{	
				if(data[i] != null)
				{
					str += "<tr>";
					str += "<td>"+(i+1)+"</td>";
					str += "<td>"+data[i].bookISBN+"</td>";
					str += "<td>"+data[i].bookSubject+"</td>";
					str += "<td>"+data[i].bookWriter+"</td>";
					str += "<td>"+data[i].bookCompany+"</td>";
					str += "<td>"+data[i].rentStartDate+"</td>";
					str += "<td>"+data[i].rentEndDate+"</td>";
					if(data[i].lateTime > 0){
					str += "<td></td>";	
					}else {
						str += "<td><font color='red'>"+data[i].lateTime+"</font></td>";	
					}
					str += "</tr>";
				}
			
				if(data[i] == null)
				{
					str += "<tr>";
					str += "<td>"+(i+1)+"</td>";
					str += "<td></td>";
					str += "<td></td>";
					str += "<td></td>";
					str += "<td></td>";
					str += "<td></td>";
					str += "<td></td>";
					str += "<td></td>";	
					str += "</tr>";
					
				}
			}
			str += "</tbody>";
			str += "</table>";
			
			console.log(data);
			$("#rentInfoResultTable").html(str);
		}
	})
}

function userWishInfoFn(userID) {
	
	$.ajax({
		url: "/muser/ajax/userWishInfoOk",
		type: "GET",
		data: userID=userID,
		error:function(){
			alert("userWishInfoOk function error");
		},success:function(){
			
			str = "";
			$("#userInfo").html(str);
		}
	})
}

function userRentInfoFn(userID) {
	
	$.ajax({
		url: "/muser/ajax/userRentInfoOk",
		type: "GET",
		data: userID=userID,
		error:function(){
			alert("userRentInfoOk function error");
		},success:function(){
			
			str = "";
			$("#userInfo").html(str);
		}
	})
}
