<%@ page language="java" import="java.util.*,javabean.VeInfo" pageEncoding="utf-8"%>
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
    
    <title>My JSP 'JveInfo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  <link rel="stylesheet" href="css/ts.css" type="text/css"></link>
  </head>
  
  <body>	
   		
		<%request.setCharacterEncoding("utf-8"); %> 
		  <%
			List list  = (List)session.getAttribute("lvf"); 
			if(list!= null){
		
    	   		  	VeInfo info = (VeInfo)list.get(0);
    	  %>	 	<center><h2>车辆型号为<%=info.getVhcLcs()%>的详细信息</h2>
	    	   		<table border="1" id="mytable" cellspacing="0">
	    	   		<tr>	
						<td>车辆型号：</td>	    	   		
	    	    		<td ><%=info.getVhcForm()%></td>	
	    			</tr>
	    			<tr>	
						<td>燃油类型：</td>	   		
	    	    		<td ><%=info.getOilType()%></td>	
	    			</tr>
	    			<tr>	
						<td>车辆类型：</td>	
	    	    		<td ><%=info.getVhcType()%></td>	
	    			</tr>
	    			<tr>	
						<td>载重量：</td> 	   		
	    	    		<td ><%=info.getLoadCpt()%></td>
	    			</tr>
	    			<tr>	
						<td>耗油量：</td> 	   		
	    	    		<td ><%=info.getOilCpt()%></td>
	    			</tr>
	    			<tr>
	    				
						<td>特种</td>	 
						<td><%
    					if(info.isVhcSpc()){
    						%><%="是" %>
    				<%
    					}else{
    				%><%="否" %>				
    				<%	}
					%>  		
	    	    		</td>
	    			</tr>
	    		 		
    	  <% 	
	    	}
    	   %>
    	  
   		</table><br/>
   		<a href="javascript:history.go(-1)">返回上一页</a></center>
  </body>
</html>
