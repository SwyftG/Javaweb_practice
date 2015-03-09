package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javabean.Goodsyard;

/**
 * ���ߣ��ƴ�
 * ������ڣ�2011��7��20��
 * ���ܣ�ִ�л�����Ϣɾ������
 */
public class HdelGyd extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//ǰ̨��ֵ
		Goodsyard gyd = new Goodsyard();
		gyd.setGoodsyardname(request.getParameter("g1"));
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
			//Statementִ��Sql���
			st = conn.createStatement();
			//ִ�л�����Ϣɾ��
			String s="delete from goodsyard where GyName='"+new String(gyd.getGoodsyardname().getBytes("ISO8859-1"),"utf-8")+"'";
			st.executeUpdate(s);
			
			HttpSession session = request.getSession();
			int hct=Integer.parseInt(request.getParameter("count"));
			List list =(List)session.getAttribute("HDL"); 
			list.remove(hct);
			
			request.getRequestDispatcher("/serv2").forward(request, response);
			
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
