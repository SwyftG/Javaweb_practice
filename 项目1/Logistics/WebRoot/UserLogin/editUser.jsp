<%@ page language="java" import="java.util.*,javabean.User" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
	<!--
	 作者： 宋戈
	 完成日期：2011-7-21
	 模块功能：显示所有用户信息-->
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'edit.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<!--
	判断是否有此权限
		-->
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
	<!--
	连接css和script-->
	<script  type="text/javascript" src="/Logistics/javascript/editUser.js">
		</script>
  
  <link rel="stylesheet" href="css/ts.css" type="text/css"></link>
  </head>
  
  <body>
  	<a href="UserLogin/addAdmin.jsp">添加用户</a>
  	
	<table width="400" id="mytable" cellspacing="0">
		<tr>
			<th>ID</th>
			<th>用户名</th>
			<th>管理员</th>
			<th>司机</th>
			<th>编辑</th>
			<th>删除</th>
		</tr>
		<tr>
			<%
				List list  = (List)session.getAttribute("SUL"); 
			    	   		if(list != null)
			    	   		{
			    	   		  for(int i = 1;i<list.size();i++)
			    	   		  {
			    	   		  		User user = (User)list.get(i);

		   	 %>
		   	 <tr>
			<td class="alt"><%=user.getUserid() %></td>
			<td class="alt"><%=user.getUsername() %></td>
			<%String quan=user.getUserquanxian();
				if("管理员".equals(quan)){
			 %> 
			<td class="alt"><input type="radio" checked="checked"/></td>
			<td class="alt"><input type="radio" /></td><%} %>
			<% if ("司机".equals(quan)){ 
			%>
			<td class="alt"><input type="radio" /></td>
			<td class="alt"><input type="radio" checked="checked"/></td><%} %>
			<td class="alt"><a href="UserLogin/changeUser.jsp?name=<%=user.getUsername()%>&id=<%=user.getUserid()%>&spwd=<%=user.getUserpwd() %>">编辑</a></td>
			<td class="alt"><a onclick="return del()" href="servlet/Sdeluser?id=<%=user.getUserid()%>&sun=<%=user.getUsername()%>">删除</a></td>
		</tr>
		 <% 
    	   	}
    	   		  }else{
    	   		%>
    	   		<tr>
    			<td class="alt" width="20%" colspan="5">没有任何记录</td>
    			</tr>
    	   		<% 
    	  		}
    	   		%>
	</table>
  </body>
</html>

