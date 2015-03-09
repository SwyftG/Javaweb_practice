<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页top</title>

 <link rel="stylesheet" href="css/topcss.css" type="text/css"></link>
 </head>
 <body>
		<div class="d1">
			<img src="images/HD01.gif">
		</div>
		<div class="d2">
       		<div class="d3">
       			 <span class="STYLE3">今天是
						<script language="JavaScript" type="text/javascript">
			                dayObj=new Date();
			                monthStr=dayObj.getMonth()+1;
			                year2000=dayObj.getYear();
			                if(year2000<1900)year2000+=1900;
			                document.write(monthStr+"月"+dayObj.getDate()+"日");
			                if(dayObj.getDay()==1)document.write("星期一");
			                if(dayObj.getDay()==2)document.write("星期二");
			                if(dayObj.getDay()==3)document.write("星期三");
			                if(dayObj.getDay()==4)document.write("星期四");if(dayObj.getDay()==5)document.write("星期五");
			                if(dayObj.getDay()==6)document.write("星期六");
			                if(dayObj.getDay()==0)document.write("星期日");      	
						</script>  
				  </span>
			</div>
			<div class="d4">
				<a href="#">本站首页</a>
			</div>
			<div class="d5">
				<a href="#">物流动态</a>
			</div>
			<div class="d6">
				<a href="#">物流知识</a>
			</div>
			<div class="d7">
				<a href="#">货物信息</a>
			</div>
			<div class="d8">
				<a href="#">车辆信息</a>
			</div>
			<div class="d9">
				<a href="#">企业信息</a>
			</div>
		</div>
       
 </body>
</html>
