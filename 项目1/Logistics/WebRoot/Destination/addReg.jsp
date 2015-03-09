<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addReg.jsp' starting page</title>
    
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
      功能： 实现区域信息的增加：表单提交到servlet/HaddReg中实现编辑功能。 
  -->
  <body>
    <%request.setCharacterEncoding("utf-8"); %>
    <form action="servlet/HaddReg" method="post" onsubmit="return test()">
        <table align="center" id="mytable" cellspacing="0">
            <tr>
                <td>区域名称：<input type="text" name="v1" id="q1" size="18"/></td>
            </tr>
            <tr>
                <td>备注信息：<br /><textarea rows="10" cols="25" name="v2"></textarea></td>
            </tr>
            <tr>
                <td>
                	<center>
                		<input type="submit" value="添加"/>
                		&nbsp;&nbsp;
                		<input type="reset" value="清除"/>
                		&nbsp;&nbsp;
                		<input type="button" value="返回" onclick='location.href("blank.jsp")'/>
                	</center>
                </td>
            </tr>
        </table>
        
    </form>
  </body>
</html>
