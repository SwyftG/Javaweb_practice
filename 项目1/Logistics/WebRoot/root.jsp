<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'root.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<%	String Fs=null;
			 Fs=(String)session.getAttribute("Flag");
			if(Fs==null){
		 %>
		<script type="text/javascript">
			alert("您还未登录！");
			window.location.href="UserLogin/login.jsp";
		</script>
		<%
			}
		%>

	

  </head>
 
	<frameset rows="23%,*" cols="" frameborder="yes" border="1" framespacing="1">
		<frame src="top.jsp" name="topFrame" scrolling="No" noresize="noresize" id="topFrame" title="topFrame" />
		<frameset cols="17%,83%" frameborder="yes" border="1" framespacing="1">
		    <frame src="newleft.jsp" name="leftFrame" scrolling="No" noresize="noresize" id="leftFrame" title="leftFrame" />
		    <frame src="servlet/lvuser" name="mainFrame" id="mainFrame" title="mainFrame" />
		</frameset>
	</frameset>


  
  <body>
  
  </body>
</html>
