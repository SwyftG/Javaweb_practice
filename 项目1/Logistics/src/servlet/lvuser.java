/*
���ߣ���Ψ
ʱ�䣺2011��7��20��
ģ�鹦�ܣ��������ϵͳ*/
package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javabean.User;
import javabean.goods;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class lvuser extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		
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
		// ʢ�Ų�ѯ����Ľ����
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(strCon,strUser,strPwd);
			st = conn.createStatement();
			String sql =null;		
			
			conn = DriverManager.getConnection(strCon,strUser,strPwd);
			// Statement������ִ��sql��䡣
			st = conn.createStatement();	
			// ִ�в�ѯ
			HttpSession session=request.getSession();
			String vvid=(String)session.getAttribute("llun");
			rs = st.executeQuery("select * from manager where UserName ='"+vvid+"'");
			
			
			List list = new ArrayList();
			
				while(rs.next()){
					User user1 = new User();
					user1.setUserid(rs.getInt("UID"));
					user1.setUsername(rs.getString("UserName"));
					user1.setUserquanxian(rs.getString("UserPower"));
					list.add(user1);
				}
			
				session.setAttribute("lvuser", list);
				request.getRequestDispatcher("/main.jsp").forward(request, response);
			
		}catch (Exception e) {
			
			e.printStackTrace();
		
		}finally{
			try {
				if(rs!=null)rs.close();
			
			}catch (Exception e1) {
				
				e1.printStackTrace();
			}
			
			try {
				if(st!=null)st.close();
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
			
			try {
				if(conn!=null)conn.close();
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}

		
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
		
	}

}
