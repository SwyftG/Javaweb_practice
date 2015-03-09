<%@ page language="java" import="java.util.*"  pageEncoding="utf-8" %>
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
    <base href="<%=basePath %>">
    
    <title>My JSP 'bianji.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="css/ts.css" type="text/css"></link>
	<script type="text/javascript" src="/Logistics/javascript/vvjs.js"></script>
	<script type="text/javascript" src="/Logistics/javascript/vv1.js"></script>
 </head>
  
  <body>
    <center><h2>编辑货物信息</h2></center>
    		<br/>
    		<form action="servlet/lvedit" method="post" onSubmit="return canSubmit()" name="form1"  >
    			<table width="300" align="center" id="mytable" >
    				<tr>
    					<td width="40%">货物编号</td>
    					<td width="60%"><%=request.getParameter("id")%><input type="hidden" name="goods_ID" size="15" maxlength="6" id="id" value="<%=request.getParameter("id")%>" /></td>
    					
    				</tr>
				<tr>
					<td>
						货物类型
					</td>
					<td>
					<%if((new String(request.getParameter("type").getBytes("ISO8859-1"),"utf-8")).equals("散装")){
                	%>	<select name="goods_Type" id="type" >
						<option value="散装" selected="selected">散装</option>
				 		 		<option value="液态">液态</option>
                         		<option value="生物类">生物类</option>
                         		<option value="低温冷藏">低温冷藏</option>
                         		<option value="箱式运输">箱式运输</option>
					</select>
                	<%}
                	else if((new String(request.getParameter("type").getBytes("ISO8859-1"),"utf-8")).equals("液体")){
                	%>	<select name="goods_Type" id="type" >
						<option value="散装" >散装</option>
				 		 		<option value="液态" selected="selected">液态</option>
                         		<option value="生物类">生物类</option>
                         		<option value="低温冷藏">低温冷藏</option>
                         		<option value="箱式运输">箱式运输</option>
					</select>
					<%}
                	else if((new String(request.getParameter("type").getBytes("ISO8859-1"),"utf-8")).equals("生物类")){
                	%>	<select name="goods_Type" id="type" >
						<option value="散装" >散装</option>
				 		 		<option value="液态" >液态</option>
                         		<option value="生物类" selected="selected">生物类</option>
                         		<option value="低温冷藏">低温冷藏</option>
                         		<option value="箱式运输">箱式运输</option>
					</select>
					<%}
                	else if((new String(request.getParameter("type").getBytes("ISO8859-1"),"utf-8")).equals("低温冷藏")){
                	%>	<select name="goods_Type" id="type" >
						<option value="散装" >散装</option>
				 		 		<option value="液态" >液态</option>
                         		<option value="生物类">生物类</option>
                         		<option value="低温冷藏" selected="selected">低温冷藏</option>
                         		<option value="箱式运输">箱式运输</option>
					</select>
					
                	<%}else{
                	%>	<select name="goods_Type" id="type" >
						<option value="散装" >散装</option>
				 		 		<option value="液态" >液态</option>
                         		<option value="生物类">生物类</option>
                         		<option value="低温冷藏">低温冷藏</option>
                         		<option value="箱式运输" selected="selected">箱式运输</option>
					</select>
                	<%}%>
						
					</td>
					
				</tr>
				<tr>
					<td>
						货物重量
					</td>
					<td>
						<input type="text" name="goods_Weight"  id="weight"  value="<%=request.getParameter("weight")%>"/>
					</td>
					
				</tr>
				<tr>
					<td>
						货物所在地
					</td>
					<td>
						<input type="text" name="goods_Place"  id="place" value="<%=new String(request.getParameter("place").getBytes("ISO8859-1"),"utf-8")%>"/>
					</td>
					
				</tr>
				
				<tr>
					<td>
						危险品
					</td>
					  <%	if((new String(request.getParameter("danger").getBytes("ISO8859-1"),"utf-8")).equals("是")){
	            %>		
	            		<td >
		                	是：<input type="radio" name="danger" value="是"  checked="checked"/>
		                	否：<input type="radio" name="danger" value="否"/>
	                	</td>
                <% 	}else{
	            %>		
	            		<td >
		                	是：<input type="radio" name="danger" value="是"  />
		                	否：<input type="radio" name="danger" value="否" checked="checked"/>
	                	</td>
                <%	} %>
					
					
				</tr>
				<tr>
					<td>
						状态
					</td>
					<td>
						<input type="text" value="未装运" name="goods_Status" id="status"value="<%=request.getParameter("status")%>"
			  />
					</td>
					
				</tr>
				
				<tr>
					<td>
						备注信息
					</td>
					<td>
						<textarea rows="5" cols="17" name="msg" ><%=new String(request.getParameter("msg").getBytes("ISO8859-1"),"utf-8")%></textarea>
					</td>
					
				</tr>

				<tr>
					
					<td colspan="2">
						<center>
								<br/><input type="submit"  value="提  交" onclick="return nimei()" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="button"  value="返  回"  onclick='location.href("blank.jsp")'/>
						</center>
						
					</td>
					
				</tr>
			</table>
    		
    		</form>
    		
			
			
  </body>
</html>
