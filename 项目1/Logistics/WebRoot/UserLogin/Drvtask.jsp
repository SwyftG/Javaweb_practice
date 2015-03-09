<%@ page language="java" import="java.util.*,javabean.drive" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>司机任务</title>

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
		if(qx!="siji"){
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
		<%
			List list = (List) session.getAttribute("llAL");
		%>
		<table width="700" cellspacing="0" id="mytable">
			<tr>
				<th>
					货单号
				</th>
				<th>
					出发时间
				</th>
				<th>
					货物状态
				</th>
				<th>
					任务详细信息
				</th>
			</tr>
			<%
				if (list != null) {
					for (int i = 0; i < list.size(); i++) {
						drive drv = (drive) list.get(i);
			%>
			<tr>
				<td class="alt"><%=drv.getGlId()%></td>
				<td class="alt"><%=drv.getStime()%></td>
				<td class="alt"><%=drv.getGlstatus()%></td>
				<td class="alt">
					<a href="servlet/SdrvInfo?tk=<%=drv.getGlId()%>">任务详细信息</a>
				</td>
			</tr>
			<%
					}
				} else {
			%>
			<tr>
				<td class="alt" colspan="4">
					没有任务
				</td>
			</tr>
		</table>
		<%
				}
		%>
	</body>
</html>
