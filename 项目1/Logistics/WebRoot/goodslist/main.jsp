<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!--
作者：刘嘉杰
时间：2011年7月20日
模块功能：货运调度安排
-->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'main.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<%	String qx=null;
			 qx=(String)session.getAttribute("vvquanxian");
			if(qx!="g"){
		 %>
		<script type="text/javascript">
			alert("您没有此权限！");
			window.location.href="/Logistics/quanxian.jsp";
		</script>
		<%
			}
		%>
  </head>
  
  <body>
  
  <%request.getRequestDispatcher("/servlet/Jmyserv").forward(request,response); %>
 
  </body>
</html>
