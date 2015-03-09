/*
作者：刘嘉杰
时间：2011年7月20日
模块功能：货运调度安排删除
*/
package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javabean.gdInfo;
public class Jdel extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		//从servlet中执行删除功能
		gdInfo info = new gdInfo();
		info.setGLID(request.getParameter("vl"));
		//i是在前台显示页面的欲删除记录的list的记录项号，以便在返回给前台的list中删除此项。
		int i=Integer.parseInt(request.getParameter("ct"));
		
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
		
		try {
			//执行sql语句
			conn = DriverManager.getConnection(strCon,strUser,strPwd);
			st = conn.createStatement();
			
			String s="delete from goodslist where GLID="+Integer.parseInt(info.getGLID())+";";
			st.executeUpdate(s);
			
			//获取在前台显示的查询结果，删除第记录号为i的项
			HttpSession session =request.getSession();			
			List list  = (List)session.getAttribute("jUL"); 
			list.remove(i);
			request.getRequestDispatcher("Jve").forward(request, response);
		
		}catch (Exception e) {
			
			e.printStackTrace();
		
		}finally{
			//关闭相映资源
			try {
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
