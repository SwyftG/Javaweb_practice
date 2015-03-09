<%@ page language="java" import="java.util.*,javabean.gdInfo" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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

		<title>My JSP 'display.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		
		function fun1()
		{	
			window.location.href='Jveh?jvi='+document.getElementById("vl2").value;
		
		}
	</script>
	
	<script type="text/javascript" src="/Logistics/javascript/ljj.js"></script>
	
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
	<body onload="fillSelect(1);fillSelect(2);">
		<form method="post" action="servlet/Jadd" onSubmit="return test()">
			<center>
			<table width="380" id="mytable" cellspacing="0" >
				<tr>
					<td width=45%>
						货单编号
						(自动生成)
						<input type="hidden" Name="status" value="已分配">
					</td>
					<td>
						司机
						<select name="sj">
							
							<%
								List list = (List) session.getAttribute("UL1");
								if (list != null) {
									for (int i = 0; i < list.size(); i++) {
										gdInfo user = (gdInfo) list.get(i);
							%>
							<option><%=user.getUserName()%></option>
							<%
								}
								}
							%>
						</select>
					</td>
				</tr>
				<tr>
					<td>
						车辆
					
						<select name="vl" id="vl2">
							
							<%
								List list2 = (List) session.getAttribute("UL2");
								if (list2 != null) {
									for (int i = 0; i < list2.size(); i++) {
										gdInfo user = (gdInfo) list2.get(i);
							%>
							<option value='<%=user.getVhcLcs()%>'><%=user.getVhcLcs()%></option>
						
						
							<%		}
								}
								
							%>
						</select>
					</td>
					<td colspan="2">
								<a href="javascript:fun1();">车辆信息</a>
					</td>	
					
				</tr>
				<tr>
					<td>
						出发地
					</td>
					<td>
						<select name="ot">
							
							<%
								List list3 = (List) session.getAttribute("UL3");
								if (list3 != null) {
									for (int i = 0; i < list3.size(); i++) {
										gdInfo user = (gdInfo) list3.get(i);
							%>
							<option><%=user.getSGyName()%></option>
							<%
								}
								}
							%>
						</select>
					</td>
				</tr>
				<tr>
					<td>
						目的地
					</td>
					<td>
						<select name="lc">
							
							<%
								if (list3 != null) {
									for (int i = 0; i < list3.size(); i++) {
										gdInfo user = (gdInfo) list3.get(i);
							%>
							<option><%=user.getDGyName()%></option>
							<%
								}
								}
							%>
						</select>
					</td>
				</tr>
				<tr>
					<td>
						货物
					</td>
					<td>
						<select name="oc">
							
							<%
								List list4 = (List) session.getAttribute("UL4");
								if (list4 != null) {
									for (int i = 0; i < list4.size(); i++) {
										gdInfo user = (gdInfo) list4.get(i);
							%>
							<option><%=user.getGdID()%></option>
							<%
									}
								}
							%>
						</select>
					</td>
				</tr>
				<tr>
					<td>
						预计里程
					</td>
					<td>
						<input type="Text" Name="km"size="5" maxlength="10" id="name">
						km
					</td>
				</tr>
				<tr>
					<td>
						预计发货时间
					</td>
					<td >
						<select name="tm1" id="year1" onchange="fillDate(1)"></select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <select name="tm2" id="month1" onchange="fillDate(1)"></select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <select name="tm3" id="day1"></select>
					</td>
				</tr>
				<tr>
					<td>
						预计到货时间
					</td>
					<td>
						<select name="tm4" id="year2" onchange="fillDate(2)"></select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <select name="tm5" id="month2" onchange="fillDate(2)"></select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <select name="tm6" id="day2"></select>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<br/><center><INPUT TYPE="submit" VALUE="确 认" size="8"  >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<INPUT TYPE="reset" VALUE="重 置" size="8"></center>
					</td>
				</tr>
			</table></center>
		</form>
	</body>
</html>
