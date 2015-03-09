<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!--
	 作者： 宋戈
	 完成日期：2011-7-21
	 模块功能：修改Admin密码-->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'mima.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
		
		<!--
	验证是否有权限-->
		<%	String qx=null;
		 qx=(String)session.getAttribute("vvquanxian");
		if(qx!="admin"){
	 %>
	<script type="text/javascript">
		alert("您没有此权限！");
		window.location.href="/Logistics/quanxian.jsp";
	</script>
	<%
		}
	%>
	<script type="text/javascript" src="/Logistics/javascript/changepwd.js">
		</script>
		
  <link rel="stylesheet" href="css/ts.css" type="text/css"></link>
  </head>
  
<body>
	<center>
    <h2>密码修改(Admin管理员)</h2>
	<form action="servlet/Sadminpwd" method="post" onsubmit="return pan()">
	<table border="1" id="mytable" cellspacing="0">
    	<tr>
        	<td width="80" height="20"><center>用户名：</center></td><td width="120">Admin</td>
        </tr>
        <tr>
        	<td><center>密码：</center></td><td><input type="password" maxlength="30" height="20" name="pwd0" id="pwd0"/></td>
        </tr> 
        <tr>
        	<td><center>确认密码：</center></td><td><input type="password" maxlength="30" height="20" name="pwd" id="pwd1"/></td>
        </tr>    
       
        </table>
        <br/>
        	<center><input type="submit" value="修改" />&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="取消" />	</center>
       
 
    
    </form>
    </center>
</body>
</html>
