<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
    
    <title>My JSP 'Vehicle.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
<body bgcolor="#ECF9B9">



<table width="80%" border="0" align="center">
<form action="?action=save&id=>" method="post" name="theForm"> 
   <tr align="center"bgcolor="#FFCC66">
   <td colspan="8">车辆信息管理</td>
   </tr>
   <tr><td colspan="8"><hr /></td></tr>
  <tr>
    <td width="13%">车辆编号</td>
    <td width="20%">    
      <input type="text" name="vihid" value=" " readonly size="20" />    </td>
    <td width="12%">车牌号</td>
    <td width="20%"><input type="text" name="vehino" size="20"/> </td>
    <td width="12%">所属公司</td>
    <td width="23%"><input type="text" name="owename" size="20"/> </td>
  </tr>
   <tr>
     <td>地址</td>
     <td>    
        <input type="text" name="addr" size="20"/>    </td>
    <td>电话 </td>
    <td><input type="text" name="phone" size="20"/> </td>
    <td>司机姓名</td>
    <td><input type="text" name="driname"size="20" /> </td>
  </tr>
   <tr>
     <td>驾驶证号</td>
     <td>    
        <input type="text" name="dlno"size="20" />    </td>
    <td>货车型号</td>
    <td><input type="text" name="nowheel" size="20"/> </td>
    <td>最大载重量</td>
    <td><input type="text" name="mweight" size="20"/> </td>
  </tr>   
   <tr>
    <td colspan="6">
	<a href="#" onclick="return go()"><img src = "images/back.gif" border="0"></a>
      <input type="submit" name="submit" value="O K"size="50"style="background:#FFCC66"/>
	  <input type="reset" name="reset" value ="Cancel" size="50" style="background:#FFCC66"/>
   </td>
  </tr>
  </form>
</table>
 
		<table width="80%" border="0" align="center">
<form action="?action=editsave&id=" method="post" name="theForm"> 
   <tr align="center"bgcolor="#FFCC66">
   <td colspan="8">车辆信息管理</td>
   </tr>
   <tr><td colspan="8"><hr /></td></tr>
  <tr>
    <td width="13%">车辆编号</td>
    <td width="20%">    
      <input type="text" name="vihid" value=" " readonly size="20" />    </td>
    <td width="12%">车牌号</td>
    <td width="20%"><input type="text" name="vehino" value=" " size="20"/> </td>
    <td width="12%">所属公司</td>
    <td width="23%"><input type="text" name="owename"value=" " size="20"/> </td>
  </tr>
   <tr>
     <td>地址</td>
     <td>    
        <input type="text" name="addr" value = " "size="20"/>    </td>
    <td>电话 </td>
    <td><input type="text" name="phone" value=" "size="20"/> </td>
    <td>司机姓名</td>
    <td><input type="text" name="driname" value=" "size="20" /> </td>
  </tr>
   <tr>
     <td>驾驶证号</td>
     <td>    
        <input type="text" name="dlno" value=""size="20" />    </td>
    <td>货车型号</td>
    <td><input type="text" name="nowheel" value=""size="20"/> </td>
    <td>最大载重量</td>
    <td><input type="text" name="mweight" value=""size="20"/> </td>
  </tr>   
   <tr>
    <td colspan="6">
	<a href="#" onclick="return go()"><img src = "images/back.gif" border="0"></a>
      <input type="submit" name="submit" value="O K"size="50"style="background:#FFCC66"/>
	  <input type="reset" name="reset" value ="Cancel" size="50"style="background:#FFCC66"/>
   </td>
  </tr>
    </form>
</table>
		

<table width="80%" align="center">
<Tr align="center"><td colspan="8">车辆信息列表</td></tr>
   
 <tr bgcolor="#FFCC66">
  <Td><div align="center">车辆信息编号 
  </div></td>
    <Td><div align="center">车牌号</div></td>
    <Td><div align="center">所属公司
    </div></td>
    <Td><div align="center">地址</div></td> 
   <Td><div align="center">电话	
   </div></td>
    <Td><div align="center">司机姓名
    </div></td>
    <Td><div align="center">驾驶证号
    </div></td>
	<Td><div align="center">货车类型
    </div></td>
	<Td><div align="center">最大载重量
    </div></td>
    <Td><div align="center">修改
    </div></td>
 </tr>

  <tr  bgcolor="#FFCCCC">
  <Td><div align="center"> 
  </div></td>
    <Td><div align="center"></div></td>
    <Td><div align="center">
    </div></td>
    <Td><div align="center"></div></td> 
   <Td><div align="center">	
   </div></td>
    <Td><div align="center">
    </div></td>
    <Td><div align="center">
    </div></td>
	<Td><div align="center">
    </div></td>
	<Td><div align="center">
    </div></td>
    <Td><div align="center"><><img src="images/button-edit.gif" border="0"></a>
    </div></td></tr>
 
 
 <tr align="right"  valign="bottom">
 <td colspan=""><a href="?action=add"><img src="images/button-add.gif" border="0"></a></td>
 <td colspan="7" align="right"  valign="bottom" > <form name="form1"><a href='#' onclick=""><img src ="images\button-first.gif" border="0"align="center"></a>&nbsp;&nbsp;<a href='#'onclick="dopage();"><img src ="images\button-prev.gif" border="0" align="center"></a>&nbsp;&nbsp;<a href='#' onclick="dopage();"><img src ="images\button-next.gif" border="0" align="center"></a>&nbsp;&nbsp;<a href='#' onclick="dopage();"><img src ="images\button-last.gif" align="center" border="0"></a>
 <input type="text" size=3	onmouseover='this.focus();this.select()' name="topage"
			value="">go&nbsp; <input type="submit" id="go"
			value=" GO "style="background:#FFCC66"></td></tr>
 </form>
</table>

</body>
</html>

  </body>
</html>
