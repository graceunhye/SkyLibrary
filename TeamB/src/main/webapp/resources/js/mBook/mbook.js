function searchFn(query, type){
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
				alert("대출 중인 도서입니다.");
			}
		}
	});
}
