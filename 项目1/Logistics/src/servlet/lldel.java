package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javabean.VeInfo;
public class lldel extends HttpServlet {
	/*
	作者：李柳依
	时间：2011年7月20日
	模块功能：车辆管理系统*/	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		//此servlet完成的业务逻辑是删除数据库中车辆记录。
		VeInfo info = new VeInfo();
		info.setVhcLcs(request.getParameter("vl"));
		//i是在前台显示页面的欲删除记录的list的记录项号，以便在返回给前台的list中删除此项。
		int i=Integer.parseInt(request.getParameter("ct"));
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
		
		try {
			//执行sql删除语句。
			conn = DriverManager.getConnection(strCon,strUser,strPwd);
			st = conn.createStatement();
			String s="delete from vehicle where VhcLcs='"+info.getVhcLcs()+"';";
			st.executeUpdate(s);
			//获取在前台显示的查询结果，删除第记录号为i的项，跳转至具有查询功能的llsrcveh servlet页面。
			HttpSession session =request.getSession();
			List list  = (List)session.getAttribute("lsUL"); 
			list.remove(i);
			request.getRequestDispatcher("llsrcveh").forward(request, response);
		
		}catch (Exception e) {
			
			e.printStackTrace();
		
		}finally{
			
			try {
				//关闭相应资源。
				st.close();
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
			
			try {
				conn.close();
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
		}	
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}
	
}
