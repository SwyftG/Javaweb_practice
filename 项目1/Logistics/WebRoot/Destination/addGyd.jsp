<%@ page language="java" import="java.util.*,javabean.Region" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addGyd.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="css/ts.css" type="text/css"></link>

  <script type="text/javascript" src="javascript/regionJs.js"></script>
 </head>
  <!-- 
      作者：黄翠
      完成日期：2011年7月20日
      功能： 实现货场信息的增加：表单提交到servlet/HaddGyd中实现编辑功能。 
  -->
  <body>
    <%request.setCharacterEncoding("utf-8"); %>
    <form action="servlet/HaddGyd" method="post" onsubmit="return test3()">
    <table id="mytable" align="center">
        <tr>
        	<td>货场名称：</td><td><input type="text" maxlength="30" name="j1" id="j1"/></td>
        </tr>
        <tr>
        	<td>所属区域：</td>
        	<td>
    	<% List list1  = (List)session.getAttribute("HEL"); 
    	   		if(list1 != null)
    	   		{%>
    	   			<select name="j2">
    	   		 <% for(int i = 0;i<list1.size();i++)
    	   		  {
    	   		  	Region region = (Region)list1.get(i);%>
    	   		  		  		
					<option><%= region.getRegionname()%></option>
					
					<% 
    	   		  }%>
    	   		  </select>
    	   		<%}
    	   		%>
    		</td>
    
        </tr>
        <tr>
        	<td>货场地址：</td><td><input type="text" maxlength="100" name="j3" id="j3"/></td>
        </tr>
        <tr>
        	<td>货场面积：</td><td><input type="text" name="j4" id="j4"/>平米</td>
        </tr>
        <tr>
        	<td>是否室内：</td>
			<td colspan="7">
                	是：<input type="radio" name="j5" id="j51" value="true"/>&nbsp;&nbsp;
                	否：<input type="radio" name="j5" id="j52" value="false"/>
            </td>
        </tr>
        <tr>
        	<td>是否允许危险品：</td>
        	<td colspan="7">
                	是：<input type="radio" name="j6" id="j61" value="true"/>&nbsp;&nbsp;
                	否：<input type="radio" name="j6" id="j62" value="false"/>
                </td>
        </tr>
        <tr>
        	<td colspan="2">备注信息：<br /><textarea cols="50" rows="10" name="j7"></textarea></td>
        </tr>
        <tr>
        	<td colspan="2"><center><input type="submit" value="添加" />&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="清除" />&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="返回" onclick='location.href("Destination/blank2.jsp")'/></center></td>
        </tr>
    </table>
</form>
  </body>
</html>
