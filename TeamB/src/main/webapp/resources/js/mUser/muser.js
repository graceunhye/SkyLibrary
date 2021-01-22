
var getData = "";

$(document).ready(function(){
		
	$("#userRemove").click(function(){
		
		if(confirm("정말 삭제하시겠습니까?") == true){
			//삭제
			for(var i=0; i<getData.length; i++){
				if($("#checked_"+getData[i].userID).prop("checked")){
					var userID = getData[i].userID;
					$.ajax({
						url: "/muser/ajax/userRemoveOk",
						type: "get",
						data: {userID:userID},
						error:function(){
							alert("회원 삭제 과정 중 에러가 발생했습니다.");
						},
						success:function(){
							alert("강제탈퇴처리 되었습니다");
							userSearchFn();
						}
					})	
				}
			}
	    }
	    else{
	        return ;
	    }

	});
	
	
})

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
			getData = data;
			for(var i=0; i<data.length; i++){
				
				str += "<tr class='resultTable'>";
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
				str += "	<td><input type='checkbox' id='checked_"+data.userID+"'></td>";
				str += "</tr>";			
			}
			alert("총 "+data.length+"건이 검색 되었습니다.");
			$("#result").html(str);
		}
		
	})
}


function userInfoViewFn(userID) {
	
	$.ajax({
		url: "/muser/ajax/userInfoOk",
		type: "GET",
		data: userID=userID,
		error:function(){
			alert("userInfoView function error");
		},success:function(){
			
			str = "";
			$("#userInfo").html(str);
			userWishInfoFn(userID);
			userRentInfoFn(userID);
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
