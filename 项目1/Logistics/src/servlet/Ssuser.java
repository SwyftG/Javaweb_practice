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
	 * ���ߣ� �θ�
	 * ������ڣ�2011-7-21
	 * ģ�鹦�ܣ���ʾ���е��û���Ϣ
	 */

public class Ssuser extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//���ú����ַ�
		request.setCharacterEncoding("utf-8");
		
		// �����������
		String strClass = "com.mysql.jdbc.Driver";
		String strCon = "jdbc:mysql://192.168.1.31:3306/logistics";
		String strUser = "songge";
		String strPwd="123456";
		// ����һ�����϶��󡣡���
		List list = new ArrayList();
		// ����������
			try {
				Class.forName(strClass);
			} catch (ClassNotFoundException e) {

				e.printStackTrace();
			}
			Connection conn =null;
			Statement st =null;
			ResultSet rs = null;
			try {
				// ���ݿ����Ӷ���
				 conn = DriverManager.getConnection(strCon,strUser,strPwd);
				// Statement������ִ��sql��䡣
				st = conn.createStatement();				 
				rs = st.executeQuery("select * from manager");
				
				// ����������е�����
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
				// �ر���Ӧ��Դ
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
			//��ת����ʾ��ǰ̨ҳ��
			request.getRequestDispatcher("/UserLogin/editUser.jsp").forward(request, response);
	}


}
