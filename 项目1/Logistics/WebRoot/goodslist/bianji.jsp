<%@ page language="java" import="java.util.*,javabean.gdInfo"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
	request.setCharacterEncoding("utf-8");
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

		<title>My JSP 'chanVehicle.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="css/ts.css" type="text/css"></link>
	</head>
	<body>
		<center>
			<h2> 
				ljiaji货单编辑： 
			</h2>
		</center>
		<br />
		<form action="servlet/Jchange" method="post">
			<table width="400" height="200" align="center" id="mytable" cellspacing="0">
				<tr>
					<td>
						货单编号：
					</td>
					<td>
						<input type="text" maxlength="20" name="gi" value="<%=request.getParameter("gi")%>" readonly="readonly" size="10"/>
					</td>
					<td>
						司机：
					</td>
					<td>
						<select name="sj">
							<option value="-1">
								请选择
							</option>
							<%	
								//list用来获取对应编辑的数据,方便页面初始化。								
								List list = (List) session.getAttribute("jUL");
								gdInfo in = (gdInfo)list.get(Integer.parseInt(request.getParameter("cc")));
								
								List list1 = (List)session.getAttribute("JUL1");
								if (list1!= null) {
									for (int i = 0; i < list1.size(); i++) {
										gdInfo user = (gdInfo)list1.get(i);
										if(in.getUserName().equals(user.getUserName())){%>
										<option selected="selected"><%=user.getUserName()%></option>
										<%
										}else{%>
											<option><%=user.getUserName()%></option>
									  <%}	
									}
									
								}
								
							%>
						</select>
					</td>
				</tr>
				<tr>
					<td>
						车辆牌照：
					</td>
					<td>
						<select name="vl">
							<option value="-1">
								请选择
							</option>
							<%	
								//list用来获取对应编辑的数据,方便页面初始化。								
								List list2 = (List)session.getAttribute("JUL2");
								if (list2!= null) {
									for (int i = 0; i < list2.size(); i++) {
										gdInfo user = (gdInfo)list2.get(i);
										if(in.getVhcLcs().equals(user.getVhcLcs())){%>
										<option selected="selected"><%=user.getVhcLcs()%></option>
										<%
										}else{%>
											<option><%=user.getVhcLcs()%></option>
									  <%}	
									}
									
								}
								
							%>
						</select>
					</td>
					<td>
						货号：
					</td>
					<td>
						<select name="oc">
							<option value="-1">
								请选择
							</option>
							<%	 
								//list用来获取对应编辑的数据,方便页面初始化。								
								List list4 = (List)session.getAttribute("JUL4");
								if (list4!= null) {
									for (int i = 0; i < list4.size(); i++) {
										gdInfo user = (gdInfo)list4.get(i);
										if(in.getGdID().equals(user.getGdID())){%>
										<option selected="selected"><%=user.getGdID()%></option>
										<%
										}else{%>
											<option><%=user.getGdID()%></option>
									  <%}	
									}
								}
							%>
						</select>
					</td>
				</tr>
				<tr>
					<td>
						出发地：
					</td>
					<td>
						<select name="ot">
							<option value="-1">
								请选择
							</option>
							<%	
								//list用来获取对应编辑的数据,方便页面初始化。								
								List list3 = (List)session.getAttribute("JUL3");
								if (list3!= null) {
									for (int i = 0; i < list3.size(); i++) {
										gdInfo user = (gdInfo)list3.get(i);
										if(in.getSGyName().equals(user.getSGyName())){%>
										<option selected="selected"><%=user.getSGyName()%></option>
										<%
										}else{%>
											<option><%=user.getSGyName()%></option>
									  <%}	
									}
								}
							%>
						</select>
					</td>
					<td>
						目的地：
					</td>
					<td>
						<select name="lc">
							<option value="-1">
								请选择
							</option>
							<%	
								//list用来获取对应编辑的数据,方便页面初始化。								
								if (list3!= null) {
									for (int i = 0; i < list3.size(); i++) {
										gdInfo user = (gdInfo)list3.get(i);
										if(in.getDGyName().equals(user.getDGyName())){%>
										<option selected="selected"><%=user.getDGyName()%></option>
										<%
										}else{%>
											<option><%=user.getDGyName()%></option>
									  <%}	
									}
								}
							%>
						</select>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<br />
						<input type="submit" value="修 改" />
					</td>
					<td colspan="2" align="center">
						<br />
						<input type="reset" value="重  置" />
					</td>
				</tr>
			</table>
			<a href="javascript:history.go(-1)">返回上一页面</a>
		</form>
	</body>
</html>
