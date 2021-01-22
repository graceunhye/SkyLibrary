function returnFn(node, id, isbn){
			if(confirm("반납하시겠습니까?")){
				$.ajax({
					url  : "/myPage/bookReturnAjax",
					type : "post",
					data : "isbn="+isbn+"&id="+id,
					success : function(data){
						$(node).parent().parent().remove();
					}	
				});			
			}
		}
		
		function extensionFn(node, isbn){
			if(confirm("연장하시겠습니까?")){
				$.ajax({
					url : "/myPage/bookExtensionAjax",
					type : "post",
					data : "isbn="+isbn,
					success : function(data){
						var str1 = data.rentEndDate
						var str2 = "<input type='button' class='normalBtn' value='연장불가' disabled>";
						
						$(node).parent().prev().prev(".endd_td").html(str1);
						$(node).parent().html(str2);
					}
				});
			}
		} 