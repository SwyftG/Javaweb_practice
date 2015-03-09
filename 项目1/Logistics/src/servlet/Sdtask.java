package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javabean.drive;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Sdtask extends HttpServlet {
	/*
	作者：李柳依
	时间：2011年7月20日
	模块功能：车辆管理系统*/
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//此后台完成的业务逻辑是查询登录的司机的所有尚未送达的货单任务。
		request.setCharacterEncoding("utf-8");
		//连接数据库
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
		
		try {
			
			conn = DriverManager.getConnection(strCon,strUser,strPwd);
			st = conn.createStatement();

			HttpSession session = request.getSession();
			String t=(String)session.getAttribute("llun");
			//执行sql查询语句。
			String sql =null;		
			sql="select * from goodslist where Username='"+t+"'and GlStatus!='已送达' order by GLStime";
			rs = st.executeQuery(sql);					
			//创建Arraylist对象。
			List list = new ArrayList();
			while(rs.next()){
		
						drive dv1=new drive();
						dv1.setGlstatus(rs.getString("GlStatus"));
						dv1.setGlId(rs.getInt("GLID"));
						dv1.setStime(rs.getString("GLStime"));
						list.add(dv1);			
			}
				//利用session传值。
				session.setAttribute("llAL", list);	
				
		}catch (Exception e) {
			
			e.printStackTrace();
		
		}finally{
			//关闭相应的资源。
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

			request.getRequestDispatcher("/UserLogin/Drvtask.jsp").forward(request, response);
			
		}
		
	}

}
