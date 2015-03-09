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

import org.omg.CORBA.Request;

import javabean.Goodsyard;
import javabean.Region;
/**
 * ���ߣ� �ƴ�
 * ������ڣ�2011��7��20��
 * ҳ�湦�ܣ�ִ�л�����Ϣ��ѯ����
 */
public class HveGyd extends HttpServlet {

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
			 
			 Region region=new Region();
			 HttpSession session = req.getSession();
			 region.setRegionname(req.getParameter("c1"));
			 session.setAttribute("c1key",req.getParameter("c1"));
			 rs = st.executeQuery("select * from goodsyard where RegName='"+region.getRegionname()+"'");
			
			 while(rs.next())
			 {
				Goodsyard gyd = new Goodsyard();
				gyd.setGoodsyardname(rs.getString("GyName"));
				gyd.setRegion(rs.getString("RegName"));
				gyd.setAddress(rs.getString("GyAddress"));
				gyd.setArea(rs.getInt("GyArea"));
				gyd.setIndoor(rs.getString("GyIndoor"));				
				gyd.setDanger(rs.getString("GyDanger"));
				gyd.setRemarks(rs.getString("GyRmk"));
				list.add(gyd);
			}			
			session.setAttribute("HDL", list);	
			session.setAttribute("Hcount", req.getParameter("count"));		
			
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
		req.getRequestDispatcher("/serv2").forward(req, resp);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
