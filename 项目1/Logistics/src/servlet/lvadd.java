/*
���ߣ���Ψ
ʱ�䣺2011��7��20��
ģ�鹦�ܣ��������ϵͳ*/
package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class lvadd extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		// �����������
		String strClass = "com.mysql.jdbc.Driver";
		// ���ݿ������ַ���
		String strUrl = "jdbc:mysql://192.168.1.31/logistics";
		String strUser = "hd";
		String strPwd = "000000";
		
		Connection conn = null;
		Statement st = null;
		
		try {
			Class.forName(strClass);
			// ����������
			conn = DriverManager.getConnection(strUrl,strUser,strPwd);
			st = conn.createStatement();
			
			String id = request.getParameter("goods_ID");
			String type =  request.getParameter("goods_Type"); 
			String weight =request.getParameter("goods_Weight"); 
			String place =request.getParameter("goods_Place"); 
			String danger =request.getParameter("danger"); 
			String msg =request.getParameter("msg"); 
			String status =request.getParameter("goods_Status"); 
			// ִ�в������
			PreparedStatement pst=conn.prepareStatement("insert into goods (GdID,GdType,GdWeight,GyName,GdDanger,GdStatus,GdRmk) value(?,?,?,?,?,?,?)");
			pst.clearParameters();
			pst.setString(1, id);
			pst.setString(2, type);
			pst.setString(3, weight);
			pst.setString(4, place);
			pst.setString(5, danger);
			pst.setString(6, status);
			pst.setString(7, msg);
			pst.executeUpdate();
			
			// ҳ����ת
			
			response.sendRedirect(request.getContextPath()+"/goods/blank.jsp");
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally{
			//�ر���Ӧ����Դ��
				try {
					st.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				try {
					conn.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			
		}

		
		
		
		
		
		
		
		
		
		
		
		
	
	}
	}
	


