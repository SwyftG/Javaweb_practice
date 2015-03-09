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
 * ҳ�湦�ܣ�ִ��������Ϣ��ѯ����
 */
public class HveReg extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		//�������ݿ�
		String strClass = "com.mysql.jdbc.Driver";
		String strCon = "jdbc:mysql://192.168.1.31:3306/logistics";
		String strUser = "hd";
		String strPwd="000000";
		//����һ�����϶���
		List list = new ArrayList();
			//����������
			try {
				Class.forName(strClass);
			} catch (ClassNotFoundException e) {

				e.printStackTrace();
			}
			Connection conn =null;
			Statement st =null;
			ResultSet rs = null;
			
			try {
				//���ݿ������ַ���
				 conn = DriverManager.getConnection(strCon,strUser,strPwd);
				 //Statementִ��sql���
				 st = conn.createStatement();			 
				 rs = st.executeQuery("select * from region");		 
				 while(rs.next())
					{	Region region=new Region();			    
						region.setRegionname( rs.getString("RegName") );	
						region.setRemarks( rs.getString("RegRmk") );
						list.add(region);
					}
				
				 HttpSession session = req.getSession();
				 session.setAttribute("HBL", list);
		
			} catch (SQLException e) {
				
				e.printStackTrace();
			}finally{
				//�ر���Ӧ��Դ
				try {
					if(rs!=null) rs.close();
				} catch (SQLException e1) {
					
					e1.printStackTrace();    
				}
				
				try {
					if(st!=null) st.close();
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
				try {
					if(conn!=null) conn.close();
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
			}
			
			req.getRequestDispatcher("/Destination/veReg.jsp").forward(req, resp);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
