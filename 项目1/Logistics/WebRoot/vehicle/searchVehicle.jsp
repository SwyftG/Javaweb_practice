<%@ page language="java" import="java.util.*,javabean.VeInfo" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!--
作者：李柳依
时间：2011年7月20日
模块功能：车辆管理系统
-->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
  	车辆查询界面，本页提供车辆查询功能以及编辑和删除的链接。通过查询数据库，将查询结果利用list返回到该界面显示。    -->
  <body>
  	
    <center>
		<h1>车辆管理系统</h1>
		<a href="vehicle/NewVehicle.jsp" >新增记录</a><br/>
		<form method="post" action="servlet/llsrcveh">
			<table width="700" >
			
				<tr>
		        	<td width="12%" align="right">型号：</td>
		            <td width="15%"><input type="text" name="vf"/></td>
		            <td width="15%" align="right" >燃油类型：</td>
		            <td width="15%">
						<select name="ot">
							<option selected="selected">全部</option>
							<option>汽油</option>
							<option>柴油</option>
						</select>
		            </td>
		            <td width="15%" align="right">车辆类型：</td>
		            <td width="15%">
						<select name="vt">
							<option selected="selected">全部</option>
							<option>普通</option>
							<option>油罐</option>
							<option>箱式</option>
						</select>
		            </td>
		            <td width="13%"><input type="submit" value="查 找" /></td>
	        	</tr>
			</table>
			
		</form>
		
   		<table width="700" id="mytable" cellspacing="0">
			<tr>
				<th>车辆型号</th>
				<th>燃油类型</th>
				<th>车辆类型</th>
				<th>载重量</th>
				<th>特种</th>
				<th>编辑|删除</th>
			</tr>
		<%request.setCharacterEncoding("utf-8"); %>
		  <%
		  
			List list  = (List)session.getAttribute("lsUL"); 
			if(list!=null){
				for(int i = 0;i<list.size();i++){
    	   		  	VeInfo info = (VeInfo)list.get(i);
    	  %>	
	    	   		<tr>		
	    			<td class="alt"><%=info.getVhcForm()%></td>	
	    			<td class="alt"><%=info.getOilType()%></td>
	    			<td class="alt"><%=info.getVhcType()%></td>
					<td class="alt"><%=info.getLoadCpt()%></td>
	    			<td class="alt">
    				<%
    					if(info.isVhcSpc()){
    						%><%="是" %>
    				<%
    					}else{
    				%><%="否" %>				
    				<%	}
					%>
    			</td>
    			<td class="alt"><a href="vehicle/chanVehicle.jsp?vl=<%=info.getVhcLcs()%>&vf=<%=info.getVhcForm()%>&ot=<%=info.getOilType()%>&oc=<%=info.getOilCpt()%>&lc=<%=info.getLoadCpt()%>&vt=<%=info.getVhcType()%>&vs=<%=info.isVhcSpc()%>&vr=<%=info.getVhcRmk()%>">编辑</a>|<a onclick="Javascript:return confirm('确认删除?')" href="servlet/lldel?vl=<%=info.getVhcLcs()%>&ct=<%=i %>">删除</a></td>
    			</tr>
    	  <% 
    	   		}
  	   
	    	}else{
	    		
	    	   		%>
	    	   		<tr>
	    			<td colspan="6">没有记录</td>
	    			</tr>
	    	   		<% 
	    	   	
    	   }
    	   %>
    	  
   		</table><br/>
   		
	</center>
  </body>
</html>
