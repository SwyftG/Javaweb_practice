/*
���ߣ���Ψ
ʱ�䣺2011��7��20��
ģ�鹦�ܣ��������ϵͳ*/
package servlet;

import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javabean.goods;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class lvsearch2 extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		// �����������
		String strClass = "com.mysql.jdbc.Driver";
		// ���ݿ������ַ���
		String strCon = "jdbc:mysql://192.168.1.31/logistics";
		String strUser = "hd";
		String strPwd="000000";
		goods goods1=new goods();
		goods1.setGoods_Type(request.getParameter("goods_Type"));
		goods1.setGoods_Status(request.getParameter("goods_Status"));
		
		
		// ����һ�����϶��󡣡���
		List list = new ArrayList();
		// ����������
			try {
				Class.forName(strClass);
			} catch (ClassNotFoundException e) {

				e.printStackTrace();
			}
			Connection conn =null;
			Statement st =null;
			ResultSet rs = null;
			try {
				// ���ݿ����Ӷ���
				 conn = DriverManager.getConnection(strCon,strUser,strPwd);
				// Statement������ִ��sql��䡣
				 st = conn.createStatement();
				 
	 
				// ʢ�Ų�ѯ����Ľ����
				// ִ�в�ѯ
				// ��������
				 String sql =null;
				
					if(("ȫ��").equals(goods1.getGoods_Type()))
					{
						if(goods1.getGoods_Status().equals("ȫ��"))
						{sql = "select * from goods ;";}
						else{sql = "select * from goods where GdStatus='"+goods1.getGoods_Status()+ "' ;";}
						
						
					}
					else{
						if(("ȫ��").equals(goods1.getGoods_Status())){sql = "select * from goods where GdType='"+goods1.getGoods_Type()+ "' ;";}
						else{sql = "select * from goods where GdType='"+goods1.getGoods_Type()+ "' and GdStatus='"+goods1.getGoods_Status()+ "';";}
					}
					rs = st.executeQuery(sql);
				
				// ����������е�����
				if(rs!=null){
				while(rs.next())
				{	
					goods goods = new goods();
					goods.setGoods_ID(rs.getString("GdID"));
					goods.setGoods_Type(rs.getString("GdType"));
					goods.setGoods_Weight(rs.getString("GdWeight"));
					goods.setGoods_Place(rs.getString("GyName"));
					goods.setDanger(rs.getString("GdDanger"));
					goods.setMsg(rs.getString("GdRmk"));
					goods.setGoods_Status(rs.getString("GdStatus"));
					list.add(goods);
				}
				HttpSession session = request.getSession();
				session.setAttribute("UL", list);}
				
				
				
			
			} catch (SQLException e) {
				
				e.printStackTrace();
			}finally{
				// �ر���Ӧ��Դ
				try {
					if(rs!=null){
					rs.close();}
				} catch (SQLException e1) {
					
					e1.printStackTrace();    
				}
				
				try {
					if(st!=null){st.close();}
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
				try {
					if(conn!=null){conn.close();}
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
			}
			response.sendRedirect(request.getContextPath()+"/goods/chazhao.jsp");
			
	}

}
