package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
	/**
	 * 作者： 宋戈
	 * 完成日期：2011-7-21
	 * 模块功能：修改Admin管理员密码
	 */
public class Sadminpwd extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		

		// 数据库连接字符串
		String strClass = "com.mysql.jdbc.Driver";
		String strCon = "jdbc:mysql://localhost:3306/logistics";
		String strUser = "songge";
		String strPwd="123456";
		
		//修改密码的sql语句
		try {
			Class.forName(strClass);
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		Connection conn =null;
		Statement st =null;
		
		//释放变量st,e,conn.
		
		try {
			conn = DriverManager.getConnection(strCon,strUser,strPwd);
			st = conn.createStatement();
			st.executeUpdate("update manager set UserPwd='"+request.getParameter("pwd") +"' where UserName='Admin'" );
			request.getRequestDispatcher("/UserLogin/Admin.jsp").forward(request, response);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		finally{
			try {
				st.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

}
