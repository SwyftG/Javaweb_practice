<%@ page language="java" import="java.util.*,javabean.Region,javabean.Goodsyard" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'chanGyd.jsp' starting page</title>
    
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
  </head>
  <!-- 
      作者：黄翠
      完成日期：2011年7月20日
      功能：实现货场信息的编辑：从veGyd.jsp文件中获值来进行页面初始化，表单提交到servlet/HeditGyd中实现编辑功能。
  -->
  <body>
       <% 
       	request.setCharacterEncoding("utf-8");  
    	%>
    	
    <form action="servlet/HeditGyd" method="post" onsubmit="return test2()">
    <table  align="center" id="mytable" cellspacing="0">
        <tr>
        	<td>货场名称：</td>
        	<td>
        		<input type="text" maxlength="30" name="b1" value="<%=new String(request.getParameter("g1").getBytes("ISO8859-1"),"utf-8")%>" readonly="readonly"/>
        	</td>
        </tr>
        <tr>
        	<td>所属区域：</td>
        	<td>
        	<% List list1  = (List)session.getAttribute("HFL"); 
    	   		if(list1 != null)
    	   		{%>
    	   			<select name="b2">
    	   		 <% for(int i = 0;i<list1.size();i++)
    	   		 {
    	   		  	Region region = (Region)list1.get(i);
    	   		  	if(region.getRegionname()==request.getParameter("g2")){%>
    	   		  	<option selected="selected" ><%= region.getRegionname()%></option>
    	   		  	<%}else{ %>
    	   		  	<option><%=region.getRegionname()%></option>
    	   		  	<% }	  		
				}%>
    	   		  </select>
    	   	<%}%>
        	</td>
        </tr>
        <tr>
        	<td>货场地址：</td>
        	<td>
        		<input type="text" maxlength="100" name="b3" value="<%=new String(request.getParameter("g3").getBytes("ISO8859-1"),"utf-8")%>"/>
        	</td>
        </tr>
        <tr>
        	<td>货场面积：</td><td><input type="text" name="b4" id="b4" value="<%=request.getParameter("g4")%>"/>平米</td>
        </tr>
        <tr>
        	<td>是否室内：</td>
			<%	if(request.getParameter("g5").equals("true")){
	           		 %>
			
	            		<td colspan="7">
		                	是：<input type="radio" name="b5" checked="checked" value="true"/>
		                	否：<input type="radio" name="b5" value="false"/>
	                	</td>
                <% 	}else{
	           	%>		
	            		<td colspan="7">
		                	是：<input type="radio" name="b5" value="true"/>
		                	否：<input type="radio" name="b5" checked="checked" value="false"/>
	                	</td>
                <%	} %>
        </tr>
        <tr>
        	<td>是否允许危险品：</td>
			<%	if(request.getParameter("g6").equals("true")){
	            %>		
	            		<td colspan="7">
		                	是：<input type="radio" name="b6" checked="checked" value="true"/>
		                	否：<input type="radio" name="b6" value="false"/>
	                	</td>
                <% 	}else{
	            %>		
	            		<td colspan="3">
		                	是：<input type="radio" name="b6" value="true"/>
		                	否：<input type="radio" name="b6" checked="checked" value="false"/>
	                	</td>
                <%	} %>
        </tr>
        <tr>
        	<td colspan="2">备注信息：<br /><textarea cols="50" rows="10" name="b7"><%=new String(request.getParameter("g7").getBytes("ISO8859-1"),"utf-8")%></textarea></td>
        </tr>
        <tr>
        	<td colspan="2"><center><input type="submit" value="修改" onclick="return nimei()" />&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="返回" onclick='location.href("Destination/blank2.jsp")'/></center></td>
        </tr>
    </table>
</form>
  </body>
</html>

