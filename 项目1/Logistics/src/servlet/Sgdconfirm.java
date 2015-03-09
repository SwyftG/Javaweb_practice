package servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
/*
���ߣ�������
ʱ�䣺2011��7��20��
ģ�鹦�ܣ���������ϵͳ*/

public class Sgdconfirm extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//�˺�̨��ɵ�ҵ���߼����ṩ����ȷ�ϣ��޸����ݿ��л���״̬��
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
		
		try {
			conn = DriverManager.getConnection(strCon,strUser,strPwd);
			st = conn.createStatement();
			
			HttpSession session= request.getSession();
			//����list���󣬻�ȡ��˾���Ĵ����������ϸ��Ϣ��
			List list  = (List)session.getAttribute("llDL"); 
			drive dv1=new drive();
			if(list!= null){
    	   		dv1 = (drive)list.get(0);
			}
			
			if(dv1!=null){
				
				String g =dv1.getGlstatus();	
				int id=dv1.getGlId();	
				String sql =null;		
				//����ǡ��ѷ��䡯��״̬������ȷ���Ժ����ݿ��л���״̬��Ϊ'��ȷ��'������ǡ���ȷ�ϡ���״̬������ȷ���Ժ���״̬��Ϊ'���ʹ�'
				if("�ѷ���".equals(g)){
					sql="update goodslist join goods on goodslist.GdID=goods.GdID set GlStatus='��ȷ��' where GLId='"+id+"'";
				}else{
					
					sql="update goodslist join goods on goodslist.GdID=goods.GdID set GlStatus='���ʹ�' where GLId='"+id+"'";
				}
				//ִ��sql���,i��ִ��sql����Ӱ��ļ�¼������
				int i=st.executeUpdate(sql);					
				//ִ��sql���ɹ���ʧ�ܽ���ת����ͬ��ҳ�档
				if(i==1){
					
					request.getRequestDispatcher("/UserLogin/consuc.jsp").forward(request, response);
				}else{
					
					request.getRequestDispatcher("/UserLogin/confail.jsp").forward(request, response);
				}
				
			}
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
	
		}
	}

}
