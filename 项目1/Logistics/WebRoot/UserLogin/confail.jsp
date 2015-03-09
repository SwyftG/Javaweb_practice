<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'confail.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="refresh" content="3;url=Sdtask">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<%	String Fs=null;
		 Fs=(String)session.getAttribute("Flag");
		if(Fs==null){
	 %>
	<script type="text/javascript">
		alert("您还未登录！");
		window.location.href="login.jsp";
	</script>
	<%
		}
	%>
	
  <link rel="stylesheet" href="css/ts.css" type="text/css"></link>
  </head>
  
  <body>
   	确认失败！3秒钟后将自动转回所有任务界面
  </body>
</html>
