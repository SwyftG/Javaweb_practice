<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!--
	 作者： 宋戈
	 完成日期：2011-7-21
	 模块功能：修改用户信息-->
<%
	request.setCharacterEncoding("utf-8");
%>
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
	<script type="text/javascript" src="/Logistics/javascript/changeUser.js"></script>
	
	<link rel="stylesheet" href="css/ts.css" type="text/css"></link>
	</head>
  
<body>
	<center>
    <h2>管理员修改</h2>
	<form action="servlet/Sedituser" method="post" onsubmit="return pan()" name="form">
	<table cellspacing="0" width="270" id="mytable" border="1">
    	<tr>
        	<td width="80" height="20">
        		原用户名：
        	</td>
        	<td width="120">
        		<%=new String(request.getParameter("name").getBytes("ISO8859-1"), "utf-8")%>
			</td>
        </tr>
        <tr>
        	<td>新用户名：</td>
        	<td width="120"><input type="text" maxlength="8" height="20" name="name2" id="name" size="19"/><input type="hidden" value="<%=request.getParameter("id")%>" name="hi" /></td>
        </tr> 
        <tr>
        	<td>原密码：</td>
			<td><input type="password" maxlength="30" height="20" name="pwd" id="pwd"/><input type="hidden" value="<%=request.getParameter("spwd")%>" id="pwd0"/></td>
        </tr>       
        <tr>
        	<td>新密码：</td>
        	<td><input type="password" maxlength="30" height="20" name="pwd1" id="pwd1"/></td>
        </tr>
     			<td>权限：</td>
        		<td>
	        		<input type="radio" name="quanxian" id="qu1" value="管理员">管理员&nbsp;
	        		<input type="radio" name="quanxian" id="qu2" value="司机">司机
        		</td>
        	
          </table>
			<br/>        
        	<center><input type="submit" value="修改"/>&nbsp;&nbsp;&nbsp;
        	<input type="reset" value="取消" />	</center>
       
   
    </form>
    </center>
</body>
</html>
