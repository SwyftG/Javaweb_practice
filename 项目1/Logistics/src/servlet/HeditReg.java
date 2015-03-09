package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javabean.Region;
/**
 * ���ߣ� �ƴ�
 * ������ڣ�2011��7��20��
 * ҳ�湦�ܣ�ִ��������Ϣ�޸Ĺ���
 */
public class HeditReg extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//ǰ̨��ֵ
		Region region = new Region();
		region.setRegionname(request.getParameter("v1"));
		region.setRemarks(request.getParameter("v2"));
		//�������ݿ�
		String strClass = "com.mysql.jdbc.Driver";
		String strCon = "jdbc:mysql://192.168.1.31:3306/logistics";
		String strUser = "hd";
		String strPwd = "000000";
		//����������
		try {
			Class.forName(strClass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection conn =null;
		Statement st =null;
		
		try {
			//���ݿ������ַ���
			conn = DriverManager.getConnection(strCon,strUser,strPwd);
			//Statementִ��sql���
			st = conn.createStatement();
			String s="update region set RegRmk='"+region.getRemarks()+"' where RegName='"+region.getRegionname()+"';";
			//�޸ĳɹ���ת���ɹ�ҳ��editsuc.jsp��������ת��ʧ��ҳ��editfail.jsp
			int i=st.executeUpdate(s);		
			if(i==1){								
				request.getRequestDispatcher("/Destination/editsuc.jsp").forward(request, response);
			}else{				
				request.getRequestDispatcher("/Destination/editfail.jsp").forward(request, response);
			}
			
		}catch (Exception e) {	
			
			e.printStackTrace();
			
		}finally{
			//�ر���Ӧ��Դ
			try {
				if(st!=null) st.close();
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
			
			try {
				if(conn!=null) conn.close();
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
		}	
	}
	
	}


