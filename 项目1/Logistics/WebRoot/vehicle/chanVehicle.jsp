<%@ page language="java" import="java.util.*,javabean.VeInfo" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!--
作者：李柳依
时间：2011年7月20日
模块功能：车辆管理系统
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
	

  <script type="text/javascript" src="javascript/vehc.js"></script>
  <link rel="stylesheet" href="css/ts.css" type="text/css"></link>
  </head>
  
  <!--实现车辆信息的编辑：从searchVehicle.jsp文件中获 值来进行页面初始化，表单提交到serv/editVehicle中实现编辑功能。-->
 
 <body>
   <center><h2>车辆信息编辑：</h2></center><br/>
    <form action="servlet/lledit" method="post" onsubmit="return test()">
       <table class="cvh" id="mytable">
			<tr>
				<td width="20%" >
                	车辆型号：
                </td>
                <td width="30%">
                	<input type="text" maxlength="20" name="vf" value="<%=request.getParameter("vf")%>" id="vf"/>
                </td>
                <td width="20%" >
                	车辆牌照：（不可修改）
                </td>
                <td width="30%">
                	<input type="text" name="vl" id="vf" value="<%=request.getParameter("vl")%>" readonly="readonly"/>
                </td>
			</tr>
              <tr>
                <td>
                	燃油类型：
                </td>
                <td>
                	<%if( (new String(request.getParameter("ot").getBytes("ISO8859-1"),"utf-8")).equals("汽油")){
                	%>	<select name="ot" >
						<option selected="selected">汽油</option>
						<option>柴油</option>
					</select>
                	<%}else{
                	%>	
                	<select name="ot" >
						<option >汽油</option>
						<option selected="selected">柴油</option>
					</select>
                	<%}%>
                </td>
                <td>
                	耗油量(升/百公里)：
                </td>
                <td>
                	<input type="text" name="oc" id="oc" value="<%=request.getParameter("oc")%>"/>
                </td>
              </tr>
              <tr>
                <td>
                	车辆类型：
                </td>
                <td>
                	<%if( (new String(request.getParameter("vt").getBytes("ISO8859-1"),"utf-8")).equals("普通")){
                	%>	<select name="vt" >
						<option selected="selected">普通</option>
						<option>油罐</option>
						<option>箱式</option>
					</select>
                	<%}
                	else if((new String(request.getParameter("vt").getBytes("ISO8859-1"),"utf-8")).equals("油罐")){
                	%>	<select name="vt" >
						<option >普通</option>
						<option selected="selected">油罐</option>
						<option>箱式</option>
					</select>
                	<%}else{
                	%>	<select name="vt" >
						<option >普通</option>
						<option >油罐</option>
						<option selected="selected">箱式</option>
					</select>
                	<%}%>
				</td>
                <td>
                	载重量(t)：
                </td>
                <td>
                	<input type="text" name="lc" id="lc" value="<%=request.getParameter("lc")%>"/>
                </td>
              </tr>
              <tr>
                <td>
                	车辆特种：
                </td>
	                <%	if(request.getParameter("vs").equals("true")){
		            %>		
		            		<td colspan="3">
			                	是：<input type="radio" name="vs" id="vs1" value="true"  checked="checked"/>
			                	否：<input type="radio" name="vs" id="vs2" value="false"/>
		                	</td>
	                <% 	}else{
		            %>		
		            		<td colspan="3">
			                	是：<input type="radio" name="vs" id="vs1" value="true" />
			                	否：<input type="radio" name="vs" id="vs2" value="false" checked="checked"/>
		                	</td>
	                <%	} %>
                
             </tr>
             <tr>
                <td>备注信息：</td>
                <td colspan="3">
                	<textarea rows="5" cols="67" name="vr"/><%=new String(request.getParameter("vr").getBytes("ISO8859-1"),"utf-8")%></textarea>
                </td>
              </tr>
             
              <tr>
                <td colspan="2" align="center">
                   <br/><input type="submit" value="修 改"/>
                </td>
                <td colspan="2" align="center">
                	<br/><input type="reset" value="清 除"/>
                </td>
              </tr>
        </table>
      
    </form>
   
     <a href="javascript:history.go(-1)">返回上一页面</a>
  </body>
</html>
