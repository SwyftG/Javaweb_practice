<%@ page language="java" import="java.util.*,javabean.drive" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'huowu.jsp' starting page</title>
    
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
		window.location.href="login.jsp";
	</script>
	<%
		}
	%>
	
  <link rel="stylesheet" href="css/ts.css" type="text/css"></link>
  </head>
  
  <body>
   <body>
   <br/>
    <%
    	request.setCharacterEncoding("utf-8");
    %>
		  <%
		  	List list  = (List)session.getAttribute("llDL"); 
		  	if(list!= null){
		  		
		      	   		  	drive drv = (drive)list.get(0);
		  %>	
	   <center><table border="1" cellspacing="0" width="400">
			<tr>
				<td>货单号:</td>
				<td width=25%><%=drv.getGlId()%></td>
				<td>车辆牌照:</td>
				<td width=25%><%=drv.getVhclcs()%></td>
			</tr>
			<tr>
				<td>发货地:</td>
				<td><%=drv.getSname()%></td>
				<td>目的地:</td>
				<td><%=drv.getDname()%></td>
			</tr>
			<tr>
				
			</tr>
			<tr>
				<td>出发时间:</td>
				<td><%=drv.getStime()%></td>
				<td>预计到达时间:</td>
				<td><%=drv.getDtime()%></td>
			</tr>
			
			<tr>
				<td >危险品:</td>
				<td colspan="3"><%=drv.getDanger()%></td>
			</tr>
    	  	<tr>
				<td >备注信息:</td>
				<td colspan="3"><%=drv.getRmk()%></td>
			</table>
				<br/><input type="button" onclick="location.href='Sgdconfirm'" value="发货确认"/>
		
   		</center> 
    	
    		
    	  <% 
    	   		
	    	}
    	   %>
    
  </body>
  </body>
</html>
