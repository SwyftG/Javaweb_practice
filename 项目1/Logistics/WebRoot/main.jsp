<%@ page language="java" import="java.util.*,javabean.User" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

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
	<style type="text/css">
#main { 
	
	width: 100%;
	height: 100%;
	background-image: url(images/123.bmp) 
	}
#left{float:left ;width: 45%;}
#middle{margin:0 ;width: 10%;}
#right{float:right ;width: 45%;text-align:top;}
</style>		

  </head>
  
  <body>
  <%
			request.setCharacterEncoding("utf-8");
		%>
   <div id="main" >
  <h1><marquee>宋哥物流     值得信赖</marquee></h1>

  <div id="left"  >
  		<img src="images/denglu.gif" align="top" />
	<%
					List list=(List)session.getAttribute("lvuser");	
					if (list != null) {
							User user = (User) list.get(0);
							
				%>
 
  		<table>
  			<tr><td>您好，<%=user.getUsername()%>！</td></tr>
  			<tr><td>您的ID：<%=user.getUserid()%></td></tr>
  			<tr><td>您的权限：<%=user.getUserquanxian()%></td></tr>
  		</table>
  		<%} %>
  		
  </div >
   <div  id="middle" ><img align="middle" src="images/line.gif" width="9" >
  </div>
  <div id="right"   >
 <div >
  我们的宗旨：
  
  顾客就是上帝
 </div> 
 
 
  </div>
 
 
 
   
    	
    </div>
  </body>
</html>
