package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javabean.VeInfo;
public class lldel extends HttpServlet {
	/*
	���ߣ�������
	ʱ�䣺2011��7��20��
	ģ�鹦�ܣ���������ϵͳ*/	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		//��servlet��ɵ�ҵ���߼���ɾ�����ݿ��г�����¼��
		VeInfo info = new VeInfo();
		info.setVhcLcs(request.getParameter("vl"));
		//i����ǰ̨��ʾҳ�����ɾ����¼��list�ļ�¼��ţ��Ա��ڷ��ظ�ǰ̨��list��ɾ�����
		int i=Integer.parseInt(request.getParameter("ct"));
		//�������ݿ⡣
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
		
		try {
			//ִ��sqlɾ����䡣
			conn = DriverManager.getConnection(strCon,strUser,strPwd);
			st = conn.createStatement();
			String s="delete from vehicle where VhcLcs='"+info.getVhcLcs()+"';";
			st.executeUpdate(s);
			//��ȡ��ǰ̨��ʾ�Ĳ�ѯ�����ɾ���ڼ�¼��Ϊi�����ת�����в�ѯ���ܵ�llsrcveh servletҳ�档
			HttpSession session =request.getSession();
			List list  = (List)session.getAttribute("lsUL"); 
			list.remove(i);
			request.getRequestDispatcher("llsrcveh").forward(request, response);
		
		}catch (Exception e) {
			
			e.printStackTrace();
		
		}finally{
			
			try {
				//�ر���Ӧ��Դ��
				st.close();
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
			
			try {
				conn.close();
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
