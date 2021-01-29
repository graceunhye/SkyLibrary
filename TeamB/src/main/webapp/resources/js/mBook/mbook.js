function searchFn(query, type){
	//alert("query::"+query);
	//alert("type::"+type);
	$.ajax({
		url: "/mbook/ajax/searchOk",
		type: "POST",
		data: {
			searchType: type,
			searchText: query
		},error:function(){
			alert("검색 오류입니다. 다시 시도해주세요.");
		},success:function(data){
			var str = "";
			
			for(var i=0; i<data.length; i++) {
				
				str += "<tr class='resultTable' onclick='detailViewFn("+data[i].bookISBN+")'>";
				str += "	<td>"+(i+1)+"</td>";
				str += "	<td>"+data[i].bookISBN+"</td>";
				str += "	<td>"+data[i].bookSubject+"</td>";
				str += "	<td>"+data[i].bookWriter+"</td>";
				str += "	<td>"+data[i].bookCompany+"</td>";
				str += "	<td>"+data[i].bookPublicationDate+"</td>";
				str += "	<td><input type='button' value='삭제' onclick='deleteFn("+data[i].bookISBN+",0)' class='deleteBtn'></td>";
				str += "</tr>";	
				
			}
			
			//alert(data.length+"건이 검색되었습니다.");
			$("#result").html(str);
		}
	});
};


function searchOutSideFn(query, target){
	
	var searchParams = {
			'query': query,
			'target': target,
			'size' : 50 
		}
	
	$.ajax({
		url: "https://dapi.kakao.com/v3/search/book",
		type: "GET",
		headers: {"Authorization" : "KakaoAK ce878c29352ce1d287030399519a30e2"},
		async: false,
		data: searchParams,
		dataType: "json",
		error:function(){
			alert("검색 오류입니다. 다시 시도해주세요.");
		},success:function(kakao){
			
			$.ajax({ // DB에 있는 전체 도서 리스트
				url: "/mbook/ajax/searchOk",
				type: "POST",
				data: {
				},error:function(){
					alert("검색 오류입니다. 다시 시도해주세요.");
				},success:function(data){
					
					var str = "";

					$.each(kakao.documents, function(i, search) {
						var isbnArr = (search.isbn).split(' ');
						
						str += "<tr class='resultTable' onclick='detailViewFn("+isbnArr[1]+")'>";
						str += "	<td>"+(i+1)+"</td>";
						
						str += "	<td>"+isbnArr[1]+"</td>";
						str += "	<td>"+search.title+"</td>";
						str += "	<td>"+search.authors+"</td>";
						str += "	<td>"+search.publisher+"</td>";
						
						var dateArr = (search.datetime).split("T");
						str += "	<td>"+dateArr[0]+"</td>";
						
						var bigo = "";
						for(var j=0; j<data.length; j++) {
							if(data[j].bookISBN == isbnArr[1]){
								 bigo = "<td><input type='button' value='삭제' onclick='deleteFn("+isbnArr[1]+",1)' class='deleteBtn'></td>";
								 //console.log(data[j].bookISBN+":"+isbnArr[1]);
								 break;
							}else {
								bigo = "<td><input type='button' value='등록' onclick='addFn("+isbnArr[1]+")' class='insertBtn'></td>";
							}
						}
						str += bigo;
						str += "</tr>";	
						str += "<input type='hidden' id='bookSubject_"+isbnArr[1]+"' value='"+search.title+"'>";
						str += "<input type='hidden' id='bookWriter_"+isbnArr[1]+"' value='"+search.authors+"'>";
						str += "<input type='hidden' id='bookCompany_"+isbnArr[1]+"' value='"+search.publisher+"'>";
						str += "<input type='hidden' id='bookPublicationDate_"+isbnArr[1]+"' value='"+dateArr[0]+"'>";
						str += "<input type='hidden' id='bookCoverImg_"+isbnArr[1]+"' value='"+search.thumbnail+"'>";
						str += "<input type='hidden' id='bookStory_"+isbnArr[1]+"' value='"+search.contents+"'>";
						
					});
					$("#result").html(str);
				}
			});
		}
	});
};

