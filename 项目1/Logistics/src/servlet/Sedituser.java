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
	 * ���ߣ� �θ�
	 * ������ڣ�2011-7-21
	 * ģ�鹦�ܣ��༭�û���Ϣ
	 */

public class Sedituser extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//���ú����ַ�
		request.setCharacterEncoding("utf-8");

		
		//�������ݿ�
		String strClass = "com.mysql.jdbc.Driver";
		String strUrl = "jdbc:mysql://localhost:3306/logistics";
		String strUser = "songge";
		String strPwd="123456";
		
		List list = new ArrayList();
		//����������
		try {
			Class.forName(strClass);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connection conn = null;
		Statement st = null;
	
	
	
	 		
		// ���ݿ����Ӷ���
		try {
			conn = DriverManager.getConnection(strUrl,strUser,strPwd);
			st = conn.createStatement();
	
		
			
			//��ȡ�޸ĺ���û��������룬Ȩ�޺�ID��
			User user1=new User();
			user1.setUsername(request.getParameter("name2"));			
			user1.setUserquanxian(request.getParameter("quanxian"));			
			user1.setUserpwd(request.getParameter("pwd1"));			
			user1.setUserid(Integer.parseInt(request.getParameter("hi")));
			
	
			String name=user1.getUsername();
			String pwd=user1.getUserpwd();			
			//�޸��û���Ϣ��sql���
			PreparedStatement pst=conn.prepareStatement(" update manager set UserName=? , UserPwd=? ,UserPower='"+ user1.getUserquanxian()+"' where UID='"+ user1.getUserid()+"'");
		
			pst.setString(1, name);
			pst.setString(2, pwd);
			pst.executeUpdate();			
			//��ת����ʾҳ��ĺ�̨
			request.getRequestDispatcher("Ssuser").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//�ͷ���Դ
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
