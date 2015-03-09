<%@ page language="java" import="java.util.*,javabean.gdInfo"
	pageEncoding="utf-8"%>
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

		<title>My JSP 'index.jsp' starting page</title>
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
			<h1>
				货运查询
			</h1>

			<form method="post" action="servlet/Jve">
				<table >

					<tr>
						<td>
							货单编号：
						</td>
						<td>
							<input type="text" name="gi" />
						</td>
						<td>
							出发地：
						</td>
						<td>
							<select name="ot">
								<option selected="selected">
									全部
								</option>
								<%
								List list1 = (List) session.getAttribute("JCD");
								if (list1 != null) {
									for (int i = 0; i < list1.size(); i++) {
									
										gdInfo user = (gdInfo)list1.get(i);
								%>
							<option><%=user.getSGyName()%></option>
								<%
									}
								}
								%>
							</select>
						</td>
						<td width="15%" align="right">
							分配状态：
						</td>
						<td width="15%">
							<select name="vt">
								<option selected="selected">
									全部
								</option>
								<option>
									已分配
								</option>
								<option>
									已确认
								</option>
								<option>
									已送达
								</option>
							</select>
						</td>
						<td width="13%">
							<input type="submit" value="查 找" />
						</td>
					</tr>
				</table>

			</form>

			<table border="1" id="mytable" cellspacing="0">
				<tr>
					<th width=11%>
						货单编号
					</th>
					<th width=7%>
						司机
					</th>
					<th>
						车辆
					</th>
					<th>
						出发地
					</th>
					<th>
						目的地
					</th>
					<th>
						货物
					</th>
					<th width=7%>
						距离
					</th>
					<th width="11%">
						出发时间
					</th>
					<th width="11%">
						到达时间
					</th>
					<th width=7%>
						状态
					</th >
					<th width=13%>
						编辑|删除
					</th>
				</tr>
				<%
					request.setCharacterEncoding("utf-8");
				%>
				<%
					List list = (List) session.getAttribute("jUL");
					if (list != null) {
						for (int i = 0; i < list.size(); i++) {
							gdInfo info = (gdInfo) list.get(i);
				%>
				<tr>
					<td class="alt"><%=info.getGLID()%></td>
					<td class="alt"><%=info.getUserName()%></td>
					<td class="alt"><%=info.getVhcLcs()%></td>
					<td class="alt"><%=info.getSGyName()%></td>
					<td class="alt"><%=info.getDGyName()%></td>
					<td class="alt"><%=info.getGdID()%></td>
					<td class="alt"><%=info.getGLKm()%></td>
					<td class="alt"><%=info.getGLStime()%></td>
					<td class="alt"><%=info.getGLDtime()%></td>
					<td class="alt"><%=info.getGlStatus()%></td>
					
					<td class="alt">
						<a href="servlet/Jchser?gi=<%=info.getGLID()%>&cc=<%=i%>">编辑</a>|
						<a href="servlet/Jdel?vl=<%=info.getGLID()%>&ct=<%=i%>" onclick="javascript:return confirm('确认删除？')">删除</a>
					</td>
				</tr>
				<%
						}
					}else {
				%>
				<tr>
					<td class="alt" colspan="11">
						没有任何记录
					</td>
				</tr>
				<%
					}
				%>

			</table>
			<br />
		</center>
		
	</body>
</html>