function detailViewFn(isbn){
	var searchParams = {
			'query': isbn,
			'target': 'isbn'
	}
	
	$.ajax({
		url: "https://dapi.kakao.com/v3/search/book",
		type: "GET",
		headers: {"Authorization" : "KakaoAK ce878c29352ce1d287030399519a30e2"},
		async: false,
		data: searchParams,
		dataType: "json",
		error:function(){
			alert("검색 오류입니다. 다시 시도해주세요.");
		},success:function(kakao){
			//console.log(kakao);
			var str = "";
			var isbnArr = (kakao.documents[0].isbn).split(" ");
			var dateArr = (kakao.documents[0].datetime).split("T");
			
			
			str += "<table class='viewTable' border='1'>";
			str += "<tr>";
			str += "	<td rowspan='4'><img src='"+kakao.documents[0].thumbnail+"' alt='"+kakao.documents[0].title+"'></td>";
			str += "	<td>제목</td>";
			str += "	<td colspan='3'>"+kakao.documents[0].title+"</td>";
			str += "</tr>";
			str += "<tr>";
			str += "	<td>작가명</td>";
			str += "	<td>"+kakao.documents[0].authors+"</td>";
			str += "	<td>출판사</td>";
			str += "	<td>"+kakao.documents[0].publisher+"</td>";
			str += "</tr>";
			str += "<tr>";
			str += "	<td rowspan='2'>발행일</td>";
			str += "	<td rowspan='2'>"+dateArr[0]+"</td>";
			str += "	<td rowspan='2'>ISBN</td>";
			str += "	<td rowspan='2'>"+isbnArr[1]+"</td>";
			str += "</tr>";
			str += "<tr></tr>";
			str += "<tr>";
			var contents = kakao.documents[0].contents + "...";
			if(contents == '' || contents == null){
				contents = "줄거리가 없습니다.";
			}
			str += "	<td colspan='5'>"+contents+"</td>";
			str += "</tr>";
			str += "</table>";
			
			
			$("#viewArea").html(str);
		}
		});
}

function addFn(isbn) {
	
	var bookData = {
			bookISBN:isbn,
			bookSubject:$("#bookSubject_"+isbn).val(),
			bookCompany:$("#bookCompany_"+isbn).val(),
			bookStory:$("#bookStory_"+isbn).val(),
			bookPublicationDate:$("#bookPublicationDate_"+isbn).val(),
			bookCoverImg:$("#bookCoverImg_"+isbn).val(),
			bookWriter:$("#bookWriter_"+isbn).val()
	}
	
	//console.log(bookData);

	$.ajax({
		url: "/mbook/ajax/bookAddOk",
		type: "POST",
		data: bookData,
		error: function(){
			alert("등록에 실패하였습니다. 다시 시도해주세요.");
		},success:function(result){
			if(result == "true"){
				alert("등록되었습니다.");	
				searchOutSideFn($("#searchText_outside").val(),$("#searchType_outside").val());
			}else {
				alert("이미 등록된 도서입니다.");
			}
		}
	});

};


