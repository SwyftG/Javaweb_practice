/*
作者：刘嘉杰
时间：2011年7月20日
模块功能：货运调度安排查询
*/

package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javabean.gdInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Jmyserv extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		//连接数据库。
		String strClass = "com.mysql.jdbc.Driver";
		String strCon = "jdbc:mysql://192.168.1.31/logistics";
		String strUser = "hd";
		String strPwd="000000";
		
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
			 rs = st.executeQuery("select * from goodslist");		 
			
			 List list1 = new ArrayList();
			 while(rs.next())
				{	gdInfo cfd=new gdInfo();			    
					cfd.setSGyName(rs.getString("SGyName"));
					list1.add(cfd);
				}
			 session.setAttribute("JCD", list1);
			 
		} catch (SQLException e) {				
			e.printStackTrace();
		}finally{
			try {
				//关闭资源
				if(rs!=null)rs.close();
			} catch (SQLException e1) {
				
				e1.printStackTrace();    
			}
			
			try {
				if(st!=null)st.close();
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
			
			try {
				if(conn!=null)conn.close();
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
			
		}	
			request.getRequestDispatcher("/goodslist/found.jsp").forward(request, response);
	}
	
	}


