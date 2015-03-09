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
	 * 作者：宋戈
	 * 完成日期：2011-7-21
	 * 模块功能：删除用户以及其货单
	 */
public class Sdeluser extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置字符类型。
		request.setCharacterEncoding("utf-8");
		//连接数据库
		String strClass = "com.mysql.jdbc.Driver";
		String strUrl = "jdbc:mysql://localhost:3306/logistics";
		String strUser = "songge";
		String strPwd = "123456";
		
		try {
			Class.forName(strClass);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connection conn = null;
		Statement st = null;
		//执行用于删除的sql语句。
		try {
			conn = DriverManager.getConnection(strUrl,strUser,strPwd);
			st = conn.createStatement();
			//删除goodlist中的货单
			st.executeUpdate("delete from goodslist where UserName='"+ new String(request.getParameter("sun").getBytes("ISO8859-1"),"utf-8")+"' ");
			//删除UID对应的用户
			st.execute("delete from manager where UID='"+ request.getParameter("id")+"' ");
			//跳转到显示页面的后台
			request.getRequestDispatcher("Ssuser").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//释放资源
			try {
				st.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
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