function deleteFn(isbn,where) {
	$.ajax({
		url: "/mbook/ajax/bookDeleteOk",
		type: "POST",
		data: "bookISBN="+isbn,
		error: function(){
			alert("데이터 연결에 실패하였습니다. 다시 시도해주세요.");
		},success:function(result){
			if(result=="true"){
				alert("삭제되었습니다.");
				switch(where){
				case 0: //내부자료조회
					searchFn($("input[name='searchText']").val(),
							$("select[name='searchType']").val());
					break;
				case 1: //외부자료조회
					searchOutSideFn($("#searchText_outside").val(),
							$("#searchType_outside").val());
					break;
				}
			}else {
				alert("삭제에 실패했습니다. 다시 시도해주세요.");
			}
		}
	});
}
/*
function addBookFn(){
	var str = "";
	str += "<form method='POST' enctype='multipart/form-data' action=''>";
	str += "<table class='viewTable' border='1'>";
	str += "<tr>";
	str += "	<td rowspan='3'><span id='image_container'></span></td>";
	str += "	<td>제목</td>";
	str += "	<td colspan='3'>";
	str += "		<input type='text' placholder='도서명' name='bookSubject' placeholder='도서명' size='120'>";
	str += "	</td>";
	str += "</tr>";
	str += "<tr>";
	str += "	<td>작가명</td>";
	str += "	<td><input type='text' placeholder='작가명' name='bookWriter'></td>";
	str += "	<td>출판사</td>";
	str += "	<td><input type='text' placeholder='출판일' name='bookCompany'></td>";
	str += "</tr>";
	str += "<tr>";
	str += "	<td rowspan='2'>발행일</td>";
	str += "	<td rowspan='2'><input type='text' placeholder='yyyy-MM-dd' name='bookPublicationDate'></td>";
	str += "	<td rowspan='2'>ISBN</td>";
	str += "	<td rowspan='2'><input type='text' placeholder='ISBN' name='bookISBN'></td>";
	str += "</tr>";
	str += "<tr>";
	str += "	<td>";
	str += "		<input type='file' accept='image/*' name='' onchange='setThumbnail(event)'>";
	str += "	</td>";
	str += "</tr>";
	str += "<tr>";
	str += "	<td colspan='5'>";
	str += "		<textarea cols='185' rows='8' placeholder='줄거리'></textarea>";
	str += "	</td>";
	str += "</tr>";
	str += "<tr>";
	str += "	<td colspan='5'>";
	str += "		<input type='button' value='등록'>";
	str += "	</td>";
	str += "</tr>";
	str += "</table>";
	str += "</form>";
	
	$("#viewArea").html(str);
}

function setThumbnail(event){
	var reader = new FileReader(); //파일 읽어주는 객체
	
	reader.onload = function(event) {
		var img = document.createElement("img");
		img.setAttribute("src", event.target.result);
		img.setAttribute("width", "130");
		document.querySelector("span#image_container").appendChild(img);
		imgSet = true;
	};
	
	reader.readAsDataURL(event.target.files[0]);
}

function testAPI(){
	var client_id = "aMyBgmxx8CpcNAM_n6m7";
	var client_secret = "YTxq9Am9iW";
	
	$.ajax({
		url: "https://openapi.naver.com/v1/search/book.json",
		type: "GET",
		headers: {
			"X-Naver-Client-Id": client_id,
			"X-Naver-Client-Secret": client_secret},
		data: {
			query: $("#searchText").val()
		},error:function(){
			alert("API호출 오류입니다. 다시 시도해주세요.")
		},success:function(data){
			var apiData = data;
			var searchDate;
			
			$.ajax({
				url: "/mbook/ajax/searchOk",
				type: "POST",
				data: {
					searchText:$("#searchText").val()
				},error: function(){
					
				},success: function(data){
					searchDate = data;
				}
			})
			
			
			for(var i=0; i<apiData.length; i++){
				
				str += "<tr class='resultTable' id='info_"+i+"'>";
				str += "	<td>"+(i+1)+"</td>";
				str += "	<td>"+apiData[i].isbn+"</td>";
				str += "	<td>"+apiData[i].title+"</td>";
				str += "	<td>"+apiData[i].author+"</td>";
				str += "	<td>"+apiData[i].publisher+"</td>";
				str += "	<td>"+apiData[i].pubdate+"</td>";
				for(var j=0; j<searchData; j++){
					if(apiData[i].isbn == searchData[j].bookISBN){
						str += "	<td>O</td>";
					}else{
						str += "	<td></td>";
					}
				}
				str += "</tr>";	
					
			}
			$("#result").html(str);
		}
	})
}*/