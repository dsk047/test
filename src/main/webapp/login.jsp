<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>欢迎使用图书管理系统</title>
<link href="resources/css/login.css" rel="stylesheet" />
<script type="text/javascript" src="resources/js/jquery-3.3.1.js"></script>
<link href="resources/css/bootstrap.css" rel="stylesheet"/>
<script type="text/javascript" src="resources/js/bootstrap.js"></script>
</head>

<body>
	<div class="login">
		<div class="login-1">
			<div class="login-2">
				<div class="login-3">					
						<div>		
							<div style="width:50px;display:inline-block;">账号：</div>
							<div style="width:200px;display:inline-block;"><input type="text" id="name" name="name"  class="form-control" /></div>	
							<div class="clear"></div>
						</div>
						<div style="margin-top:10px;">	
							<div style="width:50px;display:inline-block;">密码：</div>
							<div style="width:200px;display:inline-block;">
								<input type="password" name="password" id="password" class="form-control" />
							</div>
						</div>
						<div class="radio">
							<input type="radio" name="type" value="user" checked="checked"/><span>用户</span>
							<input type="radio" name="type" value="admin" style="margin-left:10px;"/><span style="margin-left:30px;">管理员</span>
						</div>
						<div class="button">
							<button class="btn btn-success" onclick="clickJson()" style="width:100px;">登录</button>
							<button class="btn btn-success" onclick="reset()" style="width:100px;">重置</button>
						</div>
				</div>
			</div>
		</div>
		<table width="788" height="66"  border="0" align="center" cellpadding="-2" cellspacing="-2" bgcolor="#FFFFFF">
		      <tr>
		        <td height="11" colspan="4" background="resources/images/copyright_t.gif"></td>
		  </tr>
		      <tr>
		        <td width="124" height="23">&nbsp;</td>
		        <td valign="bottom" align="center"></td>
		        <td width="141">&nbsp;</td>
		      </tr>
		      <tr>
		        <td height="23">&nbsp;</td>
		        <td align="center"></td>
		        <td>&nbsp;</td>
		      </tr>
		      <tr>
		        <td height="8"></td>
		        <td height="8"></td>
		        <td height="8"></td>
		      </tr>
		</table>
		
	</div>
	<script>
		 function clickJson() { 
            $.ajax({  
                 type: "POST",  
                 url: "login", 
                 data :{
                	 name:$('input[name="name"]').val(),
                	 password:$('input[name="password"]').val(),
                	 type:$('input[name="type"]:checked').val()
                 },
                 success: function(data){  
                	 if(data==0){ 
                		 window.location.href = 'user?name='+$('input[name="name"]').val();
                	 }else if(data==2){
                		 window.location.href = 'admin?name='+$('input[name="name"]').val();
                	 }else{
                		 alert("账号或密码错误，请重新输入");
                		 window.location.href = 'login.jsp';
                	 }              	
                 }  
          });  
      }
	function reset(){
		$("#name").val("");
		$("#password").val("");
	}
	</script>
</body>

</html>