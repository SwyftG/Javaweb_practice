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
 * ҳ�湦�ܣ�ִ��������Ϣɾ������
 */
public class HdelReg extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//ǰ̨��ֵ
		Region region = new Region();
		region.setRegionname(request.getParameter("rg"));
		//�������ݿ�
		String strClass = "com.mysql.jdbc.Driver";
		String strCon = "jdbc:mysql://192.168.1.31/logistics";
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
			String s1="delete from goodsyard where RegName='"+ new String(region.getRegionname().getBytes("ISO8859-1"),"utf-8")+"'";			
			String s2="delete from region where RegName='"+ new String(region.getRegionname().getBytes("ISO8859-1"),"utf-8")+"'";			
			st.executeUpdate(s1);
			st.executeUpdate(s2);			
			request.getRequestDispatcher("/Destination/blank.jsp").forward(request, response);			
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

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
