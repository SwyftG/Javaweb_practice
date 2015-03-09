<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
    
    <title>My JSP 'NewVehicle.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  	
  	<script type="text/javascript" src="javascript/vehc.js"></script>
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
	此页功能是提供新建车辆信息。将用户填入数据传到servlet的增加页面-->
  <body>
    <center><h2>车辆信息新建</h2></center><br/>
    <form method="post" action="servlet/lladd" onsubmit="return test()">
       <table width="600" height="200" align="center" id="mytable" >
              <tr>
                <td width="40%">*车辆型号：</td>
                <td width="20%"><input type="text" maxlength="20" name="vf" id="vf"/></td>
                <td width="20%">*车辆牌照：</td>
                <td width="20%"><input type="text" name="vl" id="vl"/></td>
              </tr>
              <tr>
                <td>*燃油类型：</td>
                <td><select name="ot" >
						<option>汽油</option>
						<option>柴油</option>
					</select>
				</td>
                <td>*耗油量(升/百公里)：</td>
                <td><input type="text" name="oc" id="oc"/></td>
              </tr>
              <tr>
                <td>*车辆类型：</td>
                <td><select name="vt">
						<option>普通</option>
						<option>油罐</option>
						<option>箱式</option>
					</select>
				</td>
                <td>*载重量(t)：</td>
                <td><input type="text" name="lc" id="lc"/></td>
              </tr>
              <tr>
                <td>*车辆特种：</td>
                <td colspan="3">
                	是：<input type="radio" name="vs" value="true" id="vs1"/>&nbsp;&nbsp;
                	否：<input type="radio" name="vs" value="false" id="vs2"/>
                </td>
              </tr>
              <tr>
                <td>备注信息：</td>
                <td colspan="3"><textarea rows="5" cols="57" name="vr"/></textarea></td>
              </tr>
              <tr>
                <td colspan="2" align="center"><br/><input type="submit" value="添 加" /></td>
                <td colspan="2" align="center"><br/><input type="reset" value="清 除"/></td>
              </tr>
        </table>
    </form><br/>
    <a href="javascript:history.go(-1)">返回上一页面</a>
  </body>
</html>
