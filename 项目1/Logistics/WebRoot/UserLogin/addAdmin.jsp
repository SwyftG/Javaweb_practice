<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%><!--
	 作者： 宋戈
	 完成日期：2011-7-21
	 模块功能：添加用户-->
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'add.jsp' starting page</title>
    
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
	<script  type="text/javascript" src="/Logistics/javascript/addAdmin.js">
		
	</script>
  <link rel="stylesheet" href="css/ts.css" type="text/css"></link>
  
  </head>
  
<body>
	<center>
    <h2>管理员添加(初始密码&ldquo;111111&rdquo;)</h2>
	<form action="servlet/Sadduser" method="post"  name="form" onsubmit="return add()">
	<table cellspacing="0" id="mytable" border="1">
    	<tr>
        	<td ><center>用户名：</center></td><td width="120"><input type="text" maxlength="8" height="20" name="name" size="18"/></td>
        </tr>
        <tr>
        	<td><center>密码：</center></td><td><input type="password" maxlength="30" height="20" name="pwd"/></td>
        </tr>
        <tr>
        	<td><center>权限：</center></td><td><input type="radio" name="quanxian" value="管理员" />管理员<input type="radio" name="quanxian" value="司机" />司机</td>
        </tr>
        </table><br/>
        	<td colspan="2"><center><input type="submit" value="添加" />&nbsp;&nbsp;&nbsp;<input type="reset" value="取消" />	</center></td>
        
    
    </form>
    </center>
</body>
</html>
