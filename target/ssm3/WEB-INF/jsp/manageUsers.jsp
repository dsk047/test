<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
request.setCharacterEncoding("utf-8");
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
		+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书馆管理系统</title>
<link href="<%=basePath %>resources/css/style.css" rel="stylesheet">
<script type="text/javascript" src="<%=basePath %>resources/js/jquery-1.12.3.min.js"></script>
<link href="<%=basePath %>resources/css/bootstrap.css" rel="stylesheet"/>
<script type="text/javascript" src="<%=basePath %>resources/js/bootstrap.js"></script>
</head>

<body onLoad="clockon(bgclock)">

<table width="778" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="118" valign="top" background="<%=basePath %>resources/images/top_bg.jpg" bgcolor="#EEEEEE">
    <table width="100%" height="33"  border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td width="81%" height="10"></td>
        <td colspan="2"></td>
      </tr>
      <tr>
        <td height="20">&nbsp;</td>
        <td width="10%"><a href="#" onClick="window.location.reload();" class="word_dark">刷新页面</a></td>
        <td width="9%"><a href="#" onClick="myclose()" class="word_dark">关闭系统</a></td>
       </tr>
    </table>
      <table width="93%" height="79"  border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td height="69" align="right" valign="bottom">当前登录用户：${name}</td>
        </tr>
    </table></td>
  </tr>
</table>
<!--这个是头-->
<script src="<%=basePath %>resources/js/onclock.js"></script>

<div class=menuskin id=popmenu
      onmouseover="clearhidemenu();highlightmenu(event,'on')"
      onmouseout="highlightmenu(event,'off');dynamichide(event)" style="Z-index:100;position:absolute;"></div>
<table width="778"  border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
      <tr bgcolor="#DFA40C">
        <td width="3%" height="27">&nbsp;</td>
        <td width="29%"><div id="bgclock" class="word_white"></div></td>
        <td width="30%" align="right" bgcolor="#B0690B" class="word_white"><a href="<%=basePath %>admin/main" class="word_white">首页</a> |
		<a  href="<%=basePath %>admin/addUsers" style="CURSOR:hand"  class="word_white">添加用户</a> | <a  href="<%=basePath %>admin/manageUsers" style="CURSOR:hand"  class="word_white">用户管理</a> | <a  href="<%=basePath %>admin/addBooks" style="CURSOR:hand"  class="word_white">图书录入</a> | <a  href="<%=basePath %>admin/updateBooks" style="CURSOR:hand"  class="word_white">修改图书信息</a> | <a href="<%=basePath %>login.jsp" class="word_white">退出系统</a></td> 
        <td width="2%" bgcolor="#B0690B">&nbsp;</td>
  </tr>
      <tr bgcolor="#DFA40C">
        <td height="9" colspan="4" background="<%=basePath %>resources/images/navigation_bg_bottom.gif"></td>
      </tr>
</table>
<!--navigation.jsp组合代码-->

<table width="778" height="510"  border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF" class="tableBorder_gray">
  <tr>
    <td align="center" valign="top" style="padding:5px;"><table width="100%"  border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td height="20" align="right" valign="middle" class="word_orange">当前位置：用户管理 &gt;&gt;&gt;&nbsp;</td>
      </tr>
      <tr>
        <td valign="top"><table width="100%"  border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td height="72" valign="top"><table width="100%" height="63"  border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td width="2%"rowspan="2">&nbsp;</td>
                
      
				<td width="96%" align="center" valign="top">

					<table class="table table-striped table-bordered table-hover  table-condensed">
						<thead>
			                 <tr>
								<td>用户姓名</td>
								<td>用户密码</td>
								<td>电话号码</td>
								<td>可借阅时间</td>
								<td>逾期操作次数</td>
								<td>修改借阅时间</td>
							</tr>
						</thead>	
						<tbody>
							<c:forEach items="${uList}" var="a" varStatus="status">
								<tr>
									<td style="text-align:center;line-height: 25px;">${a.userName}</td>
									<td style="text-align:center;line-height: 25px;">${a.userPassword}</td>
									<td style="text-align:center;line-height: 25px;">${a.phoneNumber}</td>
									<td style="text-align:center;line-height: 25px;">${a.day}</td>
									<td style="text-align:center;line-height: 25px;">${a.overdue}</td>
									<td style="text-align:center;line-height: 25px;"><input type="button" class="btn btn-sm btn-primary" value="修改" onclick="updateDay('${a.userName}')"/> </td>
								</tr>
							</c:forEach> 
						</tbody>
					</table>

                  </td>
                <td width="2%" rowspan="2">&nbsp;</td>
              </tr>
              <tr>
                <td height="30" align="right" valign="middle">
                <img src="<%=basePath %>resources/images/more.GIF" width="50" height="20" border="0">&nbsp;</td>
              </tr>
            </table></td>
          </tr>
        </table>
          </td>
      </tr>
    </table>
    </td>
  </tr>
</table>
<table width="778" height="66"  border="0" align="center" cellpadding="-2" cellspacing="-2" bgcolor="#FFFFFF">
      <tr>
        <td height="11" colspan="4" background="resources/images/copyright_t.gif"></td>
  </tr>
      <tr>
        <td width="124" height="23">&nbsp;</td>
        <td valign="bottom" align="center">(c) Copyright 2018 肖伟佳. All Rights Reserved. </td>
        <td width="141">&nbsp;</td>
      </tr>
      <tr>
        <td height="23">&nbsp;</td>
        <td align="center">本系统为武汉轻工大学图书管理系统，仅供毕业设计</td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td height="8"></td>
        <td height="8"></td>
        <td height="8"></td>
      </tr>
</table>

<script>
function myclose(){
	if(confirm("真的要关闭当前窗口吗?")){
		window.close();
	}
}
function updateDay(name){
	var message;
	
    	message=prompt("请输入您要修改的值");
		message=message.replace(/\D/g,'');
		if(message==""){
			alert("请输入数字");
			return false;
		}else if(message>=0&&message<100){
			var day=message;
			$.ajax({
				type:"post",
				url:"updateDay",
				data:{
					name:name,
					day:day
				},success:function(data){
					alert("已修改");
					window.location.reload();
				}
			})
		}else{
			alert("请控制在合理的数值内（0~100）");
		}	
}

</script>
</body>
