package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javabean.drive;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Sdtask extends HttpServlet {
	/*
	���ߣ�������
	ʱ�䣺2011��7��20��
	ģ�鹦�ܣ���������ϵͳ*/
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//�˺�̨��ɵ�ҵ���߼��ǲ�ѯ��¼��˾����������δ�ʹ�Ļ�������
		request.setCharacterEncoding("utf-8");
		//�������ݿ�
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
		ResultSet rs = null;
		
		try {
			
			conn = DriverManager.getConnection(strCon,strUser,strPwd);
			st = conn.createStatement();

			HttpSession session = request.getSession();
			String t=(String)session.getAttribute("llun");
			//ִ��sql��ѯ��䡣
			String sql =null;		
			sql="select * from goodslist where Username='"+t+"'and GlStatus!='���ʹ�' order by GLStime";
			rs = st.executeQuery(sql);					
			//����Arraylist����
			List list = new ArrayList();
			while(rs.next()){
		
						drive dv1=new drive();
						dv1.setGlstatus(rs.getString("GlStatus"));
						dv1.setGlId(rs.getInt("GLID"));
						dv1.setStime(rs.getString("GLStime"));
						list.add(dv1);			
			}
				//����session��ֵ��
				session.setAttribute("llAL", list);	
				
		}catch (Exception e) {
			
			e.printStackTrace();
		
		}finally{
			//�ر���Ӧ����Դ��
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

			request.getRequestDispatcher("/UserLogin/Drvtask.jsp").forward(request, response);
			
		}
		
	}

}
