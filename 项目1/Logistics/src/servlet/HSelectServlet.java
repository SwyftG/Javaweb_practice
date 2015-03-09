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

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javabean.Region;
/**
 * ���ߣ� �ƴ�
 * ������ڣ�2011��7��20��
 * ҳ�湦�ܣ�ִ��������Ϣ���ҹ���
 */
public class HSelectServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@SuppressWarnings("rawtypes")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//������ݿ�
		String strClass = "com.mysql.jdbc.Driver";
		String strCon = "jdbc:mysql://192.168.1.31:3306/logistics";
		String strUser = "hd";
		String strPwd="000000";
		//����һ�����϶���
		List list1 = new ArrayList();
			//��������
			try {
				Class.forName(strClass);
			} catch (ClassNotFoundException e) {

				e.printStackTrace();
			}
			Connection conn =null;
			Statement st =null;
			ResultSet rs = null;
			
			try {
				//��ݿ������ַ�
				 conn = DriverManager.getConnection(strCon,strUser,strPwd);
				 //Statementִ��sql���
				 st = conn.createStatement();				 
				 rs = st.executeQuery("select * from region");		 
				 while(rs.next())
					{	Region region=new Region();			    
						region.setRegionname( rs.getString("RegName") );					
						list1.add(region);
					}
				 HttpSession session = request.getSession();
				 session.setAttribute("HEL", list1);
		
			} catch (SQLException e) {
				
				e.printStackTrace();
			}finally{
				//�ر���Ӧ��Դ
				try {
					if(rs!=null)rs.close();
				} catch (SQLException e1) {
					
					e1.printStackTrace();    
				}
				
				try {
					if(st!=null)st.close();
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
				try {
					if(conn!=null)conn.close();
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
			}
			
			request.getRequestDispatcher("/Destination/addGyd.jsp").forward(request, response);
	}

}
