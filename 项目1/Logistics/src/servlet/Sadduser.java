package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javabean.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 作者： 宋戈
 * 完成日期：2011-7-21
 * 模块功能：添加用户
 */
public class Sadduser extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");//字符
		// 将用户在前台输入的内容填充给用户模型文件。
		User user= new User();
		user.setUsername(request.getParameter("name"));
		user.setUserpwd(request.getParameter("pwd"));
		user.setUserquanxian(request.getParameter("quanxian"));
		
		String strClass = "com.mysql.jdbc.Driver";
		String strUrl = "jdbc:mysql://localhost:3306/logistics";
		String strUser = "songge";
		String strPwd="123456";
		
		//加载驱动类
		try {
			Class.forName(strClass);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		Connection conn = null;
		Statement st = null;
		
		
		 try {
			// 数据库连接对象。
			conn = DriverManager.getConnection(strUrl,strUser,strPwd);
			// Statement对象来执行sql语句。
			st = conn.createStatement();
			//取得用户信息
			String name=user.getUsername();
			String pwd=user.getUserpwd();
			String power=user.getUserquanxian();
			//执行添加语句
			PreparedStatement pst=conn.prepareStatement("insert into manager (UserName,UserPwd,UserPower) values (?,?,?)");
			pst.setString(1, name);
			pst.setString(2, pwd);
			pst.setString(3, power);
			pst.executeUpdate();
			request.getRequestDispatcher("Ssuser").forward(request, response);
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				st.close();
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
