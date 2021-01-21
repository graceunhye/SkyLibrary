function userModify() {
	alert("in modify!");
	
	$("#userName").html("<input type='text' name='userName' value='"+$("#userName").text()+"'>");
	alert("userNum::"+$("#userNum").text());
	var str;
    var array = ($("#userNum").text().trim()).split("-");
	str = "<input type='text' name='userNumSplit1' value='"+array[0]+"' maxlength='3' size='3'>-";
	str += "<input type='text' name='userNumSplit2' value='"+array[1]+"' maxlength='4' size='3'>-";
	str += "<input type='text' name='userNumSplit3' value='"+array[2]+"' maxlength='4' size='3'>";
	
	$("#userNum").html(str);
	
	var str2;
	str2 = "<input type='text' name='userPostNum' size='7' value='"+$()+"'>&nbsp";
	str2 += "<input type='button' value='우편번호 찾기' onclick='PostOpen()'><br>";
	str2 += "<input type='text' name='userAddr' size='50'><br>";
	str2 += "<input type='text' name=''userAddrDetail' size='50'>";
	alert("str2::"+str2);
	$("#userPostNum").html(str2);
	
	
	var str3;
	alert($("#userEmail").text());
	var array2 = ($("#userEmail").text().trim()).split("@");
	alert("array2[0]::"+array2[0]);
	alert("array2[1]::"+array2[1]);
	str3 = "<input type='text' name='userEmail' value='"+array2[0]+"'> @";
	str3 += "<input type='text' name='userEmailDomain' value='"+array2[1]+"'>";
	
	$("#userEmail").html(str3);

//	var opt = $("select[name='userEmailDomain'] option");
//	for(var i=0; i<opt.length; i++){
//		if(opt[i].val() == FumllEmail[1]) {
//			$("select option:eq("+i+")").attr("selected","selected");
//			break;
//		}
//	}
	
	
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