<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'chanReg.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="/Logistics/javascript/vvjs.js"></script>
  	<link rel="stylesheet" href="css/ts.css" type="text/css"></link>
  </head>
  <!-- 
      作者：黄翠
      完成日期：2011年7月20日
      功能：实现区域信息的编辑：从veReg.jsp文件中获值来进行页面初始化，表单提交到servlet/HeditReg中实现编辑功能。
  -->
  <body>
    <%request.setCharacterEncoding("utf-8"); %>
    <form action="servlet/HeditReg" method="post">
        <table align="center" id="mytable">
            <tr>
                <td>区域名称：<input type="text" name="v1" value="<%=new String(request.getParameter("rg").getBytes("ISO8859-1"),"utf-8")%>" readonly="readonly" size="18"/></td>
            </tr>
            <tr>
                <td>备注信息：<br /><textarea rows="10" cols="25" name="v2"><%=new String(request.getParameter("rk").getBytes("ISO8859-1"),"utf-8")%></textarea></td>
            </tr>
            <tr>
                <td>
                	<center>
                		<input type="submit" value="修改" onclick="return nimei()"/>
                		&nbsp;&nbsp;
                		<input type="button" value="返回" onclick='location.href("blank.jsp")'/>
                	</center>
                </td>
            </tr>
        </table>
        
    </form>
  </body>
</html>
