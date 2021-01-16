
 	//ȸ�� �α���
 	function login(){
 		
 		if($("input:text").val() == ""){
			alert("���̵� �Է��ϼ���.");
			$("input:text").focus();
			return false;
		}else if($("input:password").val() == ""){
			alert("��й�ȣ�� �Է��ϼ���.");
			$("input:password").focus();
			return false;
		}else{
			document.login_frm.submit();
		}
 		
 	}
 	
 	//�缭 �α���
 	function login2(){
 		
 		if($("input:text").val() == ""){
			alert("���̵� �Է��ϼ���.");
			$("input:text").focus();
			return false;
		}else if($("input:password").val() == ""){
			alert("��й�ȣ�� �Է��ϼ���.");
			$("input:password").focus();
			return false;
		}else{
			document.login_frm2.submit();
		}
 		
 	}
 
 	
 	//�缭 �α��� ȭ������ ��ȯ
	var m_LoginStr ='<h2 class="login_title">�缭 �α���</h2>                                                                                         '
		+'<div class="login_input_box">                                                                                                               '
		+'	<form action="../../Manager/mloginout/loginProc.jsp" method="post" name="login_frm2">                                                      '
		+'		<table>                                                                                                                               '
		+'			<tr height="50" class="login_txt">                                                                                                '
		+'				<td width="100" align="right" class="login_input"><span class="point id">*</span><span class="id_title">���̵�</span>:</td>     '
		+'				<td width="300"><input type="text" class="input" name="id" size="38" placeholder=" ���̵� �Է����ּ���."></td>                    '
		+'			</tr>                                                                                                                             '
		+'			<tr height="50" class="login_txt">                                                                                                '
		+'				<td align="right" class="login_input"><span class="point">*</span>��й�ȣ:</td>                                                '
		+'				<td><input type="password" name="pw"  class="input" size="38" placeholder=" ��й�ȣ�� �Է����ּ���."></td>                         '
		+'			</tr>                                                                                                                             '
		+'			<tr class="login_option">                                                                                                         '
		+'				<td colspan="2" align="center">                                                                                               '
		+'					<a href="#">���̵�/��й�ȣã��</a>                                                                                       	  '
		+'					<font color="#2C78D7">&nbsp;|&nbsp;</font>                                                                                '
		+'					<a href="/join">ȸ������</a>                                                                                      '
		+'					<font color="#2C78D7">&nbsp;|&nbsp;</font>                                                                                '
		+'					<a href="javascript:u_login()">ȸ�� �α���</a>                                                                               '
		+'				</td>                                                                                                                         '
		+'			</tr>                                                                                                                             '
		+'			<tr height="70">                                                                                                                  '
		+'				<td colspan="2" align="center">                                                                                               '
		+'					<button type="button" class="login_btn" onclick="login2()" >�α���</button>                                                '
		+'				</td>                                                                                                                         '
		+'			</tr>                                                                                                                             '
		+'		</table>                                                                                                                              '
		+'	</form>                                                                                                                                   '
		+'</div>                                                                                                                                      '
		
		function m_login(){
			$(".login_box").html(m_LoginStr);
		}
		
		
		//ȸ�� �α��� ȭ������ ��ȯ
		var u_LoginStr ='<h2 class="login_title">�α���</h2>                                                                                         '
			+'<div class="login_input_box">                                                                                                               '
			+'	<form action="loginProc.jsp" method="post" name="login_frm">                                                      '
			+'		<table>                                                                                                                               '
			+'			<tr height="50" class="login_txt">                                                                                                '
			+'				<td width="100" align="right" class="login_input"><span class="point id">*</span><span class="id_title">���̵�</span>:</td>     '
			+'				<td width="300"><input type="text" class="input" name="id" size="38" placeholder=" ���̵� �Է����ּ���."></td>                    '
			+'			</tr>                                                                                                                             '
			+'			<tr height="50" class="login_txt">                                                                                                '
			+'				<td align="right" class="login_input"><span class="point">*</span>��й�ȣ:</td>                                                '
			+'				<td><input type="password" name="pw"  class="input" size="38" placeholder=" ��й�ȣ�� �Է����ּ���."></td>                         '
			+'			</tr>                                                                                                                             '
			+'			<tr class="login_option">                                                                                                         '
			+'				<td colspan="2" align="center">                                                                                               '
			+'					<a href="#">���̵�/��й�ȣã��</a>                                                                                       	  '
			+'					<font color="#2C78D7">&nbsp;|&nbsp;</font>                                                                                '
			+'					<a href="../join/join.jsp">ȸ������</a>                                                                                      '
			+'					<font color="#2C78D7">&nbsp;|&nbsp;</font>                                                                                '
			+'					<a href="javascript:m_login()">�缭 �α���</a>                                                                                       '
			+'				</td>                                                                                                                         '
			+'			</tr>                                                                                                                             '
			+'			<tr height="70">                                                                                                                  '
			+'				<td colspan="2" align="center">                                                                                               '
			+'					<button type="button" class="login_btn" onclick="login()" >�α���</button>                                                    '
			+'				</td>                                                                                                                         '
			+'			</tr>                                                                                                                             '
			+'		</table>                                                                                                                              '
			+'	</form>                                                                                                                                   '
			+'</div>      																																'
			
			function u_login(){
				$(".login_box").html(u_LoginStr);
			}