package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
	 * 模块功能：编辑用户信息
	 */

public class Sedituser extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置汉字字符
		request.setCharacterEncoding("utf-8");

		
		//连接数据库
		String strClass = "com.mysql.jdbc.Driver";
		String strUrl = "jdbc:mysql://localhost:3306/logistics";
		String strUser = "songge";
		String strPwd="123456";
		
		List list = new ArrayList();
		//加载驱动类
		try {
			Class.forName(strClass);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connection conn = null;
		Statement st = null;
	
	
	
	 		
		// 数据库连接对象。
		try {
			conn = DriverManager.getConnection(strUrl,strUser,strPwd);
			st = conn.createStatement();
	
		
			
			//获取修改后的用户名，密码，权限和ID。
			User user1=new User();
			user1.setUsername(request.getParameter("name2"));			
			user1.setUserquanxian(request.getParameter("quanxian"));			
			user1.setUserpwd(request.getParameter("pwd1"));			
			user1.setUserid(Integer.parseInt(request.getParameter("hi")));
			
	
			String name=user1.getUsername();
			String pwd=user1.getUserpwd();			
			//修改用户信息的sql语句
			PreparedStatement pst=conn.prepareStatement(" update manager set UserName=? , UserPwd=? ,UserPower='"+ user1.getUserquanxian()+"' where UID='"+ user1.getUserid()+"'");
		
			pst.setString(1, name);
			pst.setString(2, pwd);
			pst.executeUpdate();			
			//跳转到显示页面的后台
			request.getRequestDispatcher("Ssuser").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//释放资源
		try {
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
					
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
