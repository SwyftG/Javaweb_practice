<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

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
	
	<link rel="stylesheet" type="text/css" href="css/sdmenu.css" />
	<script type="text/javascript" src="javascript/sdmenu.js">
		
	</script>
	<script type="text/javascript">
	// <![CDATA[
	var myMenu;
	window.onload = function() {
		myMenu = new SDMenu("my_menu");
		myMenu.init();
	};
	// ]]>
	</script>
	
  </head>
  
  <body>
     
 
    <div  id="my_menu" class="sdmenu" style="float:left">
      <div>
        <span>首页</span>
         <a href="servlet/lvuser" target="mainFrame">个人信息</a>
      </div>
      <div>
        <span>目的地管理</span>
        <a href="Destination/blank.jsp" target="mainFrame">区域管理</a>
        <a href="Destination/blank2.jsp" target="mainFrame">货场管理</a>
        
      </div>
      <div>
        <span>车辆管理</span>
        <a href="vehicle/searchVehicle.jsp" target="mainFrame">车辆信息</a>
        <a href="vehicle/NewVehicle.jsp" target="mainFrame">新增车辆</a>
      </div>
      <div class="collapsed">
        <span>货物管理</span>
        <a href="goods/blank.jsp" target="mainFrame">货物资料</a>
        <a href="servlet/lvgyd" target="mainFrame">新增货物</a>
        <a href="servlet/lvsearch1" target="mainFrame">查找货物</a>
       
      </div>
      <div>
        <span>调度安排管理</span>
        <a href="servlet/Jser" target="mainFrame">创建货单</a>
        <a href="goodslist/main.jsp" target="mainFrame">货单管理</a>
      </div>
      <div>
        <span>司机任务</span>
        <a href="servlet/Sdtask" target="mainFrame">我的任务</a>
       
      </div>
      <div>
        <span>管理员管理</span>
        <a href="UserLogin/addAdmin.jsp" target="mainFrame">添加管理员</a>
        <a href="servlet/Ssuser" target="mainFrame">用户列表</a>
        <a href="UserLogin/changepwd.jsp" target="mainFrame">修改密码</a>
      </div>
       <div>
        <span>退出</span>
        <a href="?foo=bar" target="_parent">退出登录</a>
     
        
      </div>
    </div>
 
 

  </body>
</html>
