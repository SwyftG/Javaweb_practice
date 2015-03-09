package servlet;

import java.sql.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javabean.drive;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/*
���ߣ�������
ʱ�䣺2011��7��20��
ģ�鹦�ܣ���������ϵͳ*/

public class SdrvInfo extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//�˺�̨����ɵ�ҵ���߼���˾���������ϸ��Ϣ��ѯ��
		request.setCharacterEncoding("utf-8");
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
		ResultSet rs = null;
		try{
			conn = DriverManager.getConnection(strCon,strUser,strPwd);
			st = conn.createStatement();
			//ִ��sql��ѯ��䡣
			String sql =null;		
			sql="select * from goodslist join goods on goodslist.GdID=goods.GdID where GLId='"+request.getParameter("tk")+"'";
			rs = st.executeQuery(sql);					
			//����Arraylist����,���ز�ѯ�����������ǰ̨��
			HttpSession session= request.getSession();
			List list = new ArrayList();
			drive dv1=new drive();
			if(rs.next()){
						dv1.setGlstatus(rs.getString("GlStatus"));
						//���ݿ��е�GLID�ֶ���int�͡�
						dv1.setGlId(rs.getInt("GLID"));
						dv1.setVhclcs(rs.getString("VhcLcs"));
						dv1.setSname(rs.getString("SGyName"));
						dv1.setDname(rs.getString("DGyName"));
						dv1.setStime(rs.getString("GLStime"));
						dv1.setDtime(rs.getString("GLDtime"));
						dv1.setDanger(rs.getString("GdDanger"));
						dv1.setRmk(rs.getString("GdRmk"));
						list.add(dv1);			
			}
			//����session��ֵ��
			session.setAttribute("llDL", list);
			//���˾�������������ѷ����״̬����ת��huowu.jspҳ�棬������ת����ȷ��״̬��Ӧ��huowu2.jspҳ�档
			if("�ѷ���".equals(dv1.getGlstatus())){
				request.getRequestDispatcher("/UserLogin/huowu.jsp").forward(request, response);
			}else{
				request.getRequestDispatcher("/UserLogin/huowu2.jsp").forward(request, response);
			}
			
		}catch (Exception e) {
			
			e.printStackTrace();
		
		}finally{
			//�ر���Ӧ��Դ��
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
	
		}
		
	}

}
