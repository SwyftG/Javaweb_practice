<%@ page language="java" import="java.util.*,javabean.goods"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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

		<title>货物管理界面</title>
	
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
	
		<link rel="stylesheet" href="/Logistics/css/allbg.css" type="text/css"></link>
		
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
		<%
			request.setCharacterEncoding("utf-8");
		%>
		<div id="cc" >
		<center>
		
			<h2>
				物品资料管理
			</h2>
		</center>
		<br />
		<form method="post">
			<table width="600" align="center" id="mytable" cellspacing="1">
				<tr>
					<th width="15%">
						货物编号
					</th>
					<th width="15%">
						货物状态
					</th>
					<th width="15%">
						货物类型
					</th>
					<th width="15%">
						货物重量(t)
					</th>
					<th width="10%">
						货物所在地
					</th>
					<th width="10%">
						危险品
					</th>
					<th width="10%">
						备注信息
					</th>
					<th width="10%">
						编辑
					</th>
				</tr>

				<%
					List list = (List) session.getAttribute("lvUL");
					if (list != null) {
						for (int i = 0; i < list.size(); i++) {
							goods goods = (goods) list.get(i);
				%>

				<tr>
					<td class="alt"><%=goods.getGoods_ID()%>&nbsp;
					</td>
					<td class="alt"><%=goods.getGoods_Status()%>&nbsp;
					</td>
					<td class="alt"><%=goods.getGoods_Type()%>&nbsp;
					</td>
					<td class="alt"><%=goods.getGoods_Weight()%>&nbsp;
					</td>
					<td class="alt"><%=goods.getGoods_Place()%>&nbsp;
					</td>
					<td class="alt"><%=goods.getDanger()%>&nbsp;
					</td>
					<td class="alt"><%=goods.getMsg()%>&nbsp;
					</td>
					<td class="alt">
						<a href="goods/bianji.jsp?id=<%=goods.getGoods_ID()%>&status=<%=goods.getGoods_Status()%>&type=<%=goods.getGoods_Type()%>&weight=<%=goods.getGoods_Weight()%>&place=<%=goods.getGoods_Place()%>&danger=<%=goods.getDanger()%>&msg=<%=goods.getMsg()%>">编辑</a>
					</td>

				</tr>

				<%
					}
						}
				%>

				<tr>

					<td colspan="8">
						<center>
							<input type="button" value="新增"
								onclick='location.href("xinzeng.jsp")' />
							<input type="button" id="" value="查找"
								onclick='location.href("/Logistics/servlet/lvsearch1")' />
					
						</center>

					</td>

				</tr>


			</table>

		</form>
		</div>
	</body>
</html>
