<%@ page language="java" import="java.util.*,javabean.Goodsyard,javabean.Region" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'veGyd.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
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
	      功能：查看货场信息
	  -->
	<body>
		<%request.setCharacterEncoding("utf-8"); %>
		  <center><h2>货场管理</h2></center>
    <br/>
		
		<form action="servlet/HveGyd" method="post">
			<center>
				请选择您需要查找的区域：			
				<% List list1  = (List)session.getAttribute("HUL"); 
    	   		if(list1 != null)
    	   		{%>
				<select name="c1">
    	   		 <% for(int i = 0;i<list1.size();i++){
	    	   		  	Region region = (Region)list1.get(i);%>	  		
						<option><%= region.getRegionname()%></option>
				<% }%>
				</select>
    	   	<%}
    	   	%>
			&nbsp;&nbsp;<input type="submit" value="查找" />	
			</center>	
			<table  align="center" width="500" id="mytable" cellspacing="0">
        	<tr>
            	<th><p align="center"><strong>货场名称 </strong></p></th>
            	<th><p align="center"><strong>所属区域 </strong></p></th>
                <th><p align="center"><strong>地址 </strong></p></th>
                <th><p align="center"><strong>面积 </strong></p></th>
                <th><p align="center"><strong>室内 </strong></p></th>
                <th><p align="center"><strong>危险品 </strong></p></th>
                <th><p align="center"><strong>编辑|删除 </strong></p></th>
            </tr>
           
            <% 
             List list  = (List)session.getAttribute("HDL");
    	   		if(list!=null)
    	   		{
    	   		  for(int i = 0;i<list.size();i++)
    	   		  {		
    	   		  		Goodsyard gyd = (Goodsyard)list.get(i);
    	   		  		%> 	   		  		
				    	<tr>	    	   		
		    			<td class="alt"><%=gyd.getGoodsyardname() %></td>
		    			<td class="alt"><%=gyd.getRegion() %></td>
		    			<td class="alt"><%=gyd.getAddress() %></td>
		    			<td class="alt"><%=gyd.getArea() %></td>
		    			<td class="alt"><%= "true".equals(gyd.getIndoor())?"是":"否"%></td>
		    			<td class="alt"><%= "true".equals(gyd.getDanger())?"是":"否"%></td>		    			
		    			<td class="alt"><a href="selectServlet2?g1=<%=gyd.getGoodsyardname()%>&g2=<%=gyd.getRegion()%>&g3=<%=gyd.getAddress()%>&g4=<%=gyd.getArea()%>&g5=<%=gyd.getIndoor()%>&g6=<%=gyd.getDanger()%>&g7=<%=gyd.getRemarks()%> ">编辑</a>|<a href="servlet/HdelGyd?g1=<%=gyd.getGoodsyardname()%>&count=<%=i %>" onclick="javaScript:return confirm('是否确认删除？')">删除</a></td> 
		    			</tr>
    	   		  <% 
    	   		  }   		
    	   		}else{
    	   		%>
    	   		<tr>
    			<td width="20%" colspan="7"><center>没有记录</center></td> 			
    			</tr>	   		
    	   		<%  	   		
    	   		} 	   
    	   %>
    	    <tr><td colspan="7"><center><input type="button" value="新增"
								onclick='location.href("/Logistics/selectServlet")' /></center></td></tr>
            </table>
		</form>
	</body>
</html>
