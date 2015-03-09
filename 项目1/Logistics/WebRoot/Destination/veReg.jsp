<%@ page language="java" import="java.util.*,javabean.Region" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'veReg.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="javascript/regionJs.js"></script>
  <link rel="stylesheet" href="css/ts.css" type="text/css"></link>
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
  <!-- 
      作者：黄翠
      完成日期：2011年7月20日
      功能：查看区域信息
  -->
  <body>
    <%request.setCharacterEncoding("utf-8"); %>
    <center><h2>区域管理</h2></center>
    <br/>
  <form action="servlet/HveReg" method="post">
    <table id="mytable" cellspacing="0" cellpadding="0" align="center">
     <tr>
     	<th><strong>区域名称</strong></th>
     	<th><strong>编辑|删除</strong></th>
     </tr>
     <% 
             List list  = (List)session.getAttribute("HBL");
    	   		if(list != null)
    	   		{
    	   			 for(int i = 0;i<list.size();i++)
    	   		 	{
    	   		  		Region region = (Region)list.get(i);%> 	   		  		
				    	 <tr>	    	   		
			    			<td class="alt"><%= region.getRegionname()%></td>	    			
			    			<td class="alt"><a href="/Logistics/Destination/chanReg.jsp?rg=<%= region.getRegionname()%>&rk=<%= region.getRemarks()%>" value="edit">编辑</a>|<a value="delete" href="servlet/HdelReg?rg=<%= region.getRegionname()%>" onclick="javaScript:return confirm('是否确认删除？')" >删除</a></td> 
		    			 </tr>   
    	   		  <% 
    	   		  }
    	   		}else{
    	   		%>
    	   		<tr>
    			<td width="20%" colspan="7">没有任何记录</td> 			
    			</tr>	   		
    	   		<%  	   		
    	   		} 	   
    	   %>
    	   <tr><td colspan="2"><center><input type="button" value="新增"
								onclick='location.href("/Logistics/Destination/addReg.jsp")' /></center></td></tr>
        	</table>
  </form>
  
  		
		  		
  </body>
</html>


