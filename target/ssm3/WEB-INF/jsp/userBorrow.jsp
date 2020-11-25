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
<script type="text/javascript" src="<%=basePath %>resources/js/jquery-3.3.1.js"></script>
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
        <script language="javascript">
			function myclose(){
				if(confirm("真的要关闭当前窗口吗?")){
					window.close();
				}
			}
		</script>
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
        <td width="22%" align="right" bgcolor="#B0690B" class="word_white"><a href="<%=basePath %>user/main" class="word_white">首页</a> |
        <a  href="<%=basePath %>book/userBorrow?name=${name}" style="CURSOR:hand"  class="word_white">图书借阅</a> | <a  href="<%=basePath %>book/userReturn?name=${name}" style="CURSOR:hand"  class="word_white">图书归还</a> | <a  href="<%=basePath %>user/userInformation?name=${name}" style="CURSOR:hand"  class="word_white">用户信息</a> | <a href="<%=basePath %>login.jsp" class="word_white">退出系统</a></td>
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
        <td height="20" align="right" valign="middle" class="word_orange">当前位置：图书借阅 &gt;&gt;&gt;&nbsp;</td>
      </tr>
      <tr>
        <td valign="top"><table width="100%"  border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td height="52" background="<%=basePath %>resources/images/borrowBackRenew.gif">&nbsp;</td>
          </tr>
          <tr>
            <td height="72" valign="top"><table width="100%" height="63"  border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td width="2%" rowspan="2">&nbsp;</td>
                
                <div style="margin-left:20px;">
						<span>请选择您需要的查询方式</span> 
						<select name="method" id="method" onchange="method()">
							<option value="1">图书编号</option>
							<option value="2">图书名称</option>
							<option value="3">作者</option>
							<option value="4">出版社</option>
							<option value="5" id="type" onclick="as()">类型</option>
						</select>
						 <select id="k" style="width: 100px;display:none;">
						    	<option value="">请选择类型</option>
								<option value="计算机">计算机</option>
								<option value="生活">生活</option>
								<option value="经管">经管</option>
								<option value="文学">文学</option>					
								<option value="教育">教育</option>
						</select>
							
						<input type="text" name="key" id="key" style="width:100px;"> 
						
						<input type="button" value="查询" onclick="submit()"/>
				</div>
				<td width="96%" align="center" valign="top">
                <table width="100%"  class="table table-striped table-bordered table-hover  table-condensed">
               <thead>
                 <tr>
					<td>图书编号</td>
					<td>图书名称</td>
					<td>图书类型</td>
					<td>出版社</td>
					<td>作者</td>
					<td>数量</td>
					<td>操作${bList}</td>
				</tr>
				</thead>	
				<tbody id="bookBorrow">

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
		function method() {
			var vs = $('select option:selected').val();
			if (vs == "5") {
				$("#key").hide();
				$("#k").show();
			} else {
				$("#key").show();
				$("#k").hide();

			}
		}
		function submit() {
			
			var type = $("#method").val();
			var text = $("#key").val();
			var k = $("#k").val();
			if (k != "" && type == "5") {
				text = k;
			}
			
			$.ajax({
				url : 'queryBook',
				type : 'post',
				data : {
					method : type,
					key : text
				},
				success : function(data) {					
					appendContentHtml(data);
				}
			});			
		} 
		function appendContentHtml(param) {
			var htmlContent = "";
			if(param.length==0){
				alert("查无此书");
				return false;
			}else{
			$.each(param,function(index,data){
				if (index % 2 == 0) {
					htmlContent = htmlContent + "<tr style=\"cursor:pointer\" bgcolor=\"#f9f9f9\" id=\"num"+data.bookId+"\">";
				} else {
					htmlContent = htmlContent + "<tr style=\"cursor:pointer\" bgcolor=\"#fefefe\" >";
				}
				htmlContent = htmlContent + "<td>"+data.bookId+"</td>";
				htmlContent = htmlContent + "<td>"+data.bookName+"</td>"; 
				htmlContent = htmlContent + "<td id=\"num"+data.bookId+"\">"+data.number+"</td>";
				htmlContent = htmlContent + "<td>"+data.type+"</td>";  		  
				htmlContent = htmlContent + "<td>"+data.press+"</td>";  
				htmlContent = htmlContent + "<td>"+data.author+"</td>"; 
				htmlContent = htmlContent +"<td><input type=\"button\" value=\"借阅\" id=\"get\" onclick=\"getBook('"+data.bookId+"')\"/>"
				htmlContent = htmlContent +"<input type=\"button\" value=\"预约\" id=\"appoint\" onclick=\"appointBook('"+data.bookId+"')\"/></td>"
				htmlContent = htmlContent + "</tr>";
			});
			$("#bookBorrow").empty();
			$("#bookBorrow").html(htmlContent);
			}
		}
		 function getBook(id) {
				$.ajax({
					url : 'getBook',
					type : 'post',
					data : {
						id : id
					},
					success : function(data) {
						if (data == "fail") {
							alert("藏书不足！");
						} else if (data == "success") {
							var num = $("#num" + id).html();
							$("#num" + id).html(num - 1);
							alert("图书租借成功");
						} else {
							alert("您已经借阅本图书，请勿重复操作");
						}

					}
				});	
				
			} 
		function appointBook(id) {
			$.ajax({
				url : 'appointBook',
				type : 'post',
				data : {
					id : id
				},
				success : function(data) {
					alert(data);
				}
			})
		}
</script>
</body>
</html>