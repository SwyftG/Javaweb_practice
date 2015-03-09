 <%@ page language="java" import="java.util.*,javabean.lvg"  import="java.sql.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!--
作者：李唯
时间：2011年7月20日
模块功能：货物管理系统
-->

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html> 
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'xinzeng.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="/Logistics/css/allbg.css" />
	<script type="text/javascript" src="/Logistics/javascript/vvjs.js">

	</script>
	<script type="text/javascript" src="/Logistics/javascript/vv1.js"></script>
	
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
	
	<link rel="stylesheet" href="css/ts.css" type="text/css"></link>
	</head>
 

  <body>
  <div id="allbg">
    <center><h2>新增货物信息</h2></center>
    		<br/>
    		<form action="servlet/lvadd" method="post" name="form1" onSubmit="return Submit()" >
    			<table width="300" align="center" >
    				<tr>
    					<td width="40%">货物编号</td>
    					<td width="60%">（自动生成）</td>
    					
    				</tr>
				<tr>
					<td>
						货物类型
					</td>
					<td>
						<select name="goods_Type" id="type"><option value="散装">散装</option>
				 		 		<option value="液态">液态</option>
                         		<option value="生物类">生物类</option>
                         		<option value="低温冷藏">低温冷藏</option>
                         		<option value="箱式运输">箱式运输</option>
                         </select>
					</td>
					
				</tr>
				<tr>
					<td>
						货物重量
					</td>
					<td>
						<input type="text" name="goods_Weight" id="weight"/>
					</td>
					
				</tr>
				<tr>
					<td>
						货物所在地
					</td>
					<td>
						<select name="goods_Place" id="place">
							
							<%
								List list3 = (List) session.getAttribute("lvUL3");
								if (list3 != null) {
									for (int i = 0; i < list3.size(); i++) {
										lvg user = (lvg) list3.get(i);
							%>
							<option><%=user.getAddress()%></option>
							<%
								}
								}
							%>
						</select>
						
					</td>
					
				</tr>
				
				<tr>
					<td>
						危险品
					</td>
					<td>
						<input type="radio" name="danger" value="是" /> 是
						<input type="radio" name="danger" value="否" checked="checked" /> 否
					</td>
					
				</tr>
				<tr>
					<td>
						状态
					</td>
					<td>
						<input type="text" value="未装运" name="goods_Status" id="status"
			  />
					</td>
					
				</tr>
				
				<tr>
					<td>
						备注信息
					</td>
					<td>
						<textarea rows="5" cols="17" name="msg"></textarea>
					</td>
					
				</tr>
				<tr>
					
					<td colspan="3">
						<center>
								<br/><input type="submit"  value="提  交" onclick="return nimei()" />&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="button"  value="返  回" onclick='location.href("blank.jsp")'  />
								
						</center>
						
					</td>
					
				</tr>
			</table>
    		
    		</form>
   </div>
  </body>
</html>
