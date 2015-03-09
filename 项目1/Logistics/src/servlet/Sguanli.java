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
	 * ���ߣ��θ�
	 * ������ڣ�2011-7-21
	 * ģ�鹦�ܣ�ʵ�ֵ�¼�ĺ�̨����
	 */
public class Sguanli extends HttpServlet {

		public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//���ú����ַ���
		request.setCharacterEncoding("utf-8");
		//����һ���ж��Ƿ��¼�ı�־��
		String Flag=null;
		String quanxian=null;
		boolean loginFlag=false;
		
		User user = new User();
		// �趨�û���
		user.setUsername(request.getParameter("username"));
		// �趨����
		user.setUserpwd(request.getParameter("userpwd")); 
		//�趨Ȩ��
		user.setUserquanxian(request.getParameter("quanxian"));  
		//�������ݿ�
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
			//�����ݿ���ȡ����������Ϣ�������Ϣ������
			String strsql = "select count(*) as count1 from manager where UserName = '" + user.getUsername() + "' and UserPwd = '" + user.getUserpwd() + "' and UserPower = '"+user.getUserquanxian() + "'";
			rs = st.executeQuery(strsql);	
			if(rs.next())
			{                                  
				// �Ӳ�ѯ������л��������
				int count = rs.getInt("count1");
				 // ���ݽ���ж��Ƿ������ȷ��
				if(count>0)
				{
					loginFlag=true;
					Flag="ok";
				}
				
			}
			//�ѵ�¼��־�Ž�session
			HttpSession session =request.getSession();
			session.setAttribute("llun", user.getUsername()); 
			session.setAttribute("Flag", Flag);
			
			String quan=user.getUserquanxian();
			if(loginFlag&&("˾��".equals(quan))){
				//����Ȩ��ֵ
				quanxian="siji";
				session.setAttribute("vvquanxian",quanxian );
				//��ת���ڲ�����
				request.getRequestDispatcher("/root.jsp").forward(request, response);
				
			}
			else if(loginFlag&&("����Ա".equals(quan))){
				//����Ȩ��ֵ
				quanxian="g";
				session.setAttribute("vvquanxian",quanxian );
				//��ת���ڲ�����
				request.getRequestDispatcher("/root.jsp").forward(request, response);
			}
			else if(loginFlag&&(quan==null)){
				//����Ȩ��ֵ
				quanxian="admin";
				session.setAttribute("vvquanxian",quanxian );
				//Admin�Ĺ������
				request.getRequestDispatcher("/root.jsp").forward(request, response);
			}else{
				//��¼ʧ�ܵĽ���
				request.getRequestDispatcher("/UserLogin/fail.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//�ͷ���Դ
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
