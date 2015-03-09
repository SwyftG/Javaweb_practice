package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javabean.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

	/**
	 * 作者：宋戈
	 * 完成日期：2011-7-21
	 * 模块功能：实现登录的后台代码
	 */
public class Sguanli extends HttpServlet {

		public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置汉字字符。
		request.setCharacterEncoding("utf-8");
		//定义一个判断是否登录的标志。
		String Flag=null;
		String quanxian=null;
		boolean loginFlag=false;
		
		User user = new User();
		// 设定用户名
		user.setUsername(request.getParameter("username"));
		// 设定密码
		user.setUserpwd(request.getParameter("userpwd")); 
		//设定权限
		user.setUserquanxian(request.getParameter("quanxian"));  
		//连接数据库
		String strClass = "com.mysql.jdbc.Driver";
		String strUrl = "jdbc:mysql://localhost/logistics";
		String strUser = "songge";
		String strPwd = "123456";

		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			
			Class.forName(strClass);
			conn = DriverManager.getConnection(strUrl,strUser,strPwd);
			st = conn.createStatement();
			//从数据库中取出和输入信息相符的信息并计数
			String strsql = "select count(*) as count1 from manager where UserName = '" + user.getUsername() + "' and UserPwd = '" + user.getUserpwd() + "' and UserPower = '"+user.getUserquanxian() + "'";
			rs = st.executeQuery(strsql);	
			if(rs.next())
			{                                  
				// 从查询结果集中获得数量。
				int count = rs.getInt("count1");
				 // 根据结果判断是否身份正确。
				if(count>0)
				{
					loginFlag=true;
					Flag="ok";
				}
				
			}
			//把登录标志放进session
			HttpSession session =request.getSession();
			session.setAttribute("llun", user.getUsername()); 
			session.setAttribute("Flag", Flag);
			
			String quan=user.getUserquanxian();
			if(loginFlag&&("司机".equals(quan))){
				//设置权限值
				quanxian="siji";
				session.setAttribute("vvquanxian",quanxian );
				//跳转到内部界面
				request.getRequestDispatcher("/root.jsp").forward(request, response);
				
			}
			else if(loginFlag&&("管理员".equals(quan))){
				//设置权限值
				quanxian="g";
				session.setAttribute("vvquanxian",quanxian );
				//跳转到内部界面
				request.getRequestDispatcher("/root.jsp").forward(request, response);
			}
			else if(loginFlag&&(quan==null)){
				//设置权限值
				quanxian="admin";
				session.setAttribute("vvquanxian",quanxian );
				//Admin的管理界面
				request.getRequestDispatcher("/root.jsp").forward(request, response);
			}else{
				//登录失败的界面
				request.getRequestDispatcher("/UserLogin/fail.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//释放资源
			if(rs != null)
			{
				try {
					rs.close();
				} catch (SQLException e) {	
					e.printStackTrace();
				}
				try {
					st.close();
				} catch (SQLException e) {	
					e.printStackTrace();
				}
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}		
		
	}

}
