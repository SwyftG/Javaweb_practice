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

import javabean.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
	
	/**
	 * 作者： 宋戈
	 * 完成日期：2011-7-21
	 * 模块功能：显示所有的用户信息
	 */

public class Ssuser extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置汉字字符
		request.setCharacterEncoding("utf-8");
		
		// 驱动类的名称
		String strClass = "com.mysql.jdbc.Driver";
		String strCon = "jdbc:mysql://192.168.1.31:3306/logistics";
		String strUser = "songge";
		String strPwd="123456";
		// 定义一个集合对象。。。
		List list = new ArrayList();
		// 加载驱动类
			try {
				Class.forName(strClass);
			} catch (ClassNotFoundException e) {

				e.printStackTrace();
			}
			Connection conn =null;
			Statement st =null;
			ResultSet rs = null;
			try {
				// 数据库连接对象。
				 conn = DriverManager.getConnection(strCon,strUser,strPwd);
				// Statement对象来执行sql语句。
				st = conn.createStatement();				 
				rs = st.executeQuery("select * from manager");
				
				// 遍历结果集中的内容
				while(rs.next())
				{
					User user = new User();
					user.setUserid(rs.getInt("UID"));
					user.setUsername(rs.getString("UserName"));
					user.setUserpwd(rs.getString("UserPwd"));
					user.setUserquanxian(rs.getString("UserPower"));
					list.add(user);
				}
				HttpSession session = request.getSession();
				session.setAttribute("SUL", list);
				
			
			} catch (SQLException e) {
				
				e.printStackTrace();
			}finally{
				// 关闭相应资源
				try {
					rs.close();
				} catch (SQLException e1) {
					
					e1.printStackTrace();    
				}
				
				try {
					st.close();
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
				try {
					conn.close();
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
			}
			//跳转到显示的前台页面
			request.getRequestDispatcher("/UserLogin/editUser.jsp").forward(request, response);
	}


}
