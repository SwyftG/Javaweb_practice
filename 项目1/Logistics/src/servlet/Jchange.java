/*
作者：刘嘉杰
时间：2011年7月20日
模块功能：货运调度安排编辑
*/
package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javabean.gdInfo;;
public class Jchange extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		doPost(request,response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		//创建javabean对象，用于存放前台输入的数据，然后把这些数据加到数据库中。
		gdInfo user = new gdInfo();
		user.setGLID(request.getParameter("gi"));
		user.setUserName(request.getParameter("sj"));
		user.setVhcLcs(request.getParameter("vl"));
		user.setGdID(request.getParameter("oc"));
		user.setSGyName(request.getParameter("ot"));
		user.setDGyName(request.getParameter("lc"));
		
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
			conn = DriverManager.getConnection(strCon,strUser,strPwd);
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		
		try {
			//执行sql语句中的编辑功能，修改数据
			PreparedStatement ps = conn.prepareStatement("update goodslist set UserName='"+user.getUserName()+"',VhcLcs='"+user.getVhcLcs()+"',SGyName='"+user.getSGyName()+"',GdID="+Integer.parseInt(user.getGdID())+",DGyName='"+user.getDGyName()+"' where GLID="+Integer.parseInt(user.getGLID())+";");
			ps.executeUpdate();
			request.getRequestDispatcher("Jve").forward(request, response);
			
		}catch (Exception e) {
			
			e.printStackTrace();
		
		}finally{
			
			try {
				//关闭资源
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
	
}


