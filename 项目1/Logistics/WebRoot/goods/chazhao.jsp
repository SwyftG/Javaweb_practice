<%@ page language="java" import="java.util.*" import= "javabean.goods" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'chazhao.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
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
    <center><h2>物品查找</h2></center>
  		<br/>
  		<form action="servlet/lvsearch2" method="post" >
			<table width="600" align="center" >
				<tr>
					<td width="100%">货物类型<select  name="goods_Type" id="type" />
							<option value="全部">全部</option>
							<option value="散装">散装</option>
 		 		<option value="液态">液态</option>
                     		<option value="生物类">生物类</option>
                     		<option value="低温冷藏">低温冷藏</option>
                     		<option value="箱式运输">箱式运输</option>
					</select>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						
						
						货物状态<select  name="goods_Status" id="status" />
						<option value="全部">全部</option>
						<option value="未装运" >未装运</option>
                     		<option value="已装运">已装运</option>
                     		
						</select>
									
									  
					</td>
					
					
				</tr>
				
			</table>
		

		<br/>
		
			<table width="600" align="center" id="mytable" cellspacing="0">
				<tr>
					<th width="15%">货物编号</th>
					<th width="15%">货物状态</th>
					<th width="15%">货物类型</th>
					<th width="15%">货物重量(t)</th>
					<th width="10%">货物所在地</th>
					<th width="10%">危险品</th>
					<th width="10%">备注信息</th>
					<th width="10%">编辑</th>
				</tr>
				<%
					List list  = (List)session.getAttribute("UL"); 
						if(!(list.size()==0)){
				    				for(int i = 0;i<list.size();i++)
				    	   		  {		
				    					goods goods = (goods)list.get(i);
				%>
<tr>
	<td class="alt"><%=goods.getGoods_ID() %>&nbsp;</td>
	<td class="alt"><%=goods.getGoods_Status() %>&nbsp;</td>
	<td class="alt"><%=goods.getGoods_Type()%>&nbsp;  </td>
	<td class="alt"><%=goods.getGoods_Weight() %>&nbsp; </td>
	<td class="alt"><%=goods.getGoods_Place() %>&nbsp;</td>
	<td class="alt"><%=goods.getDanger() %>&nbsp;</td>
	<td class="alt"><%=goods.getMsg() %>&nbsp;</td>
	
	<td class="alt"><a href="goods/bianji.jsp?id=<%=goods.getGoods_ID()%>&status=<%=goods.getGoods_Status()%>&type=<%=goods.getGoods_Type()%>&weight=<%=goods.getGoods_Weight()%>&place=<%=goods.getGoods_Place()%>&danger=<%=goods.getDanger()%>&msg=<%=goods.getMsg()%>">编辑</a></td>
	
</tr>
<%}}else{ %>
<tr>
<td>没有此类商品</td>
		
			
				</tr>
	   		
	   		<% 
	   		
	   		}
	   
	   %>

		<tr>
	
			<td colspan="8">
			<center>
					<input type="submit" id="" value="查  找" />
					<input type="button"  value="返  回" onclick='location.href("/Logistics/goods/blank.jsp")' />
			</center>
			</td>
		
		</tr>
	</table>
  		
  	</form>
  </body>
</html>
