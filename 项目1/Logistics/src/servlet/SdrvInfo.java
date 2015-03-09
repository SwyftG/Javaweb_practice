package servlet;

import java.sql.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javabean.drive;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/*
作者：李柳依
时间：2011年7月20日
模块功能：车辆管理系统*/

public class SdrvInfo extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//此后台的完成的业务逻辑是司机任务的详细信息查询。
		request.setCharacterEncoding("utf-8");
		//连接数据库。
		String strClass = "com.mysql.jdbc.Driver";
		String strCon = "jdbc:mysql://192.168.1.31/logistics";
		String strUser = "hd";
		String strPwd = "000000";
		
		
		try {
			Class.forName(strClass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection conn =null;
		Statement st =null;
		ResultSet rs = null;
		try{
			conn = DriverManager.getConnection(strCon,strUser,strPwd);
			st = conn.createStatement();
			//执行sql查询语句。
			String sql =null;		
			sql="select * from goodslist join goods on goodslist.GdID=goods.GdID where GLId='"+request.getParameter("tk")+"'";
			rs = st.executeQuery(sql);					
			//创建Arraylist对象,承载查询结果集，传给前台。
			HttpSession session= request.getSession();
			List list = new ArrayList();
			drive dv1=new drive();
			if(rs.next()){
						dv1.setGlstatus(rs.getString("GlStatus"));
						//数据库中的GLID字段是int型。
						dv1.setGlId(rs.getInt("GLID"));
						dv1.setVhclcs(rs.getString("VhcLcs"));
						dv1.setSname(rs.getString("SGyName"));
						dv1.setDname(rs.getString("DGyName"));
						dv1.setStime(rs.getString("GLStime"));
						dv1.setDtime(rs.getString("GLDtime"));
						dv1.setDanger(rs.getString("GdDanger"));
						dv1.setRmk(rs.getString("GdRmk"));
						list.add(dv1);			
			}
			//利用session传值。
			session.setAttribute("llDL", list);
			//如果司机货单任务是已分配的状态，跳转至huowu.jsp页面，否则跳转至已确认状态对应的huowu2.jsp页面。
			if("已分配".equals(dv1.getGlstatus())){
				request.getRequestDispatcher("/UserLogin/huowu.jsp").forward(request, response);
			}else{
				request.getRequestDispatcher("/UserLogin/huowu2.jsp").forward(request, response);
			}
			
		}catch (Exception e) {
			
			e.printStackTrace();
		
		}finally{
			//关闭相应资源。
			try {
				if(rs!=null)rs.close();
			
			}catch (Exception e1) {
				
				e1.printStackTrace();
			}
			
			try {
				if(st!=null)st.close();
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
			
			try {
				if(conn!=null)conn.close();
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
	
		}
		
	}

}
